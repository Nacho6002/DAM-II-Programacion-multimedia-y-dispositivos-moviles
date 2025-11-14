package com.example.elpuenterepaso2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText editTextNombre;
    Button buttonEnviar;

    public static final String EXTRA_NOMBRE = "extra_nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        buttonEnviar = findViewById(R.id.buttonEnviar);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreEnviar = editTextNombre.getText().toString();
                //Aqui se el dice el lugar de origen y el destino
                Intent intent = new Intent(MainActivity.this, Segunda.class);
                //Guarda el dato dentro de la intencion
                intent.putExtra (EXTRA_NOMBRE, nombreEnviar);
                //Aqui se lanza la intencion
                startActivity(intent);
            }
        });




    }
}