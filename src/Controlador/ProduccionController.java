/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ProduccionDAO;
import Enum.Destino;

import Modelo.ProduccionDTO;
import Servicios.ProduccionServicios;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author gipsy
 */
public class ProduccionController {
   private final ProduccionServicios service = new ProduccionServicios (new ProduccionDAO());

    public ProduccionDTO registrarProduccion(Integer cultivoId, Date fecha,double CantidadRecolectada, String calidad, Destino destino) {
        ProduccionDTO dto = new ProduccionDTO();
        dto.setCultivoId(cultivoId);
        dto.setFecha(fecha);
        dto.setCantidadRecolectada(CantidadRecolectada);
        dto.setCalidad(calidad);
        dto.setDestino(destino);
        return service.registrar(dto);
    }

    public List<ProduccionDTO> listarProduccion(Date desde, Date hasta) {
    LocalDate desdeLocal = desde.toLocalDate();
    LocalDate hastaLocal = hasta.toLocalDate();
    return service.listarPorRango(desdeLocal, hastaLocal);
}
}