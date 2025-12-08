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

public class ConnectionFactory {
   private static final String URL = "jdbc:mysql://localhost:3306/Proyecto_ProduccionAgricola";
    private static final String USER = "root";
    private static final String PASS = "Root123@";

    private static ConnectionFactory instancia;

    public  ConnectionFactory() {
    }
    
     public static synchronized ConnectionFactory getInstancia() {
        if (instancia == null) {
            instancia = new ConnectionFactory();
        }
        return instancia;
    }

   public Connection getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } 
    catch (ClassNotFoundException e)
    {
        System.out.println("Driver MySQL no encontrado: " + e.getMessage());
    }
    
    return DriverManager.getConnection(URL, USER, PASS);
}
}