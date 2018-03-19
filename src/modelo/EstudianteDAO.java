package modelo;
import java.sql.*;
import java.util.Observable;

/**
 *
 * @author renzo
 */
public class EstudianteDAO extends Observable {
    Conection conexion;
    String rptaregistro;
    //Connection co = cn.GetConection();
    public EstudianteDAO(){
        conexion = new Conection();
        rptaregistro ="Registro Exitoso";
    }

    
 public String insertarEstudiante(String nombre,String apellido,String cedula,String user,String pass){
     
     try {
         Connection accesoDB = conexion.GetConection();
         PreparedStatement pps = accesoDB.prepareStatement("INSERT INTO estudiante (nombre, apellido, cedula, usuario, pass) VALUES (?,?,?,?,?)");
         pps.setString(1, nombre);
         pps.setString(2, apellido);
         pps.setString(3, cedula);
         pps.setString(4, user);
         pps.setString(5, pass);
         
         int num =pps.executeUpdate();
         if (num > 0 ) {
             setChanged();
             notifyObservers(rptaregistro);             
         }
         
     } catch (Exception e) {
         
     }return rptaregistro;
     
     
 }
}
