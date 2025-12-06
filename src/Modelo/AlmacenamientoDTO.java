/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoDTO {
    private int id;
    private String producto;
    private double cantidad;
    private Date fechaIngreso;
    private Date fechaEgreso;

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

   

}
