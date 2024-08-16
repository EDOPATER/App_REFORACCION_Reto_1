package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

public class HistorialActividadesActivity extends AppCompatActivity {

    private EditText etEspecieVariedad, etFechaSiembra, etUbicacionGeografica, etCantidadSiembra, etAlturaDiametro, etFechaRegistro;
    private Button btnActualizarDatos, btnVolverPanel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_historial_actividades);

        // Vincular los EditText y Botones con sus IDs
        etEspecieVariedad = findViewById(R.id.editTextText2);
        etFechaSiembra = findViewById(R.id.fechaSiembra);
        etUbicacionGeografica = findViewById(R.id.editTextText3);
        etCantidadSiembra = findViewById(R.id.cantidadSiembra);
        etAlturaDiametro = findViewById(R.id.altura);
        etFechaRegistro = findViewById(R.id.fechaRegistro);
        btnActualizarDatos = findViewById(R.id.buttonActualizarDatos);
        btnVolverPanel = findViewById(R.id.buttonVolverPanel);

        // Cargar los datos guardados en SharedPreferences
        cargarDatos();

        // Manejar el botón de Volver al Panel
        btnVolverPanel.setOnClickListener(v -> {
            Intent back = new Intent(HistorialActividadesActivity.this, PanelControlActivity.class);
            startActivity(back);
        });

        // Manejar el botón de Actualizar Datos
        btnActualizarDatos.setOnClickListener(v -> actualizarDatos());
    }

    // Método para cargar los datos desde SharedPreferences
    private void cargarDatos() {
        SharedPreferences sharedPreferences = getSharedPreferences("ActividadesPrefs", MODE_PRIVATE);

        String especieVariedad = sharedPreferences.getString("especieVariedad", "");
        String fechaSiembra = sharedPreferences.getString("fechaSiembra", "");
        String ubicacionGeografica = sharedPreferences.getString("ubicacionGeografica", "");
        String cantidadSiembra = sharedPreferences.getString("cantidadSiembra", "");
        String alturaDiametro = sharedPreferences.getString("alturaDiametro", "");
        String fechaRegistro = sharedPreferences.getString("fechaRegistro", "");

        etEspecieVariedad.setText(especieVariedad);
        etFechaSiembra.setText(fechaSiembra);
        etUbicacionGeografica.setText(ubicacionGeografica);
        etCantidadSiembra.setText(cantidadSiembra);
        etAlturaDiametro.setText(alturaDiametro);
        etFechaRegistro.setText(fechaRegistro);
    }

    // Método para actualizar los datos y guardarlos nuevamente en SharedPreferences
    private void actualizarDatos() {
        // Obtener los valores de los EditText
        String especieVariedad = etEspecieVariedad.getText().toString().trim();
        String fechaSiembra = etFechaSiembra.getText().toString().trim();
        String ubicacionGeografica = etUbicacionGeografica.getText().toString().trim();
        String cantidadSiembra = etCantidadSiembra.getText().toString().trim();
        String alturaDiametro = etAlturaDiametro.getText().toString().trim();
        String fechaRegistro = etFechaRegistro.getText().toString().trim();

        // Validar que los campos no estén vacíos
        if (especieVariedad.isEmpty() || fechaSiembra.isEmpty() || ubicacionGeografica.isEmpty() || cantidadSiembra.isEmpty() ||
                alturaDiametro.isEmpty() || fechaRegistro.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Guardar los datos en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("ActividadesPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("especieVariedad", especieVariedad);
        editor.putString("fechaSiembra", fechaSiembra);
        editor.putString("ubicacionGeografica", ubicacionGeografica);
        editor.putString("cantidadSiembra", cantidadSiembra);
        editor.putString("alturaDiametro", alturaDiametro);
        editor.putString("fechaRegistro", fechaRegistro);

        editor.apply();

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "Datos actualizados exitosamente", Toast.LENGTH_SHORT).show();
    }
}