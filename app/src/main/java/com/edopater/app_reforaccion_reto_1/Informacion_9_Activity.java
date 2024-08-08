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

public class Informacion_9_Activity extends AppCompatActivity {

    private Button A_Informacion;
    private RecyclerView recyclerViewPosts;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextAdapter textAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion9);

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
                Intent back = new Intent(Informacion_9_Activity.this, InformacionAmbActivity.class);
                startActivity(back);
            }
        });
    }
    //PENDIENTE EL CONTENIDO DEL TEXTO
    private SpannableString getTextContent() {
        String text = "\tCreación de Hábitats\n\n" +
                "1.\tRefugio para Especies: La reforestación crea nuevos hábitats para diversas especies de plantas, animales, insectos y microorganismos, proporcionando refugio y áreas de reproducción.\n" +
                "2.\tDiversidad de Nichos: Al establecer una variedad de especies de árboles y estructuras de vegetación, se crean diferentes nichos ecológicos que pueden ser ocupados por una mayor diversidad de especies.\n\n" +
                "\tConectividad Ecológica\n\n" +
                "1.\tConexión de Fragmentos de Bosque: Las plantaciones de árboles pueden actuar como corredores biológicos que conectan áreas fragmentadas de bosque, permitiendo el movimiento de especies y el flujo genético entre poblaciones.\n" +
                "2.\tReducción del Aislamiento: Estos corredores ayudan a reducir el aislamiento de poblaciones pequeñas, aumentando sus oportunidades de supervivencia y reproducción.\n\n" +
                "\tRecuperación de Ecosistemas Degradados\n\n" +
                "1.\tRestauración de Funciones Ecológicas: La reforestación puede restaurar las funciones ecológicas perdidas en áreas degradadas, como la regulación del ciclo del agua, la fijación de nutrientes y la mejora de la calidad del suelo.\n" +
                "2.\tIncremento de la Resiliencia: La recuperación de ecosistemas degradados mejora la resiliencia frente a perturbaciones como incendios, sequías y enfermedades.\n\n" +
                "\tAumento de la Diversidad de Especies\n\n" +
                "1.\tPlantación de Especies Nativas: Incluir una variedad de especies de árboles nativos en las plantaciones aumenta la biodiversidad y proporciona beneficios específicos a la fauna local que depende de esas especies.\n" +
                "•\tInteracciones Ecológicas: La reforestación promueve interacciones ecológicas complejas, como la polinización y la dispersión de semillas, que son cruciales para la diversidad y la salud del ecosistema.\n\n" +
                "\tConservación de Especies Amenazadas\n\n" +
                "1.\tHábitats Críticos: La reforestación puede crear o expandir hábitats críticos para especies amenazadas o en peligro de extinción, proporcionando áreas seguras para su supervivencia.\n" +
                "2.\tFomento de Poblaciones: Al aumentar la cantidad y calidad de hábitats disponibles, se pueden fomentar el crecimiento y la recuperación de poblaciones de especies vulnerables.\n\n" +
                "\tMitigación del Cambio Climático\n\n" +
                "1.\tSecuestro de Carbono: Los árboles capturan y almacenan dióxido de carbono (CO₂) de la atmósfera, lo que ayuda a mitigar el cambio climático y sus impactos negativos sobre la biodiversidad.\n" +
                "2.\tMicroclimas Locales: Las áreas reforestadas pueden crear microclimas más favorables para diversas especies, protegiéndolas de temperaturas extremas y condiciones climáticas adversas.\n\n";

        SpannableString spannableString = new SpannableString(text);

        int start1 = text.indexOf("Creación de Hábitats");
        int end1 = start1 + "Creación de Hábitats".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start1, end1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start2 = text.indexOf("Conectividad Ecológica");
        int end2 = start2 + "Conectividad Ecológica".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start2, end2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start3 = text.indexOf("Recuperación de Ecosistemas Degradados");
        int end3 = start3 + "Recuperación de Ecosistemas Degradados".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start3, end3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start4 = text.indexOf("Aumento de la Diversidad de Especies");
        int end4 = start4 + "Aumento de la Diversidad de Especies".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start4, end4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start5 = text.indexOf("Conservación de Especies Amenazadas");
        int end5 = start5 + "Conservación de Especies Amenazadas".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start5, end5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start6 = text.indexOf("Mitigación del Cambio Climático");
        int end6 = start6 + "Mitigación del Cambio Climático".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start6, end6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
}

