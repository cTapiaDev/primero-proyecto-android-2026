package com.example.miprimeraapp;

import android.graphics.Color;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miprimeraapp.databinding.ItemUserBinding;

import java.util.List;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuarioViewHolder> {

    private List<Usuario> listaUsuarios;

    public UsuariosAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        ItemUserBinding binding;

        public UsuarioViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Usuario usuario) {
            binding.tvNombre.setText(usuario.getNombre());
            binding.tvArea.setText(usuario.getArea());
            binding.tvEmail.setText(usuario.getEmail());
            binding.ivAvatar.setImageResource(usuario.getIdImagen());

            if (usuario.isEsActivo()) {
                binding.viewStatus.setBackgroundColor(Color.parseColor("#4CAF50"));
            } else {
                binding.viewStatus.setBackgroundColor(Color.parseColor("#F44336"));
            }
        }
    }
}
