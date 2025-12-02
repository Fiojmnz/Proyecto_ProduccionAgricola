/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Almacenamiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gipsy
 */
public class AlmacenamientoDAO {
    private final Connection conn;

    public AlmacenamientoDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean agregar(Almacenamiento a) {
        String sql = "INSERT INTO almacenamiento(producto, cantidad, fecha_ingreso) VALUES (?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getProducto());
            ps.setDouble(2, a.getCantidad());
            ps.setDate(3, Date.valueOf(a.getFechaIngreso()));
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    a.setId(rs.getInt(1));
                }
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar almacenamiento", e);
        }
    }

    public List<Almacenamiento> listar() {
        String sql = "SELECT * FROM almacenamiento";
        List<Almacenamiento> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar almacenamiento", e);
        }
    }

    public boolean actualizar(Almacenamiento a) {
        String sql = "UPDATE almacenamiento SET producto=?, cantidad=?, fecha_ingreso=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getProducto());
            ps.setDouble(2,  a.getCantidad());
            ps.setDate(3, Date.valueOf(a.getFechaIngreso()));
            ps.setInt(4, a.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar almacenamiento", e);
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM almacenamiento WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar almacenamiento", e);
        }
    }

    private Almacenamiento map(ResultSet rs) throws SQLException {
        Almacenamiento a = new Almacenamiento();
        a.setId(rs.getInt("id"));
        a.setProducto(rs.getString("producto"));
        a.setCantidad(rs.getInt("cantidad"));
        a.setFechaIngreso(rs.getDate("fecha_ingreso").toLocalDate());
        return a;
    }
}
