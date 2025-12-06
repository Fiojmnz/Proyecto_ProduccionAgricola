/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import DAO.UsuarioDAO;
import DB.ConnectionFactory;
import Enum.Rol;
import Modelo.Usuario;
import Validaciones.EncriptadorContrasena;
import java.sql.SQLException;
/**
 *
 * @author gipsy
 */
public class AdministradorAuntenticacion {
    private static AdministradorAuntenticacion instancia;
    private final UsuarioDAO usuarioDAO;
    private Usuario actual;

    private AdministradorAuntenticacion() throws SQLException {
        this.usuarioDAO = new UsuarioDAO(ConnectionFactory.getInstancia().getConnection());
    }

    public static AdministradorAuntenticacion getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new AdministradorAuntenticacion();
        }
        return instancia;
    }

    public boolean login(String username, String password) {
        Usuario u = usuarioDAO.buscarPorUsername(username);
        if (u != null && u.isActivo() && EncriptadorContrasena.verifica(password, u.getPasswordHash())) {
            actual = u;
            return true;
        }
        return false;
    }

    public void logout() {
        actual = null;
    }

    public boolean isAuthenticated() {
        return actual != null;
    }

    public boolean isAdmin() {
        return isAuthenticated() && actual.getRol() == Rol.ADMINISTRADOR;
    }

    public Rol getRol() {
        return isAuthenticated() ? actual.getRol() : null;
    }

    public Usuario getUsuarioActual() {
        return actual;
    }
}
   
