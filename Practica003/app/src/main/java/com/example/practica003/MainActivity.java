package com.example.practica003;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fbtnAgregar;
    private SearchView srcProductos;
    private Aplicacion app;

    private itemData itemData;
    private int posicion = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srcProductos = (SearchView) findViewById(R.id.menu_search);

        app = (Aplicacion) getApplication();
        recyclerView = (RecyclerView) findViewById(R.id.recId);
        recyclerView.setAdapter(app.getAdapter());

        fbtnAgregar = (FloatingActionButton) findViewById(R.id.agregarProducto);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        fbtnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemData = null;
                Intent intent = new Intent(MainActivity.this,alumno_alta.class);
                Bundle datos = new Bundle();
                datos.putSerializable("producto",itemData);
                datos.putInt("posicion",posicion);
                intent.putExtras(datos);
                startActivityForResult(intent,0);
            }
        });

        app.getAdapter().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicion = recyclerView.getChildAdapterPosition(v);
                itemData = app.getItems().get(posicion);
                Log.d("", "onClick: asd" + itemData);
                Intent intent = new Intent(MainActivity.this, alumno_alta.class);
                Bundle datos = new Bundle();
                datos.putSerializable("producto",itemData);
                intent.putExtra("posicion", posicion);
                intent.putExtras(datos);
                Log.d("", "onClick: asd" + datos);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        recyclerView.getAdapter().notifyDataSetChanged();
        posicion = -1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuitem,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                MainActivity.this.app.getAdapter().update(newText);
                MainActivity.this.app.getAdapter().notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}