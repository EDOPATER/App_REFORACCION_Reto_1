package com.edopater.app_reforaccion_reto_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import com.edopater.app_reforaccion_reto_1.modelos.Usuario;

public class InicioSesionActivity extends AppCompatActivity {

    private Button A_panelControl;
    private EditText emailEditText;
    private EditText passwordEditText;
    //private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_sesion);

        A_panelControl = findViewById(R.id.buttonInicio);
        emailEditText = findViewById(R.id.correoEditText);
        passwordEditText = findViewById(R.id.contrasenaEditText);
        //loginButton = findViewById(R.id.buttonInicio);
        registerButton = findViewById(R.id.buttonVolverReg);

        A_panelControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent next = new Intent(InicioSesionActivity.this, panelControlActivity.class);
                startActivity(next);
            }
        });

       // loginButton.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View v) {
       //         String email = emailEditText.getText().toString();
       //         String password = passwordEditText.getText().toString();

                // Validar las credenciales del usuario
       //         if (validarCredenciales(email, password)) {
                    // Credenciales válidas, realizar la acción de inicio de sesión
       //           iniciarSesion();
       //         } else {
                    // Credenciales inválidas, mostrar mensaje de error
       //            Toast.makeText(InicioSesionActivity.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
       //         }
       //     }
       // });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realizar la acción de registro
                registrar();
            }
        });
    }
        private boolean validarCredenciales(String email, String password) {
            // Aquí se implementa la lógica de validación de las credenciales.
            // Se puede realizar consultas a la base de datos, verificar con un API, etc.
            // Por simplicidad, aquí se valida un usuario fijo.

            // Usuario de ejemplo

            Usuario usuarioEjemplo = new Usuario("nombre", "apellidos", "correo", "contrasena");

            return email.equals(usuarioEjemplo.getCorreo()) && password.equals(usuarioEjemplo.getContrasena());
        }

        private void iniciarSesion() {
            // Aquí se implementa la lógica para iniciar sesión.
            // Por ejemplo, se puede abrir una nueva actividad o realizar alguna acción después del inicio de sesión exitoso.
            Intent next = new Intent(InicioSesionActivity.this, panelControlActivity.class);
            startActivity(next);
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
        }

        private void registrar() {
            // Aquí puedes implementar la lógica para registrar un nuevo usuario.
            Intent Registrar = new Intent(InicioSesionActivity.this, registrarseActivity.class );
            startActivity(Registrar);
            // Por ejemplo, puedes abrir una actividad de registro o mostrar un formulario de registro.
            Toast.makeText(this, "Registro de usuario", Toast.LENGTH_SHORT).show();
        }
}