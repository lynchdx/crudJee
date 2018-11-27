 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.ControllerProducto;
import include.Producto;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Lynch
 */
public class ProductoServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        //objeto para usar librerías para subir imáganes (librerías en carpeta)
        FileItemFactory file_factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(file_factory);
        
        //Array para guardar variables del jsp.
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> imagenes = new ArrayList<>();
        
        //hace un try
        try {
            List items = sfu.parseRequest(request);//Por request se capturan los datos del jsp
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                if (!item.isFormField()) { //si no son tipo campo formulario (imágenes)
                    File archivo = new File("C:\\Users\\Lynch\\Documents\\NetBeansProjects\\crudProductos\\web\\img\\productos\\"+item.getName());
                    item.write(archivo);
                    
                    //agrega las imagenes del constructor de abajo a la bd
                    imagenes.add("img/productos/"+item.getName());
                }else{
                campos.add(item.getString());//ingresa los datos del contrusctor de abajo
                }
            }
            
        } catch (Exception e) {  
        }
        
  //Obtiene los campos del formulario por posición, el primer 0 es el id, el campos.get(0) 0= primer campo del form
        Producto p = new Producto(0, campos.get(0), campos.get(1), Integer.parseInt(campos.get(2)), 
                campos.get(3), campos.get(4),campos.get(5), Integer.parseInt(campos.get(6)),
                campos.get(7), imagenes.get(0), imagenes.get(1),imagenes.get(2),
                imagenes.get(3), imagenes.get(4));
        ControllerProducto cp = new ControllerProducto();
        
        //muestra en el jsp true o flase de crearProducto.
        //response.getWriter().print(cp.crearProductoController(p));
        
        if (cp.crearProductoController(p)) { //devuelve un true o flase
            response.getWriter().println("Producto Agregado exitósamente");
        }else{
            response.getWriter().println("Error al agregar producto");
        }
        
        
        
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
        processRequest(request, response);
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
