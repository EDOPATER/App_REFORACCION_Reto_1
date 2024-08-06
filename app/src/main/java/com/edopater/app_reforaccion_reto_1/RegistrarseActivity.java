package com.edopater.app_reforaccion_reto_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.edopater.app_reforaccion_reto_1.helper.Encrypt;
import com.edopater.app_reforaccion_reto_1.helper.FileManager;
import com.edopater.app_reforaccion_reto_1.helper.Validation;
import com.edopater.app_reforaccion_reto_1.helper.Validation2;
import com.edopater.app_reforaccion_reto_1.modelos.Usuario;

public class RegistrarseActivity extends AppCompatActivity {

    Usuario     user;
    EditText    nombreEditText;
    EditText    apellidosEditText;
    EditText    emailEditText;
    EditText    passwordEditText;
    EditText    repetirContrasenaEditText;
    Button      botonRegistrarse;
    private boolean terminosAceptados;
    private boolean datosAceptados;
    private NewUser newUser;

    public enum TipoCampo { REQUERIDO, NO_REQUERIDO }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        // Inicializar vistas
        nombreEditText = findViewById(R.id.nombreEditText);
        apellidosEditText = findViewById(R.id.apellidosEditText);
        emailEditText = findViewById(R.id.correoEditText);
        passwordEditText = findViewById(R.id.contrasenaEditText);
        repetirContrasenaEditText = findViewById(R.id.confirmarContrasenaEditText);
        botonRegistrarse = findViewById(R.id.botonRegistrarse2);

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
                if (repetirContrasenaEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    repetirContrasenaEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    togglePasswordVisibilityButton2.setImageResource(R.drawable.ic_visibility_off);
                } else {
                    repetirContrasenaEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    togglePasswordVisibilityButton2.setImageResource(R.drawable.ic_visibility);
                }
                // Mueve el cursor al final del texto
                repetirContrasenaEditText.setSelection(repetirContrasenaEditText.getText().length());
            }
        });

        botonRegistrarse.setOnClickListener(new View.OnClickListener() {

            // Validar los campos
            //Validation2 validation2 = new Validation2();
        //validation2.validateTextField(nombreEditText, "nombre", 3, 50, TipoCampo.REQUERIDO);
        //validation2.validateTextField(apellidosEditText, "apellido", 3, 50, TipoCampo.REQUERIDO);
        //validation2.validateEmail(emailEditText);
        //validation2.validatePassword(passwordEditText, repetirContrasenaEditText, 8, 16);

            @Override
            public void onClick(View view) {
                if (registrarUsuario()) {

                    // Crear el intent para InicioSesionActivity
                    Intent intentInicioSesion = new Intent(RegistrarseActivity.this, InicioSesionActivity.class);

                    String correo = newUser.emailEditText.getText().toString();
                    String contrasena = newUser.passwordEditText.getText().toString();
                    String nombre = nombreEditText.getText().toString();
                    String apellidos = apellidosEditText.getText().toString();

                    // Pasar los valores como extras
                    intentInicioSesion.putExtra("email", correo);
                    intentInicioSesion.putExtra("password", contrasena);
                    intentInicioSesion.putExtra("nombre", nombre);
                    intentInicioSesion.putExtra("apellidos", apellidos);

                    startActivityForResult(intentInicioSesion, 1);

                }
            }
        });
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
                    user = new Usuario(nombre, apellidos, correo, contrasena, repetirContrasena);
                    user.contrasena   = Encrypt.encryptPassword(contrasena); //Encriptamos la contraseña

                    // Crear una instancia de FileManager para guardar al usuario
                    FileManager fileManager = new FileManager(this);
                    if (fileManager.insertNewUser(user)) {
                        // Mostrar un mensaje de éxito
                        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        return true;
                    } else {
                        Toast.makeText(this, "Error al registrar el usuario", Toast.LENGTH_SHORT).show();
                    }
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





