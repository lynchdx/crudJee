package controller;

import include.Producto;
import java.util.ArrayList;
import modelo.ModeloProducto;

public class ControllerProducto {

//----------------------------------------Método crer producto llamado del modelo-----------------------    
    
    
    //Llama al crearProducto en ModeloProducto, pasándole un objeto producto.
    public boolean crearProductoController(Producto p) {
        ModeloProducto mp = new ModeloProducto();
        return mp.crearProductoModelo(p);
    }
    
//----------------Método listar todos los productos (llamado del modelo con html incluido --------------  
//eh el link <a = href> envía a detalles.jsp> pasándoselo el id por variable ?
    //Llama al método getAllProductos del modelo. y lo mete dentro de código html
    public String listarProductosController() {
        String htmlcode = "";
        ModeloProducto mp = new ModeloProducto();
        int i= 0;
        for (Producto p : mp.getAllProductosModelo()) {
     
            htmlcode += "<div class=\"row col-lg-6 text-center\"><a href=\'detalles.jsp?idProducto="+p.getId()+"'>\n"+
"  <div class=\"col-sm-6 col-md-4 text-center\">\n" +
"    <div class=\"thumbnail\">\n" +
"      <img src="+p.getImg1()+" class=\"img-thumbnail rounded\" alt=\"\">\n" +
"      <div class=\"caption\">\n" +
"        <h3>"+p.getNombre()+"</h3>\n" +
"        <label>Precio: $</label><label>"+p.getPrecio()+"</label></a>\n" +
"        <p>"+p.getDescripcion()+"</p>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>"; 
        }
        return htmlcode;
    }
    
    
  //------------------------------------------------Listar Detalle Producto------------------------  
    public String listarDetalleProductoController(int id){
    Producto pr = new ModeloProducto().getProductoModelo(id);
        
        String code = 
"<div>\n" +
"<h1 class=\"display-3\">Detalles de Producto</h1>\n" +
"<table class=\"table\">\n" +
"  <tr>\n" +
"    <th scope=\"col\">Nombre</th>\n" +
"    <th scope=\"col\">"+pr.getNombre()+"</th>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <th scope=\"col\">Descripcion</th>\n" +
"    <th scope=\"col\">"+pr.getDescripcion()+"</th>\n" +
"  </tr> \n" +
"  <tr>\n" +
"    <th scope=\"col\">Precio</th>\n" +
"    <th scope=\"col\">$ "+pr.getPrecio()+"</th>\n" +
"  </tr> \n" +
"  <tr>\n" +
"    <th scope=\"col\">Categoría</th>\n" +
"    <th scope=\"col\">"+pr.getCategoria()+"</th>\n" +
"  </tr> \n" +
"  <tr>\n" +
"    <th scope=\"col\">Detalles</th>\n" +
"    <th scope=\"col\">"+pr.getDetalle()+"</th>\n" +
"  </tr> \n" +
"  <tr>\n" +
"    <th scope=\"col\">Reviews</th>\n" +
"    <th scope=\"col\">"+pr.getReviews()+"</th>\n" +
"  </tr> \n" +
"  <tr>\n" +
"    <th scope=\"col\">Tamaño</th>\n" +
"    <th scope=\"col\">"+pr.getSize()+"</th>\n" +
"  </tr> \n" +
"  <tr>\n" +
"    <th scope=\"col\">Color</th>\n" +
"    <th scope=\"col\">"+pr.getColor()+"</th>\n" +
"  </tr> \n" +
"</table>\n" +
"</div>\n" +
"\n" +
"\n" +
"<div>\n" +
"<table class=\"table\">\n" +
"  <th><img src="+pr.getImg1()+" class=\"img-thumbnail rounded\" alt=\"\"></th><th><img src="+pr.getImg2()+" class=\"img-thumbnail rounded\" alt=\"\"></th><th><img src="+pr.getImg3()+" class=\"img-thumbnail rounded\" alt=\"\"></th><th><img src="+pr.getImg4()+" class=\"img-thumbnail rounded\" alt=\"\"></th><th><img src="+pr.getImg5()+" class=\"img-thumbnail rounded\" alt=\"\"></th>\n" +
"</table>\n" +
"</div>";
    
    
    
            return code;
    
    }
    
    
    
/*------------------------------Cargar hrml de Lista producto por ID-----------------------------------*/    
//Se cargará en administración jsp
    public String traerVistaPanelController(){
        String htmlcore ="";
        ModeloProducto mp = new ModeloProducto();
        ArrayList<Producto> productos = mp.getAllProductosModelo(); //carga todos los productos
        
        htmlcore += "<table class=\"table\" >\n" +
"            <tr>\n" +
"                <th>ID</th>\n" +
"                <th>Nombre</th>\n" +
"                <th>Precio</th>\n" +
"                <th>Categoría</th>\n" +
"                <th>Acciones</th>\n" +
"            </tr>\n";
        
        for(Producto p : productos){
        
       htmlcore += "<tr>\n" +
"                <td id='id_producto'>"+p.getId()+"</td>\n" +
"                <td>"+p.getNombre()+"</td>\n" +
"                <td>"+p.getPrecio()+"</td>\n" +
"                <td>"+p.getCategoria()+"</thd>\n" +
"                <td><a class=\"text-warning\" id='btn-modificar' href='modificar.jsp?id="+p.getId()+"'>Modificar</a> &nbsp;&nbsp;&nbsp;&nbsp;<a id='btn-eliminar' class=\"text-danger\" href=\"\">Eliminar</a></td>\n" +
"            </tr>\n"; 
            
        }
        
        htmlcore += "</table>";
        return htmlcore;
    }
    
    
//--------------------Método que borra producto por ID--------------------------
    //se llama del modelo
    public boolean deleteProductoController(int id){
    ModeloProducto mp = new ModeloProducto();
    return mp.borrarProductoModelo(id);
    }

    
    
