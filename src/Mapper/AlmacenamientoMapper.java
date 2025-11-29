/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import Modelo.AlmacenamientoDTO;
import Modelo.Almacenamiento;

/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoMapper {
     public static Almacenamiento toEntity(AlmacenamientoDTO dto) {
        Almacenamiento a = new Almacenamiento();
        a.setProducto(dto.getProducto());
        a.setCantidad(dto.getCantidad());
        a.setFechaIngreso(dto.getFechaIngreso());
        a.setFechaEgreso(dto.getFechaEgreso());
        return a;
    }

    public static AlmacenamientoDTO toDTO(Almacenamiento a) {
        AlmacenamientoDTO dto = new AlmacenamientoDTO();
        dto.setProducto(a.getProducto());
        dto.setCantidad(a.getCantidad());
        dto.setFechaIngreso(a.getFechaIngreso());
        dto.setFechaEgreso(a.getFechaEgreso());
        return dto;
    }

}
