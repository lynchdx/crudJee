package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //Variables de conexión
    private String driver = "com.mysql.jdbc.Driver";//también lo usan con nombre var classname
    private String database = "comercio";
    private String hostname = "localhost";
    private String port = "3306";

    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    //usuario y pass bd
    private String username = "root";
    private String password = "";

    //se usa para la segunda forma de conexión
    Connection conn = null; 

    //primer método de conexión
    /*
    public Connection conectar() {

        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    } */

 //Era para probar la conxión.
    public static void main(String[] args) {
        Conexion c = new Conexion();
        System.out.println(""+c.getConnection());
    }
     
    //constructor de conexion
    public Conexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("conectado");
        }catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
        
    }

    public Connection getConnection() {
        return conn;
    }
 
}
