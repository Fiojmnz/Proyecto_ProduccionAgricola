/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Enum.EstadoCrecimiento;
import Enum.TipoCultivo;
import java.sql.Date;


/**
 *
 * @author gipsy
 */
public class Cultivo {
   private int id;
    private String Nombre;
    private TipoCultivo tipo;
    private double AreaSembrada;
    private EstadoCrecimiento estadoCrecimiento;
    private Date FechaSiembra;
    private Date FechaCosecha;

    public Cultivo() {}

    public Cultivo(int id, String Nombre, TipoCultivo tipo, double AreaSembrada, EstadoCrecimiento estadoCrecimiento, Date FechaSiembra, Date FechaCosecha) {
        this.id = id;
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.AreaSembrada = AreaSembrada;
        this.estadoCrecimiento = estadoCrecimiento;
        this.FechaSiembra = FechaSiembra;
        this.FechaCosecha = FechaCosecha;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public TipoCultivo getTipo() {
        return tipo;
    }

    public double getAreaSembrada() {
        return AreaSembrada;
    }

    public EstadoCrecimiento getEstadoCrecimiento() {
        return estadoCrecimiento;
    }

    public Date getFechaSiembra() {
        return FechaSiembra;
    }

    public Date getFechaCosecha() {
        return FechaCosecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setTipo(TipoCultivo tipo) {
        this.tipo = tipo;
    }

    public void setAreaSembrada(double AreaSembrada) {
        this.AreaSembrada = AreaSembrada;
    }

    public void setEstadoCrecimiento(EstadoCrecimiento estadoCrecimiento) {
        this.estadoCrecimiento = estadoCrecimiento;
    }

    public void setFechaSiembra(Date FechaSiembra) {
        this.FechaSiembra = FechaSiembra;
    }

    public void setFechaCosecha(Date FechaCosecha) {
        this.FechaCosecha = FechaCosecha;
    }

    
}
 