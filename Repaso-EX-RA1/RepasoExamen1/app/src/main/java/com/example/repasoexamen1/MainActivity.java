package com.example.repasoexamen1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editTextNum1;

    EditText editTextNum2;
    Button buttonSumar;
    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        buttonSumar = findViewById(R.id.buttonSumar);
        textViewResultado = findViewById(R.id.textViewResultado);


        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cogo los textos que el usuario escribio
                String PrimerNumero = editTextNum1.getText().toString();
                String SegundoNumero = editTextNum2.getText().toString();

                //Compruebo que no esten vacios
                if(PrimerNumero.isEmpty() || SegundoNumero.isEmpty()){
                    Toast.makeText(MainActivity.this, "Debes escribir un numero", Toast.LENGTH_SHORT).show();
                    return;
                }

                try{
                    //Convierto los textos en numeros
                    double num1 = Double.parseDouble(PrimerNumero);
                    double num2 = Double.parseDouble(SegundoNumero);

                    //Realizo la suma
                    double resultado = num1 + num2;

                    textViewResultado.setText(String.valueOf(resultado));
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Debes escribir un numero", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}