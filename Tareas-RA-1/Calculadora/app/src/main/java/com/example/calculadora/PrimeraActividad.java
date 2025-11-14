package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrimeraActividad extends AppCompatActivity {

    EditText etNum1, etNum2;
    TextView tvResultado;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnSuma, btnResta, btnMulti, btnDiv, btnSqrt, btnClear, btnIgual, btnMostrar;

    private String operacionActual = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNum1 = findViewById(R.id.editTextNumber3);
        etNum2 = findViewById(R.id.editTextNumber4);
        tvResultado = findViewById(R.id.resultadoTextView);

        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button5);
        btn3 = findViewById(R.id.button6);
        btn4 = findViewById(R.id.button7);
        btn5 = findViewById(R.id.button8);
        btn6 = findViewById(R.id.button9);
        btn7 = findViewById(R.id.button10);
        btn8 = findViewById(R.id.button11);
        btn9 = findViewById(R.id.button12);

        btnSuma = findViewById(R.id.button15);  // +
        btnResta = findViewById(R.id.button14); // -
        btnMulti = findViewById(R.id.button13); // x
        btnDiv = findViewById(R.id.button17);   // /
        btnSqrt = findViewById(R.id.button);    // Sqrt
        btnClear = findViewById(R.id.button18); // Clear
        btnIgual = findViewById(R.id.button16); // =
        btnMostrar = findViewById(R.id.btnMostrar);

        etNum1.requestFocus();

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String digit = b.getText().toString();
                View focusedView = getCurrentFocus();
                if (focusedView instanceof EditText) {
                    ((EditText) focusedView).append(digit);
                } else {
                    etNum1.append(digit);
                }
            }
        };

        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionActual = "+";
                etNum2.requestFocus();
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionActual = "-";
                etNum2.requestFocus();
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionActual = "x";
                etNum2.requestFocus();
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionActual = "/";
                etNum2.requestFocus();
            }
        });


        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionActual = "sqrt";
                calcular();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNum1.setText("");
                etNum2.setText("");
                tvResultado.setText("0");
                operacionActual = "";
                etNum1.requestFocus();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = tvResultado.getText().toString();
                if (resultado.contains("Error") || resultado.equals("0")) {
                    Toast.makeText(PrimeraActividad.this, "Realiza un cálculo primero", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(PrimeraActividad.this, SegundaActividad.class);
                intent.putExtra("RESULTADO_EXTRA", resultado);
                startActivity(intent);
            }
        });

    }

    private void calcular() {
        String strNum1 = etNum1.getText().toString();
        String strNum2 = etNum2.getText().toString();

        if (operacionActual.isEmpty()) {
            Toast.makeText(this, "Selecciona una operación", Toast.LENGTH_SHORT).show();
            return;
        }

        if (strNum1.isEmpty()) {
            Toast.makeText(this, "Introduce el primer número", Toast.LENGTH_SHORT).show();
            return;
        }

        if (strNum2.isEmpty() && !operacionActual.equals("sqrt")) {
             Toast.makeText(this, "Introduce el segundo número", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = 0;
        double num2 = 0;
        double resultado = 0;

        try {
            num1 = Double.parseDouble(strNum1);
            if (!strNum2.isEmpty()) {
                num2 = Double.parseDouble(strNum2);
            }

            switch (operacionActual) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "x":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        tvResultado.setText("Error: Div 0");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
                case "sqrt":
                    if (num1 < 0) {
                        tvResultado.setText("Error: Raíz neg");
                        return;
                    }
                    resultado = Math.sqrt(num1);
                    break;
            }

            tvResultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            tvResultado.setText("Error: Formato");
        }
    }
}
