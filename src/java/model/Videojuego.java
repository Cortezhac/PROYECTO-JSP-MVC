/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Videojuego {
    private int id_videojuego;
    private String nomb_videojuego;
    private String tipo_videojuego;
    private String compania_videojuego;
    
    public Videojuego(){
        
    }
    
    public Videojuego(Videojuego juego){
        this.id_videojuego = juego.getId_videojuego();
        this.nomb_videojuego = juego.getNomb_videojuego();
        this.tipo_videojuego = juego.getTipo_videojuego();
        this.compania_videojuego = juego.getCompania_videojuego();
    }
    
    public Videojuego( int id,String nombreVideojuego, String tipoVideojuego, String companiaVideojuego){
        this.id_videojuego = id;
        this.nomb_videojuego = nombreVideojuego;
        this.tipo_videojuego = tipoVideojuego;
        this.compania_videojuego = companiaVideojuego;
    }
    
    public int getId_videojuego() {
        return id_videojuego;
    }

    public void setId_videojuego(int id_videojuego) {
        this.id_videojuego = id_videojuego;
    }

    public String getNomb_videojuego() {
        return nomb_videojuego;
    }

    public void setNomb_videojuego(String nomb_videojuego) {
        this.nomb_videojuego = nomb_videojuego;
    }

    public String getTipo_videojuego() {
        return tipo_videojuego;
    }

    public void setTipo_videojuego(String tipo_videojuego) {
        this.tipo_videojuego = tipo_videojuego;
    }

    public String getCompania_videojuego() {
        return compania_videojuego;
    }

    public void setCompania_videojuego(String compania_videojuego) {
        this.compania_videojuego = compania_videojuego;
    }
    
}
