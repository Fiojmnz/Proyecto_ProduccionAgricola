/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.ProduccionDAO;
import Mapper.ProduccionMapper;
import Modelo.Produccion;
import Modelo.ProduccionDTO;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gipsy
 */
public class ProduccionServicios {
    private final ProduccionDAO dao;

    public ProduccionServicios (ProduccionDAO dao) { this.dao = dao; }

    public ProduccionDTO registrar(ProduccionDTO dto) {
    Produccion p = ProduccionMapper.toEntity(dto);
    dao.agregar(p);
    ProduccionDTO out = ProduccionMapper.toDTO(p);
    out.setProductividad(calcularProductividad(out.getCantidadRecolectada(), out.getCalidad()));
    return out;
}


    public List<ProduccionDTO> listarPorRango(java.time.LocalDate desde, java.time.LocalDate hasta) {
        return dao.listarPorFecha(Date.valueOf(desde), Date.valueOf(hasta)).stream()
                .map(e -> {
                    ProduccionDTO d = ProduccionMapper.toDTO(e);
                    d.setProductividad(calcularProductividad(d.getCantidadRecolectada(), d.getCalidad()));
                    return d;
                }).collect(Collectors.toList());
    }

    private double calcularProductividad(double cantidad, String calidad) {
        double factor = switch (calidad) { 
            case "ALTA" -> 1.0; case "MEDIA" -> 0.8; default -> 0.6; };
        return cantidad * factor;
    }
}

