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
            System.out.println("Error x001 " + this.getClass() + " "+ ex);
        }
        return ListaVideojuegos;
    }

    @Override
    public Videojuego list(int id_videojuego) {
        String sqlQuery = "SELECT * FROM videojuego WHERE id_videojuego = " + id_videojuego + ";";
        try {
            cone = cn.getConnection();
            sqlStatement = cone.prepareStatement(sqlQuery);
            miResultSet = sqlStatement.executeQuery(sqlQuery); // devuelve un obj de tipo ResulSet
            while (miResultSet.next()) {
                Juego.setId_videojuego(miResultSet.getInt("id_videojuego"));
                Juego.setNomb_videojuego(miResultSet.getString("nom_videojuego"));
                Juego.setTipo_videojuego(miResultSet.getString("tipo_videojuego"));
                Juego.setCompania_videojuego(miResultSet.getString("compania_videojuego"));
            }
        } catch (SQLException e) {
            System.out.println("Error x002 " + this.getClass() + " "+ e);
        }
        return Juego;
    }

    @Override
    public boolean add(Videojuego videojuego) {
        String sqlQuery = "INSERT INTO videojuego (nom_videojuego, tipo_videojuego, compania_videojuego) VALUES "
                + "('"+ videojuego.getNomb_videojuego() +"','"+ videojuego.getTipo_videojuego() + "','"+videojuego.getCompania_videojuego()+"');";
        try {
            cone = cn.getConnection();// Obtiene la conexion y la almacena
            sqlStatement = cone.prepareStatement(sqlQuery); // se prara el query 
            sqlStatement.executeUpdate(); // Ejecuta el queryalmacenado y retorna un entero
            return true;
        } catch (SQLException e) {
            System.out.println("Error x003 " + this.getClass() + " "+ e);
        }
        return false;
    }

    @Override
    public boolean edit(Videojuego videojuego) {
        String sqlQuery = "UPDATE videojuego SET nom_videojuego = '" + videojuego.getNomb_videojuego() + "', compania_videojuego = '"+
            videojuego.getCompania_videojuego() + "', tipo_videojuego = '"+ videojuego.getTipo_videojuego()+ "' WHERE id_videojuego=" + videojuego.getId_videojuego() + ";";
        try {
            cone = cn.getConnection();
            sqlStatement = cone.prepareStatement(sqlQuery);
            sqlStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error x004 " + this.getClass() + " " + e);
        }
        return false;
    }

    @Override
    public boolean delete(int id_videojuego) {
        String sqlQuey = "DELETE FROM videojuego WHERE id_videojuego = " + id_videojuego + ";";
        try {
            cone = cn.getConnection();
            sqlStatement = cone.prepareStatement(sqlQuey);
            sqlStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error x 005 " + this.getClass() + " " + e);
        }
        return false;
    }
    
}
