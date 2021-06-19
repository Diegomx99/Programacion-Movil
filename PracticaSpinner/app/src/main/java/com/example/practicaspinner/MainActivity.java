package com.example.practicaspinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    DecimalFormat df = new DecimalFormat("#.##");
    private EditText txtCantidad;
    private Spinner spnMoneda;
    private TextView lblTotal;
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnCerrar;
    private String moneda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conexion a componentes
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        spnMoneda = (Spinner) findViewById(R.id.spnMoneda);
        lblTotal = (TextView) findViewById(R.id.lblTotal);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        // Adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.monedas));
        spnMoneda.setAdapter(adapter);

        spnMoneda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moneda = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Boton Calcular

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCantidad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Favor de ingresar una cantidad", Toast.LENGTH_SHORT).show();
                }
                else {
                    switch (moneda){
                        case "Dólares Americano":
                            lblTotal.setText("Total: $" + df.format(Double.parseDouble(txtCantidad.getText().toString()) * 0.050340) + " Dólares Americanos");
                            break;
                        case "Euros":
                            lblTotal.setText("Total: $" + df.format(Double.parseDouble(txtCantidad.getText().toString()) * 0.041160) + " Euros");
                            break;
                        case "Dólares Canadiense":
                            lblTotal.setText("Total: $" + df.format(Double.parseDouble(txtCantidad.getText().toString()) * 0.060700) + " Dólares Canadiense");
                            break;
                        case "Libra Esterlina":
                            lblTotal.setText("Total: $" + df.format(Double.parseDouble(txtCantidad.getText().toString()) * 0.035480) + " Libras");
                            break;
                    }
                }
            }
        });

        //Boton Limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCantidad.setText("");
                lblTotal.setText("Total: $0");
                spnMoneda.setSelection(0);
            }
        });

        //Boton Cerrar
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("¿Desea Salir?");
                dlg.setMessage("Presione OK para cerrar la aplicación")
                    .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = dlg.create();
                alertDialog.show();
            }
        });
    }
}