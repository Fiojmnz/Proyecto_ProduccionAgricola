/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import Modelo.UsuarioDTO;

/**
 *
 * @author AsusVivobook
 */
public class UsuarioValidacion {
    public void validarRegistro(UsuarioDTO dto) {
        if (dto.getUsername() == null || dto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio");
        }
        if (dto.getPassword() == null || dto.getPassword().length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }
        if (dto.getRol() == null) {
            throw new IllegalArgumentException("El rol es obligatorio");
        }
    }
}
