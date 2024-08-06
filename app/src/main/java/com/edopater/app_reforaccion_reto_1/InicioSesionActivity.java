package com.edopater.app_reforaccion_reto_1;

import androidx.appcompat.app.AppCompatActivity;
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
import com.edopater.app_reforaccion_reto_1.helper.Encrypt;
import com.edopater.app_reforaccion_reto_1.helper.FileManager;
import com.edopater.app_reforaccion_reto_1.modelos.Usuario;

public class InicioSesionActivity extends AppCompatActivity {

    Usuario     user;
    EditText    correo;
    EditText    contrasena;
    private Button registerButton;
    private String expectedEmail;
    private String expectedPassword;
    private String expectedNombre;
    private String expectedApellidos;
    private Button A_panelControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        // Inicializar los EditText
        correo= findViewById(R.id.correoEditText);
        contrasena = findViewById(R.id.contrasenaEditText);

        // Obtener los valores pasados por Intent
        Intent intent = getIntent();
        expectedEmail = intent.getStringExtra("email");
        expectedPassword = intent.getStringExtra("password");
        expectedNombre = intent.getStringExtra("nombre");
        expectedApellidos = intent.getStringExtra("apellidos");

        // Usar los valores (por ejemplo, mostrar en TextViews para verificación)
        if (expectedEmail != null) {
            correo.setText(expectedEmail);
        }
        if (expectedPassword != null) {
            contrasena.setText(expectedPassword);
        }

        // Inicializar vistas
        A_panelControl = findViewById(R.id.buttonInicio);
        registerButton = findViewById(R.id.buttonVolverReg);

        ImageButton togglePasswordVisibilityButton = findViewById(R.id.togglePasswordVisibilityButton);

        togglePasswordVisibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contrasena.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    contrasena.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    togglePasswordVisibilityButton.setImageResource(R.drawable.ic_visibility_off);
                } else {
                    contrasena.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    togglePasswordVisibilityButton.setImageResource(R.drawable.ic_visibility);
                }
                // Mueve el cursor al final del texto
                contrasena.setSelection(contrasena.getText().length());
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
                login();
            }
        });

    }

        private void registrar() {
            // Aquí puedes implementar la lógica para registrar un nuevo usuario.
            Intent registrar = new Intent(InicioSesionActivity.this, RegistrarseActivity.class );
            startActivity(registrar);
            Toast.makeText(this, "Registro de usuario", Toast.LENGTH_SHORT).show();
        }

    public void login(){

        String email    = this.correo.getText().toString();
        String password = this.contrasena.getText().toString();

        //Obtener el usuario GLOBAL de la application
        MyApplication app = (MyApplication) getApplicationContext();
        user = app.getUser();

        if (user != null) {
            user.setDefaultData();
            user.correo = email;
            user.contrasena = Encrypt.encryptPassword(password); // Encriptamos la contraseña ingresada

            if(!email.isEmpty() && !password.isEmpty()) {

            FileManager fileManager = new FileManager(this);

            //Validar credenciales en base de datos
            Usuario userLogged = fileManager.findUserByEmailAndPassword(user);

            if (userLogged != null) {
                user.copyData(userLogged); //Actualizamos el usuario GLOBAL de la aplicación con los datos de la base de datos
                Intent intent = new Intent(this, PanelControlActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
            }
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Error al obtener el usuario de la aplicación", Toast.LENGTH_LONG).show();
        }
    }
}
