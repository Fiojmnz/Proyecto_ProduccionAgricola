/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.TrabajadorDAO;
import DB.ConnectionFactory;
import Mapper.TrabajadorMapper;
import Modelo.Trabajador;
import Modelo.TrabajadorDTO;
import Servicios.TrabajadorServicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class TrabajadorController {
    private final TrabajadorServicios service;

    public TrabajadorController() throws SQLException {
        Connection conn = ConnectionFactory.getInstancia().getConnection();
        this.service = new TrabajadorServicios(new TrabajadorDAO(conn));
    }
public boolean registrarTrabajador(TrabajadorDTO dto) {
        try {
            TrabajadorDTO resultado = service.registrar(dto);
            return resultado != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<TrabajadorDTO> listarTrabajadores(String filtroPuesto) {
        return service.listar(filtroPuesto);
    }

    public boolean actualizarTrabajador(TrabajadorDTO dto) {
        return service.actualizar(dto);
    }

    public boolean eliminarTrabajador(String cedula) {
        return service.eliminar(cedula);
    }

}