package com.example.proyectoopenweatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    // Aquí configuro la llamada a la API
    // Pido la ciudad, mi clave, que me lo de en Centígrados (metric) y en español (es)
    @GET("weather")
    Call<RespuestaApi> obtenerClima(
            @Query("q") String ciudad,
            @Query("appid") String apiKey,
            @Query("units") String unidades,
            @Query("lang") String idioma
    );
}