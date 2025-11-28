/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;
import Modelo.Cultivo;
import Modelo.CultivoDTO;

/**
 *
 * @author gipsy
 */
public class CultivoMapper {
        public static Cultivo toEntity(CultivoDTO dto) {
        if (dto == null) return null;
        Cultivo c = new Cultivo();
        c.setId(dto.getId() == null ? 0 : dto.getId());
        c.setNombre(dto.getNombre());
        c.setTipo(dto.getTipo());
        c.setAreaSembrada(dto.getAreaSembrada());
        c.setEstadoCrecimiento(dto.getEstadoCrecimiento());
        c.setFechaSiembra(dto.getFechaSiembra());
        c.setFechaCosecha(dto.getFechaCosecha());
        return c;
    }

    public static CultivoDTO toDTO(Cultivo e) {
        if (e == null) return null;
        CultivoDTO dto = new CultivoDTO();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setTipo(e.getTipo());
        dto.setAreaSembrada(e.getAreaSembrada());
        dto.setEstadoCrecimiento(e.getEstadoCrecimiento());
        dto.setFechaSiembra(e.getFechaSiembra());
        dto.setFechaCosecha(e.getFechaCosecha());
        return dto;
    }
}