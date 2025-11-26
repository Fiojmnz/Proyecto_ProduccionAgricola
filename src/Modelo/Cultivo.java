/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;


/**
 *
 * @author gipsy
 */
public class Cultivo implements Cloneable {
    private int id;
    private String Nombre;
    private String  Tipo;
    private double AreaSembrada;
    private String EstadoCrecimiento;
    private Date FechaSiembra;
    private Date FechaCosecha;
    
    public Cultivo() {}

    public Cultivo(int id, String Nombre, String Tipo, double AreaSembrada, String EstadoCrecimiento, Date FechaSiembra, Date FechaCosecha) {
        this.id = id;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.AreaSembrada = AreaSembrada;
        this.EstadoCrecimiento = EstadoCrecimiento;
        this.FechaSiembra = FechaSiembra;
        this.FechaCosecha = FechaCosecha;
    }

    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public double getAreaSembrada() {
        return AreaSembrada;
    }

    public String getEstadoCrecimiento() {
        return EstadoCrecimiento;
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

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setAreaSembrada(double AreaSembrada) {
        this.AreaSembrada = AreaSembrada;
    }

    public void setEstadoCrecimiento(String EstadoCrecimiento) {
        this.EstadoCrecimiento = EstadoCrecimiento;
    }

    public void setFechaSiembra(Date FechaSiembra) {
        this.FechaSiembra = FechaSiembra;
    }

    public void setFechaCosecha(Date FechaCosecha) {
        this.FechaCosecha = FechaCosecha;
    }

   
    @Override 
    public Cultivo clone() {
        try {
            return (Cultivo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("No se puede clonar el Cultivo", e);
        }
    }

    @Override
    public String toString() {
        return "Cultivo{" + "id=" + id + ", Nombre=" + Nombre + ", Tipo=" + Tipo + ", AreaSembrada=" + AreaSembrada + ", EstadoCrecimiento=" + EstadoCrecimiento + ", FechaSiembra=" + FechaSiembra + ", FechaCosecha=" + FechaCosecha + '}';
    }
    
    
}
