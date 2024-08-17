package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class ExportarDatosActivity extends AppCompatActivity {

    private BarChart barChart;
    private View A_Panel, downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exportar_datos);

        barChart = findViewById(R.id.grafico_bar);
        A_Panel = findViewById(R.id.buttonVolverPanel);
        downloadButton = findViewById(R.id.buttonDescargar);

        setupBarChart();

        A_Panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ExportarDatosActivity.this, PanelControlActivity.class);
                startActivity(back);
            }
        });

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exportarDatosPDF();
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

    private void exportarDatosPDF() {
        // Obtener los datos desde SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("ActividadesPrefs", MODE_PRIVATE);
        String especieVariedad = sharedPreferences.getString("especieVariedad", "N/A");
        String fechaSiembra = sharedPreferences.getString("fechaSiembra", "N/A");
        String ubicacionGeografica = sharedPreferences.getString("ubicacionGeografica", "N/A");
        String cantidadSiembra = sharedPreferences.getString("cantidadSiembra", "N/A");
        String alturaDiametro = sharedPreferences.getString("alturaDiametro", "N/A");
        String fechaRegistro = sharedPreferences.getString("fechaRegistro", "N/A");

        // Crear un documento PDF
        PdfDocument documentoPDF = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
        PdfDocument.Page pagina = documentoPDF.startPage(pageInfo);
        Canvas canvas = pagina.getCanvas();
        Paint paint = new Paint();

        paint.setTextSize(16);

        int y = 25;
        canvas.drawText("Datos de Reforestación", 10, y, paint);
        y += 20;
        canvas.drawText("Especie/Variedad: " + especieVariedad, 10, y, paint);
        y += 20;
        canvas.drawText("Fecha de Siembra: " + fechaSiembra, 10, y, paint);
        y += 20;
        canvas.drawText("Ubicación Geográfica: " + ubicacionGeografica, 10, y, paint);
        y += 20;
        canvas.drawText("Cantidad de Siembra: " + cantidadSiembra, 10, y, paint);
        y += 20;
        canvas.drawText("Altura/Diámetro: " + alturaDiametro, 10, y, paint);
        y += 20;
        canvas.drawText("Fecha de Registro: " + fechaRegistro, 10, y, paint);

        documentoPDF.finishPage(pagina);

        // Guardar el documento PDF
        String directorio = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        String nombreArchivo = "Datos_Reforestacion.pdf";
        File archivoPDF = new File(directorio, nombreArchivo);

        try {
            documentoPDF.writeTo(new FileOutputStream(archivoPDF));
            Toast.makeText(this, "PDF guardado en " + archivoPDF.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar el PDF: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            documentoPDF.close();
        }
    }
}