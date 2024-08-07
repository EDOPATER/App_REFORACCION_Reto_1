package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Informacion_1_Activity extends AppCompatActivity {

    private Button A_Informacion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion1);

        // Enlaza el TextView
        TextView informacionTextView = findViewById(R.id.Informacion1);

        // Asigna un texto al TextView
        String text = "\tCaptura de Carbono\n\n" +
                "1.\tSecuestro de CO₂: Los árboles absorben dióxido de carbono (CO₂) de la atmósfera durante la fotosíntesis y lo almacenan en su biomasa (troncos, ramas, hojas y raíces) y en el suelo. Este proceso, conocido como secuestro de carbono, reduce la concentración de CO₂ en la atmósfera, uno de los principales gases de efecto invernadero responsables del cambio climático.\n" +
                "2.\tAlmacenamiento a Largo Plazo: La madera de los árboles puede almacenar carbono durante décadas o incluso siglos, especialmente en especies de crecimiento lento y en bosques manejados de manera sostenible. Esto proporciona una solución a largo plazo para el almacenamiento de carbono.\n" +
                "\tBeneficios Ecológicos\n\n" +
                "1.\tRestauración de Ecosistemas: La reforestación contribuye a la restauración de ecosistemas degradados, mejorando la biodiversidad y la resiliencia de los ecosistemas frente al cambio climático. Los bosques sanos son más capaces de soportar condiciones climáticas extremas y de recuperarse de perturbaciones.\n" +
                "2.\tProtección del Suelo: Los árboles ayudan a prevenir la erosión del suelo, mejoran su estructura y aumentan su capacidad de retener agua. Esto es crucial para mantener la salud del suelo y su capacidad de actuar como sumidero de carbono.\n" +
                "\tBeneficios Económicos\n\n" +
                "1.\tGeneración de Empleo: Las actividades de reforestación y manejo forestal sostenible crean empleos en áreas rurales, contribuyendo al desarrollo económico y a la reducción de la pobreza.\n" +
                "2.\tProducción de Recursos: Las plantaciones de árboles pueden proporcionar madera, productos forestales no madereros (como frutas, resinas y medicinas) y biomasa para energía, ofreciendo fuentes de ingresos sostenibles.\n";

        SpannableString spannableString = new SpannableString(text);

        String[] boldTexts = {
                "Captura de Carbono",
                "Secuestro de CO₂:",
                "Almacenamiento a Largo Plazo:",
                "Beneficios Ecológicos",
                "Restauración de Ecosistemas:",
                "Protección del Suelo:",
                "Beneficios Económicos",
                "Generación de Empleo:",
                "Producción de Recursos:"
        };

        for (String boldText : boldTexts) {
            int start = text.indexOf(boldText);
            if (start >= 0) {
                int end = start + boldText.length();
                spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                Log.e("Informacion_1_Activity", "Texto no encontrado: " + boldText);
            }
        }

        informacionTextView.setText(spannableString);

        A_Informacion = findViewById(R.id.buttonVolverInformacion);

        A_Informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Informacion_1_Activity.this, InformacionAmbActivity.class);
                startActivity(back);
            }
        });
    }
}
