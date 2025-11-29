/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.TrabajadorDAO;
import Modelo.TrabajadorDTO;
import Mapper.TrabajadorMapper;
import Modelo.Trabajador;
import Validaciones.TrabajadorValidacion;

/**
 *
 * @author AsusVivobook
 */
public class TrabajadorServicios {
    private final TrabajadorDAO dao;
    private final TrabajadorValidacion validator = new TrabajadorValidacion();

    public TrabajadorServicios(TrabajadorDAO dao) {
        this.dao = dao;
    }

    public TrabajadorDTO registrar(TrabajadorDTO dto) {
        validator.validarRegistro(dto);

        // Se puede verificar duplicados con el DAO
        // if (dao.existeCedula(dto.getCedula())) {
        //     throw new TrabajadorDuplicadoException("La cédula ya está registrada.");
        // }
        Trabajador t = TrabajadorMapper.toEntity(dto);
        dao.agregar(t);
        return TrabajadorMapper.toDTO(t);
    }

}
