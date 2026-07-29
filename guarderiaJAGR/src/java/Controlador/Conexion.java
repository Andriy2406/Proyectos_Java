package Controlador;

import java.sql.Connection; 
import java.sql.DriverManager;

public class Conexion {
    
    private Connection conn;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root" ;
    private String password = "";
    private String baseDatos = "guarderia";
    private String url = "jdbc:mysql://localhost:3307/" + baseDatos + "?useTimezone=true&serverTimezone=UTC";
    
    public Conexion () {
    
    conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            
            if (conn == null) {
            System.out.println("No se establecio la Conexion" + url);
            } else {
            System.out.println("Conexion Exitosa con la base de datos" + baseDatos);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
 public Connection getConn(){
 return conn;
 } 
}



