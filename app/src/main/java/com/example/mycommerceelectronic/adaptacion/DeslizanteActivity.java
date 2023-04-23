package com.example.mycommerceelectronic.adaptacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mycommerceelectronic.R;

public class DeslizanteActivity extends PagerAdapter {

    Context context;

    LayoutInflater layoutInflater;

    public DeslizanteActivity(Context context){
        this.context = context;
    }
    int imagesArray[] = {

            R.drawable.onboardscreen1,
            R.drawable.onboardscreen2,
            R.drawable.onboardscreen3

    };
    int headingArray [] = {
            R.string.primera_slide,
            R.string.segunda_slide,
            R.string.tercera_slide
    };
    int descripcionArray [] = {
            R.string.descripcion,
            R.string.descripcion,
            R.string.descripcion,

    };



    @Override
    public int getCount() {
        return headingArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)  context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.deslizante,container, false);

        ImageView imageView = view.findViewById(R.id.slider_img);
        TextView heading = view.findViewById(R.id.heading);
        TextView descripcion = view.findViewById(R.id.description);

        imageView.setImageResource(imagesArray[position]);
        heading.setText(headingArray[position]);
        descripcion.setText(descripcionArray[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

    public static class AdaptadorDeslizante {
    }
}
