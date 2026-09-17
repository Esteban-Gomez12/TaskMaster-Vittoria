package com.example.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (!usuario.isEmpty() && !password.isEmpty()) {
                Intent intent = new Intent(LoginActivity.this, TaskFormActivity.class);
                startActivity(intent);
                finish(); // Cierra esta Activity para que no vuelva al presionar atrás
            } else {
                Toast.makeText(LoginActivity.this, "Por favor ingresa usuario y contraseña", Toast.LENGTH_SHORT).show();
            }
        });
    }
}