package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class InformacionAmbActivity extends AppCompatActivity {

    private Button A_Panel;
    private Button A_Carbono;
    private Button A_Calidad;
    private Button A_Biodiversidad;
    private Button A_Agua;
    private Button A_Beneficios;
    private Button A_ImpactoClima;
    private Button A_Normas;
    private Button A_Compensacion;
    private Button A_HuellaCarbono;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_ambiental);

        A_Panel = findViewById(R.id.buttonVolverPanel);

        A_Panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent back = new Intent(InformacionAmbActivity.this, PanelControlActivity.class);
                startActivity(back);
            }
        });

        A_Carbono = findViewById(R.id.buttonCarbono);

        A_Carbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_1_Activity.class);
                startActivity(next);
            }
        });

        A_Calidad = findViewById(R.id.buttonCalidad);

        A_Calidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_2_Activity.class);
                startActivity(next);
            }
        });

        /*A_Biodiversidad = findViewById(R.id.buttonBiodiversidad);

        A_Biodiversidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_3_Activity.class);
                startActivity(next);
            }
        });

        A_Agua = findViewById(R.id.buttonAgua);

        A_Agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_4_Activity.class);
                startActivity(next);
            }
        });

        A_Beneficios = findViewById(R.id.buttonBeneficios);

        A_Beneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_5_Activity.class);
                startActivity(next);
            }
        });

        A_ImpactoClima = findViewById(R.id.buttonImpactoClima);

        A_ImpactoClima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_6_Activity.class);
                startActivity(next);
            }
        });

        A_Normas = findViewById(R.id.buttonNormas);

        A_Normas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_7_Activity.class);
                startActivity(next);
            }
        });

        A_Compensacion = findViewById(R.id.buttonCompensacion);

        A_Compensacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_8_Activity.class);
                startActivity(next);
            }
        });

        A_HuellaCarbono = findViewById(R.id.buttonHuellaCarbono);

        A_HuellaCarbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InformacionAmbActivity.this, Informacion_9_Activity.class);
                startActivity(next);
            }
        });*/

    }
}