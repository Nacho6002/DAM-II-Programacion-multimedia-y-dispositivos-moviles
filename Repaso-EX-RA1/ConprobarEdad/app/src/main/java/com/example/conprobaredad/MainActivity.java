package com.example.conprobaredad;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NOM = "extra_nom";
    public static final String EXTRA_APELLIDO = "extra_apellido";
    public static final String EXTRA_EDAD = "extra_edad";

    String TAG = "UNO";
    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextEdad;

    Button buttonComprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Iniciando ");
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextEdad = findViewById(R.id.editTextEdad);
        buttonComprobar = findViewById(R.id.buttonComprobar);

        buttonComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = editTextNombre.getText().toString();
                
                String apelli = editTextApellido.getText().toString();
                
                String edad = editTextEdad.getText().toString();

                Intent intent = new Intent(MainActivity.this, Segunda.class);

                intent.putExtra(EXTRA_NOM, nom);
                intent.putExtra(EXTRA_APELLIDO, apelli);
                intent.putExtra(EXTRA_EDAD, edad);
                
                startActivity(intent);
                
                
            }
        });

        

        
    }
}
