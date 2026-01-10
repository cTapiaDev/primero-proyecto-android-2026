package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.miprimeraapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private boolean esDisponible = true;
    private int numeroProyectos = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inicializarEventos();
    }

    private void inicializarEventos() {
        binding.btnContactar.setOnClickListener(v -> {
            Toast.makeText(this, "Enviando correo...", Toast.LENGTH_LONG).show();

            numeroProyectos++; // numeroProyectos = numeroProyectos + 1;
            actualizarContadores();
        });

        binding.btnEstado.setOnClickListener(v -> {
            esDisponible = !esDisponible;

            actualizarVisualizacionEstado();
        });
    }

    private void actualizarContadores() {
        binding.tvProyectosCount.setText(String.valueOf(numeroProyectos));
    }

    private void actualizarVisualizacionEstado() {
        if (esDisponible) {
            binding.btnEstado.setText("Disponible");
            binding.btnEstado.setBackgroundColor(getColor(R.color.teal));
            binding.tvCargo.setText("Android Developer");
        } else {
            binding.btnEstado.setText("Ocupado");
            binding.btnEstado.setBackgroundColor(getColor(R.color.red));
            binding.tvCargo.setText("No molestar");
        }
    }
}