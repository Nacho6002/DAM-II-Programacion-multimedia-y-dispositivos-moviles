package com.example.examenexamenra1mprofe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button buttonM1A, buttonM1E, buttonResumen;
    String TAG = "MAX";
    TextView textViewPlatosM1, textViewPrecioM1, textViewErrorM1;
    int ContadorM1 = 0;
    public static final int MAX_PLATOS = 8;
    public static final double PRECIO_PLATOM1 = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonM1A = findViewById(R.id.buttonM1A);
        buttonM1E = findViewById(R.id.buttonM1E);
        textViewPlatosM1 = findViewById(R.id.textViewPlatosM1);
        textViewPrecioM1 = findViewById(R.id.textViewPrecioM1);
        textViewErrorM1 = findViewById(R.id.textViewErrorM1);
        buttonResumen = findViewById(R.id.buttonResumen);

        actualizarVistas();

        buttonM1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operacion("+");
            }
        });

        buttonM1E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operacion("-");
            }
        });

        buttonResumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("contadorM1", ContadorM1);
                startActivity(intent);
            }
        });
    }

    private void Operacion(String s){
       switch (s){
           case "+":
               if(ContadorM1 < MAX_PLATOS){
                   ContadorM1++;
                   actualizarVistas();
               }else{
                   Log.e(TAG, "No puede tener mas de 8 platos" );
                   textViewErrorM1.setText("No se pueden agregar mas de 8 Platos");
               }
               break;
           case "-":
               if (ContadorM1 > 0) {
                   ContadorM1--;
                   actualizarVistas();
               }
               break;
       }
    }

    private void actualizarVistas() {
        textViewPlatosM1.setText(String.valueOf(ContadorM1));
        textViewPrecioM1.setText(String.valueOf(ContadorM1 * PRECIO_PLATOM1));
        textViewErrorM1.setText("");
    }
}
