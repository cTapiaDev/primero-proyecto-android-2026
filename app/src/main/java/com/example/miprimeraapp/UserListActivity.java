package com.example.miprimeraapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.miprimeraapp.databinding.ActivityUserListBinding;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

    private ActivityUserListBinding binding;
    private UsuariosAdapter adapter;
    private List<Usuario> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        crearDatos();

        adapter = new UsuariosAdapter(dataList);

        binding.rvListaUsuarios.setAdapter(adapter);
        binding.rvListaUsuarios.setLayoutManager(new LinearLayoutManager(this));
    }


    private void crearDatos() {
        dataList = new ArrayList<>();

        dataList.add(new Usuario("Usuario 1", "Desarrollo", "usuario1@gmail.com", true, R.mipmap.ic_launcher));
        dataList.add(new Usuario("Usuario 2", "Diseño UX", "usuario2@gmail.com", true, R.mipmap.ic_launcher));
        dataList.add(new Usuario("Usuario 3", "Contabilidad", "usuario3@gmail.com", false, R.mipmap.ic_launcher));

        for (int i = 4; i <= 500; i++) {
            boolean activo = (i % 2 == 0);
            dataList.add(new Usuario("Usuario" + i, "Sistemas", "usuario" + i + "@gmail.com", activo, R.mipmap.ic_launcher));
        }
    }
}