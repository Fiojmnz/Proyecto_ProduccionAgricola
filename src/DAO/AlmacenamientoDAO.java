/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.util.Date;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoDAO {
    public boolean agregar(Almacenamiento a) {
        String sql = "INSERT INTO almacenamiento(producto, cantidad, fecha_ingreso, fecha_egreso) VALUES (?,?,?,?)";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getProducto());
            ps.setDouble(2, a.getCantidad());
            ps.setDate(3, Date.valueOf(a.getFechaIngreso()));
            ps.setDate(4, a.getFechaEgreso() == null ? null : Date.valueOf(a.getFechaEgreso()));
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
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar almacenamiento", e);
        }
    }

    private Almacenamiento map(ResultSet rs) throws SQLException {
        Almacenamiento a = new Almacenamiento();
        a.setId(rs.getInt("id"));
        a.setProducto(rs.getString("producto"));
        a.setCantidad(rs.getDouble("cantidad"));
        a.setFechaIngreso(rs.getDate("fecha_ingreso").toLocalDate());
        Date fe = rs.getDate("fecha_egreso");
        a.setFechaEgreso(fe == null ? null : fe.toLocalDate());
        return a;
    }
}
