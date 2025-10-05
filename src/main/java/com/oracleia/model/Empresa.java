package com.oracleia.model;

public class Empresa {
    private int idEmpresa;
    private String nombre;
    private String direccion;
    private String telefono;

    public Empresa(int idEmpresa, String nombre, String direccion, String telefono) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public int getIdEmpresa() { return idEmpresa; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
}
