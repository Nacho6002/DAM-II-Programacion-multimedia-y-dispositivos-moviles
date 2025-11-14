package com.example.simulacrodeexamen1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum;
    Button buttonTabla;

    public static final String NUMERO_EXTRA = "numero_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum = findViewById(R.id.editTextNum);
        buttonTabla = findViewById(R.id.buttonTabla);

        buttonTabla.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String num = editTextNum.getText().toString();

                Intent intent = new Intent(MainActivity.this, Segunda.class);

                intent.putExtra(NUMERO_EXTRA, num);

                startActivity(intent);

            }
        });
    }
}