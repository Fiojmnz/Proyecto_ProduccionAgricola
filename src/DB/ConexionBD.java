/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AsusVivobook
 */
public class ConexionBD {
    private static  ConexionBD instancia;
    private Connection conexion;
    
   private final String url = "jdbc:mariadb://localhost:3306/produccion_agricola";
   private final String user = "root";
   private final String password = "Root123@";
   
   
   private ConexionBD() { 
        try {
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar BD: " + e.getMessage(), e);
        }
    }
    public static synchronized ConexionBD getInstancia() {
        if (instancia == null) instancia = new ConexionBD();
        return instancia;
    }
    public Connection getConexion() { return conexion; }
}