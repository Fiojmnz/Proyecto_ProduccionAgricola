/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import Modelo.UsuarioDTO;
import Modelo.Usuario;

/**
 *
 * @author AsusVivobook
 */
public class UsuarioMapper {
    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setUsername(dto.getUsername());
        u.setRol(dto.getRol());
        return u;
    }

    public static UsuarioDTO toDTO(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsername(u.getUsername());
        dto.setRol(u.getRol());
        return dto;
    }
}
