/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.ProduccionDAO;
import Modelo.ProduccionDTO;
import Mapper.ProduccionMapper;
import Modelo.Produccion;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gipsy
 */
public class ProduccionServicios {
    private final ProduccionDAO dao;

    public ProduccionServicios(ProduccionDAO dao) {
        this.dao = dao;
    }

    public ProduccionDTO registrar(ProduccionDTO dto) {
        Produccion p = ProduccionMapper.toEntity(dto);

        // Ejemplo de cálculo de productividad 
        double productividad = p.getCantidadRecolectada() * 0.8; 
        p.setProductividad(productividad);

        dao.agregar(p);
        return ProduccionMapper.toDTO(p);
    }

    public List<ProduccionDTO> listar() {
        return dao.listar()
                .stream()
                .map(ProduccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ProduccionDTO> listarPorFecha(java.time.LocalDate inicio, java.time.LocalDate fin) {
        return dao.listarPorFecha(inicio, fin)
                .stream()
                .map(ProduccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean actualizar(ProduccionDTO dto) {
        Produccion p = ProduccionMapper.toEntity(dto);
        return dao.actualizar(p);
    }

    public boolean eliminar(int id) {
        return dao.eliminar(id);
    }

    public void generarReportePDF(String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            pw.println("Reporte de Producción (PDF simulado)");
            for (ProduccionDTO dto : listar()) {
                pw.println(dto.getId() + " - " + dto.getFecha() + " - "
                        + dto.getCantidadRecolectada() + " - "
                        + dto.getCalidad() + " - "
                        + dto.getDestino() + " - Prod: "
                        + dto.getProductividad());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al generar reporte PDF", e);
        }
    }

    public void generarReporteXML(String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            pw.println("<producciones>");
            for (ProduccionDTO dto : listar()) {
                pw.println("  <produccion>");
                pw.println("    <id>" + dto.getId() + "</id>");
                pw.println("    <fecha>" + dto.getFecha() + "</fecha>");
                pw.println("    <cantidad>" + dto.getCantidadRecolectada() + "</cantidad>");
                pw.println("    <calidad>" + dto.getCalidad() + "</calidad>");
                pw.println("    <destino>" + dto.getDestino() + "</destino>");
                pw.println("    <productividad>" + dto.getProductividad() + "</productividad>");
                pw.println("  </produccion>");
            }
            pw.println("</producciones>");
        } catch (Exception e) {
            throw new RuntimeException("Error al generar reporte XML", e);
        }
    }
}
