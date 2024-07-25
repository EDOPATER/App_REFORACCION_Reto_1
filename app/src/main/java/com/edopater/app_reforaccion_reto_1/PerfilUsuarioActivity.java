package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PerfilUsuarioActivity extends AppCompatActivity {

    private Button A_Panel;
    private String expectedEmail;
    private String expectedPassword;
    private String expectedNombre;
    private String expectedApellidos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil_usuario);

        Intent intent = getIntent();
        expectedEmail = intent.getStringExtra("email");
        expectedPassword = intent.getStringExtra("password");
        expectedNombre = intent.getStringExtra("nombre");
        expectedApellidos = intent.getStringExtra("apellidos");

        // Usar los valores (por ejemplo, mostrar en TextViews para verificación)
        TextView emailTextView = findViewById(R.id.correoEditText);
        TextView passwordTextView = findViewById(R.id.contrasenaEditText);
        TextView nombreTextView = findViewById(R.id.nombreEditText);
        TextView apellidosTextView = findViewById(R.id.apellidosEditText);
        emailTextView.setText(expectedEmail);
        passwordTextView.setText(expectedPassword);
        nombreTextView.setText(expectedNombre);
        apellidosTextView.setText(expectedApellidos);

        A_Panel = findViewById(R.id.buttonVolverPanel);

        A_Panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent back = new Intent(PerfilUsuarioActivity.this, PanelControlActivity.class);
                startActivity(back);
            }
        });

    }
}