/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import Modelo.ProduccionDTO;
import Modelo.Produccion;

/**
 *
 * @author gipsy
 */
public class ProduccionMapper {
    public static Produccion toEntity(ProduccionDTO dto) {
        Produccion p = new Produccion();
        p.setId(dto.getId());
        p.setFecha(dto.getFecha());
        p.setCantidadRecolectada(dto.getCantidadRecolectada());
        p.setCalidad(dto.getCalidad());
        p.setDestino(dto.getDestino());
        return p;
    }

    public static ProduccionDTO toDTO(Produccion p) {
        ProduccionDTO dto = new ProduccionDTO();
        dto.setId(p.getId());
        dto.setFecha(p.getFecha());
        dto.setCantidadRecolectada(p.getCantidadRecolectada());
        dto.setCalidad(p.getCalidad());
        dto.setDestino(p.getDestino());
        dto.setProductividad(p.getProductividad());
        return dto;
    }
}
