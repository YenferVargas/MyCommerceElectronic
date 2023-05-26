package com.example.mycommerceelectronic.adaptacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mycommerceelectronic.R;
import com.example.mycommerceelectronic.modelos.NuevoProductoModelo;

import java.util.List;

public class NuevoProductoAdapter extends RecyclerView.Adapter<NuevoProductoAdapter.ViewHolder> {
    private Context context;
    private List<NuevoProductoModelo> list;

    public NuevoProductoAdapter(Context context, List<NuevoProductoModelo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nuevo_producto,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.nuevoImg);
        holder.nuevoNombre.setText(list.get(position).getNombre());
        holder.nuevoPrecio.setText(list.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView nuevoImg;
        TextView nuevoNombre, nuevoPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nuevoImg = itemView.findViewById(R.id.new_img);
            nuevoNombre = itemView.findViewById(R.id.new_product_name);
            nuevoPrecio = itemView.findViewById(R.id.new_price);
        }
    }

}
