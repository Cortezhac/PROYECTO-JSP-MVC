<%-- 
    Document   : delete
    Created on : 28-may-2020, 18:15:43
    Author     : Admin
--%>

<%@page import="modelDAO.VideojuegoDAO"%>
<%@page import="model.Videojuego"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Recursos/css/Main.css">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Videojuego DeleteGame;
            VideojuegoDAO utilidades = new VideojuegoDAO();
            int id_videojuego = Integer.parseInt((String)request.getParameter("id"));
            DeleteGame = new Videojuego(utilidades.list(id_videojuego));
        %>
        <div class="container">
            <h1>Esta seguro que desea eliminar este registro?</h1>
            <div>
                <h3>Nombre juego <span><%=DeleteGame.getNomb_videojuego()%></span></h3>
                <h3>Desarrolladora <span><%=DeleteGame.getCompania_videojuego()%></span></h3>
                <h3>Tipo de juego <span><%=DeleteGame.getTipo_videojuego()%></span></h3>
            </div>
            <div>
                <a href="Controlador?accion=delete&id=<%=DeleteGame.getId_videojuego()%>">Elminar</a>
            </div>
        </div>
    </body>
</html>
