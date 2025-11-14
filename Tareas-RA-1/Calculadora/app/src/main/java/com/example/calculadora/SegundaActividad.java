package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActividad extends AppCompatActivity {

    TextView tvResultadoFinal;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_2);

        tvResultadoFinal = findViewById(R.id.tvResultadoFinal);
        btnVolver = findViewById(R.id.btnVolver);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String resultado = extras.getString("RESULTADO_EXTRA");
            tvResultadoFinal.setText(resultado);
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
