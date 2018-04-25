package modelo;

import java.sql.PreparedStatement;
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
    /**
     * Metodo que inserta las partidas de las facturas, recibe un arreglo 
     * [numPartida,kilos_eti,Pieza,Libras,pesoBascula,pesoMuerto,merma,costo,compra_id,fecha,producto,folioFactura]
     * @param data
     * @return 
     */
    public boolean insertRowBuy(ArrayList data){
    Conexion conexion=new Conexion();
    conexion.conectar();
    try{
    PreparedStatement sql = conexion.getConexion().prepareStatement("insert into partida(numPartida,kilos_eti,Pieza,Libras,pesoBascula,pesoMuerto,merma,costo,compra_id,fecha,producto,folioFactura,cantidadProducto) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    sql.setString(1, data.get(0).toString()); 
    sql.setString(2, data.get(1).toString());
    sql.setString(3, data.get(2).toString());
    sql.setString(4, data.get(3).toString());
    sql.setString(5, data.get(4).toString());
    sql.setString(6, data.get(5).toString());
    sql.setString(7, data.get(6).toString());
    sql.setString(8, data.get(7).toString());
    sql.setString(9, data.get(8).toString());
    sql.setString(10, data.get(9).toString());
    sql.setString(11, data.get(10).toString());
    sql.setString(12, data.get(11).toString());
    sql.setString(13, data.get(12).toString());
    sql.execute();
    conexion.getConexion().close();
    new mProductos().updateExistence(data.get(12).toString(), data.get(10).toString());
    return true;
    }catch(Exception e){
        System.out.println("Error insertRowBuy "+e);
        return false;
    } 
    } 
    
    public ArrayList dataBuyLatest(){
    ArrayList data=buyLatest();
     ArrayList rows=new ArrayList();
        Conexion conexion=new Conexion();
       conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("SELECT * FROM partida where compra_id='"+rows.get(0).toString());
            while(result.next()){
            ArrayList r=result.
            }
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recupera última factura: "+ e);
        }
    }
    private ArrayList buyLatest(){
       ArrayList data=new ArrayList();
        Conexion conexion=new Conexion();
       conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("SELECT * FROM compra ORDER by idcompras desc LIMIT 1");
            result.next();
            data.add(result.getString("idcompras"));
            data.add(result.getString("folio"));
            data.add(result.getString("fecha"));
            data.add(result.getString("proveedor"));
            data.add(result.getString("MermaTotal"));
            data.add(result.getString("sellos"));
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recupera última factura: "+ e);
        }
      return data;
    }
}
