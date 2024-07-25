package com.edopater.app_reforaccion_reto_1;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import android.annotation.SuppressLint;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.edopater.app_reforaccion_reto_1.modelos.Usuario;

public class RegistrarseActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText nombreEditText;
    private EditText apellidosEditText;
    private EditText passwordEditText;
    private EditText repetirContrasenaEditText;
    private boolean terminosAceptados;
    private boolean datosAceptados;
    private Button botonRegistrarse;
    private NewUser newUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrarse);

        // Inicializar vistas
        emailEditText = findViewById(R.id.correoEditText);
        nombreEditText = findViewById(R.id.nombreEditText);
        apellidosEditText = findViewById(R.id.apellidosEditText);
        passwordEditText = findViewById(R.id.contrasenaEditText);
        repetirContrasenaEditText = findViewById(R.id.confirmarContrasenaEditText);
        botonRegistrarse = findViewById(R.id.botonRegistrarse2);

        EditText emailEditText = findViewById(R.id.correoEditText);
        EditText passwordEditText = findViewById(R.id.contrasenaEditText);
        EditText passwordConfEditText = findViewById(R.id.confirmarContrasenaEditText);
        ImageButton togglePasswordVisibilityButton = findViewById(R.id.togglePasswordVisibilityButton);
        ImageButton togglePasswordVisibilityButton2 = findViewById(R.id.togglePasswordVisibilityButton_2);

        newUser = new NewUser(emailEditText, passwordEditText);

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

        togglePasswordVisibilityButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordConfEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    passwordConfEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    togglePasswordVisibilityButton2.setImageResource(R.drawable.ic_visibility_off);
                } else {
                    passwordConfEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    togglePasswordVisibilityButton2.setImageResource(R.drawable.ic_visibility);
                }
                // Mueve el cursor al final del texto
                passwordConfEditText.setSelection(passwordConfEditText.getText().length());
            }
        });


        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registrarUsuario()) {
                    // Crear el intent para InicioSesionActivity
                    Intent intentInicioSesion = new Intent(RegistrarseActivity.this, InicioSesionActivity.class);

                    String email = newUser.emailEditText.getText().toString();
                    String password = newUser.passwordEditText.getText().toString();
                    String nombre = nombreEditText.getText().toString();
                    String apellidos = apellidosEditText.getText().toString();

                    // Pasar los valores como extras
                    intentInicioSesion.putExtra("email", email);
                    intentInicioSesion.putExtra("password", password);
                    intentInicioSesion.putExtra("nombre", nombre);
                    intentInicioSesion.putExtra("apellidos", apellidos);

                    startActivityForResult(intentInicioSesion, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {

            // Datos recibidos de InicioSesionActivity, iniciar PerfilUsuarioActivity

            String email = data.getStringExtra("email");
            String password = data.getStringExtra("password");
            String nombre = data.getStringExtra("nombre");
            String apellidos = data.getStringExtra("apellidos");

            Intent intentPerfilUsuario = new Intent(RegistrarseActivity.this, PerfilUsuarioActivity.class);
            intentPerfilUsuario.putExtra("email", email);
            intentPerfilUsuario.putExtra("password", password);
            intentPerfilUsuario.putExtra("nombre", nombre);
            intentPerfilUsuario.putExtra("apellidos", apellidos);
            startActivity(intentPerfilUsuario);
        }
    }

    private boolean registrarUsuario() {
        String correo = emailEditText.getText().toString().trim();
        String nombre = nombreEditText.getText().toString().trim();
        String apellidos = apellidosEditText.getText().toString().trim();
        String contrasena = passwordEditText.getText().toString().trim();
        String repetirContrasena = repetirContrasenaEditText.getText().toString().trim();

        // Obtener los valores de los checkboxes
        terminosAceptados = ((CheckBox) findViewById(R.id.checkBoxTerminos)).isChecked();
        datosAceptados = ((CheckBox) findViewById(R.id.checkBoxDatos)).isChecked();

        // Validar los campos
        if (nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || repetirContrasena.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            if (!contrasena.equals(repetirContrasena)) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            } else {
                if (!terminosAceptados || !datosAceptados) {
                    Toast.makeText(this, "Debes aceptar los términos y condiciones y tratamiento de datos", Toast.LENGTH_SHORT).show();
                } else {
                    // Crear una instancia de la clase Usuario con los datos ingresados
                    Usuario usuario = new Usuario(nombre, apellidos, correo, contrasena);

                    // Aquí se puede realizar la lógica adicional, como enviar los datos a un servidor o guardarlos localmente

                    // Mostrar un mensaje de éxito
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
        }
        return false;
    }

    // Clase para encapsular los campos de texto
    class NewUser {
        EditText emailEditText;
        EditText passwordEditText;

        NewUser(EditText emailEditText, EditText passwordEditText) {
            this.emailEditText = emailEditText;
            this.passwordEditText = passwordEditText;
        }
    }
}





