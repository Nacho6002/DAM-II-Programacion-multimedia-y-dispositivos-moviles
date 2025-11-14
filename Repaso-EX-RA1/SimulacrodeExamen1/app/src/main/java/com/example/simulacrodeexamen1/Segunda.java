package com.example.simulacrodeexamen1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Segunda extends AppCompatActivity {

TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);

        textViewResultado = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();

        String numeroResivido = intent.getStringExtra(MainActivity.NUMERO_EXTRA);

        Integer res = Integer.parseInt(numeroResivido);

        textViewResultado.setText("Tabla de Multiplicar \n\n");
        for (int i = 1; i <= 12; i++) {
        int resultado = res * i;
            textViewResultado.append(String.valueOf(res + "x" + i + "=" + resultado + "\n"));
        }

    }
}