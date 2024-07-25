package com.edopater.app_reforaccion_reto_1;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import com.edopater.app_reforaccion_reto_1.modelos.Usuario;

public class InicioSesionActivity extends AppCompatActivity {

    private Button A_panelControl;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText nombreEditText;
    private EditText apellidosEditText;
    private Button registerButton;
    private String expectedEmail;
    private String expectedPassword;
    private String expectedNombre;
    private String expectedApellidos;

    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_sesion);

        // Inicializar los EditText
        emailEditText = findViewById(R.id.correoEditText);
        passwordEditText = findViewById(R.id.contrasenaEditText);
        EditText emailEditText = findViewById(R.id.correoEditText);
        EditText passwordEditText = findViewById(R.id.contrasenaEditText);

        // Obtener los valores pasados por Intent
        Intent intent = getIntent();
        expectedEmail = intent.getStringExtra("email");
        expectedPassword = intent.getStringExtra("password");
        expectedNombre = intent.getStringExtra("nombre");
        expectedApellidos = intent.getStringExtra("apellidos");

        // Usar los valores (por ejemplo, mostrar en TextViews para verificación)
        TextView emailTextView = findViewById(R.id.correoEditText);
        TextView passwordTextView = findViewById(R.id.contrasenaEditText);
        emailTextView.setText(expectedEmail);
        passwordTextView.setText(expectedPassword);


        // Inicializar vistas
        A_panelControl = findViewById(R.id.buttonInicio);
        registerButton = findViewById(R.id.buttonVolverReg);

        ImageButton togglePasswordVisibilityButton = findViewById(R.id.togglePasswordVisibilityButton);

        togglePasswordVisibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    togglePasswordVisibilityButton.setImageResource(R.drawable.ic_visibility_off);
                } else {
                    passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    togglePasswordVisibilityButton.setImageResource(R.drawable.ic_visibility);
                }
                // Mueve el cursor al final del texto
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Realizar la acción de registro
                registrar();
            }
        });


        A_panelControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validar las credenciales del usuario
                if (validarCredenciales(email, password)) {
                // Credenciales válidas, realizar la acción de inicio de sesión
                  iniciarSesion();
                } else {
                // Credenciales inválidas, mostrar mensaje de error
                   Toast.makeText(InicioSesionActivity.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

        private boolean validarCredenciales(String email, String password) {
            // Comparar los valores ingresados con los valores esperados
            return email.equals(expectedEmail) && password.equals(expectedPassword);
        }

        private void iniciarSesion() {
            // Implementa la acción a Panel de Control
            Intent intent = new Intent(InicioSesionActivity.this, PanelControlActivity.class);
            startActivity(intent);
            finish(); // Finaliza la actividad actual para que el usuario no pueda volver con el botón Atrás
        }

        private void registrar() {
            // Aquí puedes implementar la lógica para registrar un nuevo usuario.
            Intent Registrar = new Intent(InicioSesionActivity.this, RegistrarseActivity.class );
            startActivity(Registrar);
            // Por ejemplo, puedes abrir una actividad de registro o mostrar un formulario de registro.
            Toast.makeText(this, "Registro de usuario", Toast.LENGTH_SHORT).show();
        }
}