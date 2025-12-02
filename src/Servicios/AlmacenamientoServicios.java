/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.AlmacenamientoDAO;
import Modelo.AlmacenamientoDTO;
import Mapper.AlmacenamientoMapper;
import Modelo.Almacenamiento;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoServicios {
    private final AlmacenamientoDAO dao;

    public AlmacenamientoServicios(Connection conn) {
        this.dao = new AlmacenamientoDAO(conn);
    }

    public AlmacenamientoDTO registrar(AlmacenamientoDTO dto) {
        Almacenamiento a = AlmacenamientoMapper.toEntity(dto);
        dao.agregar(a);
        return AlmacenamientoMapper.toDTO(a);
    }

    public List<AlmacenamientoDTO> listar() {
        return dao.listar()
                .stream()
                .map(AlmacenamientoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean actualizar(AlmacenamientoDTO dto) {
        Almacenamiento a = AlmacenamientoMapper.toEntity(dto);
        return dao.actualizar(a);
    }

    public boolean eliminar(int id) {
        return dao.eliminar(id);
    }

    public void generarReportePDF(String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            pw.println("Reporte de Almacenamiento (PDF simulado)");
            for (AlmacenamientoDTO dto : listar()) {
                pw.println(dto.getId() + " - " + dto.getProducto() + " - "
                        + dto.getCantidad() + " - "
                        + dto.getFechaIngreso());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al generar reporte PDF", e);
        }
    }

    public void generarReporteXML(String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            pw.println("<almacenamientos>");
            for (AlmacenamientoDTO dto : listar()) {
                pw.println("  <almacenamiento>");
                pw.println("    <id>" + dto.getId() + "</id>");
                pw.println("    <producto>" + dto.getProducto() + "</producto>");
                pw.println("    <cantidad>" + dto.getCantidad() + "</cantidad>");
                pw.println("    <fechaIngreso>" + dto.getFechaIngreso() + "</fechaIngreso>");
                pw.println("  </almacenamiento>");
            }
            pw.println("</almacenamientos>");
        } catch (Exception e) {
            throw new RuntimeException("Error al generar reporte XML", e);
        }
    }
}
