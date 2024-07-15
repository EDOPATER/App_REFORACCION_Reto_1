package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.VideoView;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    private VideoView videoRefor;
    private Button Registro;
    private Button Inicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        videoRefor = findViewById(R.id.videoRefor);
        Registro = findViewById(R.id.buttonRegistro);
        Inicio = findViewById(R.id.buttonInicio);

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
            Intent next = new Intent(MainActivity.this, registrarseActivity.class);
            startActivity(next);
    }
    });

        Inicio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
        Intent next = new Intent(MainActivity.this, InicioSesionActivity.class);
        startActivity(next);
    }
    });

        // Asignación de la ruta del video que está en res/raw
        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_reforestar;
        videoRefor.setVideoURI(Uri.parse(path));

        // Iniciar la reproducción del video
        videoRefor.start();

  }
}

