package com.edopater.app_reforaccion_reto_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import android.annotation.SuppressLint;
import android.widget.EditText;
import android.widget.Toast;

public class registrarseActivity extends AppCompatActivity {

    private Button A_Inicio;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrarse);

        A_Inicio = findViewById(R.id.buttonRegistro2);

        A_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(registrarseActivity.this, InicioSesionActivity.class);
                startActivity(next);
            }
        });




    }
}