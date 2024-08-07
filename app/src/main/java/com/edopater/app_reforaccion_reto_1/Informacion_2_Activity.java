package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;

public class Informacion_2_Activity extends AppCompatActivity {

    private Button A_Informacion;
    private RecyclerView recyclerViewPosts;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextAdapter textAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion2);

        recyclerViewPosts = findViewById(R.id.recyclerViewPosts);
        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerViewPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<SpannableString> spannableStrings = new ArrayList<>();
        spannableStrings.add(getTextContent());

        textAdapter = new TextAdapter(this, spannableStrings);
        recyclerView.setAdapter(textAdapter);

        A_Informacion = findViewById(R.id.buttonVolverInformacion);

        A_Informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Informacion_2_Activity.this, InformacionAmbActivity.class);
                startActivity(back);
            }
        });
    }

    private SpannableString getTextContent() {
        String text = "\tPrevención de la Erosión del Suelo\n\n" +
                "1.\tRaíces de los árboles: Las raíces de los árboles ayudan a mantener la estructura del suelo, reduciendo la erosión por agua y viento.\n" +
                "2.\tCobertura Vegetal: Las hojas y ramas de los árboles proporcionan una cobertura que protege el suelo de la erosión directa causada por la lluvia y el viento.\n\n" +
                "\tMejora de la Estructura del Suelo\n\n" +
                "1.\tMateria Orgánica: La descomposición de las hojas, ramas y raíces muertas de los árboles añade materia orgánica al suelo, mejorando su estructura y aumentando su capacidad de retener agua y nutrientes.\n" +
                "2.\tAgregados del Suelo: La actividad biológica en el suelo, como la acción de los microorganismos, ayuda a formar agregados del suelo, mejorando la porosidad y la aireación del suelo.\n\n" +
                "\tIncremento de la Fertilidad del Suelo\n\n" +
                "1.\tCiclo de Nutrientes: Los árboles contribuyen al ciclo de nutrientes al absorberlos del suelo y devolverlos en forma de hojarasca y residuos vegetales, que se descomponen y liberan nutrientes de nuevo al suelo.\n" +
                "2.\tNitrógeno: Algunas especies de árboles, como las leguminosas, fijan nitrógeno en el suelo a través de una relación simbiótica con bacterias, aumentando la fertilidad del suelo.\n\n" +
                "\tRetención de Agua\n\n" +
                "1.\tCapacidad de Retención de Agua: Los suelos con alto contenido de materia orgánica tienen una mayor capacidad para retener agua, lo cual es crucial en áreas con variabilidad en la disponibilidad de agua.\n" +
                "2.\tReducción de la Escorrentía: La cobertura de los árboles y la mejora de la estructura del suelo disminuyen la escorrentía superficial, aumentando la infiltración de agua y recargando los acuíferos.\n\n" +
                "\tAumento de la Actividad Biológica del Suelo\n\n" +
                "1.\tMicroorganismos del Suelo: La descomposición de materia orgánica por microorganismos del suelo mejora la salud del suelo y su capacidad para soportar el crecimiento de plantas.\n" +
                "2.\tFauna del Suelo: Los árboles crean un hábitat favorable para una variedad de fauna del suelo, como lombrices y otros invertebrados, que mejoran la aireación y la estructura del suelo.\n\n" +
                "\tRegulación del pH del Suelo\n\n" +
                "1.\t•\tNeutralización: La descomposición de la materia orgánica y la acción de las raíces pueden ayudar a neutralizar el pH del suelo, creando condiciones más favorables para el crecimiento de plantas\n\n";

        SpannableString spannableString = new SpannableString(text);

        int start1 = text.indexOf("Prevención de la Erosión del Suelo");
        int end1 = start1 + "Prevención de la Erosión del Suelo".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start1, end1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start2 = text.indexOf("Mejora de la Estructura del Suelo");
        int end2 = start2 + "Mejora de la Estructura del Suelo".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start2, end2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start3 = text.indexOf("Incremento de la Fertilidad del Suelo");
        int end3 = start3 + "Incremento de la Fertilidad del Suelo".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start3, end3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start4 = text.indexOf("Retención de Agua");
        int end4 = start4 + "Retención de Agua".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start4, end4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start5 = text.indexOf("Aumento de la Actividad Biológica del Suelo");
        int end5 = start5 + "Aumento de la Actividad Biológica del Suelo".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start5, end5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start6 = text.indexOf("Regulación del pH del Suelo");
        int end6 = start6 + "Regulación del pH del Suelo".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start6, end6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
}
