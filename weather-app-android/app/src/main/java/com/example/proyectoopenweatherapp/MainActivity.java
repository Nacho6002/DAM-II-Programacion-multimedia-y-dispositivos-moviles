package com.example.proyectoopenweatherapp; // Asegúrate que este sea tu paquete

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private AppViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Titulo de la barra
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("WEATHER APP - API");
        }

        // 1. Configuro la lista (Recycler)
        RecyclerView recycler = findViewById(R.id.recyclerCiudades);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        final ClimaAdapter adapter = new ClimaAdapter();
        recycler.setAdapter(adapter);

        // 2. Conecto el ViewModel para ver la Base de Datos
        viewModel = new ViewModelProvider(this).get(AppViewModel.class);

        // Me quedo escuchando cambios: si añades una ciudad, aquí aparece sola
        viewModel.getListaCiudades().observe(this, ciudades -> {
            adapter.setCiudades(ciudades);
        });

        // 3. El botón flotante para ir al Buscador
        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nos vamos a la pantalla de buscar con API
                Intent intent = new Intent(MainActivity.this, BuscadorActivity.class);
                startActivity(intent);
            }
        });
    }
}