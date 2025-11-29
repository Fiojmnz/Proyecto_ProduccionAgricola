/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import Excepciones.ValidacionException;
import Modelo.CultivoDTO;

/**
 *
 * @author gipsy
 */
public class CultivoValidador {
     public void validarCrear(CultivoDTO dto) {
        if (dto == null) throw new ValidacionException("Datos de cultivo vacíos");
        if (dto.getNombre() == null || dto.getNombre().isBlank())
            throw new ValidacionException("El nombre del cultivo es obligatorio");
        if (dto.getTipo() == null)
    throw new ValidacionException("El tipo de cultivo es obligatorio");
        if (dto.getAreaSembrada() <= 0)
            throw new ValidacionException("El área sembrada debe ser mayor a 0");
         if (dto.getEstadoCrecimiento() == null)
    throw new ValidacionException("El estado de crecimiento es obligatorio");
        if (dto.getFechaSiembra() == null)
            throw new ValidacionException("La fecha de siembra es obligatoria");
    }
}

