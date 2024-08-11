package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class ExportarDatosActivity extends AppCompatActivity {

    private BarChart barChart;
    private View A_Panel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exportar_datos);

        barChart = findViewById(R.id.grafico_bar);
        A_Panel = findViewById(R.id.buttonVolverPanel);

        setupBarChart();

        A_Panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent back = new Intent(ExportarDatosActivity.this, PanelControlActivity.class);
                startActivity(back);
            }
        });
    }

    private void setupBarChart() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 60f));
        entries.add(new BarEntry(2f, 80f));
        entries.add(new BarEntry(3f, 65f));
        entries.add(new BarEntry(4f, 75f));

        BarDataSet dataSet = new BarDataSet(entries, "Reforestación");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(dataSet);
        barChart.setData(data);
        barChart.invalidate(); // refresh
    }
}