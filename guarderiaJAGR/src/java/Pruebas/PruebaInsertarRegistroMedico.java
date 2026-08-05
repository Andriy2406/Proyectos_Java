package Pruebas;
import Modelo.RegistroMedico;
import Controlador.RegistroMedicoDAO;
import java.util.Scanner;


public class PruebaInsertarRegistroMedico {
    
    public static void main(String[] args) {
           
        Scanner sc = new Scanner(System.in);
        RegistroMedico miRegistro = new RegistroMedico();
        RegistroMedicoDAO dao = new RegistroMedicoDAO();
        
        System.out.println("Ingrese la observación del niño: ");
        miRegistro.setObservaciones(sc.nextLine());
        System.out.println("Ingrese las alergias del niño: ");
        miRegistro.setAlergias(sc.nextLine());
        System.out.println("Ingrese el contacto de emergencia del niño: ");
        miRegistro.setContactoEmergencia(sc.nextLine());
        System.out.println("Ingrese el ID del niño: ");
        miRegistro.setIdNinos(sc.nextInt());
        
        boolean resultado = dao.InsertarRegistroMedico(miRegistro);
        if (resultado) {
            System.out.println("El registro se guardo correctamente");
            
        }else{
            System.out.println("El registro no se pudo ingresar correctamente");
        }
    }
    
}
