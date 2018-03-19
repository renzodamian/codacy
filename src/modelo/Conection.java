
package modelo;
import java.sql.*;
/**
 *
 * @author renzo
 */
public class Conection {
    public Conection (){
        
    }
    Connection con;
    public Connection GetConection(){
        //Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/matricula","root","");
            
        }catch (SQLException ex){
            
        }catch (Exception e){
            
        }
        return con;
    }
    
}
