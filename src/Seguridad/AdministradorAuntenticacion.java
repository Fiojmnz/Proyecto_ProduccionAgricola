/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import DAO.UsuarioDAO;
import Enum.Rol;
import Modelo.Usuario;
import Validaciones.EncriptadorContraseña;

/**
 *
 * @author gipsy
 */
public class AdministradorAuntenticacion {
    private final UsuarioDAO usuarioDAO;
    private Usuario actual;

    public AdministradorAuntenticacion (UsuarioDAO usuarioDAO) { this.usuarioDAO = usuarioDAO; }

    public boolean login(String username, String password) {
        Usuario u = usuarioDAO.buscarPorUsername(username);
        if (u != null && u.isActivo() && EncriptadorContraseña.verifica (password, u.getPasswordHash())) {
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
        return isAuthenticated() && actual.getRol() == Rol.ADMINISTRADOR ; 
    }
    public Usuario getUsuarioActual() {
        return actual; 
    }
}
