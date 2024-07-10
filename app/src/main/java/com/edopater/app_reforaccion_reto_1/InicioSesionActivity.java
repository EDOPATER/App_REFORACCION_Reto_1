package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InicioSesionActivity extends AppCompatActivity {

    private Button A_panelControl;
    private Button A_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_sesion);

        A_panelControl = findViewById(R.id.buttonInicio);
        A_registro = findViewById(R.id.buttonVolverReg);

        A_panelControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InicioSesionActivity.this, panelControlActivity.class);
                startActivity(next);
            }
        });

        A_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent back = new Intent(InicioSesionActivity.this, registrarseActivity.class);
                startActivity(back);
            }
        });
  }
}