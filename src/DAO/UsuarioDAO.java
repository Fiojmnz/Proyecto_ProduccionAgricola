/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import Enum.Rol;
import Validaciones.EncriptadorContrasena;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class UsuarioDAO {

    private final Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean existeUsername(String username) {
    String sql = "SELECT COUNT(*) FROM Usuario WHERE username = ?"; 
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            
            throw new RuntimeException("Error al verificar Usuario", e);
        }

        return false;
    }

  
    public Usuario buscarPorUsername(String username) {
        String sql = "SELECT * FROM Usuario WHERE username = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getLong("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPasswordHash(rs.getString("password"));
                    u.setRol(Rol.valueOf(rs.getString("rol").toUpperCase()));
                    u.setActivo(rs.getBoolean("activo"));
                    return u;
                }
            }
        } catch (SQLException e) {
         
            throw new RuntimeException("Error al buscar usuario por Usuario", e);
        }
        return null;
    }

    public void agregar(Usuario u) {
    try (PreparedStatement ps = conn.prepareStatement(
        "INSERT INTO Usuario(username, password, rol, activo) VALUES (?, ?, ?, ?)")) {

        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPasswordHash());
        ps.setString(3, u.getRol().name());
        ps.setBoolean(4, u.isActivo());

        ps.executeUpdate();

    } catch (SQLException e) {
       
        throw new RuntimeException("Error al insertar Usuario", e);
    }
}


    public List<Usuario> listar() {
       List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM Usuario"; // ← OJO: Usuario

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getLong("id"));
                u.setUsername(rs.getString("username"));
                u.setPasswordHash(rs.getString("password"));
                u.setRol(Rol.valueOf(rs.getString("rol").toUpperCase()));
                u.setActivo(rs.getBoolean("activo"));
                lista.add(u);
            }

        } catch (SQLException e) {
           
            throw new RuntimeException("Error al listar Usuario", e);
        }

        return lista;
    }

    public boolean eliminar(String username) {
    String sql = "DELETE FROM Usuario WHERE username = ?"; // ← OJO: Usuario

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
           
            throw new RuntimeException("Error al eliminar Usuario", e);
        }
    }


}
