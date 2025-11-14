package com.example.repaso4for;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.FontResourcesParserCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumero;
    Button buttonEmpezar;
    TextView textViewMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumero = findViewById(R.id.editTextNumero);
        buttonEmpezar = findViewById(R.id.buttonEmpezar);
        textViewMostrar = findViewById(R.id.textViewMostrar);

        buttonEmpezar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String numero = editTextNumero.getText().toString();

                int num = Integer.parseInt(numero);

                textViewMostrar.setText("");
                for (int i = 1; i <= num; i++) {
                    textViewMostrar.append(String.valueOf(i) + "\n");
                }
            }


        });
    }
}
