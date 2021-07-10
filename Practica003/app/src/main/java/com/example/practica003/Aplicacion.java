package com.example.practica003;

import android.app.Application;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Aplicacion extends Application {

    public static ArrayList<itemData> items;
    private myAdapter adapter;

    public ArrayList<itemData> getItems() {
        return items;
    }

    public myAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        items = itemData.llenarTienda();
        adapter = new myAdapter(items, this);
    }
}
