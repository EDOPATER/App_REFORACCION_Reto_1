package com.edopater.app_reforaccion_reto_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.edopater.app_reforaccion_reto_1.modelos.Usuario;

public class PerfilUsuarioActivity extends AppCompatActivity {

    private Usuario user;
    private Button A_Panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        // Obtener el usuario de la aplicación
        MyApplication app = (MyApplication) getApplicationContext();
        user = app.getUser();

        // Usar los valores de la clase Usuario
        TextView emailTextView = findViewById(R.id.correoEditText);
        TextView passwordTextView = findViewById(R.id.contrasenaEditText);
        TextView passwordConfirmTextView = findViewById(R.id.confirmarContrasenaEditText);
        TextView nombreTextView = findViewById(R.id.nombreEditText);
        TextView apellidosTextView = findViewById(R.id.apellidosEditText);

        if (user != null) {
            emailTextView.setText(user.correo);
            passwordTextView.setText(user.contrasena); // Considerar si es seguro mostrar la contraseña
            passwordConfirmTextView.setText(user.contrasena);
            nombreTextView.setText(user.nombre);
            apellidosTextView.setText(user.apellidos);
        }

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
