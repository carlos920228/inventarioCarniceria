package modelo;

import Controlador.Utilerias;
import java.sql.PreparedStatement;
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
            System.out.println("insert into salidas (fecha, usuario, destino, chofer, surtio, total) values("+new Utilerias().fecha()+",'"+new Utilerias().usuario()+"','"+data.get(0).toString()+"','"+data.get(1).toString()+"','"+data.get(2).toString()+"','"+data.get(3).toString()+"')");
            sql.execute("insert into salidas (fecha, usuario, destino, chofer, surtio, total) values ('"+new Utilerias().fecha()+"','"+new Utilerias().usuario()+"','"+data.get(0).toString()+"','"+data.get(1).toString()+"','"+data.get(2).toString()+"','"+data.get(3).toString()+"'");
            ResultSet r=sql.executeQuery("select LAST_INSERT_ID() as id");
            r.next();
            conexion.getConexion().close();
            return r.getString("id");
        } catch (Exception e) {
            System.out.println("Error en insertarDeparture"+e);
            return "Error";
        }
}
    public boolean insertRowDeparture(ArrayList l,String id){
    Conexion conexion=new Conexion();
    conexion.conectar();
        try {
             PreparedStatement sql=conexion.getConexion().prepareStatement("insert into productosSalida(producto,partida,kilos,piezas,merma,costo,cantidad,trf) values(?,?,?,?,?,?,?,?)");
             sql.setString(1, l.get(0).toString());
             sql.setString(2, l.get(1).toString());
             sql.setString(3, l.get(2).toString());
             sql.setString(4, l.get(3).toString());
             sql.setString(5, l.get(4).toString());
             sql.setString(6, l.get(5).toString());
             sql.setString(7, l.get(6).toString());
             sql.setString(8, id);
             boolean result=sql.execute();
             conexion.getConexion().close();
             return result;
        } catch (Exception e) {
        return false;        
        }
    }

}
