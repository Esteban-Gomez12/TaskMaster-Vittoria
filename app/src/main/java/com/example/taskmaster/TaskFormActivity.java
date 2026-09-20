package com.example.taskmaster;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TaskFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        // 1. Vincular componentes desde el XML
        EditText etTaskName = findViewById(R.id.etTaskName);
        Spinner spCategory = findViewById(R.id.spCategory);
        RadioGroup rgSize = findViewById(R.id.rgSize);
        CheckBox cbExtraCream = findViewById(R.id.cbExtraCream);
        CheckBox cbVegMilk = findViewById(R.id.cbVegMilk);
        RatingBar rbPriority = findViewById(R.id.rbPriority);
        ProgressBar pbStatus = findViewById(R.id.pbStatus);
        Button btnSaveTask = findViewById(R.id.btnSaveTask);

        // 2. Configurar opciones del Spinner
        String[] categorias = {"Espresso", "Cappuccino", "Latte", "Pastelería", "Tarea de Limpieza"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spCategory.setAdapter(adapter);

        // 3. Ajustar el progreso inicial
        pbStatus.setProgress(100);

        // 4. Acción del botón Guardar (Usamos todas las variables para eliminar las advertencias)
        btnSaveTask.setOnClickListener(v -> {
            String nombre = etTaskName.getText().toString().trim();
            String categoria = spCategory.getSelectedItem().toString();

            // Leer RadioGroup
            int selectedRadioId = rgSize.getCheckedRadioButtonId();
            String tamano = "Mediano";
            if (selectedRadioId != -1) {
                RadioButton rbSelected = findViewById(selectedRadioId);
                tamano = rbSelected.getText().toString();
            }

            // Leer CheckBoxes
            boolean conCrema = cbExtraCream.isChecked();
            boolean conLecheVeg = cbVegMilk.isChecked();

            // Leer RatingBar
            float prioridad = rbPriority.getRating();

            if (!nombre.isEmpty()) {
                String mensaje = "Pedido: " + nombre +
                        "\nCategoría: " + categoria +
                        "\nTamaño: " + tamano +
                        "\nPrioridad: " + prioridad + "★" +
                        (conCrema ? "\n+ Crema Chantilly" : "") +
                        (conLecheVeg ? "\n+ Leche Vegetal" : "");

                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Ingresa un nombre para el pedido", Toast.LENGTH_SHORT).show();
            }
        });
    }
}