/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Enum.Destino;
import java.sql.Date;

/**
 *
 * @author gipsy
 */
public class ProduccionDTO {
    private Integer id;
    private int CultivoId;
    private Date Fecha;
    private double CantidadRecolectada;
    private String calidad;
    private Destino destino;
    private Double productividad;
    public Integer getId() {
        return id;
    }

    public int getCultivoId() {
        return CultivoId;
    }

    public Date getFecha() {
        return Fecha;
    }

    public double getCantidadRecolectada() {
        return CantidadRecolectada;
    }

    public String getCalidad() {
        return calidad;
    }

    public Destino getDestino() {
        return destino;
    }

    public Double getProductividad() {
        return productividad;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCultivoId(int CultivoId) {
        this.CultivoId = CultivoId;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public void setCantidadRecolectada(double CantidadRecolectada) {
        this.CantidadRecolectada = CantidadRecolectada;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void setProductividad(Double productividad) {
        this.productividad = productividad;
    }
    
    
}
