package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

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
    private PieChart pieChart1;
    private PieChart pieChart2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_panel_control);

        pieChart1 = findViewById(R.id.grafico_pie_1);
        pieChart2 = findViewById(R.id.grafico_pie_2);

        setupPieChar1(); // Configura el primer gráfico
        setupPieChart2(); // Configura el segundo gráfico

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

    private void setupPieChar1() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40f, "Plantaciones"));
        entries.add(new PieEntry(30f, "Sembrados"));
        entries.add(new PieEntry(20f, "Especies"));
        entries.add(new PieEntry(10f, "Otros"));

        PieDataSet dataSet = new PieDataSet(entries, "Estadísticas de Reforestación");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        // Cambiar el color del texto de los valores y su tamaño
        dataSet.setValueTextColor(Color.RED); // Color del texto
        dataSet.setValueTextSize(10f); // Tamaño del texto

        PieData data = new PieData(dataSet);
        pieChart1.setData(data);

        // Cambiar el color de las etiquetas de los segmentos
        pieChart1.setEntryLabelColor(Color.BLACK); // Color de las etiquetas

        pieChart1.invalidate(); // refresh
    }

    private void setupPieChart2() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(30f, "Fertilización"));
        entries.add(new PieEntry(45f, "Oxígeno"));
        entries.add(new PieEntry(5f, "Plagas"));
        entries.add(new PieEntry(20f, "Riego"));

        PieDataSet dataSet = new PieDataSet(entries, "Estadísticas de Reforestación");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        // Cambiar el color del texto de los valores y su tamaño
        dataSet.setValueTextColor(Color.RED); // Color del texto
        dataSet.setValueTextSize(10f); // Tamaño del texto

        PieData data = new PieData(dataSet);
        pieChart2.setData(data);

        // Cambiar el color de las etiquetas de los segmentos
        pieChart2.setEntryLabelColor(Color.BLACK); // Color de las etiquetas

        pieChart2.invalidate(); // refresh
    }

}