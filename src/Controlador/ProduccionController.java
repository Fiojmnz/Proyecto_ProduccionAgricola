/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.ProduccionDAO;
import DB.ConnectionFactory;
import Enum.Destino;
import Modelo.Produccion;
import Modelo.ProduccionDTO;
import Servicios.ProduccionServicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

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
 public boolean registrarProduccion(Date fecha, double cantidad, String calidad, Destino destino, int idCultivo) {
        Produccion p = new Produccion();
        p.setFecha(fecha);
        p.setCantidadRecolectada(cantidad);
        p.setCalidad(calidad);
        p.setDestino(destino.name());
        p.setIdCultivo(idCultivo);

        try {
            return service.agregar(p); 
        } catch (Exception e) {
            System.err.println("ERROR AL REGISTRAR PRODUCCIÓN:");
         
            return false;
        }
    }

    public List<ProduccionDTO> listarProduccion() {
        return service.listar();
    }

public List<ProduccionDTO> listarProduccionPorFecha(Date inicio, Date fin) {
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
