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
public class Producción {
    private Integer id;
    private Integer cultivoId;
    private LocalDate fecha;
    private double cantidad; // en campo
    private String calidad;  // ALTA, MEDIA, BAJA
    private String destino;  // VENTA, ALMACENAMIENTO

    public Integer getId() {
        return id;
    }

    public Integer getCultivoId() {
        return cultivoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getCalidad() {
        return calidad;
    }

    public String getDestino() {
        return destino;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCultivoId(Integer cultivoId) {
        this.cultivoId = cultivoId;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
