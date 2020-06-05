<%-- 
    Document   : edit
    Created on : 28-may-2020, 18:15:32
    Author     : Admin
--%>

<%@page import="model.Videojuego"%>
<%@page import="modelDAO.VideojuegoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Recursos/css/Main.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Editar</h1>
            <% 
               VideojuegoDAO utilidadesDAO = new VideojuegoDAO();
               int id = Integer.parseInt((String)request.getParameter("id"));
               Videojuego EditGame = new Videojuego(utilidadesDAO.list(id));
            %>
            <form action="Controlador">
                <input type="hidden" name="id" id="id" value="<%=EditGame.getId_videojuego()%>">
                <label for="txtNombre">Nombre videojuego</label>
                <input type="text" name="txtNombre" id="nombre" placeholder="<%=EditGame.getNomb_videojuego()%>">
                <label for="txtTipoJuego">Tipo de juego</label>
                <input tyoe="text" name="txtTipoJuego" id="tipo" placeholder="<%=EditGame.getTipo_videojuego()%>">
                <label for="txtCompania">Desarrolladora</label>
                <input type="text" name="txtCompania" id="compania" placeholder="<%=EditGame.getCompania_videojuego()%>">
                <input type="submit" onmouseenter="defecto();" name="accion" value="actualizar">
            </form>
        </div>
            <script src="Recursos/js/validadcion.js"></script>
    </body>
</html>
