/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import Modelo.TrabajadorDTO;

/**
 *
 * @author AsusVivobook
 */
public class TrabajadorValidacion {
    public void validarRegistro(TrabajadorDTO dto) {
        if (dto.getCedula() == null || dto.getCedula().isEmpty()) {
            throw new IllegalArgumentException("La cédula es obligatoria.");
        }
        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        if (dto.getCorreo() == null || !dto.getCorreo().contains("@")) {
            throw new IllegalArgumentException("El correo debe ser válido.");
        }
        if (dto.getSalario() <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor que cero.");
        }
    }
}
