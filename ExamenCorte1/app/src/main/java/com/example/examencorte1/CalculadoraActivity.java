package com.example.examencorte1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView lblCalcalculadora;
    private TextView lblUsuario;
    private TextView lblNum1;
    private TextView lblNum2;
    private TextView lblResultado;
    private EditText txtNum1;
    private EditText txtNum2;
    private Button btnSuma;
    private Button btnResta;
    private Button btnMultiplicacion;
    private Button btnDivision;
    private Button btnLimpiar;
    private Button btnRegresar;
    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        lblCalcalculadora = (TextView) findViewById(R.id.lblCalcalculador);
        lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        lblNum1 = (TextView) findViewById(R.id.lblNum1);
        lblNum2 = (TextView) findViewById(R.id.lblNum2);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMultiplicacion = (Button) findViewById(R.id.btnMultiplicacion);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        calculadora = new Calculadora();
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("Nombre");
        lblUsuario.setText(nombre);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum1.setText("");
                txtNum2.setText("");
                lblResultado.setText("Resultado: ");
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNum1.getText().toString().matches("") || txtNum2.getText().toString().matches("")){
                    Toast.makeText(CalculadoraActivity.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                } else {
                    setNumbers();
                    lblResultado.setText("Resultado: " + calculadora.suma());
                }
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNum1.getText().toString().matches("") || txtNum2.getText().toString().matches("")){
                    Toast.makeText(CalculadoraActivity.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                } else {
                    setNumbers();
                    lblResultado.setText("Resultado: " + calculadora.resta());
                }
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNum1.getText().toString().matches("") || txtNum2.getText().toString().matches("")){
                    Toast.makeText(CalculadoraActivity.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                } else {
                    setNumbers();
                    lblResultado.setText("Resultado: " + calculadora.multiplicacion());
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNum1.getText().toString().matches("") || txtNum2.getText().toString().matches("")){
                    Toast.makeText(CalculadoraActivity.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                } else {
                    setNumbers();
                    lblResultado.setText("Resultado: " + calculadora.division());
                }
            }
        });

    }

    public void setNumbers(){
        calculadora.setNum1(Float.parseFloat(txtNum1.getText().toString()));
        calculadora.setNum2(Float.parseFloat(txtNum2.getText().toString()));
    }
}