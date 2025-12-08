/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import Enum.Rol;
import Modelo.UsuarioDTO;
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

    public void agregar(Usuario nuevo) throws SQLException {
    String sql = "INSERT INTO Usuario(username, password, rol, id) VALUES(?,?,?,?)";
    
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nuevo.getUsername());
        ps.setString(2, nuevo.getPasswordHash());
        ps.setString(3, nuevo.getRol().toString());
        ps.setObject(4, nuevo.getId()); 
        ps.executeUpdate();

        asignarUsuarioATrabajador(nuevo.getUsername(), obtenerIdUsuario(nuevo.getUsername()));
    }
}

private int obtenerIdUsuario(String username) {
    String sql = "SELECT id FROM Usuario WHERE username = ? ORDER BY id DESC LIMIT 1";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getInt("id");
    } catch (Exception e) {}
    return 0;
}

private void asignarUsuarioATrabajador(String nombre, int usuarioId) {
    String sql = "UPDATE trabajadores SET id = ? WHERE nombre = ? AND (id IS NULL OR id = 0)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, usuarioId);
        ps.setString(2, nombre);
        ps.executeUpdate();
    } catch (Exception e) {}
}

public List<UsuarioDTO> listarDTO() throws SQLException {
    List<UsuarioDTO> lista = new ArrayList<>();

    String sql = "SELECT id, username, password, rol, activo FROM Usuario";

    try (Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            UsuarioDTO dto = new UsuarioDTO();

            dto.setId(rs.getLong("id"));
            dto.setUsername(rs.getString("username"));
            dto.setPassword(rs.getString("password"));
            dto.setRol(Rol.valueOf(rs.getString("rol")));
            dto.setActivo(rs.getBoolean("activo"));

            lista.add(dto);
        }
    }

   return lista;
}
   

    public boolean eliminar(String username) {
    String sql = "DELETE FROM Usuario WHERE username = ?"; 

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
           
            throw new RuntimeException("Error al eliminar Usuario", e);
        }
    }


}
