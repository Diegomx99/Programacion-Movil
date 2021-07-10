package com.example.practica003;

import android.content.Intent;
import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class itemData implements Serializable {

    private String txtNombre;
    private String txtDescripcion;
    private String imageId;
    private Integer colorId;
    private String txtPrecio;

    public itemData(){
        this.txtNombre = "";
        this.txtDescripcion = "";
        this.colorId = 0;
        this.txtPrecio = "";
    }
    public itemData(String cat, String desc, String ImageId, Integer ColorId, String precio){
        this.txtNombre = cat;
        this.txtDescripcion = desc;
        this.imageId = ImageId;
        this.colorId = ColorId;
        this.txtPrecio = precio;
    }


    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(String txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public static ArrayList<itemData> llenarTienda() {
        ArrayList<itemData> items = new ArrayList<>();

        items.add(new itemData("Brocha","Brocha para usarse al momento de aplicar polvos",Uri.parse("android.resource://com.example.practica003/" + R.drawable.cepillo).toString(),R.color.colorBrocha,"$100"));
        items.add(new itemData("Polvo","Polvo base para la cara",Uri.parse("android.resource://com.example.practica003/" +R.drawable.polvo).toString(),R.color.colorPolvo,"$250"));
        items.add(new itemData("Base","Base liquida de bolsillo",Uri.parse("android.resource://com.example.practica003/" + R.drawable.base).toString(),R.color.colorBase,"$200"));
        items.add(new itemData("Brillo labial","Paquete de brillo labial",Uri.parse("android.resource://com.example.practica003/" + R.drawable.brillo).toString(),R.color.colorBrillo,"$250"));
        items.add(new itemData("Lapiz labial","Lapiz labial color rojo",Uri.parse("android.resource://com.example.practica003/" + R.drawable.lapiz).toString(),R.color.colorLapiz,"$120"));
        items.add(new itemData("Sombra","Paquete que contiene 4 colores de sombra para ojos",Uri.parse("android.resource://com.example.practica003/" + R.drawable.sombra).toString(),R.color.colorSombra,"$70"));
        items.add(new itemData("Mascara","Mascara para las cejas",Uri.parse("android.resource://com.example.practica003/" + R.drawable.mascara).toString(),R.color.colorMascara,"$260"));
        items.add(new itemData("Espejo","Espejo de mano de metal",Uri.parse("android.resource://com.example.practica003/" + R.drawable.espejo).toString(),R.color.colorEspejo,"$340"));
        items.add(new itemData("Esmalte","Esmalte de uñas color rojo",Uri.parse("android.resource://com.example.practica003/" + R.drawable.esmalte).toString(),R.color.colorEsmalte,"$150"));
        items.add(new itemData("Perfume","Perfume mediano con olor a lavanda",Uri.parse("android.resource://com.example.practica003/" + R.drawable.perfume).toString(),R.color.colorPerf,"$120"));
        items.add(new itemData("Gotero","Gotero con liquido para ojeras",Uri.parse("android.resource://com.example.practica003/" + R.drawable.shake).toString(),R.color.colorShake,"$230"));
        items.add(new itemData("Jabon Cosmetico","Jabon para remover imperfecciones faciales", Uri.parse("android.resource://com.example.practica003/" + R.drawable.jabon).toString(),R.color.colorJabon,"$250"));
        items.add(new itemData("Aerosol para cabello","Fijador de cabello",Uri.parse("android.resource://com.example.practica003/" + R.drawable.aerosol).toString(),R.color.colorAerosol,"$200"));
        items.add(new itemData("Crema","Crema para humectar la piel",Uri.parse("android.resource://com.example.practica003/" + R.drawable.crema).toString(),R.color.colorCrema,"$125"));
        items.add(new itemData("Pestañas falsas","Pestañas postisas de diferentes tamaños y colores",Uri.parse("android.resource://com.example.practica003/" + R.drawable.eyelash).toString(),R.color.colorEye,"$150"));
        items.add(new itemData("Vela aromatica","Vela con aroma a flores y manzana",Uri.parse("android.resource://com.example.practica003/" + R.drawable.vela).toString(),R.color.colorVela,"$25"));
        items.add(new itemData("Incienso","Set de incienso, incluye la base y 5 palos aromaticos de incienso",Uri.parse("android.resource://com.example.practica003/" + R.drawable.incienso).toString(),R.color.colorIncienso,"$50"));
        items.add(new itemData("Bata","Bata lisa, super comoda",Uri.parse("android.resource://com.example.practica003/" + R.drawable.bata).toString(),R.color.colorBata,"$20"));
        items.add(new itemData("Aromaticos","Set de botellas aromaticas para spa",Uri.parse("android.resource://com.example.practica003/" + R.drawable.aroma).toString(),R.color.colorAroma,"$500"));
        items.add(new itemData("Piedras","Piedras para uso relajante",Uri.parse("android.resource://com.example.practica003/" + R.drawable.piedras).toString(),R.color.colorPiedras,"$50"));
        items.add(new itemData("Uñas Polish","Set de uñas postisas para uso personal",Uri.parse("android.resource://com.example.practica003/" + R.drawable.unas).toString(),R.color.colorUñas,"$450"));
        items.add(new itemData("Liga para cabello","Set de ligas para el cabello",Uri.parse("android.resource://com.example.practica003/" + R.drawable.cintas).toString(),R.color.colorLiga,"$150"));
        items.add(new itemData("Peine para pelo","Peine sencillo para el pelo",Uri.parse("android.resource://com.example.practica003/" + R.drawable.peine).toString(),R.color.colorPeine,"$350"));
        items.add(new itemData("Secadora","Secadora electrica eficaz y rapida",Uri.parse("android.resource://com.example.practica003/" + R.drawable.secadora).toString(),R.color.colorSecadora,"$400"));
        items.add(new itemData("Broches","Set de 10 broches para el pelo",Uri.parse("android.resource://com.example.practica003/" + R.drawable.pasadores).toString(),R.color.colorBroche,"$100"));

        return items;
    }
}
