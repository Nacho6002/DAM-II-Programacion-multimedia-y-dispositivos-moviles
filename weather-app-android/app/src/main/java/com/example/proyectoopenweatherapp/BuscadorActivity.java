package com.example.proyectoopenweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

public class BuscadorActivity extends AppCompatActivity {

    private AppViewModel viewModel;
    // variable temporal para guardar la ciudad antes de meterla a la base
    private Ciudad ciudadTemporal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        // activo la flecha de atras
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Buscador API");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // busco los elementos de la interfaz
        SearchView searchView = findViewById(R.id.searchViewApi);
        LinearLayout layoutRes = findViewById(R.id.layoutResultado);
        TextView tvNombre = findViewById(R.id.tvNombreApi);
        TextView tvTemp = findViewById(R.id.tvTempApi);
        TextView tvDesc = findViewById(R.id.tvDescApi);
        ImageView imgIcono = findViewById(R.id.imgIconoApi);
        Button btnAgregar = findViewById(R.id.btnAgregarLista);

        viewModel = new ViewModelProvider(this).get(AppViewModel.class);

        // configuro el buscador
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!query.trim().isEmpty()){
                    // llamo al viewmodel para buscar en la api
                    viewModel.buscarEnApi(query);
                    searchView.clearFocus();
                }
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) { return false; }
        });

        // observo si la api respondio con datos
        viewModel.getClimaEncontrado().observe(this, ciudad -> {
            if (ciudad != null) {
                ciudadTemporal = ciudad;
                layoutRes.setVisibility(View.VISIBLE);

                tvNombre.setText(ciudad.nombre);
                tvTemp.setText(ciudad.temperatura);
                tvDesc.setText(ciudad.descripcion);

                // uso glide para cargar la imagen url que manda openweather
                Glide.with(this).load(ciudad.iconoUrl).into(imgIcono);
            }
        });

        // observo si hubo error
        viewModel.getErrorApi().observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        });

        // boton para guardar en room
        btnAgregar.setOnClickListener(v -> {
            if (ciudadTemporal != null) {
                viewModel.insertar(ciudadTemporal);
                Toast.makeText(this, "ciudad guardada de una", Toast.LENGTH_SHORT).show();
                finish(); // vuelvo al inicio
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}