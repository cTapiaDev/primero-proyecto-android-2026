package com.example.miprimeraapp;

public class Usuario {
    private String nombre;
    private String area;
    private String email;
    private boolean esActivo;
    private int idImagen;

    public Usuario(String nombre, String area, String email, boolean esActivo, int idImagen) {
        this.nombre = nombre;
        this.area = area;
        this.email = email;
        this.esActivo = esActivo;
        this.idImagen = idImagen;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getArea() {
        return area;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public int getIdImagen() {
        return idImagen;
    }
}
