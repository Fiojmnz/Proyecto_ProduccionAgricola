/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import Excepciones.ValidacionExcepcion;
import Modelo.CultivoDTO;

/**
 *
 * @author gipsy
 */
public class CultivoValidacion {
     public void validarCrear(CultivoDTO dto) {
        if (dto == null) throw new ValidacionExcepcion("Datos de cultivo vacíos");
        if (dto.getNombre() == null || dto.getNombre().isBlank())
            throw new ValidacionExcepcion("El nombre del cultivo es obligatorio");
        if (dto.getTipo() == null)
    throw new ValidacionExcepcion("El tipo de cultivo es obligatorio");
        if (dto.getAreaSembrada() <= 0)
            throw new ValidacionExcepcion("El área sembrada debe ser mayor a 0");
         if (dto.getEstadoCrecimiento() == null)
    throw new ValidacionExcepcion("El estado de crecimiento es obligatorio");
        if (dto.getFechaSiembra() == null)
            throw new ValidacionExcepcion("La fecha de siembra es obligatoria");
    }
}

