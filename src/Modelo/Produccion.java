/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;


/**
 *
 * @author gipsy
 */
public class Produccion {
    private int id;                     
    private LocalDate fecha;            
    private double cantidadRecolectada;
    private String calidad;             
    private double productividad;   // calculado, no se guarda en DB

    private String destino;            

    public Produccion() {
        
    }

    public Produccion(LocalDate fecha, double cantidadRecolectada, String calidad, String destino) {
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
        this.calidad = calidad;
        this.destino = destino;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCantidadRecolectada() {
        return cantidadRecolectada;
    }

    public String getCalidad() {
        return calidad;
    }

    public double getProductividad() {
        return productividad;
    }

    public String getDestino() {
        return destino;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCantidadRecolectada(double cantidadRecolectada) {
        this.cantidadRecolectada = cantidadRecolectada;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public void setProductividad(double productividad) {
        this.productividad = productividad;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Produccion{" + "id=" + id + ", fecha=" + fecha + ", cantidadRecolectada=" + cantidadRecolectada + ", calidad=" + calidad + ", productividad=" + productividad + ", destino=" + destino + '}';
    }

}
