package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InicioSesionActivity extends AppCompatActivity {

    private Button volverRegistro;
    private Button inicioPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_sesion);

        volverRegistro = findViewById(R.id.buttonVolverReg);
        inicioPanel = findViewById(R.id.buttonInicio);

        volverRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(InicioSesionActivity.this,registrarseActivity.class);
                startActivity(back);
            }
        });

        inicioPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(InicioSesionActivity.this,panelControlActivity.class);
                startActivity(next);
            }
        });

    }

 }
