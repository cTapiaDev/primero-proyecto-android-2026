package com.example.miprimeraapp;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


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
            // Toast.makeText(this, "Abriendo gestión de usuarios...", Toast.LENGTH_LONG).show();

            // Genera la intención de movernos de vista (Activity)
            Intent intent = new Intent(Dashboard.this, UserListActivity.class);

            // Enviamos información hacía DetalleActivity
            // intent.putExtra("CLAVE_TITULO", "Gestión de Usuarios");
            // intent.putExtra("CLAVE_DESC", "Aquí podrás administrar las altas, bajas y permisos.");

            // Es la instrucción para que nos mueva la app
            startActivity(intent);
        });

        binding.cardTabs.setOnClickListener(v -> {
            Intent intent = new Intent(this, TabActivity.class);
            startActivity(intent);
        });
    }
}