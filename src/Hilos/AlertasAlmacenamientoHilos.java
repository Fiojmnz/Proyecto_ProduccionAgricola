/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import Controlador.AlmacenamientoController;
import Modelo.AlmacenamientoDTO;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 *
 * @author gipsy
 */
public class AlertasAlmacenamientoHilos extends Thread {
    
 private final AlmacenamientoController controller;
    private final int UmbralDias;

    public AlertasAlmacenamientoHilos(AlmacenamientoController controller, int umbralDias) {
        this.controller = controller;
        this.UmbralDias = umbralDias;
        setDaemon(true);
    } 

    @Override
    public void run() {
        while (true) {
            List<AlmacenamientoDTO> inventario = controller.listarInventario();
            for (AlmacenamientoDTO a : inventario) {
                long dias = ChronoUnit.DAYS.between(a.getFechaIngreso(), LocalDate.now());
                if (dias >= UmbralDias) {
                    System.out.println("ALERTA: Producto " + a.getProducto() + " lleva " + dias + " días almacenado.");
                    
                }
            }
            try { Thread.sleep(60_000); } catch (InterruptedException ignored) {}
        }
    }
}
