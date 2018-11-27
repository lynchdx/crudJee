<%-- 
    Document   : modificar
    Created on : 26-11-2018, 0:14:41
    Author     : Lynch
--%>

<%@page import="controller.ControllerProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="js/paneladministracion.js"></script>
        <title>JSP Page</title>
    </head>
    <body bgproperties="fixed" background="http://botargasmaximo.com/wp-content/uploads/2016/09/backgrounds-minimalistas-abstractos-fondos-3d-wallpapers-3d.jpg">
        <h1>Modificar Producto</h1>
        
        <% ControllerProducto cp = new ControllerProducto(); 
            int idProducto = Integer.parseInt(request.getParameter("id"));
        %>
        <%= cp.traerVistaModificarProductoController(idProducto)%>
        
    </body>
</html>
