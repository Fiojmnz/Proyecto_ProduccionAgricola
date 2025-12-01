/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.FileWriter;

/**
 *
 * @author gipsy
 */
public class XmUtils {
    public static boolean EscribirSimple(String ruta, String contenido) {
        try (FileWriter fw = new FileWriter(ruta)) {
            fw.write(contenido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
