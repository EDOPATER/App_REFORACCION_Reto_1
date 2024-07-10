package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class panelControlActivity extends AppCompatActivity {

    private Button A_Perfil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_panel_control);

        A_Perfil = findViewById(R.id.buttonPerfil);

        A_Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(panelControlActivity.this, perfilUsuarioActivity.class);
                startActivity(next);
            }
        });

    }
}