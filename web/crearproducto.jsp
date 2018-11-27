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
    <script type="text/javascript" src="js/main.js"></script>
        <title>JSP Page</title>
    </head>
    <body bgproperties="fixed" background="http://botargasmaximo.com/wp-content/uploads/2016/09/backgrounds-minimalistas-abstractos-fondos-3d-wallpapers-3d.jpg">
        <h1>Nuevo Producto</h1>

        <!--crearproducto es el nombre cambiado del contextpatch der productoServlet.java--> 
        <form action="crearproducto" enctype="multipart/form-data" method="post" name="formcrear" id="form_crear">

            <!--tr = fila   td = columna-->

            <table class="table">
                <div class="form-group">
                <tr>
                    <td><label for="">Nombre:</label></td>
                    <td><input class="form-control" type="text" name="txt_nombre" id="txt_nombre"></td>
                </tr>
                <tr>
                    <td><label for="">Descripción:</label></td>
                    <td><textarea class="form-control"  col="30" rows="6" name="txa_descripcion" id="txa_descripcion"></textarea></td>
                </tr>
                <tr>
                    <td><label for="">Precio:</label></td>
                    <td><input  class="form-control" type="text" name="txt_precio" id="txt_precio"></td>
                </tr>
                <tr>
                    <td><label for="">Categoría:</label></td>
                    <td><input class="form-control" type="text" name="categoria" id="txt_categoria"></td>
                </tr>
                <tr>
                    <td><label for="">Detalles:</label></td>
                    <td><textarea class="form-control" col="30" rows="6" name="txa_detalle" id="txa_detalle"></textarea></td>
                </tr>
                <tr>
                    <td><label for="">Reviews:</label></td>
                    <td><textarea class="form-control" col="30" rows="6" name="txa_reviews" id="txa_reviews"></textarea></td>
                </tr>

                <!--Carga un cbo con 20 índices-->
                <tr>
                    <td><label for="">Size:</label></td>
                    <td>
                        <select class="form-control"  name="cbo_size" id="cbo_size">
                            <option Value="Seleccione un número">Selccione un número</option>
                            <%for (int i = 1; i < 21; i++) {%>
                            <option value="<%= i%>"><%= i%></option>
                            <%}%>
                        </select>

                    </td>
                </tr>

                <tr>
                    <td><label for="">Color:</label></td>
                    <td><input class="form-control" type="text" name="txt_color" id="txt_color"></td>
                </tr>

                <tr>
                    <td><label for="">Imágenes:</label></td>
                    <td><input class="form-control" type="file" name="name[]" id="file_archivo" multiple></td>
                    <td><input type="submit" class="btn btn-success" value="Crear Producto" id="btn_crear_producto"></td>
                </tr>

                </div>
            </table>
                                
        </form> 

    </body>
</html>
