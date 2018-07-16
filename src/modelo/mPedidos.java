
package modelo;

import Controlador.Utilerias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class mPedidos {
public String insertOrder(String sucursal){
 Conexion conexion = new Conexion();
 conexion.conectar();
    try {
        PreparedStatement sql = conexion.getConexion().prepareStatement("insert into pedidos(fecha,sucursal) values (?,?)");
            sql.setString(1, new Utilerias().fecha());
            sql.setString(2, sucursal);
            sql.execute();
            ResultSet r = sql.executeQuery("select LAST_INSERT_ID() as idPedidos");
            r.next();
            String id = r.getString("idPedidos");
            conexion.getConexion().close();
            return id;
    } catch (Exception e) {
        System.out.println("Error al insertar Pedido: "+e);
        return "Error";
    }
}
public boolean insertRowOrder(ArrayList l, String id) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            PreparedStatement sql = conexion.getConexion().prepareStatement("insert into productos_pedido(idPedido,producto,cantidad,um) values(?,?,?,?)");           
            sql.setString(1, id);
            sql.setString(2, l.get(0).toString());
            sql.setString(3, l.get(1).toString());
            sql.setString(4, l.get(2).toString());
            boolean result = sql.execute();
            conexion.getConexion().close();
            return true;
        } catch (Exception e) {
            System.out.println("Error mPedidos->insertRowOrder()"+e);
            return false;
        }
}
public ArrayList listOrders(){
ArrayList data=new ArrayList();
Conexion conexion=new Conexion();
conexion.conectar();
    try {
        Statement sql=conexion.getConexion().createStatement();
        ResultSet resultado=sql.executeQuery("select *from pedidos order by idPedidos desc");
        while(resultado.next()){
        ArrayList row=new ArrayList();
        row.add(resultado.getString("idPedidos"));
        row.add(resultado.getString("fecha"));
        row.add(resultado.getString("estatus"));
        row.add(resultado.getString("sucursal"));
        data.add(row);
        }}catch(Exception e){
        System.out.println("Error al recuperar pedidos"+e);
        }
return data;}
public ArrayList history(String producto){
ArrayList data=new ArrayList();
Conexion conexion=new Conexion();
conexion.conectar();
    try {
        Statement sql=conexion.getConexion().createStatement();
        ResultSet resultado=sql.executeQuery("SELECT DISTINCT p.folioFactura as folio, p.producto as producto, p.fecha as fecha , p.costo as costo, c.proveedor as proveedor FROM partida as p, compra as c\n" +
                                              "where c.folio=p.folioFactura and p.producto='"+producto+"' limit 7");
        while(resultado.next()){
        ArrayList row=new ArrayList();
        row.add(resultado.getString("producto"));
        row.add(resultado.getString("fecha"));
        row.add(resultado.getString("costo"));
        row.add(resultado.getString("proveedor"));
        row.add(resultado.getString("folio"));
        data.add(row);
        }
    } catch (Exception e) {
        System.out.println("Error al mostrar historico producto");
    }
return data;
}
public ArrayList rowOrder(String id){
ArrayList data=new ArrayList();
Conexion conexion=new Conexion();
conexion.conectar();
    try {
         Statement sql=conexion.getConexion().createStatement();
        ResultSet resultado=sql.executeQuery("select producto, um from productos_pedido where idPedido='"+id+"'");
        while(resultado.next()){
        ArrayList row=new ArrayList();
        row.add(resultado.getString("producto"));
        row.add(resultado.getString("um"));
        data.add(row);}
    } catch (Exception e) {
        System.out.println("Error al recuperar rowOrder "+e);
    }
    return data;
}
public boolean actualizar(String id){
Conexion conexion=new Conexion();
conexion.conectar();
    try {
         Statement sql=conexion.getConexion().createStatement();
         sql.execute("update pedidos set estatus='Impreso' where idPedidos='"+id+"'");
        return true;
    } catch (Exception e) {
        System.out.println("Error al modificar estatus de pedido "+e);
        return false;
    }
 
}
}
