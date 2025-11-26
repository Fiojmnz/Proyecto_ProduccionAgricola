/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.ConexionBD;
import Modelo.Cultivo;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author gipsy
 */
public class CultivoDAO {
     private final Connection cn = ConexionBD.getInstancia().getConexion();

    public boolean agregar(Cultivo c) {
        String sql = "INSERT INTO cultivos (Nombre, Tipo, AreaSembrada, EstadoCrecimiento, FechaSiembra, FechaCosecha) VALUES ()";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTipo());
            ps.setDouble(3, c.getAreaSembrada());
            ps.setString(4, c.getEstadoCrecimiento());
            ps.setDate(5, c.getFechaSiembra());
            ps.setDate(6, c.getFechaCosecha());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Agregar cultivo: " + e.getMessage());
            return false;
        }
    }

    public List<Cultivo> listar() {
        List<Cultivo> lista = new ArrayList<>();
        String sql = "SELECT * FROM cultivos ORDER BY Nombre";
        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cultivo(
                    rs.getInt("id"),
                    rs.getString("Nombre"),
                    rs.getString("Tipo"),
                    rs.getDouble("AreaSembrada"),
                    rs.getString("EstadoCrecimiento"),
                    rs.getDate("FechaSiembra"),
                    rs.getDate("FechaCosecha")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Listar cultivos: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizar(Cultivo c) {
        String sql = "UPDATE cultivos SET Nombre, Tipo, AreaSembrada, EstadoCrecimiento, FechaSiembra, FechaCosecha WHERE id";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTipo());
            ps.setDouble(3, c.getAreaSembrada());
            ps.setString(4, c.getEstadoCrecimiento());
            ps.setDate(5, c.getFechaSiembra());
            ps.setDate(6, c.getFechaCosecha());
            ps.setInt(7, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Actualizar cultivo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM cultivos WHERE id=?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Eliminar cultivo: " + e.getMessage());
            return false;
        }
    }

    public List<Cultivo> buscarPorNombre(String nombre) {
        List<Cultivo> lista = new ArrayList<>();
        String sql = "SELECT * FROM cultivos WHERE Nombre LIKE ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Cultivo(
                    rs.getInt("id"),
                    rs.getString("Nombre"),
                    rs.getString("Tipo"),
                    rs.getDouble("AreaSembrada"),
                    rs.getString("EstadoCrecimiento"),
                    rs.getDate("FechaSiembra"),
                    rs.getDate("FechaCosecha")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Buscar cultivos: " + e.getMessage());
        }
        return lista;
    }
}
