package com.oracleia.model;

import java.util.Date;

public class Factura {
    private int idFactura;
    private int idCliente;
    private int idProyecto;
    private double monto;
    private Date fechaEmision;

    public Factura(int idFactura, int idCliente, int idProyecto, double monto, Date fechaEmision) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idProyecto = idProyecto;
        this.monto = monto;
        this.fechaEmision = fechaEmision;
    }
    public int getIdFactura() { return idFactura; }
    public int getIdCliente() { return idCliente; }
    public int getIdProyecto() { return idProyecto; }
    public double getMonto() { return monto; }
    public Date getFechaEmision() { return fechaEmision; }
}
