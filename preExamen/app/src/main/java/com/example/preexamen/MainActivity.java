package com.example.preexamen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtEdad;
    private Button btnIMC;
    private Button btnConvertidor;
    private Button btnTerminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        btnIMC = (Button) findViewById(R.id.btnIMC);
        btnConvertidor = (Button) findViewById(R.id.btnConvertidor);
        btnTerminar = (Button) findViewById(R.id.btnTerminar);

        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("¿Desea salir de la aplicación?");
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

        btnIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("") || txtEdad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                } else {
                    Intent iIMC = new Intent(MainActivity.this, IMC_Actividad.class);
                    iIMC.putExtra("Nombre", txtNombre.getText().toString());
                    startActivity(iIMC);
                }
            }
        });

        btnConvertidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("") || txtEdad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                } else {
                    Intent iTemp = new Intent(MainActivity.this, Temperatura_Actividad.class);
                    iTemp.putExtra("Nombre", txtNombre.getText().toString());
                    startActivity(iTemp);
                }
            }
        });
    }
}