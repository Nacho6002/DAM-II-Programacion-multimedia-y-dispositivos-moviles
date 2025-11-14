package com.example.tarea2actividades;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 1. Recoger el texto enviado desde MainActivity
        Intent intento = getIntent();
        String textoRecibido = intento.getStringExtra(MainActivity.TEXTO_ENVIAR_PANTALLA_DOS);

        // 2. Buscar el TextView donde queremos poner ese texto recibido
        TextView cuadroDeTextoRecibido = findViewById(R.id.textViewRecibido);

        // 3. Poner el texto que hemos recogido en ese TextView
        cuadroDeTextoRecibido.setText(textoRecibido);

        // 4. Configurar del boton flotante para volver a la pantalla ino
        FloatingActionButton botonFlotanteVolver = findViewById(R.id.fabGoToFirst);
        botonFlotanteVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}