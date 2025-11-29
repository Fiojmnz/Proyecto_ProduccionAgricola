/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AlmacenamientoDTO;
import Servicios.AlmacenamientoServicios;
import DAO.AlmacenamientoDAO;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoController {
    private final AlmacenamientoServicios service;

    //Recibe la conexión y arma el servicio con el DAO
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
}

