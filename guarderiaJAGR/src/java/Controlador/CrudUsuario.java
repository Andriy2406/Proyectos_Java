/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.sql.*;
import Modelo.Usuario;

/**
 *
 * @author User
 */
public class CrudUsuario {
    
    private Conexion conect = new Conexion();
    
    public void insertarDato(int id, String nombre, String apellido, String numeroDocumento, String telefono, String correo, int tipoDocumento, int idRol, String contrasena)
    {
        String query="INSERT INTO usuario (id_usuario, nombre, apellido, numero_documento, telefono, correo, tipo_documento_id_tipo_documento, id_rol, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = conect.getConn();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, numeroDocumento);
            ps.setString(5, telefono);
            ps.setString(6, correo);
            ps.setInt(7, tipoDocumento);
            ps.setInt(8, idRol);
            ps.setString(9, contrasena);
            
            ps.executeUpdate();
                System.out.println("Dato insertado con éxito.");
        } catch (SQLException ex) 
        {
            System.out.println("Error al insertar dato.");
            ex.printStackTrace();
        }
    }
    
    public void leerDatos()
    {
        String query = "select * from usuario";
        try 
        {
           Connection conn = conect.getConn();
           PreparedStatement ps = conn.prepareStatement(query); 
           
           ResultSet rs = ps.executeQuery();
           
           while(rs.next())
           {
               int id = rs.getInt("id_usuario");
               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
               String numeroDocumento = rs.getString("numero_documento");
               String telefono = rs.getString("telefono");
               String correo = rs.getString("correo");
               int tipoDocumento = rs.getInt("tipo_documento_id_tipo_documento");
               int idRol = rs.getInt("id_rol");
               String contrasena = rs.getString("contrasena");
                System.out.println("ID: " + id + " Nombre: " + nombre + " Apellido: " + apellido + " Número de Documento: " + numeroDocumento + " Teléfono: " + telefono + " Correo: " + correo + " Tipo de Documento: " + tipoDocumento + " Rol: " + idRol + " Contraseña: " + contrasena);
           }
        } catch (SQLException ex) 
        {
            System.out.println("Error al insertar dato.");
            ex.printStackTrace();
        }
    }
            
    public void actualizarDatos(int id, String nombre, String apellido, String numeroDocumento, String telefono, String correo, int tipoDocumento, int idRol, String contrasena)
    {
         String query = "UPDATE usuario SET nombre = ?, apellido = ?, numero_documento = ?, telefono = ?, correo = ?, tipo_documento_id_tipo_documento = ?, id_rol = ?, contrasena = ? WHERE id_usuario = ?";
         
       try {
            Connection conn = conect.getConn();
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, numeroDocumento);
            ps.setString(4, telefono);
            ps.setString(5, correo);
            ps.setInt(6, tipoDocumento);
            ps.setInt(7, idRol);
            ps.setString(8, contrasena);
            ps.setInt(9, id);
            
            ps.executeUpdate();
                System.out.println("Dato actualizado con éxito.");
        } catch (SQLException ex) 
        {
            System.out.println("Error al aactualizar dato.");
            ex.printStackTrace();
        } 
    }
    
    
    public void eliminarDatos(int id)
    {
         String query = "delete from usuario where id_usuario = ?";
         
       try {
            Connection conn = conect.getConn();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            
            ps.executeUpdate();
                System.out.println("Dato eliminado con éxito.");
        } catch (SQLException ex) 
        {
            System.out.println("Error al eliminar dato.");
            ex.printStackTrace();
        } 
    }
}
