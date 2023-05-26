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
import com.example.mycommerceelectronic.modelos.CategoriasModels;

import java.util.List;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.ViewHolder> {
    private Context context;
    private List<CategoriasModels> list;

    public CategoriasAdapter(Context context, List<CategoriasModels> list){
        this.context = context;
        this.list = list;
    }
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_list,parent,false));
    }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){

        Glide.with(context).load(list.get(position).getImg_url()).into(holder.catImg);
        holder.catName.setText(list.get(position).getName());
    }
    public int getItemCount(){
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView catImg;
        TextView catName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catImg = itemView.findViewById(R.id.cat_img);
            catName= itemView.findViewById(R.id.cat_name);

        }
    }
}
