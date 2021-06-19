package com.example.listapersonalizada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lstProductos;
    private SearchView srcProductos;
    private ListAdapter adapter;
    ArrayList<ItemData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srcProductos = (SearchView) findViewById(R.id.menu_search);

        list.add(new ItemData(getString(R.string.itemBrocha),getString(R.string.descBrocha),R.drawable.cepillo,R.color.colorBrocha));
        list.add(new ItemData(getString(R.string.itemPolvo),getString(R.string.descPolvo),R.drawable.polvo,R.color.colorPolvo));
        list.add(new ItemData(getString(R.string.itemBase),getString(R.string.descBase),R.drawable.base,R.color.colorBase));
        list.add(new ItemData(getString(R.string.itemBrillo),getString(R.string.descBrillo),R.drawable.brillo,R.color.colorBrillo));
        list.add(new ItemData(getString(R.string.itemLapiz),getString(R.string.descLapiz),R.drawable.lapiz,R.color.colorLapiz));
        list.add(new ItemData(getString(R.string.itemSombra),getString(R.string.descSombra),R.drawable.sombra,R.color.colorSombra));
        list.add(new ItemData(getString(R.string.itemMascara),getString(R.string.descMascara),R.drawable.mascara,R.color.colorMascara));
        list.add(new ItemData(getString(R.string.itemEspejo),getString(R.string.descEspejo),R.drawable.espejo,R.color.colorEspejo));
        list.add(new ItemData(getString(R.string.itemEsmalte),getString(R.string.descEsmalte),R.drawable.esmalte,R.color.colorEsmalte));
        list.add(new ItemData(getString(R.string.itemPerf),getString(R.string.descPerf),R.drawable.perfume,R.color.colorPerf));
        list.add(new ItemData(getString(R.string.itemShake),getString(R.string.descShake),R.drawable.shake,R.color.colorShake));
        list.add(new ItemData(getString(R.string.itemJabon),getString(R.string.descJabon),R.drawable.jabon,R.color.colorJabon));
        list.add(new ItemData(getString(R.string.itemAerosol),getString(R.string.descAerosol),R.drawable.aerosol,R.color.colorAerosol));
        list.add(new ItemData(getString(R.string.itemCrema),getString(R.string.descCrema),R.drawable.crema,R.color.colorCrema));
        list.add(new ItemData(getString(R.string.itemEye),getString(R.string.descEye),R.drawable.eyelash,R.color.colorEye));
        list.add(new ItemData(getString(R.string.itemVela),getString(R.string.descVela),R.drawable.vela,R.color.colorVela));
        list.add(new ItemData(getString(R.string.itemIncienso),getString(R.string.descIncienso),R.drawable.incienso,R.color.colorIncienso));
        list.add(new ItemData(getString(R.string.itemBata),getString(R.string.descBata),R.drawable.bata,R.color.colorBata));
        list.add(new ItemData(getString(R.string.itemAroma),getString(R.string.descAroma),R.drawable.aroma,R.color.colorAroma));
        list.add(new ItemData(getString(R.string.itemPiedras),getString(R.string.descPiedras),R.drawable.piedras,R.color.colorPiedras));
        list.add(new ItemData(getString(R.string.itemUñas),getString(R.string.descUñas),R.drawable.unas,R.color.colorUñas));
        list.add(new ItemData(getString(R.string.itemLiga),getString(R.string.descLiga),R.drawable.cintas,R.color.colorLiga));
        list.add(new ItemData(getString(R.string.itemPeine),getString(R.string.descPeine),R.drawable.peine,R.color.colorPeine));
        list.add(new ItemData(getString(R.string.itemSecadora),getString(R.string.descSecadora),R.drawable.secadora,R.color.colorSecadora));
        list.add(new ItemData(getString(R.string.itemBroche),getString(R.string.descBroche),R.drawable.pasadores,R.color.colorBroche));


        lstProductos = (ListView) findViewById(R.id.lstCosme);
        adapter = new ListAdapter(this,R.layout.list_layout,R.id.lblNombre,list);
        lstProductos.setAdapter(adapter);

        lstProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Se ha seleccionado:" + " " +
                        ((ItemData) parent.getItemAtPosition(position)).getTxtNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuitems,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                MainActivity.this.adapter.update(newText);
                MainActivity.this.adapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}