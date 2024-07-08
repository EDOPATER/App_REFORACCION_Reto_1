package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Enlazar la variable real con la Lógica
        ImageView imagen1 = findViewById(R.id.imagen1);

        //Agregar la animación de salida o solidificación
        Animation fadeIn = new AlphaAnimation(0,1);
        fadeIn.setDuration(3000);
        imagen1.startAnimation(fadeIn);

        imagen1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent irAHome = new Intent(SplashActivity.this, BienvenidaActivity.class);
                startActivity(irAHome);
                finish();
            }
        },  3000);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ImageView imagen1 = findViewById(R.id.imagen1);
        imagen1.removeCallbacks(null);
    }
}