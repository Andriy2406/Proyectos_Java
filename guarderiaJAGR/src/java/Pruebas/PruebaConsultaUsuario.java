/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Modelo.Usuario;
import Controlador.UsuarioDAO;
import java.util.Scanner;

/**
 *
 * @author Aprendiz
 */
public class PruebaConsultaUsuario {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
    
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        
        System.out.println("Ingrese el correo de usario a buscar: ");
        
        String correo = sc.nextLine();
        
        Usuario miUsuario = miUsuarioDAO.consultarUsuario(correo);
        
        if (miUsuario != null){
        
        System.out.println("Nombre: " + miUsuario.getNombre());
        System.out.println("Apellido: " + miUsuario.getApellido());
        System.out.println("Número de Documento: " + miUsuario.getNumeroDocumento());
        System.out.println("Telefono: " + miUsuario.getTelefono());
        System.out.println("Correo: " + miUsuario.getCorreo());
        System.out.println("Tipo de Documento: " + miUsuario.getTipoDocumentoIdTipoDocumento());
        System.out.println("Rol: " + miUsuario.getIdRol());
        System.out.println("Contraseña: " + miUsuario.getContrasena());
        
        }else{
        System.out.println("No se encontro el usuario");
            }
        
        sc.close();
    }
}
