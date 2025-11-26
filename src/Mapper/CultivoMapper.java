/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import Modelo.Cultivo;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
/**
 *
 * @author gipsy
 */
public class CultivoMapper {
    public static Cultivo fromResultSet(ResultSet rs) throws SQLException {
        return new Cultivo(
            rs.getInt("id"),
            rs.getString("Nombre"),
            rs.getString("Tipo"),
            rs.getDouble("AreaSembrada"),
            rs.getString("EstadoCrecimiento"),
            rs.getDate("FechaSiembra"),
            rs.getDate("FechaCosecha")
        );
    }

    public static Cultivo c(String l) {
        String[] p = l.split(";");
        return new Cultivo(0, p[0], p[1], Double.parseDouble(p[2]), p[3],
                Date.valueOf(p[4]), p.length>5 && !p[5].isBlank() ? Date.valueOf(p[5]) : null);
    }

    public static String c(Cultivo c) {
        return String.join(";", c.getNombre(), c.getTipo(), String.valueOf(c.getAreaSembrada()),
                c.getEstadoCrecimiento(), c.getFechaSiembra().toString(),
                c.getFechaCosecha()!=null?c.getFechaCosecha().toString():"");
    }
}
