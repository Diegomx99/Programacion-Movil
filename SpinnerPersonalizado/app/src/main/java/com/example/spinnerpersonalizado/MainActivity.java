package com.example.spinnerpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ItemData> list = new ArrayList<>();

        list.add(new ItemData(getString(R.string.itemFrappses),getString(R.string.msgFrapsses), R.drawable.categorias));
        list.add(new ItemData(getString(R.string.itemAgradecimiento),getString(R.string.msgAgradecimiento), R.drawable.agradecimiento));
        list.add(new ItemData(getString(R.string.itemAmor),getString(R.string.msgAmor),R.drawable.amor));
        list.add(new ItemData(getString(R.string.itemNewyear),getString(R.string.msgNewYear),R.drawable.nuevo));
        list.add(new ItemData(getString(R.string.itemCanciones),getString(R.string.msgCanciones),R.drawable.canciones));

        spinner = (Spinner) findViewById(R.id.spinner1);
        SpinnerAdapter adapter = new SpinnerAdapter(this,R.layout.spinner_layout,R.id.lblCategorias,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),getString(R.string.msgSeleccionado).toString() + " " +
                        ((ItemData) parent.getItemAtPosition(position)).getTextCategoria(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}