/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.TrabajadorDAO;
import Modelo.TrabajadorDTO;
import Mapper.TrabajadorMapper;
import Modelo.Trabajador;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author AsusVivobook
 */
public class TrabajadorServicios {
    private final TrabajadorDAO dao;

    public TrabajadorServicios(TrabajadorDAO dao) {
        this.dao = dao;
    }

    public TrabajadorDTO registrar(TrabajadorDTO dto) {
        Trabajador t = TrabajadorMapper.toEntity(dto);
        dao.agregar(t);
        return TrabajadorMapper.toDTO(t);
    }

    public List<TrabajadorDTO> listar(String filtroPuesto) {
        return dao.listar(filtroPuesto)
                .stream()
                .map(TrabajadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean actualizar(TrabajadorDTO dto) {
        Trabajador t = TrabajadorMapper.toEntity(dto);
        return dao.actualizar(t);
    }

    public boolean eliminar(String cedula) {
        return dao.eliminar(cedula);
    }
}
