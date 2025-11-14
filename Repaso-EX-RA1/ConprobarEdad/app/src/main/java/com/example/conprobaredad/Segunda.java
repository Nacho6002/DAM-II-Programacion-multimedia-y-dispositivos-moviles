package com.example.conprobaredad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Segunda extends AppCompatActivity {

    TextView textViewNombre;
    TextView textViewApellido;
    TextView textViewEdad;
    TextView textViewComprobar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textViewNombre = findViewById(R.id.textViewNombre);
        textViewApellido = findViewById(R.id.textViewApellido);
        textViewEdad = findViewById(R.id.textViewEdad);
        textViewComprobar = findViewById(R.id.textViewComprobar);


        Intent intent = getIntent();

        String nomReci = intent.getStringExtra(MainActivity.EXTRA_NOM);
        String apeReci = intent.getStringExtra(MainActivity.EXTRA_APELLIDO);
        String edadReci = intent.getStringExtra(MainActivity.EXTRA_EDAD);

        Integer Edad = Integer.parseInt(edadReci);

        if (Edad >= 18){
            textViewNombre.setText(nomReci);
            textViewApellido.setText(apeReci);
            textViewEdad.setText(edadReci);
            textViewComprobar.setText("Es mayor de Edad Tiene" + edadReci + " años");
        }else{
            textViewNombre.setText(nomReci);
            textViewApellido.setText(apeReci);
            textViewEdad.setText(edadReci);
            textViewComprobar.setText("Es mejor de edad no tiene mas de 18 años");
        }

    }
}