/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AlmacenamientoDTO;
import Servicios.AlmacenamientoServicios;
import Hilos.AlertasAlmacenamientoHilos;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoController {
    private final AlmacenamientoServicios service;

    public AlmacenamientoController(Connection conn) {
        this.service = new AlmacenamientoServicios(conn);
    }

    public AlmacenamientoDTO registrarAlmacenamiento(String producto, int cantidad, java.time.LocalDate fechaIngreso) {
        AlmacenamientoDTO dto = new AlmacenamientoDTO();
        dto.setProducto(producto);
        dto.setCantidad(cantidad);
        dto.setFechaIngreso(fechaIngreso);
        return service.registrar(dto);
    }

    public List<AlmacenamientoDTO> listarInventario() {
        return service.listar();
    }

    public boolean actualizarAlmacenamiento(AlmacenamientoDTO dto) {
        return service.actualizar(dto);
    }

    public boolean eliminarAlmacenamiento(int id) {
        return service.eliminar(id);
    }

    public void generarReportePDF(String rutaArchivo) {
        service.generarReportePDF(rutaArchivo);
    }

    public void generarReporteXML(String rutaArchivo) {
        service.generarReporteXML(rutaArchivo);
    }

    public void iniciarAlertas(int umbralDias) {
        AlertasAlmacenamientoHilos hilo = new AlertasAlmacenamientoHilos(this, umbralDias);
        hilo.start();
    }
}
