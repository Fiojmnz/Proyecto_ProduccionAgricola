/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.Usuario;
import Mapper.UsuarioMapper;
import Validaciones.UsuarioValidacion;
import Validaciones.EncriptadorContrasena;
import Excepciones.DuplicadoExcepcion;
import java.sql.SQLException;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author AsusVivobook
 */
public class UsuarioServicios {
    private final UsuarioDAO dao;
    private final UsuarioValidacion validacion = new UsuarioValidacion();

    public UsuarioServicios(UsuarioDAO dao) {
        this.dao = dao;
    }

   public UsuarioDTO registrar(UsuarioDTO dto) {
        validacion.validarRegistro(dto);
        if (dao.existeUsername(dto.getUsername())) {
            throw new DuplicadoExcepcion("El nombre de usuario ya está registrado");
        }
        Usuario u = UsuarioMapper.toEntity(dto);
        u.setPasswordHash(EncriptadorContrasena.hash(dto.getPassword()));
        u.setActivo(true);
        
        try {
            dao.agregar(u);
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el usuario en la base de datos", e);
        }
        
        return UsuarioMapper.toDTO(u);
    }
    public boolean existeUsername(String username) {
    return dao.existeUsername(username);
}
public UsuarioDTO buscarPorUsername(String username) {
    Usuario u = dao.buscarPorUsername(username);
    return u != null ? UsuarioMapper.toDTO(u) : null;
}
public boolean eliminar(String username) {
    return dao.eliminar(username);
}


   public List<UsuarioDTO> listar() throws SQLException {
    return dao.listarDTO(); 
}
}
