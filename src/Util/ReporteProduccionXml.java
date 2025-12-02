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
public class ReporteProduccionXml {
    public static String generarXML(List<ProduccionDTO> datos) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<reporteProduccion>\n");
        for (ProduccionDTO d : datos) {
            sb.append("  <cosecha>\n");
            sb.append("    <id>").append(d.getId()).append("</id>\n");
            sb.append("    <fecha>").append(esc(d.getFecha() != null ? d.getFecha().toString() : "")).append("</fecha>\n");
            sb.append("    <cantidadRecolectada>").append(d.getCantidadRecolectada()).append("</cantidadRecolectada>\n");
            sb.append("    <calidad>").append(esc(d.getCalidad())).append("</calidad>\n");
            sb.append("    <destino>").append(esc(d.getDestino())).append("</destino>\n");
            sb.append("    <productividad>").append(d.getProductividad()).append("</productividad>\n");
            sb.append("  </cosecha>\n");
        }
        sb.append("</reporteProduccion>\n");
        return sb.toString();
    }

    private static String esc(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
