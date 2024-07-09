package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button Registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button Registro = findViewById(R.id.buttonRegistro);

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this,registrarseActivity.class);
                startActivity(next);
            }
        });
    }
}