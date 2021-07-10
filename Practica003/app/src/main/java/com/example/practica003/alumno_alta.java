package com.example.practica003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class alumno_alta extends AppCompatActivity {

    private Button btnGuardar;
    private Button btnRegresar;
    private Button btnSeleccionar;
    private Button btnBorrar;
    private itemData itemData;
    private EditText txtNombre;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private ImageView imgProducto;
    private TextView lblImagen;
    private int posicion;
    private Aplicacion app;
    private Uri selectedImgUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_alta);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnSeleccionar = (Button) findViewById(R.id.btnSeleccionar);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        imgProducto = (ImageView) findViewById(R.id.imgProducto);
        lblImagen = (TextView) findViewById(R.id.urlFoto);

        Bundle datos = getIntent().getExtras();
        itemData = (itemData) datos.getSerializable("producto");
        posicion = datos.getInt("posicion", posicion);

        int SELECT_PICTURE = 200;

        if(posicion >= 0){
            txtNombre.setText(itemData.getTxtNombre());
            txtDescripcion.setText(itemData.getTxtDescripcion());
            txtPrecio.setText(itemData.getTxtPrecio());
            imgProducto.setImageURI(Uri.parse(itemData.getImageId()));
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemData == null) {
                    itemData = new itemData();
                    itemData.setTxtNombre(txtNombre.getText().toString());
                    itemData.setTxtDescripcion(txtDescripcion.getText().toString());
                    itemData.setTxtPrecio(txtPrecio.getText().toString());
                    itemData.setColorId(R.color.colorPeine);
                    itemData.setImageId(selectedImgUri.toString());

                    if(validar()) {
                        Aplicacion.items.add(itemData);
                        setResult(Activity.RESULT_OK);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(),"Falto capturar datos",Toast.LENGTH_SHORT).show();
                        txtNombre.requestFocus();
                    }
                }

                if(posicion >= 0){
                    itemData.setTxtNombre(txtNombre.getText().toString());
                    itemData.setTxtDescripcion(txtDescripcion.getText().toString());
                    itemData.setTxtPrecio(txtPrecio.getText().toString());
                    itemData.setImageId(selectedImgUri.toString());

                    app.items.get(posicion).setTxtNombre(itemData.getTxtNombre());
                    app.items.get(posicion).setTxtDescripcion(itemData.getTxtDescripcion());
                    app.items.get(posicion).setTxtPrecio(itemData.getTxtPrecio());
                    app.items.get(posicion).setImageId(itemData.getImageId());

                    Toast.makeText(getApplicationContext(),"Se modifico con exito",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posicion >= 0){
                    Aplicacion.items.remove(posicion);
                    finish();
                }
            }
        });

        btnSeleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),0);
            }
        });
    }

    private boolean validar(){
        boolean exito = true;
        if(txtNombre.getText().toString().equals("")) exito = false;
        if(txtDescripcion.getText().toString().equals("")) exito = false;
        if(txtPrecio.getText().toString().equals("")) exito = false;

        return exito;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            selectedImgUri = data.getData();
            Log.d("", "onActivityResult: " + selectedImgUri);
            if (null != selectedImgUri){
                imgProducto.setImageURI(selectedImgUri);
                lblImagen.setText(selectedImgUri.toString());

            }
        }
    }

}