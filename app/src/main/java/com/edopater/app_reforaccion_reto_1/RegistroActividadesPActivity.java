package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RegistroActividadesPActivity extends AppCompatActivity {

    // Declarar los EditText y el Botón
    private EditText etEspecieVariedad, etFechaSiembra, etUbicacionGeografica, etCantidadSiembra, etAlturaDiametro, etFechaRegistro;
    private Button btnRegistrarDatos, btnVolverPanel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_actividades_plantacion);

        // Vincular los EditText y Botones con sus IDs
        etEspecieVariedad = findViewById(R.id.editTextText2);
        etFechaSiembra = findViewById(R.id.fechaSiembra);
        etUbicacionGeografica = findViewById(R.id.editTextText3);
        etCantidadSiembra = findViewById(R.id.cantidadSiembra);
        etAlturaDiametro = findViewById(R.id.altura);
        etFechaRegistro = findViewById(R.id.fechaRegistro);
        btnRegistrarDatos = findViewById(R.id.buttonReg_Datos);
        btnVolverPanel = findViewById(R.id.buttonVolverPanel);

        // Deshabilita la entrada directa y muestra el DatePickerDialog al hacer clic
        etFechaSiembra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatePickerDialog(etFechaSiembra);
            }
        });

        etFechaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatePickerDialog(etFechaRegistro);
            }
        });

        // Manejar el botón de Volver al Panel
        btnVolverPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(RegistroActividadesPActivity.this, PanelControlActivity.class);
                startActivity(back);
            }
        });

        // Manejar el botón de Registrar Datos
        btnRegistrarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarDatos();
            }
        });
    }

    // Método para mostrar el DatePickerDialog
    private void mostrarDatePickerDialog(final EditText editText) {
        final Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                RegistroActividadesPActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;  // Los meses en DatePicker comienzan desde 0
                        String fechaSeleccionada = dayOfMonth + "/" + month + "/" + year;
                        editText.setText(fechaSeleccionada);
                    }
                }, anio, mes, dia);

        datePickerDialog.show();
    }

    // Método para registrar los datos
    private void registrarDatos() {
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

        // Aquí puedes almacenar los datos en una base de datos o enviarlos a un servidor
        // Por simplicidad, los mostraremos en un Toast
        String registro = "Especie: " + especieVariedad + "\nFecha de Siembra: " + fechaSiembra +
                "\nUbicación: " + ubicacionGeografica + "\nCantidad de Siembra: " + cantidadSiembra + "\nAltura/Diámetro: " + alturaDiametro +
                "\nFecha de Registro: " + fechaRegistro;

        Toast.makeText(this, "Datos Registrados:\n" + registro, Toast.LENGTH_LONG).show();
    }
}