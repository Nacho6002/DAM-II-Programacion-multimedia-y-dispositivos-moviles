package com.example.tarea2actividades;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TEXTO_ENVIAR_PANTALLA_DOS = "com.example.tarea2actividades.TEXTO_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BotonSegundaActividad = findViewById(R.id.buttonGoToSecond);

        BotonSegundaActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, SecondActivity.class);
                intento.putExtra(TEXTO_ENVIAR_PANTALLA_DOS, "Este es el texto predefinido Enviado desde la Primera Pantalla.");
                startActivity(intento);
            }
        });
    }
}