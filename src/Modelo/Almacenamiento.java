    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author AsusVivobook
 */
public class Almacenamiento {
    private Integer id;
    private String producto;
    private double cantidad;
    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso; // es opcional

    public Integer getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
}
