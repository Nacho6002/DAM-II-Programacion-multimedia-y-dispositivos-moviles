package com.example.examenra1resolucionmi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Segunda_activity extends AppCompatActivity {

    TextView textViewNuPlatosM1, textViewRMesa1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        
        textViewNuPlatosM1 = findViewById(R.id.textViewNuPlatosM1);
        textViewRMesa1 = findViewById(R.id.textViewRMesa1);
        
        Intent intent = getIntent();
        int contadorM1 = intent.getIntExtra(MainActivity.EXTRA_MESA1A, 0);

        textViewNuPlatosM1.setText(String.valueOf(contadorM1));
        
    }
}