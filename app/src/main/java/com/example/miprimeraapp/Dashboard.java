package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.miprimeraapp.databinding.ActivityDashboardBinding;

public class Dashboard extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        setupDashboardClicks();
    }

    private void setupDashboardClicks() {

        binding.cardUsers.setOnClickListener(v -> {
            Toast.makeText(this, "Abriendo gestión de usuarios...", Toast.LENGTH_LONG).show();
            // AQUÍ AGREGAREMOS UN INTENT (navegación)
        });
    }
}