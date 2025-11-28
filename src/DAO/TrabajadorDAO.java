    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Trabajador;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author AsusVivobook
 */
public class TrabajadorDAO {
    
    // Método para insertar un trabajador
    public boolean insertar(Trabajador t) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean resultado = false;
        
        try {
            con = ConexionBD.getConnection();
            String sql = "INSERT INTO trabajadores (cedula, nombre, telefono, correo, puesto, horario, salario) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getCedula());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getTelefono());
            ps.setString(4, t.getCorreo());
            ps.setString(5, t.getPuesto());
            ps.setString(6, t.getHorario());
            ps.setDouble(7, t.getSalario());
            
            resultado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar trabajador: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return resultado;
    }
}
