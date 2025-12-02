/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Produccion;
import java.sql.*;
import java.time.LocalDate;
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
        String sql = "INSERT INTO produccion(fecha, cantidad_recolectada, calidad, destino) VALUES (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, Date.valueOf(p.getFecha()));
            ps.setDouble(2, p.getCantidadRecolectada());
            ps.setString(3, p.getCalidad());
            ps.setString(4, p.getDestino());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar producción", e);
        }
    }

    public List<Produccion> listar() {
        String sql = "SELECT * FROM produccion";
        List<Produccion> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar producción", e);
        }
    }

    public List<Produccion> listarPorFecha(LocalDate inicio, LocalDate fin) {
        String sql = "SELECT * FROM produccion WHERE fecha BETWEEN ? AND ?";
        List<Produccion> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(inicio));
            ps.setDate(2, Date.valueOf(fin));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar producción por fecha", e);
        }
    }

    public boolean actualizar(Produccion p) {
        String sql = "UPDATE produccion SET fecha=?, cantidad_recolectada=?, calidad=?, destino=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(p.getFecha()));
            ps.setDouble(2, p.getCantidadRecolectada());
            ps.setString(3, p.getCalidad());
            ps.setString(4, p.getDestino());
            ps.setInt(5, p.getId());
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
        p.setFecha(rs.getDate("fecha").toLocalDate());
        p.setCantidadRecolectada(rs.getDouble("cantidad_recolectada"));
        p.setCalidad(rs.getString("calidad"));
        p.setDestino(rs.getString("destino"));
        // productividad se calcula en el servicio, no en DB
        return p;
    }
}
