package com.example.taskmaster;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TaskFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        // 1. Vinculación de vistas con los nuevos IDs del XML
        EditText etTaskName = findViewById(R.id.etTaskName);
        Spinner spCategory = findViewById(R.id.spCategory);
        RadioGroup rgSize = findViewById(R.id.rgSize);
        CheckBox cbExtraCream = findViewById(R.id.cbExtraCream);
        CheckBox cbVegMilk = findViewById(R.id.cbVegMilk);
        RatingBar rbPriority = findViewById(R.id.rbPriority);
        ProgressBar pbStatus = findViewById(R.id.pbStatus);
        Button btnSaveTask = findViewById(R.id.btnSaveTask);
        RecyclerView rvTasks = findViewById(R.id.rvTasks);

        // 2. Spinner
        String[] categorias = {"Espresso", "Cappuccino", "Latte", "Pastelería", "Tarea de Limpieza"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spCategory.setAdapter(adapter);

        // 3. RecyclerView
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        // 4. Acción del botón Guardar
        btnSaveTask.setOnClickListener(v -> {
            String nombre = etTaskName.getText().toString().trim();
            if (!nombre.isEmpty()) {
                Toast.makeText(this, "Pedido registrado: " + nombre, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Por favor ingrese un nombre para la tarea/pedido", Toast.LENGTH_SHORT).show();
            }
        });
    }
}