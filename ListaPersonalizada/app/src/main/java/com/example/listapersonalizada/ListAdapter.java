package com.example.listapersonalizada;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Locale;

public class ListAdapter extends ArrayAdapter<ItemData> {

    int groupId;
    Activity Context;
    ArrayList<ItemData> list;
    ArrayList<ItemData> copyList = new ArrayList<>();
    LayoutInflater inflater;

    public ListAdapter(Activity Context, int groupId, int id, ArrayList<ItemData> list) {
        super(Context,id,list);
        this.list = list;
        inflater = (LayoutInflater) Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupId = groupId;
        this.copyList.addAll(list);
    }

    public View getView(int posicion, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupId,parent,false);
        ImageView imagen = (ImageView) itemView.findViewById(R.id.imgProducto);
        imagen.setImageResource(list.get(posicion).getImageId());
        TextView lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
        lblNombre.setTextColor(ContextCompat.getColor(getContext(),list.get(posicion).getColorId()));
        lblNombre.setText(list.get(posicion).getTxtNombre());
        TextView lblDescripcion = (TextView) itemView.findViewById(R.id.lblDescripcion);
        lblDescripcion.setText(list.get(posicion).getTxtDescripcion());
        return itemView;
    }

    public View getDropDownView(int posicion, View convertView, ViewGroup parent){
        return getView(posicion,convertView,parent);
    }

    public void update(String newText){
        this.list.clear();
        if(newText.isEmpty()){
            this.list.addAll(this.copyList);
        }
        for (ItemData item : this.copyList){
            if(item.getTxtNombre().toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))){
                this.list.add(item);
            }
        }
    }
}
