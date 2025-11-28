/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.UsuarioDAO;
import Modelo.Rol;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class UsuarioController {
    private final UsuarioService service = new UsuarioService(new UsuarioDAO());

    public UsuarioDTO registrarUsuario(String username, String password, Rol rol) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        dto.setRol(rol);
        dto.setActivo(true);
        return service.registrar(dto);
    }

    public List<UsuarioDTO> listarUsuarios() {
        return service.listar();
    }
}
