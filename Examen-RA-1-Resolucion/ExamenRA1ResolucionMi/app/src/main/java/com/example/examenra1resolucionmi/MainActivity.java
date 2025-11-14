package com.example.examenra1resolucionmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textViewMesa1;
    Button buttonAgregarM1, buttonEliminarM1, buttonResumen;

    public static final String EXTRA_MESA1A = "extra_mesa1a";
    public static final double PRECIO_PLATOM1 = 11.30;

    int ContadorM1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMesa1 = findViewById(R.id.textViewMesa1);
        buttonAgregarM1 = findViewById(R.id.buttonAgregarM1);
        buttonEliminarM1 = findViewById(R.id.buttonEliminarM1);
        buttonResumen = findViewById(R.id.buttonResumen);

        buttonAgregarM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContadorM1++;
            }
        });

        buttonEliminarM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContadorM1--;
            }
        });

        buttonResumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity .this, Segunda_activity.class);

                intent.putExtra(EXTRA_MESA1A, ContadorM1);

                startActivity(intent);
            }
        });
    }
}