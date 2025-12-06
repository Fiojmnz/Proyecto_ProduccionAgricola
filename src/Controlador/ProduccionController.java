/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.ProduccionDAO;
import DB.ConnectionFactory;
import Modelo.ProduccionDTO;
import Servicios.ProduccionServicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;



/**
 *
 * @author gipsy
 */
public class ProduccionController {
    
    private final ProduccionServicios service;

    public ProduccionController() throws SQLException {
        Connection conn = ConnectionFactory.getInstancia().getConnection();
        this.service = new ProduccionServicios(new ProduccionDAO(conn));
    }
    public ProduccionDTO registrarProduccion(LocalDate fecha, double cantidad, String calidad, String destino) {
        ProduccionDTO dto = new ProduccionDTO();
        dto.setFecha(fecha);
        dto.setCantidadRecolectada(cantidad);
        dto.setCalidad(calidad);
        dto.setDestino(destino);
        return service.registrar(dto);
    }

    public List<ProduccionDTO> listarProduccion() {
        return service.listar();
    }

    public List<ProduccionDTO> listarProduccionPorFecha(LocalDate inicio, LocalDate fin) {
        return service.listarPorFecha(inicio, fin);
    }

    public boolean actualizarProduccion(ProduccionDTO dto) {
        return service.actualizar(dto);
    }

    public boolean eliminarProduccion(int id) {
        return service.eliminar(id);
    }

    public void generarReportePDF(String rutaArchivo) {
        service.generarReportePDF(rutaArchivo);
    }

    public void generarReporteXML(String rutaArchivo) {
        service.generarReporteXML(rutaArchivo);
    }
}
