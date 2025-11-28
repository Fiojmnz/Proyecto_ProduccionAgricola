/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import Modelo.Produccion;
import Modelo.ProduccionDTO;

/**
 *
 * @author gipsy
 */
public class ProduccionMapper {
    public static Produccion toEntity(ProduccionDTO dto) {
        Produccion p = new Produccion();
        p.setId(dto.getId());
        p.setCultivoId(dto.getCultivoId());
        p.setFecha(dto.getFecha());
        p.setCantidadRecolectada(dto.getCantidadRecolectada());
        p.setCalidad(dto.getCalidad());
        p.setDestino(dto.getDestino());
        return p;
    }

    public static ProduccionDTO toDTO(Produccion e) {
        ProduccionDTO dto = new ProduccionDTO();
        dto.setId(e.getId());
        dto.setCultivoId(e.getCultivoId());
        dto.setFecha(e.getFecha());
        dto.setCantidadRecolectada(e.getCantidadRecolectada());
        dto.setCalidad(e.getCalidad());
        dto.setDestino(e.getDestino());
        dto.setProductividad(null);
        return dto;
    }
} 

