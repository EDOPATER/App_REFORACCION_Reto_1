package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class registroActividadesPActivity extends AppCompatActivity {

    private Button A_Panel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_actividades_plantacion);

        A_Panel = findViewById(R.id.buttonVolverPanel);

        A_Panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent back = new Intent(registroActividadesPActivity.this, panelControlActivity.class);
                startActivity(back);
            }
        });

    }
}