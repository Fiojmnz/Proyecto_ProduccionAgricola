/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Produccion;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class ProduccionDAO {
   private final Connection conn;

    public ProduccionDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean agregar(Produccion p) {
        String sql = "INSERT INTO produccion (fecha, cantidadRecolectada, calidad, destino, id_cultivo) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, p.getFecha());
            ps.setDouble(2, p.getCantidadRecolectada());  
            ps.setString(3, p.getCalidad());
            ps.setString(4, p.getDestino());
            ps.setObject(5, p.getIdCultivo()); 

            int filas = ps.executeUpdate();
            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        p.setId(rs.getInt(1));
                    }
                }
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al insertar producción: " + e.getMessage(), e);
        }
    }

    public List<Produccion> listar() {
        List<Produccion> lista = new ArrayList<>();
        String sql = "SELECT id, fecha, id_cultivo, cantidadRecolectada, calidad, destino FROM produccion";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar producción", e);
        }
        return lista;
    }

    public List<Produccion> listarPorFecha(Date inicio, Date fin) {
        List<Produccion> lista = new ArrayList<>();
        String sql = "SELECT id, fecha, id_cultivo, cantidadRecolectada, calidad, destino FROM produccion WHERE fecha BETWEEN ? AND ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, inicio);
            ps.setDate(2, fin);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(map(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al filtrar producción por fecha", e);
        }
        return lista;
    }

    public boolean actualizar(Produccion p) {
        String sql = "UPDATE produccion SET fecha=?, cantidadRecolectada=?, calidad=?, destino=?, id_cultivo=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, p.getFecha());
            ps.setDouble(2, p.getCantidadRecolectada());
            ps.setString(3, p.getCalidad());
            ps.setString(4, p.getDestino());
            ps.setObject(5, p.getIdCultivo());
            ps.setInt(6, p.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar producción", e);
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM produccion WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar producción", e);
        }
    }

    private Produccion map(ResultSet rs) throws SQLException {
        Produccion p = new Produccion();
        p.setId(rs.getInt("id"));
        p.setFecha(rs.getDate("fecha"));

        Object idCultivoObj = rs.getObject("id_cultivo");
        p.setIdCultivo(idCultivoObj != null ? rs.getInt("id_cultivo") : null);

        p.setCantidadRecolectada(rs.getDouble("cantidadRecolectada")); 
        p.setCalidad(rs.getString("calidad"));
        p.setDestino(rs.getString("destino"));

        return p;
    }
}