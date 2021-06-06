package com.example.preexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Temperatura_Actividad extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#.##");
    private TextView lblNombre;
    private EditText txtCantidad;
    private RadioButton rdbCelsToFahr;
    private RadioButton rdbFahrToCels;
    private TextView lblResult;
    private Button btnCalcularTemp;
    private Button btnLimpiarTemp;
    private Button btnRegresarTemp;
    private Temperatura temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura_actividad);

        lblNombre = (TextView) findViewById(R.id.lblNombreTemp);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        rdbCelsToFahr = (RadioButton) findViewById(R.id.rdbCelsToFahr);
        rdbFahrToCels = (RadioButton) findViewById(R.id.rdbFahrToCels);
        lblResult = (TextView) findViewById(R.id.lblResult);
        btnCalcularTemp = (Button) findViewById(R.id.btnCalcularTemp);
        btnLimpiarTemp = (Button) findViewById(R.id.btnLimpiarTemp);
        btnRegresarTemp = (Button) findViewById(R.id.btnRegresarTemp);
        temp = new Temperatura();
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("Nombre");
        lblNombre.setText("Bienvenido: " + nombre);

        btnRegresarTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCalcularTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCantidad.getText().toString().matches("")){
                    Toast.makeText(Temperatura_Actividad.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                    txtCantidad.requestFocus();
                } else {
                    temp.setTempInicial(Float.parseFloat(txtCantidad.getText().toString()));
                    if(rdbCelsToFahr.isChecked()) {
                        lblResult.setText("Resultado: " + df.format(temp.CelsToFahr()));
                    } else {
                        lblResult.setText("Resultado: " + df.format(temp.FahrToCels()));
                    }
                }
            }
        });

        btnLimpiarTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCantidad.setText("");
                rdbCelsToFahr.setChecked(true);
                lblResult.setText("Resultado: ");
            }
        });

    }
}