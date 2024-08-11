package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Enlazar la variable real con la Lógica
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imagen1 = findViewById(R.id.imagen1);
        ImageView imagen2 = findViewById(R.id.imagen2);

        //Agregar la animación de salida o solidificación
        Animation fadeIn = new AlphaAnimation(0,1);
        fadeIn.setDuration(5000);
        imagen1.startAnimation(fadeIn);

        Animation Anim_rot = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
        imagen2.startAnimation(Anim_rot);

        imagen1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent irAHome = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(irAHome);
                finish();
            }
        },  5000);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ImageView imagen1 = findViewById(R.id.imagen1);
        imagen1.removeCallbacks(null);
    }
}