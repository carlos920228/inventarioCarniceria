
package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class mClientes {
   public boolean insertar(ArrayList datos){
   Conexion conexion=new Conexion();
   conexion.conectar();
       try {
           Statement sql=conexion.getConexion().createStatement();
           sql.executeUpdate("insert into cliente (nombre, direccion, telefono) "
                   + "values ('"+datos.get(0).toString()+"','"+datos.get(1).toString()+"','"+datos.get(2).toString()+"')");
           conexion.getConexion().close();
           return true;
       } catch (Exception e) {
           System.out.println("error insertal cliente"+e);
           return false;
       }
       
   }
   public ArrayList clientesList(){
   ArrayList data= new ArrayList();
   Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql = conexion.getConexion().createStatement();
            ResultSet result = sql.executeQuery("select nombre from cliente");
            while (result.next()) {
               data.add(result.getString("nombre"));
            }
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error consult Repartidores List " + e);
        }
        return data;
   }
}
