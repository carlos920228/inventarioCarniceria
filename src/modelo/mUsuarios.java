
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Supervisor
 */
public class mUsuarios {
    public boolean insertarUsuario(ArrayList datos){
    Conexion conexion=new Conexion();
    conexion.conectar();
    try{
    Statement sql= conexion.getConexion().createStatement();
    sql.executeUpdate("Insert into usuario (nombre, usuario, contra, dir, tel, rol) "
            + "values('"+datos.get(0).toString()+"','"+datos.get(1).toString()+"','"+datos.get(2).toString()+
            "','"+datos.get(3).toString()+"','"+datos.get(4).toString()+"','"+datos.get(5).toString()+"')");
    conexion.getConexion().close();
    return true;
            }catch(Exception e){
        System.out.println("Error al insertar Usuario: "+e);
        return false;
    }
    }
    
    public ArrayList usuarios(){
     Conexion conexion=new Conexion();
    conexion.conectar();
    ArrayList resultado= new ArrayList();
    try{
    Statement sql= conexion.getConexion().createStatement();
    ResultSet rs=sql.executeQuery("select *from usuario");
        while (rs.next())
        {
            System.out.println("nombre="+rs.getObject("nombre"));
        }
       }catch(Exception e){
        System.out.println("Error al consultar Usuario: "+e);
    }
    return resultado;
    }
    
}
