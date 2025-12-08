/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import Modelo.Usuario;
import Modelo.UsuarioDTO;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        
        u.setId(dto.getId());
        u.setUsername(dto.getUsername());
        u.setPasswordHash(dto.getPassword()); 
        u.setRol(dto.getRol());
        u.setActivo(dto.isActivo());

        return u;
    }

    public static UsuarioDTO toDTO(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();

        dto.setId(u.getId());
        dto.setUsername(u.getUsername());
        dto.setPassword(u.getPasswordHash()); 
        dto.setRol(u.getRol());
        dto.setActivo(u.isActivo());

        return dto;
    }
}