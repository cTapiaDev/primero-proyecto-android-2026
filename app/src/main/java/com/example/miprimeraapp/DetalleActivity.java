package com.example.miprimeraapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.miprimeraapp.databinding.ActivityDetalleBinding;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Recibir información desde el Dashboard
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            // Sacamos los datos gracias a su llave
            String tituloRecibido = extras.getString("CLAVE_TITULO");
            String descRecibida = extras.getString("CLAVE_DESC");

            // Los pintamos en la vista
            binding.tvTituloDetalle.setText(tituloRecibido);
            binding.tvDescripcion.setText(descRecibida);
        }

        binding.btnVolver.setOnClickListener(v -> {
            finish();
        });

        binding.btnWeb.setOnClickListener(v -> {
            irAlSitioWeb();
        });

        binding.btnEnviar.setOnClickListener(v -> {
            compartirInfo();
        });
    }

    private void irAlSitioWeb() {
        // Parseo de URL
        Uri pagina = Uri.parse("https://developer.android.com");

        Intent intentWeb = new Intent(Intent.ACTION_VIEW, pagina);

        startActivity(intentWeb);
    }

    private void compartirInfo() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "¡Estamos aprendiendo android!");

        startActivity(Intent.createChooser(intent, "Compartir..."));
    }
}