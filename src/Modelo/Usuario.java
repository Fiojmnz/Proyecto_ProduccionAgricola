/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Enum.Rol;

/**
 *
 * @author AsusVivobook
 */
public class Usuario {
    private Long id;
    private String username;
    private String encriptadorContrasena;
    private Rol rol;
    private boolean activo;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return encriptadorContrasena;
    }

    public String getEncriptadorContraseña() {
        return encriptadorContrasena;
    }

   

    public Rol getRol() {
        return rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.encriptadorContrasena = passwordHash;
    }

    public void setEncriptadorContraseña(String encriptadorContraseña) {
        this.encriptadorContrasena = encriptadorContraseña;
    }

    

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
