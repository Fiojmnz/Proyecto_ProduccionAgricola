/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import Modelo.TrabajadorDTO;
import Modelo.Trabajador;

/**
 *
 * @author AsusVivobook
 */
public class TrabajadorMapper {
    public static Trabajador toEntity(TrabajadorDTO dto) {
        Trabajador t = new Trabajador();
        t.setCedula(dto.getCedula());
        t.setNombre(dto.getNombre());
        t.setTelefono(dto.getTelefono());
        t.setCorreo(dto.getCorreo());
        t.setPuesto(dto.getPuesto());
        t.setHorario(dto.getHorario());
        t.setSalario(dto.getSalario());
        return t;
    }

    public static TrabajadorDTO toDTO(Trabajador t) {
        TrabajadorDTO dto = new TrabajadorDTO();
        dto.setCedula(t.getCedula());
        dto.setNombre(t.getNombre());
        dto.setTelefono(t.getTelefono());
        dto.setCorreo(t.getCorreo());
        dto.setPuesto(t.getPuesto());
        dto.setHorario(t.getHorario());
        dto.setSalario(t.getSalario());
        return dto;
    }
}

