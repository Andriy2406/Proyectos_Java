package Controlador;

import Modelo.RegistroMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class RegistroMedicoDAO {
    
      private  Conexion conect = new Conexion();
      
        public RegistroMedico consultarRegistro(String idRegistro){
      
          RegistroMedico miRegistro = null;
          
          Connection conn = conect.getConn();
          
          try {
              String querySql = "select id_registro, observaciones, alergias, contacto_emergencia, id_ninos from registro_medico where id_registro = ?;";
              
              PreparedStatement ps = conn.prepareStatement(querySql);
              
              ps.setString(1, idRegistro);
              
              ResultSet rs = ps.executeQuery();
              
              if (rs.next()){
              
              miRegistro = new RegistroMedico();
              miRegistro.setIdRegistro(rs.getInt("id_registro"));
              miRegistro.setObservaciones(rs.getString("observaciones"));
              miRegistro.setAlergias(rs.getString("alergias"));
              miRegistro.setContactoEmergencia(rs.getString("contacto_emergencia"));
              miRegistro.setIdNinos(rs.getInt("id_ninos"));
              }
              
          } catch (SQLException e) {
              
              System.out.println(e.getMessage());
          }
          return miRegistro;
        }
        
        
        public boolean InsertarRegistroMedico(RegistroMedico miRegistro){
        
            boolean insertarR = false;
            
            Connection conn = conect.getConn();
            
            try {
                String querySql = "INSERT INTO registro_medico (observaciones, alergias, contacto_emergencia, id_ninos) VALUES (?,?,?,?)";
                
                PreparedStatement ps = conn.prepareStatement(querySql);
                ps.setString(1, miRegistro.getObservaciones());
                ps.setString(2, miRegistro.getAlergias());
                ps.setString(3, miRegistro.getContactoEmergencia());
                ps.setInt(4, miRegistro.getIdNinos());
                
                ps.executeUpdate();
                insertarR = true;
                System.out.println("Registro insertado");
            } catch (Exception e) {
                System.out.println("Error al insertar Registro: " + e.getMessage());
            }
                return insertarR;
        }
}
