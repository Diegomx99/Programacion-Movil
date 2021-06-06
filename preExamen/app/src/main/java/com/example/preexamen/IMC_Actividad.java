package com.example.preexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class IMC_Actividad extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#.##");
    private TextView lblNombre;
    private EditText txtAlturaM;
    private EditText txtAlturaCM;
    private EditText txtPeso;
    private TextView lblIMCTotal;
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnRegresar;
    private IMC IMC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_actividad);

        lblNombre = (TextView) findViewById(R.id.lblNombre);
        txtAlturaM = (EditText) findViewById(R.id.txtAlturaM);
        txtAlturaCM = (EditText) findViewById(R.id.txtAlturaCM);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        lblIMCTotal = (TextView) findViewById(R.id.lblIMCTotal);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        IMC = new IMC();
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("Nombre");
        lblNombre.setText("Bienvenido: " + nombre);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtAlturaM.getText().toString().matches("") || txtAlturaCM.getText().toString().matches("") || txtPeso.getText().toString().matches("")){
                    Toast.makeText(IMC_Actividad.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                } else {
                    float calculoIMC;
                    String Altura = txtAlturaM.getText().toString() + "." + txtAlturaCM.getText().toString();
                    IMC.setAltura(Float.parseFloat(Altura));
                    IMC.setPeso(Float.parseFloat(txtPeso.getText().toString()));
                    calculoIMC = IMC.calcularIMC();
                    lblIMCTotal.setText(df.format(calculoIMC) + "kg/m\u00B2");
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAlturaM.setText("");
                txtAlturaCM.setText("");
                txtPeso.setText("");
                lblIMCTotal.setText("");
            }
        });
    }
}