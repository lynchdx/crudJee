<%-- 
    Document   : administracion
    Created on : 25-11-2018, 22:19:29
    Author     : Lynch
--%>

<%@page import="controller.ControllerProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <script src="https://code.jquery.com/jquery-3.3.1.min.js"
         integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="js/paneladministracion.js"></script>       
 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="http://botargasmaximo.com/wp-content/uploads/2016/09/backgrounds-minimalistas-abstractos-fondos-3d-wallpapers-3d.jpg" bgproperties="fixed">
        <h1>Panel de Administración</h1>
        <% ControllerProducto cp = new ControllerProducto();%>
        <%=cp.traerVistaPanelController()%>
    </body>
</html>
