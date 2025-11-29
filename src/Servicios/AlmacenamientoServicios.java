/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.AlmacenamientoDAO;
import Modelo.AlmacenamientoDTO;
import Mapper.AlmacenamientoMapper;
import Modelo.Almacenamiento;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author AsusVivobook
 */
public class AlmacenamientoServicios {
    private final AlmacenamientoDAO dao;

    public AlmacenamientoServicios(AlmacenamientoDAO dao) {
        this.dao = dao;
    }

    public AlmacenamientoDTO registrar(AlmacenamientoDTO dto) {
        Almacenamiento a = AlmacenamientoMapper.toEntity(dto);
        dao.agregar(a);
        return AlmacenamientoMapper.toDTO(a);
    }

    public List<AlmacenamientoDTO> listar() {
        return dao.listar()
                .stream()
                .map(AlmacenamientoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
