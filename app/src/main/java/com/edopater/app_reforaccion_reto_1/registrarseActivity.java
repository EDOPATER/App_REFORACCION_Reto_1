package com.edopater.app_reforaccion_reto_1;

import androidx.appcompat.app.AppCompatActivity;
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

public class registrarseActivity extends AppCompatActivity {

    private EditText correoEditText;
    private EditText nombreEditText;
    private EditText apellidosEditText;
    private EditText contrasenaEditText;
    private EditText repetirContrasenaEditText;
    private boolean terminosAceptados;
    private boolean datosAceptados;
    private Button botonRegistrarse;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrarse);

        // Inicializar vistas
        correoEditText = findViewById(R.id.correoEditText);
        nombreEditText = findViewById(R.id.nombreEditText);
        apellidosEditText = findViewById(R.id.apellidosEditText);
        contrasenaEditText = findViewById(R.id.contrasenaEditText);
        repetirContrasenaEditText = findViewById(R.id.confirmarContrasenaEditText);
        botonRegistrarse = findViewById(R.id.botonRegistrarse2);

        EditText passwordEditText = findViewById(R.id.contrasenaEditText);
        EditText passwordConfEditText = findViewById(R.id.confirmarContrasenaEditText);
        ImageButton togglePasswordVisibilityButton = findViewById(R.id.togglePasswordVisibilityButton);
        ImageButton togglePasswordVisibilityButton2 = findViewById(R.id.togglePasswordVisibilityButton_2);

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
                    // Crear el intent para la siguiente actividad
                    Intent intent = new Intent(registrarseActivity.this, InicioSesionActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private boolean registrarUsuario() {

        String correo = correoEditText.getText().toString().trim();
        String nombre = nombreEditText.getText().toString().trim();
        String apellidos = apellidosEditText.getText().toString().trim();
        String contrasena = contrasenaEditText.getText().toString().trim();
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
}





