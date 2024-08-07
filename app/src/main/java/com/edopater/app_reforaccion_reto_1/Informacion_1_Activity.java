package com.edopater.app_reforaccion_reto_1;

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

public class Informacion_1_Activity extends AppCompatActivity {

    private Button A_Informacion;
    private RecyclerView recyclerViewPosts;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextAdapter textAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion1);

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
                Intent back = new Intent(Informacion_1_Activity.this, InformacionAmbActivity.class);
                startActivity(back);
            }
        });
    }

    private SpannableString getTextContent() {
        String text = "\tCaptura de Carbono\n\n" +
                "1.\tSecuestro de CO₂: Los árboles absorben dióxido de carbono (CO₂) de la atmósfera durante la fotosíntesis y lo almacenan en su biomasa (troncos, ramas, hojas y raíces) y en el suelo. Este proceso, conocido como secuestro de carbono, reduce la concentración de CO₂ en la atmósfera, uno de los principales gases de efecto invernadero responsables del cambio climático.\n" +
                "2.\tAlmacenamiento a Largo Plazo: La madera de los árboles puede almacenar carbono durante décadas o incluso siglos, especialmente en especies de crecimiento lento y en bosques manejados de manera sostenible. Esto proporciona una solución a largo plazo para el almacenamiento de carbono.\n\n" +
                "\tBeneficios Ecológicos\n\n" +
                "1.\tRestauración de Ecosistemas: La reforestación contribuye a la restauración de ecosistemas degradados, mejorando la biodiversidad y la resiliencia de los ecosistemas frente al cambio climático. Los bosques sanos son más capaces de soportar condiciones climáticas extremas y de recuperarse de perturbaciones.\n" +
                "2.\tProtección del Suelo: Los árboles ayudan a prevenir la erosión del suelo, mejoran su estructura y aumentan su capacidad de retener agua. Esto es crucial para mantener la salud del suelo y su capacidad de actuar como sumidero de carbono.\n\n" +
                "\tBeneficios Climáticos\n\n" +
                "1.\tRegulación del Clima Local: Los bosques influyen en el clima local mediante la moderación de temperaturas, la reducción de la velocidad del viento y la regulación de la humedad. Esto puede mitigar algunos de los efectos locales del cambio climático, como olas de calor y sequías.\n" +
                "2.\tCiclo del Agua: Los árboles juegan un papel crucial en el ciclo del agua, promoviendo la infiltración del agua en el suelo y reduciendo la escorrentía superficial, lo cual es esencial para la recarga de acuíferos y la regulación de los flujos de agua dulce.\n\n" +
                "\tBeneficios Sociales\n\n" +
                "1.\tMejora de la Calidad del Aire: Los árboles no solo capturan CO₂, sino que también absorben otros contaminantes atmosféricos, mejorando la calidad del aire y, por ende, la salud pública.\n" +
                "2.\tServicios Ecosistémicos: Los bosques proporcionan numerosos servicios ecosistémicos, como la regulación del ciclo del agua, la conservación de la biodiversidad, y la recreación y el turismo, mejorando la calidad de vida de las comunidades locales.\n\n" +
                "\tBeneficios Económicos\n\n" +
                "1.\tGeneración de Empleo: Las actividades de reforestación y manejo forestal sostenible crean empleos en áreas rurales, contribuyendo al desarrollo económico y a la reducción de la pobreza.\n" +
                "2.\tProducción de Recursos: Las plantaciones de árboles pueden proporcionar madera, productos forestales no madereros (como frutas, resinas y medicinas) y biomasa para energía, ofreciendo fuentes de ingresos sostenibles.\n\n" +
                "\tComplementariedad con Otras Estrategias\n\n" +
                "1.\tSinergias con la CAC: La reforestación puede complementarse con tecnologías de captura y almacenamiento de carbono (CAC) industrial, ofreciendo una estrategia integral para la mitigación del cambio climático. Mientras la CAC captura y almacena CO₂ de fuentes puntuales como plantas industriales, la reforestación captura CO₂ de la atmósfera de manera difusa y distribuye este almacenamiento en el paisaje.\n" +
                "2.\tEnfoques Holísticos: La combinación de reforestación con prácticas agrícolas sostenibles, conservación de bosques naturales y restauración de suelos puede maximizar la captura de carbono y contribuir a un uso más sostenible de la tierra.\n\n";

        SpannableString spannableString = new SpannableString(text);

        int start1 = text.indexOf("Captura de Carbono");
        int end1 = start1 + "Captura de Carbono".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start1, end1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start2 = text.indexOf("Beneficios Ecológicos");
        int end2 = start2 + "Beneficios Ecológicos".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start2, end2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start3 = text.indexOf("Beneficios Climáticos");
        int end3 = start3 + "Beneficios Climáticos".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start3, end3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start4 = text.indexOf("Beneficios Sociales");
        int end4 = start4 + "Beneficios Sociales".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start4, end4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start5 = text.indexOf("Beneficios Económicos");
        int end5 = start5 + "Beneficios Económicos".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start5, end5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start6 = text.indexOf("Complementariedad con Otras Estrategias");
        int end6 = start6 + "Complementariedad con Otras Estrategias".length();
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start6, end6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
}