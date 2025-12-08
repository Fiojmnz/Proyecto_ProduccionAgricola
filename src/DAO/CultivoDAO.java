/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.ConnectionFactory;
import Enum.EstadoCrecimiento;
import Enum.TipoCultivo;
import Modelo.Cultivo;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gipsy
 */
public class CultivoDAO {

    private final Connection conn;

    public CultivoDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean agregar(Cultivo c) {
        String sql = "INSERT INTO cultivos(Nombre, Tipo, AreaSembrada, EstadoCrecimiento, FechaSiembra, FechaCosecha) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTipo().name());
            ps.setDouble(3, c.getAreaSembrada());
            ps.setString(4, c.getEstadoCrecimiento().name());
            ps.setDate(5, c.getFechaSiembra());
            ps.setDate(6, c.getFechaCosecha());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) c.setId(rs.getInt(1));
            }

            return true;

        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar cultivo", e);
        }
    }

    public List<Cultivo> listar(String filtroNombre) {
        List<Cultivo> list = new ArrayList<>();

        String sql = "SELECT * FROM cultivos";
        boolean filtrar = filtroNombre != null && !filtroNombre.isBlank();

        if (filtrar) {
            sql += " WHERE Nombre LIKE ?";
        }

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            if (filtrar) {
                ps.setString(1, "%" + filtroNombre + "%");
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cultivo c = map(rs);
                    list.add(c);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al listar cultivos", e);
        }

        return list;
    }

    public boolean actualizar(Cultivo c) {
        String sql = "UPDATE cultivos SET Nombre=?, Tipo=?, AreaSembrada=?, EstadoCrecimiento=?, FechaSiembra=?, FechaCosecha=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTipo().name());
            ps.setDouble(3, c.getAreaSembrada());
            ps.setString(4, c.getEstadoCrecimiento().name());
            ps.setDate(5, c.getFechaSiembra());
            ps.setDate(6, c.getFechaCosecha());
            ps.setInt(7, c.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar cultivo", e);
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM cultivos WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar cultivo", e);
        }
    }

   private Cultivo map(ResultSet rs) throws SQLException {
    Cultivo c = new Cultivo();
    
    c.setId(rs.getInt("id"));
    c.setNombre(rs.getString("Nombre"));
    
    String tipoString = rs.getString("Tipo");
    if (tipoString != null) {
        c.setTipo(TipoCultivo.valueOf(tipoString.toUpperCase()));
    }

    String estadoString = rs.getString("EstadoCrecimiento");
    if (estadoString != null) {
        c.setEstadoCrecimiento(EstadoCrecimiento.valueOf(estadoString.toUpperCase()));
    }
 
    c.setAreaSembrada(rs.getDouble("AreaSembrada"));
    c.setFechaSiembra(rs.getDate("FechaSiembra"));
    c.setFechaCosecha(rs.getDate("FechaCosecha"));
    
    return c;
}
}
