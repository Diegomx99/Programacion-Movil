package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtCliente;
    private Button btnCotizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCliente = (EditText) findViewById(R.id.txtCliente);
        btnCotizacion = (Button) findViewById(R.id.btnCotizar);

        btnCotizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCliente.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(MainActivity.this,"Favor de introducir un nombre para continuar",Toast.LENGTH_SHORT).show();
                } else {
                    Intent icotiza = new Intent(MainActivity.this,CotizacionActividad.class);
                    icotiza.putExtra("cliente",txtCliente.getText().toString());
                    startActivity(icotiza);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.layout.activity_main){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}