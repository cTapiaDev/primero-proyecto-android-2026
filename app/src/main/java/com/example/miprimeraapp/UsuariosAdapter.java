package com.example.miprimeraapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
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
        ItemUserBinding binding = ItemUserBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new UsuarioViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuarioActual = listaUsuarios.get(position);
        holder.bind(usuarioActual);
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
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


            binding.getRoot().setOnClickListener(v -> {
                Context context = v.getContext();

                Intent intent = new Intent(context, DetalleActivity.class);

                intent.putExtra("CLAVE_TITULO", usuario.getNombre());

                String descripcion = "Área: " + usuario.getArea() + "\n" +
                                     "Email: " + usuario.getEmail() + "\n" +
                                     "Estado: " + (usuario.isEsActivo() ? "Activo" : "Inactivo");

                intent.putExtra("CLAVE_DESC", descripcion);

                context.startActivity(intent);
            });
        }
    }
}
