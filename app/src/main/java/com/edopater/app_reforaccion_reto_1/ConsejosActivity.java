package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.edopater.app_reforaccion_reto_1.Consejo_1_Activity;

public class ConsejosActivity extends AppCompatActivity {

    private Button A_Planificacion;
    private Button A_Seleccion_Planta;
    private Button A_Plantacion;
    private Button A_Riego;
    private Button A_Control_Malezas;
    private Button A_Plagas;
    private Button A_Podas;
    private Button A_Seguimiento;
    private Button A_Capacitacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consejos);

        A_Planificacion = findViewById(R.id.buttonPlanificacion);

        A_Planificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_1_Activity.class);
                startActivity(next);
            }
        });

        A_Seleccion_Planta = findViewById(R.id.buttonManPlantas);

        A_Seleccion_Planta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_2_Activity.class);
                startActivity(next);
            }
        });

        A_Plantacion = findViewById(R.id.buttonPlantacion);

        A_Plantacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_3_Activity.class);
                startActivity(next);
            }
        });

        A_Riego = findViewById(R.id.buttonRiego);

        A_Riego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_4_Activity.class);
                startActivity(next);
            }
        });

        /*A_Control_Malezas = findViewById(R.id.buttonMalezas);

        A_Control_Malezas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_5_Activity.class);
                startActivity(next);
            }
        });

        A_Plagas = findViewById(R.id.buttonPlagas);

        A_Plagas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_6_Activity.class);
                startActivity(next);
            }
        });

        A_Podas = findViewById(R.id.buttonPodas);

        A_Podas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_7_Activity.class);
                startActivity(next);
            }
        });

        A_Seguimiento = findViewById(R.id.buttonSeguimiento);

        A_Seguimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_8_Activity.class);
                startActivity(next);
            }
        });

        A_Capacitacion = findViewById(R.id.buttonCapacitacion);

        A_Capacitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(ConsejosActivity.this, Consejo_9_Activity.class);
                startActivity(next);
            }
        });*/



    }
}