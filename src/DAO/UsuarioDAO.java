/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import Enum.Rol;
import java.sql.*;
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
        try (PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE username=?")) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar usuario", e);
        }
        return false;
    }
    public Usuario buscarPorUsername(String username) {
    try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios WHERE username")) {
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getLong("id"));
            u.setUsername(rs.getString("username"));
            u.setPasswordHash(rs.getString("password"));
            u.setRol(Rol.valueOf(rs.getString("rol")));
            u.setActivo(rs.getBoolean("activo"));
            return u;
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error al buscar usuario por username", e);
    }
    return null;
}


    public void agregar(Usuario u) {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO usuarios(username,password,rol,activo) VALUES(?,?,?,?)")) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPasswordHash());
            ps.setString(3, u.getRol().name());
            ps.setBoolean(4, u.isActivo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar usuario", e);
        }
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM usuarios")) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getLong("id"));
                u.setUsername(rs.getString("username"));
                u.setPasswordHash(rs.getString("password"));
                u.setRol(Rol.valueOf(rs.getString("rol")));
                u.setActivo(rs.getBoolean("activo"));
                lista.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar usuarios", e);
        }
        return lista;
    }
    
}
