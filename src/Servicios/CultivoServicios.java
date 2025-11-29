/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.CultivoDAO;
import Mapper.CultivoMapper;
import Modelo.Cultivo;
import Modelo.CultivoDTO;
import Validaciones.CultivoValidacion;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gipsy
 */
public class CultivoServicios {

    private final CultivoDAO dao;
    private final CultivoValidacion validator = new CultivoValidacion();

    public CultivoServicios(CultivoDAO dao) 
    {   this.dao = dao; }

    public CultivoDTO crear(CultivoDTO dto) {
        validator.validarCrear(dto);
        Cultivo c = CultivoMapper.toEntity(dto);
        dao.agregar(c);
        return CultivoMapper.toDTO(c);
    }

    public List<CultivoDTO> listar(String filtroNombre) {
        return dao.listar(filtroNombre).stream().map(CultivoMapper::toDTO).collect(Collectors.toList());
    }

    public boolean actualizar(CultivoDTO dto) {
        validator.validarCrear(dto);
        return dao.actualizar(CultivoMapper.toEntity(dto));
    }

    public boolean eliminar(int id) {
        return dao.eliminar(id);
    }
}
    



