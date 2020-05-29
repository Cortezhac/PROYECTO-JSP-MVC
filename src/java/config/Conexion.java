/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class Conexion {
    private final String SERVER = "jdbc:mysql://localhost:3306/bd_videojuegos";
    private final String USER = "root";
    private final String CLAVE = "";
    private final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    Connection con;
    
    public Conexion(){
        try {
            Class.forName(DRIVER_MYSQL);
            con = DriverManager.getConnection(SERVER, USER, CLAVE);
        } catch ( SQLException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
}
