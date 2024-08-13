package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.VideoView;
import android.net.Uri;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private VideoView videoRefor;
    private Button Registro;
    private Button Inicio;
    private TextView recuperarContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoRefor = findViewById(R.id.videoRefor);
        Registro = findViewById(R.id.buttonRegistro);
        Inicio = findViewById(R.id.buttonInicio);
        recuperarContrasena = findViewById(R.id.textView9);

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, RegistrarseActivity.class);
                startActivity(next);
            }
        });

        Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, InicioSesionActivity.class);
                startActivity(next);
            }
        });

        recuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, RecuperarContrasenaActivity.class);
                startActivity(next);
            }
        });

        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_reforestar;
        videoRefor.setVideoURI(Uri.parse(path));

        videoRefor.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                float volume = 1.0f;
                mp.setVolume(volume, volume);
                mp.start();
            }
        });
    }
}