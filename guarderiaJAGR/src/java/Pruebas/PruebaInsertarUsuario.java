package Pruebas;
import Modelo.Usuario;
import Controlador.UsuarioDAO;
import java.util.Scanner;


public class PruebaInsertarUsuario {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Usuario miUsuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        System.out.println("Ingrese su nombre: ");
        miUsuario.setNombre(sc.nextLine());
        System.out.println("Ingrese su apellido: ");
        miUsuario.setApellido(sc.nextLine());
        System.out.println("Ingrese su número de documento: ");
        miUsuario.setNumeroDocumento(sc.nextLine());
        System.out.println("Ingrese su telefono: ");
        miUsuario.setTelefono(sc.nextLine());
        System.out.println("Ingrese su correo: ");
        miUsuario.setCorreo(sc.nextLine());
        System.out.println("Ingrese su tipo de documento: ");
        miUsuario.setTipoDocumentoIdTipoDocumento(sc.nextInt());
        System.out.println("Ingrese su rol: ");
        miUsuario.setIdRol(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        miUsuario.setContrasena(sc.nextLine());
        
        boolean resultado = dao.InsertarUsuario(miUsuario);
        if (resultado) {
            System.out.println("El usuario se guardo correctamente");
            
        }else{
            System.out.println("El usuario no se pudo registrar");
        }
        
    }
    
}
