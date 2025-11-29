    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class TrabajadorDAO {
    private final Connection conn;

    //Recibe la conexión desde fuera
    public TrabajadorDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean agregar(Trabajador t) {
        String sql = "INSERT INTO trabajadores(cedula, nombre, telefono, correo, puesto, horario, salario) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getCedula());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getTelefono());
            ps.setString(4, t.getCorreo());
            ps.setString(5, t.getPuesto());
            ps.setString(6, t.getHorario());
            ps.setDouble(7, t.getSalario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar trabajador", e);
        }
    }

    public List<Trabajador> listar(String filtroPuesto) {
        List<Trabajador> list = new ArrayList<>();
        String sql;

        if (filtroPuesto == null || filtroPuesto.isEmpty()) {
            sql = "SELECT * FROM trabajadores";
            try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al listar trabajadores", e);
            }
        } else {
            sql = "SELECT * FROM trabajadores WHERE puesto = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, filtroPuesto);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        list.add(map(rs));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al listar trabajadores", e);
            }
        }
        return list;
    }

    public boolean actualizar(Trabajador t) {
        String sql = "UPDATE trabajadores SET nombre=?, telefono=?, correo=?, puesto=?, horario=?, salario=? WHERE cedula=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getTelefono());
            ps.setString(3, t.getCorreo());
            ps.setString(4, t.getPuesto());
            ps.setString(5, t.getHorario());
            ps.setDouble(6, t.getSalario());
            ps.setString(7, t.getCedula());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar trabajador", e);
        }
    }

    public boolean eliminar(String cedula) {
        String sql = "DELETE FROM trabajadores WHERE cedula=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar trabajador", e);
        }
    }

    private Trabajador map(ResultSet rs) throws SQLException {
        Trabajador t = new Trabajador();
        t.setCedula(rs.getString("cedula"));
        t.setNombre(rs.getString("nombre"));
        t.setTelefono(rs.getString("telefono"));
        t.setCorreo(rs.getString("correo"));
        t.setPuesto(rs.getString("puesto"));
        t.setHorario(rs.getString("horario"));
        t.setSalario(rs.getDouble("salario"));
        return t;
    }
}
