/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.UsuarioDAO;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author AsusVivobook
 */
public class UsuarioService {
    private final UsuarioDAO dao;
    private final UsuarioValidator validator = new UsuarioValidator();

    public UsuarioService(UsuarioDAO dao) {
        this.dao = dao;
    }

    public UsuarioDTO registrar(UsuarioDTO dto) {
        validator.validarRegistro(dto);
        if (dao.existeUsername(dto.getUsername())) {
            throw new DuplicadoException("El nombre de usuario ya está registrado.");
        }
        Usuario u = UsuarioMapper.toEntity(dto);
        u.setPasswordHash(PasswordHasher.hash(dto.getPassword()));
        u.setActivo(true);
        dao.agregar(u);
        return UsuarioMapper.toDTO(u);
    }

    public List<UsuarioDTO> listar() {
        return dao.listar().stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
    }
}
