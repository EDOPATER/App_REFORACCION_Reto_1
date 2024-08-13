package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.edopater.app_reforaccion_reto_1.helper.Encrypt;
import com.edopater.app_reforaccion_reto_1.helper.FileManager;
import com.edopater.app_reforaccion_reto_1.modelos.Usuario;

public class RecuperarContrasenaActivity extends AppCompatActivity {

    Usuario     user;
    private EditText correo;
    private Button buttonRecuperar;
    private Button A_Bienvenida;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);

        correo = findViewById(R.id.emailInput);
        buttonRecuperar = findViewById(R.id.buttonRecuperar);

        buttonRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = correo.getText().toString().trim(); // Elimina espacios en blanco al inicio y al final

                if (email.isEmpty()) {
                    // Si el campo de email está vacío, muestra un mensaje de error
                    correo.setError("El campo de correo electrónico es obligatorio");
                    correo.requestFocus(); // Enfoca el campo para que el usuario lo complete
                } else {
                    // Validar si el correo existe en la base de datos
                    FileManager fileManager = new FileManager(RecuperarContrasenaActivity.this);
                    Usuario usuarioEncontrado = fileManager.findUserByEmail(email);

                    if (usuarioEncontrado != null) {
                        // El correo existe en la base de datos, se puede proceder a enviar el correo de recuperación
                        Toast.makeText(RecuperarContrasenaActivity.this, "Correo de recuperación enviado a: " + email, Toast.LENGTH_SHORT).show();

                        // Aquí puedes agregar la lógica para enviar el correo de recuperación
                    } else {
                        // El correo no existe en la base de datos
                        Toast.makeText(RecuperarContrasenaActivity.this, "El correo electrónico no está registrado", Toast.LENGTH_SHORT).show();
                        correo.setError("Correo electrónico no registrado");
                        correo.requestFocus();
                    }
                }
            }
        });

        A_Bienvenida = findViewById(R.id.buttonVolverBienvenida);

        A_Bienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(RecuperarContrasenaActivity.this, MainActivity.class);
                startActivity(back);
            }
        });

    }
}
