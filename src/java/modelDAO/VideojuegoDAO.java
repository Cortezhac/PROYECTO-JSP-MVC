/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import config.Conexion;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.resource.spi.Connector;
import model.Videojuego;

/**
 *
 * @author Admin
 */
public class VideojuegoDAO implements CRUD{
    
    Conexion cn = new Conexion(); // Proporciona la conexion con el servidor
    Connection cone; // obj de mysql.jdbc.Driver
    PreparedStatement sqlStatement; // PrepareStatement para el  sqlQuery
    ResultSet miResultSet; // Pemite manejar los datos de la BD
    Videojuego Juego = new Videojuego(); // obj videojuego
    
    @Override
    public List listar() {
        ArrayList<Videojuego> ListaVideojuegos =  new ArrayList<>();
        String sqlQueryStatement = "SELECT * FROM videojuego";
        try {
            cone = cn.getConnection();
            sqlStatement = cone.prepareStatement(sqlQueryStatement);
            miResultSet = sqlStatement.executeQuery();
            while (miResultSet.next()) {
                Videojuego Juegos = new Videojuego();
                Juegos.setId_videojuego(miResultSet.getInt("id_videojuego"));
                Juegos.setNomb_videojuego(miResultSet.getNString("nom_videojuego"));
                Juegos.setTipo_videojuego(miResultSet.getString("tipo_videojuego"));
                Juegos.setCompania_videojuego(miResultSet.getString("compania_videojuego"));
                ListaVideojuegos.add(Juegos);
            }
        } catch (SQLException ex) {
            System.out.println("Error x01 " + ex);
        }
        return ListaVideojuegos;
    }

    @Override
    public Videojuego list(int id_videojuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Videojuego videojuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Videojuego videojuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id_videojuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
