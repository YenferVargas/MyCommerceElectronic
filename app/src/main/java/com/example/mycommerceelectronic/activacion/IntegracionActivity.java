package com.example.mycommerceelectronic.activacion;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mycommerceelectronic.adaptacion.DeslizanteActivity;
import com.example.mycommerceelectronic.R;

public class IntegracionActivity extends AppCompatActivity{

    ViewPager viewPager;
    LinearLayout dotsLayout;

    Button btn;
    DeslizanteActivity deslizanteActivity;

    TextView[] dots;

    Animation animacion;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //ocultar la barra de estado
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
        setContentView(R.layout.activity_integracion);

        //Ocultar barra de herramientas
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        btn = findViewById(R.id.get_started_btn);
        addDots(0);

        viewPager.addOnPageChangeListener(changeListener);

        //Adaptador de llamada
        deslizanteActivity = new DeslizanteActivity(this);
        viewPager.setAdapter(deslizanteActivity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntegracionActivity.this, RegistroActivity.class));
                finish();
            }
        });
        }
///los tres puntitos al momento de deslizar
        private void addDots(int position){
            dots = new TextView[3];
            dotsLayout.removeAllViews();
            for  (int i = 0; i < dots.length; i++){
                dots[i] = new TextView(this);
                dots[i].setText(Html.fromHtml("&#8226"));
                dots[i].setTextSize(35);
                dotsLayout.addView(dots[i]);

            }
            if (dots.length > 0 ){
                dots[position].setTextColor(getResources().getColor(R.color.pinkk));
            }
        }
        ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //Para la visibilidad de los puntitos

            @Override
            public void onPageSelected(int position) {
                addDots(position);

                if(position == 0){
                    btn.setVisibility(View.INVISIBLE);

                }else if (position == 1){
                    btn.setVisibility((View.INVISIBLE));
                }else {
                    animacion = AnimationUtils.loadAnimation(IntegracionActivity.this,R.anim.slide_animacion);
                    btn.setAnimation(animacion);
                    btn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
}


