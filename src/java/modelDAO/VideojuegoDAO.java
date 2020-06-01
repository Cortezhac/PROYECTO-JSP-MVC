/*
 * Contiene todas las funciones del CRUD dejandolas disponibles para los otros  objetos
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
    Connection cone; // obj de mysql.jdbc.Driver guarda la conexion
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
            System.out.println("Error xVDAO01 :" + ex);
        }
        return ListaVideojuegos;
    }

    @Override
    public Videojuego list(int id_videojuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Videojuego videojuego) {
        String sqlQuery = "INSERT INTO videojuego (nom_videojuego, tipo_videojuego, compania_videojuego) VALUES "
                + "('"+ videojuego.getNomb_videojuego() +"','"+ videojuego.getTipo_videojuego() + "','"+videojuego.getCompania_videojuego()+"');";
        try {
            cone = cn.getConnection();// Obtiene la conexion y la almacena
            sqlStatement = cone.prepareStatement(sqlQuery); // se prara el query 
            sqlStatement.executeUpdate(); // Ejecuta el queryalmacenado
            return true;
        } catch (SQLException e) {
            System.out.println("Error xVDAO02 :" + e);
        }
        return false;
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
