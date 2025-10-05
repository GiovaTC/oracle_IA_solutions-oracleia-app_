package com.oracleia.model;

import java.util.Date;

public class Proyecto {
    private int idProyecto;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int idEmpresa;

    public Proyecto(int idProyecto, String nombre, Date fechaInicio, Date fechaFin, int idEmpresa) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idEmpresa = idEmpresa;
    }
    public int getIdProyecto() { return idProyecto; }
    public String getNombre() { return nombre; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public int getIdEmpresa() { return idEmpresa; }
}
