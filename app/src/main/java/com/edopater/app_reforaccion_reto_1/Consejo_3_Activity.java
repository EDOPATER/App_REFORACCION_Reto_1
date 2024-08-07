package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import android.net.Uri;

public class Consejo_3_Activity extends AppCompatActivity {

    private VideoView videoRefor;
    private Button A_Consejos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejo3);
        VideoView videoRefor = findViewById(R.id.videoRefor);

        if (videoRefor != null) {
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_reforestar);
            videoRefor.setVideoURI(videoUri);
            videoRefor.start();
        } else {
            Log.e("Consejo_1_Activity", "VideoView with ID 'miVideoView' not found");
        }

        // Enlaza el TextView
        TextView consejoTextView = findViewById(R.id.Consejo3);

        // Asigna un texto al TextView
        consejoTextView.setText("o\to\tProfundidad y orientación: Planta las plántulas a la profundidad adecuada y asegúrate de que estén orientadas correctamente (raíces hacia abajo y brotes hacia arriba).\n\n" +
                "o\to\tCompactación del suelo: Compacta suavemente el suelo alrededor de las plántulas para asegurar un buen contacto de las raíces con el suelo.\n\n");

        String text = "o\tProfundidad y orientación: Planta las plántulas a la profundidad adecuada y asegúrate de que estén orientadas correctamente (raíces hacia abajo y brotes hacia arriba).\n\n" +
                "o\tCompactación del suelo: Compacta suavemente el suelo alrededor de las plántulas para asegurar un buen contacto de las raíces con el suelo.\n\n";

        SpannableString spannableString = new SpannableString(text);

        String boldText1 = "Profundidad y orientación:";
        String boldText2 = "Compactación del suelo:";

        int start1 = text.indexOf(boldText1);
        int end1 = start1 + boldText1.length();
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start1, end1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        int start2 = text.indexOf(boldText2);
        int end2 = start2 + boldText2.length();
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start2, end2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        consejoTextView.setText(spannableString);
        consejoTextView.setText(spannableString);
        A_Consejos = findViewById(R.id.buttonVolverConsejos);

        A_Consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent back = new Intent(Consejo_3_Activity.this, ConsejosActivity.class);
                startActivity(back);
            }
        });

    }
}

