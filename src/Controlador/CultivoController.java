/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CultivoDAO;
import Modelo.Cultivo;
import java.util.List;

/**
 *
 * @author gipsy
 */
public class CultivoController {
    private final CultivoDAO cultivoDAO;

    public CultivoController(CultivoDAO cultivoDAO) {
        this.cultivoDAO = cultivoDAO;
    }

    public boolean crearCultivo(Cultivo cultivo) {
        if (!validarCultivo(cultivo)) return false;
        return cultivoDAO.agregar(cultivo);
    }

    public List<Cultivo> obtenerCultivos() {
        return cultivoDAO.listar();
    }

    public boolean modificarCultivo(Cultivo cultivo) {
        if (cultivo == null || cultivo.getId() <= 0 || !validarCultivo(cultivo)) return false;
        return cultivoDAO.actualizar(cultivo);
    }

    public boolean borrarCultivo(int id) {
        if (id <= 0) return false;
        return cultivoDAO.eliminar(id);
    }

    public List<Cultivo> buscarCultivoPorNombre(String Nombre) {
        if (Nombre == null || Nombre.isBlank()) return List.of();
        return cultivoDAO.buscarPorNombre(Nombre);
    }

    private boolean validarCultivo(Cultivo cultivo) {
        return cultivo != null &&
               cultivo.getNombre() != null && !cultivo.getNombre().isBlank() &&
               cultivo.getTipo() != null && !cultivo.getTipo().isBlank() &&
               cultivo.getAreaSembrada() > 0 &&
               cultivo.getEstadoCrecimiento() != null && !cultivo.getEstadoCrecimiento().isBlank() &&
               cultivo.getFechaSiembra() != null;
    }
}