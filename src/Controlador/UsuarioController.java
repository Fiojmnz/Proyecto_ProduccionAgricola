/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.UsuarioDTO;
import Enum.Rol;
import Servicios.UsuarioServicios;
import DAO.UsuarioDAO;
import DB.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class UsuarioController {
  private final UsuarioServicios service;

    public UsuarioController() throws SQLException {
        Connection conn = ConnectionFactory.getInstancia().getConnection();
        this.service = new UsuarioServicios(new UsuarioDAO(conn));
    }
    public UsuarioDTO registrarUsuario(String username, String password, Rol rol) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        dto.setRol(rol);
        return service.registrar(dto);
    }
    
    public boolean existeUsername(String username) {
    return service.existeUsername(username);
}
public UsuarioDTO buscarPorUsername(String username) {
    return service.buscarPorUsername(username);
}

    public List<UsuarioDTO> listarUsuario() {
        return service.listar();
    }
    
   public boolean eliminarUsuario(String username) {
    return service.eliminar(username);
}


}
