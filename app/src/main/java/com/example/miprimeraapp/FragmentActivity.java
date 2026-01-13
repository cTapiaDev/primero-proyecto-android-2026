package com.example.miprimeraapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.miprimeraapp.databinding.ActivityFragmentBinding;
import com.google.android.material.navigation.NavigationView;

public class FragmentActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityFragmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar Toolbar
        setSupportActionBar(binding.toolbar);

        // Icono que nos permite abrir o cerrar el menú
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.open_nav,
                R.string.close_nav
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Escuchar los clics del menú
        binding.navView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
            binding.navView.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Mostrar Fragmento HOME
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        } else if (id == R.id.nav_profile) {
            // Mostrar Fragmento Perfil
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ProfileFragment())
                    .commit();
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Cerrando sesión...", Toast.LENGTH_LONG).show();
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPresed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.getOnBackPressedDispatcher();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }



}