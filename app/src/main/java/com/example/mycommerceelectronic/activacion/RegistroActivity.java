package com.example.mycommerceelectronic.activacion;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycommerceelectronic.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistroActivity extends AppCompatActivity{

        EditText name,email,password;
        private FirebaseAuth auth;

        SharedPreferences sharedPreferences;

        protected void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_registro);

                getSupportActionBar().hide();

                auth = FirebaseAuth.getInstance();
                if (auth.getCurrentUser() != null){
                        startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                        finish();
                }

                name = findViewById(R.id.name);
                email = findViewById(R.id.email);
                password = findViewById(R.id.password);

                sharedPreferences = getSharedPreferences("PantalladeEmbarque",MODE_PRIVATE);
                boolean isFirstTime = sharedPreferences.getBoolean("PrimerTiempo", true);

                if (isFirstTime){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("PrimerTiempo",false);
                        editor.commit();

                        Intent intent = new Intent(RegistroActivity.this, IntegracionActivity.class);
                        startActivity(intent);
                        finish();
                }


        }
        public void registrar(View view){

                String userName = name.getText().toString();
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();

                if (TextUtils.isEmpty(userName)){
                        Toast.makeText(this,"Introduzca el nombre!", Toast.LENGTH_SHORT).show();
                        return;
                }

                if (TextUtils.isEmpty(userEmail)){
                        Toast.makeText(this,"Introducir su correo electrónico!", Toast.LENGTH_SHORT).show();
                        return;
                }

                if (TextUtils.isEmpty(userPassword)){
                        Toast.makeText(this,"Intruzca su contraseña!", Toast.LENGTH_SHORT).show();
                        return;
                }
                if (userPassword.length() < 6){
                        Toast.makeText(this,"Contraseña demasiado corta, introduzca al menos 6 caracteres!", Toast.LENGTH_SHORT).show();
                        return;
                }
                auth.createUserWithEmailAndPassword(userEmail,userPassword)
                        .addOnCompleteListener(RegistroActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                            Toast.makeText(RegistroActivity.this,"Registro satisfactorio", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(RegistroActivity.this,MainActivity.class));
                                    }else {
                                            Toast.makeText(RegistroActivity.this,"Registro fallido"+task.getException(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                        });

               // startActivity(new Intent(RegistroActivity.this,MainActivity.class));

        }

        public void iniciar(View view) {
                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
        }
}