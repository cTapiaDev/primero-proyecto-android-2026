package com.example.miprimeraapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.miprimeraapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            validarCredenciales();
        });

        binding.tvForgot.setOnClickListener(v -> {
            Toast.makeText(this, "Funcionalidad no implementada aún", Toast.LENGTH_LONG).show();
        });
    }

    private void validarCredenciales() {

        // Obtener textos del usuario
        String email = binding.etEmail.getText().toString().trim();
        String pass = binding.etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            binding.etEmail.setError("Campo requerido");
            binding.etEmail.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            binding.etPassword.setError("Campo requerido");
            return;
        }

        if (email.equals("admin@curso.com") && pass.equals("123456")) {
            usuarioLogueado();
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }

    private void usuarioLogueado() {
        binding.tvWelcome.setText("¡Hola, admin!");
        binding.tvWelcome.setTextColor(Color.GREEN);
        binding.btnLogin.setEnabled(false);
        binding.btnLogin.setText("Redireccionando...");

        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);

        finish();
    }
}