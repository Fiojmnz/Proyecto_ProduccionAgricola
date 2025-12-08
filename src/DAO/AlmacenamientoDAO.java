/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Almacenamiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author gipsy
 */
public class AlmacenamientoDAO {
    private final Connection conn;

    public AlmacenamientoDAO(Connection conn) {
        this.conn = conn;
    }

public Almacenamiento agregar(Almacenamiento a) {  
    String sql = "INSERT INTO almacenamiento (producto, cantidad, fechaIngreso, fechaEgreso) VALUES (?, ?, ?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, a.getProducto());
        ps.setInt(2, (int) a.getCantidad());
        ps.setDate(3, a.getFechaIngreso());
        ps.setDate(4, a.getFechaEgreso());

        int filas = ps.executeUpdate();
        if (filas > 0) {
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    a.setId(rs.getInt(1));  
                }
            }
        }
        return a;  
    } catch (SQLException e) {
        throw new RuntimeException("Error al agregar almacenamiento", e);
    }
}

    public List<Almacenamiento> listar() {
        String sql = "SELECT id, producto, cantidad, fechaIngreso, fechaEgreso FROM almacenamiento";
        List<Almacenamiento> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar almacenamiento", e);
        }
        return list;
    }

    public boolean actualizar(Almacenamiento a) {
        String sql = "UPDATE almacenamiento SET producto=?, cantidad=?, fechaIngreso=?, fechaEgreso=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getProducto());
            ps.setDouble(2, a.getCantidad());  
            ps.setDate(3, a.getFechaIngreso());
            ps.setDate(4, a.getFechaEgreso());
            ps.setInt(5, a.getId());
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
        a.setCantidad(rs.getDouble("cantidad"));       
        a.setFechaIngreso(rs.getDate("fechaIngreso"));
        a.setFechaEgreso(rs.getDate("fechaEgreso"));     
        return a;
    }
}