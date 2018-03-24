
package modelo;

import java.sql.Statement;
import java.util.ArrayList;

public class mSucursal {
   public boolean insertarSucursal(ArrayList datos){
       Conexion conexion=new Conexion();
       conexion.conectar();
       try {
           Statement sql=conexion.getConexion().createStatement();
           sql.executeUpdate("insert into sucursal (nombre, colonia, ciudad, calle, rfc, tel, cp, regimen) values"
                   + "('"+datos.get(0).toString()+"','"+datos.get(1).toString()+"','"+datos.get(2).toString()+"',"
                           + "'"+datos.get(3).toString()+"','"+datos.get(4).toString()+"','"+datos.get(5).toString()+"',"
                                   + "'"+datos.get(6).toString()+"','"+datos.get(7).toString()+"')");
           
           return true;
       } catch (Exception e) {
           System.out.println("Erro en insertar sucursal: "+e);
           return false;
       }
   }
}
