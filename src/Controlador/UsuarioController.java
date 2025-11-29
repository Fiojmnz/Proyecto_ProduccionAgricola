/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.UsuarioDTO;
import Enum.Rol;
import Servicios.UsuarioServicios;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class UsuarioController {

    private final UsuarioServicios service;

    public UsuarioController(Connection conn) {
        this.service = new UsuarioServicios(new UsuarioDAO(conn));
    }

    public UsuarioDTO registrarUsuario(String username, String password, Rol rol) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        dto.setRol(rol);
        return service.registrar(dto);
    }

    public List<UsuarioDTO> listarUsuarios() {
        return service.listar();
    }
}
