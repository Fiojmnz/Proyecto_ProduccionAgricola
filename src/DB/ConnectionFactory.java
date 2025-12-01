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
    private static final String URL = "jdbc:mariadb://localhost:3306/Proyecto_ProduccionAgricola";
    private static final String USER = "root";
    private static final String PASS = "Root123@";

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}