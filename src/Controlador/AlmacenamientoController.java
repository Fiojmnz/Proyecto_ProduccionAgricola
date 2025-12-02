/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.AlmacenamientoDAO;
import Modelo.AlmacenamientoDTO;
import Servicios.AlmacenamientoServicios;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;



/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoController {
    private final AlmacenamientoServicios service;

    public AlmacenamientoController(Connection conn) {
        this.service = new AlmacenamientoServicios(new AlmacenamientoDAO(conn));
    }

    public AlmacenamientoDTO registrarIngreso(String producto, double cantidad, LocalDate ingreso) {
        AlmacenamientoDTO dto = new AlmacenamientoDTO();
        dto.setProducto(producto);
        dto.setCantidad(cantidad);
        dto.setFechaIngreso(ingreso);
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
}
