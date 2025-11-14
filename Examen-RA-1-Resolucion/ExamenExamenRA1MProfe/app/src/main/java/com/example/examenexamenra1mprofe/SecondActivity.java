package com.example.examenexamenra1mprofe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textViewPlatosM1, textViewPrecioM1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewPlatosM1 = findViewById(R.id.textViewPlatosM1);
        textViewPrecioM1 = findViewById(R.id.textViewPrecioM1);

        Intent intent = getIntent();
        int contadorM1 = intent.getIntExtra("contadorM1", 0);

        double precioTotal = contadorM1 * MainActivity.PRECIO_PLATOM1;

        textViewPlatosM1.setText(String.valueOf(contadorM1));
        textViewPrecioM1.setText(String.valueOf(precioTotal));
    }
}
