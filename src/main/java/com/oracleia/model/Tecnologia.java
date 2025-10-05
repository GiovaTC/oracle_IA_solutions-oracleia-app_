package com.oracleia.model;

public class Tecnologia {
    private int idTecnologia;
    private String nombre;
    private String version;

    public Tecnologia(int idTecnologia, String nombre, String version) {
        this.idTecnologia = idTecnologia;
        this.nombre = nombre;
        this.version = version;
    }
    public int getIdTecnologia() { return idTecnologia; }
    public String getNombre() { return nombre; }
    public String getVersion() { return version; }
}
