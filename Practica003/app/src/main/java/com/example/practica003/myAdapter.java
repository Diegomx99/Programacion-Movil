package com.example.practica003;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Locale;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> implements View.OnClickListener{

    private ArrayList<itemData> listaTienda;
    private ArrayList<itemData> copyLista = new ArrayList<>();
    private View.OnClickListener listener;
    private Context context;
    private LayoutInflater inflater;

    public myAdapter(ArrayList<itemData> listaTienda, Context context) {
        this.listaTienda = listaTienda;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.copyLista.addAll(listaTienda);
    }

    @Override
    public void onClick(View v) {
        if(listener != null) listener.onClick(v);
    }

    @NonNull
    @NotNull
    @Override
    public myAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tienda_items,null,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull myAdapter.ViewHolder holder, int position) {
        itemData item = listaTienda.get(position);
        holder.txtNombre.setText(item.getTxtNombre());
        holder.txtDescripcion.setText(item.getTxtDescripcion());
        holder.txtPrecio.setText(item.getTxtPrecio());
        holder.imageId.setImageURI(Uri.parse(item.getImageId()));
    }

    @Override
    public int getItemCount() {
        return listaTienda.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private LayoutInflater inflater;
        private TextView txtNombre;
        private TextView txtDescripcion;
        private TextView txtPrecio;
        private ImageView imageId;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtDescripcion = (TextView) itemView.findViewById(R.id.txtDescripcion);
            txtPrecio = (TextView) itemView.findViewById(R.id.txtPrecio);
            imageId = (ImageView) itemView.findViewById(R.id.foto);
        }
    }

    public void update(String newText){
        this.listaTienda.clear();
        if(newText.isEmpty()){
            this.listaTienda.addAll(this.copyLista);
        }
        for (itemData item : this.copyLista){
            if(item.getTxtNombre().toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))){
                this.listaTienda.add(item);
            }
        }
    }
}
