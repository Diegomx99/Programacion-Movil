package com.example.examencorte1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView lblCalculadora;
    private TextView lblUsuario;
    private TextView lblContraseña;
    private EditText txtUsuario;
    private EditText txtContraseña;
    private Button btnIngresar;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblCalculadora = (TextView) findViewById(R.id.lblcalc);
        lblUsuario = (TextView) findViewById(R.id.lblUser);
        lblContraseña = (TextView) findViewById(R.id.lblContra);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContraseña = (EditText) findViewById(R.id.txtContra);
        btnIngresar = (Button) findViewById(R.id.btnIng);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsuario.getText().toString().matches("") || txtContraseña.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Falto capturar información",Toast.LENGTH_SHORT).show();
                } else if (txtUsuario.getText().toString().matches(getResources().getString(R.string.user)) && txtContraseña.getText().toString().matches(getResources().getString(R.string.pass))) {
                    Intent iCalc = new Intent(MainActivity.this, CalculadoraActivity.class);
                    iCalc.putExtra("Nombre", txtUsuario.getText().toString());
                    startActivity(iCalc);
                } else {
                    Toast.makeText(MainActivity.this, "Contraseña o Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
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
    }
}