package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
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

public class EstadisticasActivity extends AppCompatActivity {

    private BarChart barChart;
    private PieChart pieChart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas_progreso);

        barChart = findViewById(R.id.grafico_bar);
        pieChart = findViewById(R.id.grafico_pie);

        setupBarChart();
        setupPieChart();

        Button volverPanelButton = findViewById(R.id.buttonVolverPanel);
        volverPanelButton.setOnClickListener(v -> {
            Intent intent = new Intent(EstadisticasActivity.this, PanelControlActivity.class);
            startActivity(intent);
        });
    }

    private void setupBarChart() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 55f));
        entries.add(new BarEntry(2f, 80f));
        entries.add(new BarEntry(3f, 65f));
        entries.add(new BarEntry(4f, 70f));

        BarDataSet dataSet = new BarDataSet(entries, "Reforestación");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(dataSet);
        barChart.setData(data);
        barChart.invalidate(); // refresh
    }

    private void setupPieChart() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40f, "Plantaciones"));
        entries.add(new PieEntry(30f, "Árboles plantados"));
        entries.add(new PieEntry(20f, "Especies"));
        entries.add(new PieEntry(10f, "Otros"));

        PieDataSet dataSet = new PieDataSet(entries, "Estadísticas de Reforestación");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        // Cambiar el color del texto de los valores y su tamaño
        dataSet.setValueTextColor(Color.RED); // Color del texto
        dataSet.setValueTextSize(12f); // Tamaño del texto

        PieData data = new PieData(dataSet);
        pieChart.setData(data);

        // Cambiar el color de las etiquetas de los segmentos
        pieChart.setEntryLabelColor(Color.BLACK); // Color de las etiquetas

        pieChart.invalidate(); // refresh
    }
}
