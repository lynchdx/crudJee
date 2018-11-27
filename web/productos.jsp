<%-- 
    Document   : productos
    Created on : 25-11-2018, 15:56:33
    Author     : Lynch
--%>

<%@page import="controller.ControllerProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body background="http://botargasmaximo.com/wp-content/uploads/2016/09/backgrounds-minimalistas-abstractos-fondos-3d-wallpapers-3d.jpg" bgproperties="fixed">
        
        <a href="crearproducto.jsp" class="btn btn-primary">Crear Producto</a>
        <a href="administracion.jsp" class="btn btn-info">Panel de administración</a>
        
        
        <%
        ControllerProducto cp = new ControllerProducto();
        %>
        <%=cp.listarProductosController()%>
        
        
    </body>
</html>
