/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.ProduccionDAO;
import Modelo.ProduccionDTO;
import Servicios.ProduccionServicios;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;



/**
 *
 * @author gipsy
 */
public class ProduccionController {
    private final ProduccionServicios service;

    // Constructor recibe la conexión y arma el servicio con el DAO
    public ProduccionController(Connection conn) {
        this.service = new ProduccionServicios(new ProduccionDAO(conn));
    }

    // Crear
    public ProduccionDTO registrarProduccion(LocalDate fecha, double cantidad, String calidad, String destino) {
        ProduccionDTO dto = new ProduccionDTO();
        dto.setFecha(fecha);
        dto.setCantidadRecolectada(cantidad);
        dto.setCalidad(calidad);
        dto.setDestino(destino);
        return service.registrar(dto);
    }
 // Leer
    public List<ProduccionDTO> listarProduccion() {
        return service.listar();
    }

    public List<ProduccionDTO> listarProduccionPorFecha(LocalDate inicio, LocalDate fin) {
        return service.listarPorFecha(inicio, fin);
    }

    // Actualizar
    public boolean actualizarProduccion(ProduccionDTO dto) {
        return service.actualizar(dto);
    }

    // Eliminar
    public boolean eliminarProduccion(int id) {
        return service.eliminar(id);
    }

    // Reportes
    public void generarReportePDF(String rutaArchivo) {
        service.generarReportePDF(rutaArchivo);
    }

    public void generarReporteXML(String rutaArchivo) {
        service.generarReporteXML(rutaArchivo);
    }
}
