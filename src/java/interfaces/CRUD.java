/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Videojuego;

/**
 *
 * @author Admin
 */
public interface CRUD {
    public List listar();
    public Videojuego list(int id_videojuego);
    public boolean add(Videojuego videojuego);
    public boolean edit(Videojuego videojuego);
    public boolean delete(int id_videojuego);
    
}
