package com.oracleia.model;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String puesto;
    private double salario;
    private int idEmpresa;

    public Empleado(int idEmpleado, String nombre, String puesto, double salario, int idEmpresa) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.idEmpresa = idEmpresa;
    }
    public int getIdEmpleado() { return idEmpleado; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }
    public int getIdEmpresa() { return idEmpresa; }
}
