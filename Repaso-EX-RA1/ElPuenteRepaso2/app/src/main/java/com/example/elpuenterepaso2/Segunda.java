package com.example.elpuenterepaso2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Segunda extends AppCompatActivity {

    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        textViewResultado = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();

        String nombreRecibido = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);

        textViewResultado.setText(nombreRecibido);



    }
}
