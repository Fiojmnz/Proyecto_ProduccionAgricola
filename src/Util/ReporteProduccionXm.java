/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Modelo.ProduccionDTO;
import java.util.List;

/**
 *
 * @author gipsy
 */
public class ReporteProduccionXm {
      public static String generarXML(List<ProduccionDTO> datos) {
        StringBuilder sb = new StringBuilder();
        sb.append("<reporteProduccion>\n");
        for (ProduccionDTO d : datos) {
            sb.append("  <cosecha>\n");
            sb.append("    <CultivoId>").append(d.getCultivoId()).append("</cultivoId>\n");
            sb.append("    <Fecha>").append(d.getFecha()).append("</fecha>\n");
            sb.append("    <CantidadRecolectada>").append(d.getCantidadRecolectada()).append("</cantidad>\n");
            sb.append("    <Calidad>").append(d.getCalidad()).append("</calidad>\n");
            sb.append("    <Destino>").append(d.getDestino()).append("</destino>\n");
            sb.append("    <Productividad>").append(d.getProductividad()).append("</productividad>\n");
            sb.append("  </Cosecha>\n");
        }
        sb.append("</reporteProduccion>\n");
        return sb.toString();
    }
}
