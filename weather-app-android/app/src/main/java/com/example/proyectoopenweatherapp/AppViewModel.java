package com.example.proyectoopenweatherapp;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// viewmodel igual al del primer trabajo pero aumentado lo de retrofit
// aqui mezclo la base de datos local con la api de internet
public class AppViewModel extends AndroidViewModel {

    private CiudadDao dao;
    private LiveData<List<Ciudad>> listaCiudades;

    // livedata nuevos para manejar la respuesta de la api
    private MutableLiveData<Ciudad> climaEncontrado = new MutableLiveData<>();
    private MutableLiveData<String> errorApi = new MutableLiveData<>();

    // la key que me saque registrandome en openweather
    private static final String API_KEY = "TU_API_KEY_AQUI";

    public AppViewModel(@NonNull Application application) {
        super(application);
        // esto es lo mismo del proyecto anterior conexion a room
        BaseDatosClima db = BaseDatosClima.getDatabase(application);
        dao = db.ciudadDao();
        listaCiudades = dao.obtenerTodas();
    }

    public LiveData<List<Ciudad>> getListaCiudades() { return listaCiudades; }
    public MutableLiveData<Ciudad> getClimaEncontrado() { return climaEncontrado; }
    public MutableLiveData<String> getErrorApi() { return errorApi; }

    // insertar en base de datos en segundo plano
    public void insertar(Ciudad ciudad) {
        BaseDatosClima.databaseWriteExecutor.execute(() -> {
            dao.insertar(ciudad);
        });
    }

    // metodo nuevo para consumir la api publica
    public void buscarEnApi(String nombreCiudad) {
        // configuracion basica de retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService servicio = retrofit.create(WeatherService.class);

        // pido en español y sistema metrico
        Call<RespuestaApi> llamada = servicio.obtenerClima(nombreCiudad, API_KEY, "metric", "es");

        llamada.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RespuestaApi datos = response.body();

                    String nombre = datos.nombreCiudad;
                    // redondeo la temperatura para que no salgan decimales feos
                    String temp = Math.round(datos.main.temp) + "°C";
                    String desc = datos.weather.get(0).description;
                    String iconoCode = datos.weather.get(0).icon;

                    // url oficial de openweather para las imagenes @4x para que se vea mas grande
                    String urlIcono = "https://openweathermap.org/img/wn/" + iconoCode + "@4x.png";

                    // creo el objeto pero aun no lo guardo en la base
                    Ciudad c = new Ciudad(nombre, temp, desc, urlIcono);
                    climaEncontrado.postValue(c);
                } else {
                    errorApi.postValue("no encontre esa ciudad ñaño revisa bien");
                }
            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                errorApi.postValue("fallo el internet o se cayo la api");
            }
        });
    }
}
