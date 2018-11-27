package modelo;

import include.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModeloProducto extends Conexion {
/*
Todos estos métodos, deben enviarse al controller.    
*/
   
    
/*----------------------------------------Método crear------------------------------------------*/    
    
    //método que crea producto
    public boolean crearProductoModelo(Producto p) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String query = "call insertProducto(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getDescripcion());
            pst.setInt(3, p.getPrecio());
            pst.setString(4, p.getCategoria());
            pst.setString(5, p.getDetalle());
            pst.setString(6, p.getReviews());
            pst.setInt(7, p.getSize());
            pst.setString(8, p.getColor());
            pst.setString(9, p.getImg1());
            pst.setString(10, p.getImg2());
            pst.setString(11, p.getImg3());
            pst.setString(12, p.getImg4());
            pst.setString(13, p.getImg5());

            if (pst.executeUpdate() == 1) {
                flag = true;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();  //si la conexión no se ha cerrado, la cierra
                }
                if (pst != null) { //sí el pst ejecutó una query
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("" + e.getMessage());
            }
        }

        return flag;
    }

    //El sout devuelve el boolean del crearProducto.
    /*
    public static void main(String[] args) {
        ModeloProducto mp = new ModeloProducto();
        //como es booleano el método, se puede imprimir
        System.out.println(mp.crearProductoModelo(new Producto(0, "Pantalón", "Pantalón suave", 17900, "Ropa", "Pantalón Tipo Slim", "Reviews Pantalón", 8, "Azul", "ima.jpg1", "ima.jpg2", "ima.jpg3", "ima.jpg4", "ima.jpg5")));

    } */
 
    
    
    
    /*-------------------------------------Método Listar Todos--------------------------------------------*/
    
    //Método que devuelve una lista con todos los productos, llama el procedure selecAllProductos
    public ArrayList<Producto> getAllProductosModelo() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "call selectAllProductos()";
            pst = getConnection().prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) { //hace recorrer los resultados
                listaProductos.add(new Producto(rs.getInt("id_producto"), rs.getString("nombre"), rs.getString("descripcion"),
                        rs.getInt("precio"), rs.getString("categoria"), rs.getString("detalles"), rs.getString("reviews"),
                        rs.getInt("size"), rs.getString("color"), rs.getString("imagen_1"), rs.getString("imagen_2"),
                        rs.getString("imagen_3"), rs.getString("imagen_4"), rs.getString("imagen_5")));
            }
        } catch (Exception e) {
        } finally { //para cerrar la conexión después del catch
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }

        }
        return listaProductos;
    }

    /* para main para probar método
    public static void main(String[] args) {
        ModeloProducto mp = new ModeloProducto();
        for(Producto p : mp.getAllProductosModelo()){
            System.out.println(p.getNombre());
        }
    }
    */
    
    
    /*-------------------------------------Método Listar Producto por id--------------------------------------------*/
    
    //Método que devuelve un producto, el método se va al controlador.
    public Producto getProductoModelo(int idProducto) {
        
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "select * from productos where id_producto = ?";
            pst = getConnection().prepareCall(query);
            pst.setInt(1, idProducto);
            rs = pst.executeQuery();
            while (rs.next()) { //hace recorrer los resultados
                producto = new Producto(rs.getInt("id_producto"), rs.getString("nombre"), rs.getString("descripcion"),
                        rs.getInt("precio"), rs.getString("categoria"), rs.getString("detalles"), rs.getString("reviews"),
                        rs.getInt("size"), rs.getString("color"), rs.getString("imagen_1"), rs.getString("imagen_2"),
                        rs.getString("imagen_3"), rs.getString("imagen_4"), rs.getString("imagen_5"));
            }
        } catch (Exception e) {
        } finally { //para cerrar la conexión después del catch
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }

        }
        return producto; 
    }
    
//---------------------------Método borrar producto por id---------------------------------------    
    
    public boolean borrarProductoModelo(int idProducto){
    boolean borrado = false;
    
    PreparedStatement pst = null;
    
        try {
            String query = "call deleteProducto(?)";
            pst = getConnection().prepareCall(query);
            pst.setInt(1, idProducto);
            
            //pregunta si hubo cambios en al llamar el procedur o query.
            if (pst.executeUpdate() == 1) {
                borrado = true;
            }
            
        } catch (Exception e) {
        } finally { //para cerrar la conexión después del catch
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    return borrado;    
    }
    
    
//-----------------------Método modificar-------------------------------------
public boolean modificarProductoModelo(Producto p) {
        PreparedStatement pst = null;
        boolean modificado = false;
        try {
            String query = "call updateProducto(?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(query);
            
            pst.setInt(1, p.getId());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getDescripcion());
            pst.setInt(4, p.getPrecio());
            pst.setString(5, p.getCategoria());
            pst.setString(6, p.getDetalle());
            pst.setString(7, p.getReviews());
            if (pst.executeUpdate() == 1) {
                modificado = true;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();  //si la conexión no se ha cerrado, la cierra
                }
                if (pst != null) { //sí el pst ejecutó una query
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("" + e.getMessage());
            }
        }

        return modificado;
    }    
    
    
    
    
}
