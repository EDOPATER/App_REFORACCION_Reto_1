package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PanelControlActivity extends AppCompatActivity {

    private Button A_Perfil;
    private Button A_Reg_Actividad;
    private Button A_Reg_History;
    private Button A_Reg_Estadisticas;
    private Button A_Info_Ambiental;
    private Button A_Consejos;
    private Button A_Redes_Sociales;
    private Button A_Notificaciones;
    private Button A_Exportar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_panel_control);

        A_Perfil = findViewById(R.id.buttonPerfil);

        A_Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, PerfilUsuarioActivity.class);
                startActivity(next);
            }
        });

        A_Reg_Actividad = findViewById(R.id.button_RegAct);

        A_Reg_Actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, RegistroActividadesPActivity.class);
                startActivity(next);
            }
        });

        A_Reg_History = findViewById(R.id.buttonHistory);

        A_Reg_History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, HistorialActividadesActivity.class);
                startActivity(next);
            }
        });

        A_Reg_Estadisticas = findViewById(R.id.buttonEstadisticas);

        A_Reg_Estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, EstadisticasActivity.class);
                startActivity(next);
            }
        });

        A_Info_Ambiental = findViewById(R.id.buttonInformacion);

        A_Info_Ambiental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, InformacionAmbActivity.class);
                startActivity(next);
            }
        });

        A_Consejos = findViewById(R.id.buttonConsejos);

        A_Consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, ConsejosActivity.class);
                startActivity(next);
            }
        });

        A_Redes_Sociales = findViewById(R.id.buttonRedes);

        A_Redes_Sociales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, RedesSocialesActivity.class);
                startActivity(next);
            }
        });

        A_Notificaciones = findViewById(R.id.buttonNotificaciones);

        A_Notificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, NotificacionesActivity.class);
                startActivity(next);
            }
        });

        A_Exportar = findViewById(R.id.buttonExportar);

        A_Exportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(PanelControlActivity.this, ExportarDatosActivity.class);
                startActivity(next);
            }
        });
    }
}