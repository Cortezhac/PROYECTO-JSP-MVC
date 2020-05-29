<%-- 
    Document   : list
    Created on : 28-may-2020, 18:15:20
    Author     : Admin
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelDAO.VideojuegoDAO"%>
<%@page import="model.Videojuego"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Listar Personas</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>TIPO</th>
                        <th>DESARROLLADORA</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                    VideojuegoDAO game = new VideojuegoDAO();
                    List<Videojuego> list = game.listar();// Traigo la lista de la bd
                    Iterator<Videojuego> iterador = list.iterator();
                    Videojuego juego = null;
                    while(iterador.hasNext()){
                        juego = iterador.next();
                    %>
                    <tr>
                        <td><%= juego.getId_videojuego() %></td>
                        <td><%= juego.getNomb_videojuego() %></td>
                        <td><%= juego.getTipo_videojuego() %></td>
                        <td><%= juego.getCompania_videojuego() %></td>
                        <td>EDIT REMOVE</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

        </div>
    </body>
</html>
