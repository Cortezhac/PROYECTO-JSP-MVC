/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Videojuego;
import modelDAO.VideojuegoDAO;

/**
 *
 * @author Admin
 */
public class Controlador extends HttpServlet {

    // Rutas de las vistas
    String list = "vistas/list.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    String remove = "vistas/delete.jsp";
    Videojuego Vjuego = new Videojuego(); // obj videojuego
    VideojuegoDAO VjuegoDAO = new VideojuegoDAO(); // DAO funciones del CRUD
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        //Contiene la accion a ejecutar de la paguina
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("list")) {
            acceso=list; // Path de acceso
        }else if(action.equalsIgnoreCase("add")){
            acceso = add;
        }else if(action.equalsIgnoreCase("Agregar")){
            String nom_juego = request.getParameter("txtNombre");
            String compania_juego = request.getParameter("txtCompania");
            String tipo_juego = request.getParameter("txtTipo");
            Vjuego.setNomb_videojuego(nom_juego);
            Vjuego.setCompania_videojuego(compania_juego);
            Vjuego.setTipo_videojuego(tipo_juego);
            VjuegoDAO.add(Vjuego);
            acceso=list; // Cambiando path de acceso 
        }else if(action.equalsIgnoreCase("edit")){
            // crear parametro idJuego a partir del id de la tablaa que es enviado por la URI
            request.setAttribute("idJuego", request.getParameter("id"));
            acceso=edit; // path de la vista editar
        }else if(action.equalsIgnoreCase("actualizar")){
            String id = request.getParameter("id");
            String nombrejuego = request.getParameter("txtNombre");
            String tipojuego = request.getParameter("txtTipoJuego");
            String companiajuego = request.getParameter("txtCompania");
            // Llenar objeto
            Vjuego.setId_videojuego(Integer.parseInt(id));
            Vjuego.setNomb_videojuego(nombrejuego);
            Vjuego.setCompania_videojuego(companiajuego);
            Vjuego.setTipo_videojuego(tipojuego);
            VjuegoDAO.edit(Vjuego);
            acceso = list; // Cambiar direccion
        }else if(action.equalsIgnoreCase("remove")){
            request.setAttribute("iddelete", request.getParameter("id"));
            acceso=remove; // cambiando direccion
        }else if(action.equalsIgnoreCase("delete")){
            int idRemove = Integer.parseInt((String)request.getParameter("id"));
            VjuegoDAO.delete(idRemove);
            acceso = list;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
