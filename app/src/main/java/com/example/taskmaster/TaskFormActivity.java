package com.example.taskmaster;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TaskFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        EditText etNombreTarea = findViewById(R.id.etNombreTarea);
        CheckBox cbUrgente = findViewById(R.id.cbUrgente);
        RatingBar ratingImportancia = findViewById(R.id.ratingImportancia);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> {
            String nombre = etNombreTarea.getText().toString().trim();

            if (!nombre.isEmpty()) {
                String esUrgente = cbUrgente.isChecked() ? "Urgente" : "Normal";
                float estrellas = ratingImportancia.getRating();

                String mensaje = "Tarea '" + nombre + "' (" + esUrgente + ") guardada con " + estrellas + " estrellas";
                Toast.makeText(TaskFormActivity.this, mensaje, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(TaskFormActivity.this, "Ingresa un nombre para la tarea", Toast.LENGTH_SHORT).show();
            }
        });
    }
}