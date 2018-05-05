package modelo;

import Controlador.Utilerias;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class mSalidas {
/**
 * Método que inserta los datos de la transferencia
 * @param ArrayList
 * @return 
 */
    public String insertDeparture(ArrayList data){
        Conexion conexion=new Conexion();
        conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            sql.execute("insert into salidas (fecha,usuario,destino,chofer,surtio,total) values('"+new Utilerias().fecha()+"','"+new Utilerias().usuario()+"','"+data.get(0).toString()+"','"+data.get(1).toString()+"'"+data.get(2).toString()+"'"+data.get(3).toString()+"'");
            ResultSet r=sql.executeQuery("select LAST_INSERT_ID() as id");
            r.next();
            conexion.getConexion().close();
            return r.getString("id");
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
}
    public boolean insertRowDeparture(){
    
    }

}
