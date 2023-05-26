package com.example.mycommerceelectronic.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mycommerceelectronic.R;
import com.example.mycommerceelectronic.adaptacion.CategoriasAdapter;
import com.example.mycommerceelectronic.adaptacion.NuevoProductoAdapter;
import com.example.mycommerceelectronic.modelos.CategoriasModels;
import com.example.mycommerceelectronic.modelos.NuevoProductoModelo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {


    RecyclerView catRecyclerview,nuevoProductoRecyclerview;

    //Categoria vista del reciclador xd :(
    CategoriasAdapter categoriasAdapter;
    List<CategoriasModels> categoriaModelList;

    //Nuevo producto recyclerview
    NuevoProductoAdapter nuevoProductoAdapter;
    List<NuevoProductoModelo>nuevoProductoModeloList;

     //Firebase aqui la conexion a la base de datos
    FirebaseFirestore db ;
    public InicioFragment(){


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //el diseño de este fragmento
        View root = inflater.inflate( R.layout.fragment_inicio, container, false);
        catRecyclerview = root.findViewById(R.id.rec_category);
        //inis
        nuevoProductoRecyclerview = root.findViewById(R.id.new_product_rec);

       //aqui el error
        newProductReciclerview = root.findViewById(R.id.new_product_rec);
        popularRecyclerView = root.findViewById(R.id.popular_rec);
        db = FirebaseFirestore.getInstance();

        //imagen deslizante
        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.home_9,"descuento en artículos de belleza", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner2,"descuento en perfumes", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner3,"70 % OFF", ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(slideModels);

        //Categoria
        catRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoriaModelList = new ArrayList<>();
        categoriasAdapter = new CategoriasAdapter(getContext(),categoriaModelList);
        catRecyclerview.setAdapter(categoriasAdapter);

        db.collection("Categoria")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                CategoriasModels categoriasModels = document.toObject(CategoriasModels.class);
                                categoriaModelList.add(categoriasModels);
                                categoriasAdapter.notifyDataSetChanged();
                            }
                        }else {

                        }

                    }
                });


        return root;
    }


}