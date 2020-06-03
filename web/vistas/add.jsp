<%-- 
    Document   : add
    Created on : 30-may-2020, 17:06:25
    Author     : Admin
--%>

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
            <h1>Agregar persona</h1>
            <form action="Controlador">
                <label for="txtNombre">Nombre Juego</label>
                <input type="text" maxlength="30" name="txtNombre" placeholder="X juego">
                <label for="txtCompania">Desarrolladora</label>
                <input type="text" maxlength="30" name="txtCompania" placeholder="xxxcreadora">
                <label for="txtTipo">Tipo juego</label>
                <input type="text" maxlength="30" name="txtTipo" placeholder="FPS,aventura etc">
                <input type="submit" name="accion" value="Agregar">
            </form>
        </div>
            
    </body>
</html>
