package com.example.session2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView lblPais;
    private ListView lstPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner = (Spinner) findViewById(R.id.spnPaises);
        lblPais = (TextView) findViewById(R.id.lblPais);
        lstPaises = (ListView) findViewById(R.id.lstPaises);

        // Diseño del Adaptador

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.paises));
        lstPaises.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String pais = parent.getItemAtPosition(position).toString();
                lblPais.setText(pais);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lstPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pais = parent.getItemAtPosition(position).toString();
                lblPais.setText(pais);
            }
        });
    }
}