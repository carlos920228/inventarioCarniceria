
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
public class mRepartidor {
    public boolean insertarRepartidor(ArrayList datos){
    Conexion conexion=new Conexion();
    conexion.conectar();
    try{
    Statement sql= conexion.getConexion().createStatement();
    sql.executeUpdate("Insert into chofer (nombre,dir,tel) "
            + "values('"+datos.get(0).toString()+"','"+datos.get(1).toString()+"','"+datos.get(2).toString()+"')");
    conexion.getConexion().close();
    return true;
            }catch(Exception e){
        System.out.println("Error al insertar Usuario: "+e);
        return false;
    }
    }
    public ArrayList listRepartidores() {
        ArrayList data = new ArrayList();
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql = conexion.getConexion().createStatement();
            ResultSet result = sql.executeQuery("select idchofer,nombre from chofer");
            while (result.next()) {
                ArrayList<String> product = new ArrayList();
                product.add(result.getString("idchofer"));
                product.add(result.getString("nombre"));
                data.add(product);
            }
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error consult Repartidores List " + e);
        }
        return data;

    }
    
}
