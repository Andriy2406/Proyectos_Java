package Pruebas;
import Modelo.RegistroMedico;
import Controlador.RegistroMedicoDAO;
import java.util.Scanner;


public class PruebaConsultaRegistroMedico {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        RegistroMedicoDAO miRegistroDAO = new RegistroMedicoDAO();
        
        System.out.println("Ingrese el ID del registro a buscar: ");
        
        String idRegistro = sc.nextLine();
        
        RegistroMedico miRegistro = miRegistroDAO.consultarRegistro(idRegistro);
        
        if (miRegistro != null){
        
        System.out.println("ID: " + miRegistro.getIdRegistro());
        System.out.println("Observaciones: " + miRegistro.getObservaciones());
        System.out.println("Alergias: " + miRegistro.getAlergias());
        System.out.println("Contacto de Emergencia: " + miRegistro.getContactoEmergencia());
        System.out.println("ID del Niño: " + miRegistro.getIdNinos());
        
        }else{
            System.out.println("No se encontro el Registro Medico");
        }
        
        sc.close();
    }
    
}
