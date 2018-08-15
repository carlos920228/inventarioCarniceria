package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class mConversion {

    public boolean insert(ArrayList datos){
    Conexion conexion=new Conexion();
   conexion.conectar();
       try {
           Statement sql=conexion.getConexion().createStatement();
           sql.executeUpdate("insert into conversion (producto,fecha,cantidad,motivo) "
                   + "values ('"+datos.get(0).toString()+"','"+datos.get(1).toString()+"','"+datos.get(2).toString()+"','"+datos.get(3).toString()+"')");
           conexion.getConexion().close();
           return true;
       } catch (Exception e) {
           System.out.println("error insertal conversion"+e);
           return false;
       }
       
    }
    
    public ArrayList data(){
    ArrayList data=new ArrayList();
    Conexion conexion=new Conexion();
    conexion.conectar();
    try {
        Statement sql=conexion.getConexion().createStatement();
        ResultSet result=sql.executeQuery("select producto,cantidad,fecha,motivo from conversion order by id desc");
        while(result.next()){
         ArrayList<String> product=new ArrayList();
         product.add(result.getString("producto"));
         product.add(result.getString("cantidad"));
         product.add(result.getString("fecha"));
         product.add(result.getString("motivo"));
         data.add(product);
        }
        conexion.getConexion().close();
    } catch (Exception e) {
        System.out.println("Error consult conversionList "+e);
    }
    return data;
    }
    
}
