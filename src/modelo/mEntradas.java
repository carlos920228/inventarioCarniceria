package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class mEntradas {

    public String folio() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("select count(*)+1 as total from compra");
            result.next();
            return result.getString("total");
        } catch (Exception e) {
            System.out.println("Error folio compra= "+e);
            return "Error";
        }
    }
    /**
     * Método que inserta una compra, recibe un arreglo de String [folio factura,fecha,proveedor,total,merma,sellos]
     * @param datos
     * @return boolean 
     */
    public boolean insertBuy(ArrayList<String> datos){
    Conexion conexion = new Conexion();
        conexion.conectar();
        try {
         Statement sql=conexion.getConexion().createStatement();
         sql.executeUpdate("insert into compra(folio,fecha,proveedor,total,MermaTotal,sellos) values('"+datos.get(0)+"','"+datos.get(1)+"','"+datos.get(2)+"','"+datos.get(3)+"','"+datos.get(4)+"','"+datos.get(5)+"')");
        return true;
        }catch(Exception e){
            System.out.println("Error al insertar compra: "+e);
            return false;
        }
    }
}