    //no hay action, xq se modificará con ajax, tampoco el método, ni enctype.
//--------Cargar HTML Modificar Producto---------------------
public String traerVistaModificarProductoController(int idProducto){
    
    ModeloProducto mp = new ModeloProducto();
    Producto p = mp.getProductoModelo(idProducto);
    String code = ""; 
     code += "<form name=\"formmodificar\" id=\"form_modificar\">\n" +
"\n" +
"            <table>\n" +
"             <tr>\n" +
"                    <td><input type=\"hidden\" name=\"idproducto\" value='"+p.getId()+"' ></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><label for=\"\">Nombre:</label></td>\n" +
"                    <td><input type=\"text\" name=\"txt_nombre\" id=\"txt_nombre\" value='"+p.getNombre()+"'></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><label for=\"\">Descripción:</label></td>\n" +
"                    <td><textarea col=\"30\" rows=\"6\" name=\"txa_descripcion\" id=\"txa_descripcion\">"+p.getDescripcion()+"</textarea></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><label for=\"\">Precio:</label></td>\n" +
"                    <td><input type=\"text\" name=\"txt_precio\" id=\"txt_precio\" value='"+p.getPrecio()+"'></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><label for=\"\">Categoría:</label></td>\n" +
"                    <td><input type=\"text\" name=\"categoria\" id=\"txt_categoria\" value='"+p.getCategoria()+"'></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><label for=\"\">Detalles:</label></td>\n" +
"                    <td><textarea col=\"30\" rows=\"6\" name=\"txa_detalle\" id=\"txa_detalle\">"+p.getDetalle()+"</textarea></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><label for=\"\">Reviews</label></td>\n" +
"                    <td><textarea col=\"30\" rows=\"6\" name=\"txa_reviews\" id=\"txa_reviews\">"+p.getReviews()+"</textarea></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td></td>\n" +
"                    <td><input type=\"submit\" value=\"Modificar Producto\" id=\"btn_modificar_producto\"></td>\n" +
"                </tr>\n" +
"\n" +
"            </table>\n" +
"\n" +
"\n" +
"\n" +
"        </form> ";
    
    return code;
}    
    

//---------UpdateProducto del modelo--------------------------------------------
public boolean updateProductoController(Producto p){
    ModeloProducto mp = new ModeloProducto();
    return mp.modificarProductoModelo(p);
    
}


}
