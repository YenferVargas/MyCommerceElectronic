package com.example.mycommerceelectronic.activacion;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mycommerceelectronic.R;
import com.example.mycommerceelectronic.fragmentos.InicioFragment;

public class MainActivity extends AppCompatActivity {

        Fragment    iniciofragment;

        protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciofragment = new InicioFragment();
        loadFragment(iniciofragment);

        }

    private void loadFragment(Fragment iniciofragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.inicio_container,iniciofragment);
        transaction.commit();
    }
}