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
     rows.add(data);
        Conexion conexion=new Conexion();
       conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("SELECT * FROM partida where compra_id='"+data.get(0).toString()+"'");
            while(result.next()){
            ArrayList r=new ArrayList();
            r.add(result.getString("producto"));
            r.add(result.getString("numPartida"));
            r.add(result.getString("kilos_eti"));
            r.add(result.getString("Pieza"));
            r.add(result.getString("Libras"));
            r.add(result.getString("pesoBascula"));
            r.add(result.getString("pesoMuerto"));
            r.add(result.getString("merma"));
            r.add(result.getString("costo"));
            r.add(result.getString("fecha"));
            r.add(result.getString("cantidadProducto"));
            rows.add(r);
            }
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recupera última factura: "+ e);
        }
        return rows;
    }
    /**
     * Recibe el id para recuperar la factura 
     * @param id
     * @return 
     */
    public ArrayList dataBuyLatest(String id){
    ArrayList rows=new ArrayList();
    if(folio(id)){
    ArrayList data=buyLatest(id);
     rows.add(data);
        Conexion conexion=new Conexion();
       conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("SELECT * FROM partida where compra_id='"+id+"'");
            while(result.next()){
            ArrayList r=new ArrayList();
            r.add(result.getString("producto"));
            r.add(result.getString("numPartida"));
            r.add(result.getString("kilos_eti"));
            r.add(result.getString("Pieza"));
            r.add(result.getString("Libras"));
            r.add(result.getString("pesoBascula"));
            r.add(result.getString("pesoMuerto"));
            r.add(result.getString("merma"));
            r.add(result.getString("costo"));
            r.add(result.getString("fecha"));
            r.add(result.getString("cantidadProducto"));
            rows.add(r);
            }
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recupera última factura: "+ e);
        }
    }
        return rows;
    
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
            data.add(result.getString("sellos"));
            data.add(result.getString("fecha"));
            data.add(result.getString("proveedor"));
            data.add(result.getString("total"));
            data.add(result.getString("MermaTotal"));
            
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recupera última factura: "+ e);
        }
      return data;
    }
    /**
     * Recibe el id a recuperar los datos
     * @param id
     * @return 
     */
    private ArrayList buyLatest(String id){
       ArrayList data=new ArrayList();
        Conexion conexion=new Conexion();
       conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("SELECT * FROM compra where idcompras='"+id+"'");
            result.next();
            data.add(result.getString("idcompras"));
            data.add(result.getString("folio"));
            data.add(result.getString("sellos"));
            data.add(result.getString("fecha"));
            data.add(result.getString("proveedor"));
            data.add(result.getString("total"));
            data.add(result.getString("MermaTotal"));
            
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recupera última factura: "+ e);
        }
      return data;
    }
    /**
     * Verifica si existe el folio solicitado
     * 
     * @return 
     */
    private boolean folio(String id){
    Conexion conexion=new Conexion();
       conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("SELECT idcompras FROM compra where idcompras='"+id+"'");
            return result.next();
        }catch(Exception e){
            System.out.println("Error al buscar el folio: "+e);
            return false;
        }
    }
    /**
     * Método que devuelve los combos que se encuentran en inventario
     * id,partida,ketiqueta,#piezas, Merma, Costo,Fecha, Factura
     * @return ArrayList
     */
    public ArrayList exisCombo(){
    ArrayList combos=new ArrayList();
    Conexion conexion=new Conexion();
       conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("SELECT * FROM partida where producto='Combo' and estado<>'1'");
            while(result.next()){
            ArrayList r=new ArrayList();
            r.add(false);
            r.add(result.getString("idpartida"));
            r.add(result.getString("numPartida"));
            r.add(result.getString("kilos_eti"));
            r.add(result.getString("Pieza"));
            r.add(result.getString("merma"));
            r.add(result.getString("costo"));
            r.add(result.getString("fecha"));
            r.add(result.getString("folioFactura"));
            combos.add(r);
            }
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recupera última factura: "+ e);
        }
    return combos;
    }
    /**
     * Método que devuelve el ultimo costo de un producto, busca en las facturas
     * @param descrip
     * @return 
     */
    public String ultimoCosto(String descrip){
    Conexion conexion=new Conexion();
    String costo="0.0";
    conexion.conectar();
        try {
            Statement sql=conexion.getConexion().createStatement();
            ResultSet result=sql.executeQuery("SELECT costo FROM partida where producto='"+descrip+"' order by fecha desc limit 1");
            while(result.next()){
            costo=result.getString("costo");
            return costo;
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar el ultimo precio");
        }
        return costo;
    }
    /**
     *
     * @param inicio
     * @param fin
     * @return
     */
    public ArrayList reporteFacturas(String inicio, String fin) {
        ArrayList rows = new ArrayList();
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql = conexion.getConexion().createStatement();
                  ResultSet resultado = sql.executeQuery("select *from compra where fecha BETWEEN '"+ inicio + "' and '"+ fin+"'");
                   while (resultado.next()) {
                       ArrayList data=new ArrayList();
                        data.add(resultado.getString("idcompras"));
                        data.add(resultado.getString("proveedor"));
                        data.add(resultado.getString("sellos"));
                        data.add(resultado.getString("folio"));
                        data.add(resultado.getString("fecha"));
                        data.add(resultado.getString("total"));
                        rows.add(data);
            }
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error reporte Facturas: " + e);
        }
        return rows;
    }
}
