package modelo;

import Controlador.Utilerias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class mVentas {
public String insertSale(ArrayList data){
 Conexion conexion = new Conexion();
 conexion.conectar();
    try {
        PreparedStatement sql = conexion.getConexion().prepareStatement("insert into venta (fecha, usuario, cliente, repartidor, total) values (?,?,?,?,?)");
            sql.setString(1, new Utilerias().fecha());
            sql.setString(2, new Utilerias().usuario());
            sql.setString(3, data.get(0).toString());
            sql.setString(4, data.get(1).toString());
            sql.setString(5, data.get(2).toString());
            sql.execute();
            ResultSet r = sql.executeQuery("select LAST_INSERT_ID() as id");
            r.next();
            String id = r.getString("id");
            conexion.getConexion().close();
            return id;
    } catch (Exception e) {
        System.out.println("Error al insertar Venta: "+e);
        return "Error";
    }
}
public boolean insertRowSale(ArrayList l, String id) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            PreparedStatement sql = conexion.getConexion().prepareStatement("insert into pruducto_venta(producto,partida,kilos,piezas,costo,cantidad,precio,subTotal,idVenta) values(?,?,?,?,?,?,?,?,?)");
            sql.setString(1, l.get(0).toString());
            sql.setString(2, l.get(1).toString());
            sql.setString(3, l.get(2).toString());
            sql.setString(4, l.get(3).toString());
            sql.setString(5, l.get(4).toString());
            sql.setString(6, l.get(5).toString());
            sql.setString(7, l.get(6).toString());
            sql.setString(8, l.get(7).toString());
            sql.setString(9, id);
            boolean result = sql.execute();
            conexion.getConexion().close();
            return true;
        } catch (Exception e) {
            System.out.println("Error mVentas->insertRowSale()"+e);
            return false;
        }
}
public ArrayList listSale(String inicio, String fin, String rcp){
ArrayList rows = new ArrayList();
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql = conexion.getConexion().createStatement();
            if(!rcp.equals("Todas")){
                   ResultSet resultado = sql.executeQuery("select idventa, fecha, cliente, usuario, repartidor, round(total,2) as tota, estado, descuento from venta where fecha BETWEEN '"+ inicio + "' and '"+ fin+"' and estado='"+rcp+"'");
                   while (resultado.next()) {
                       ArrayList data=new ArrayList();
                        data.add(resultado.getString("idventa"));
                        data.add(resultado.getString("fecha"));
                        data.add(resultado.getString("cliente"));
                        data.add(resultado.getString("usuario"));
                        data.add(resultado.getString("repartidor"));
                        data.add(resultado.getString("tota"));
                        data.add(resultado.getString("estado"));
                        data.add(resultado.getString("descuento"));
                        rows.add(data);
                    }}else{
                   ResultSet resultado = sql.executeQuery("select idventa, fecha, cliente, usuario, repartidor, round(total,2) as tota, estado, descuento from venta where fecha BETWEEN '"+ inicio + "' and '"+ fin+"'");
                   while (resultado.next()) {
                       ArrayList data=new ArrayList();
                        data.add(resultado.getString("idventa"));
                        data.add(resultado.getString("fecha"));
                        data.add(resultado.getString("cliente"));
                        data.add(resultado.getString("usuario"));
                        data.add(resultado.getString("repartidor"));
                        data.add(resultado.getString("tota"));
                        data.add(resultado.getString("estado"));
                        data.add(resultado.getString("descuento"));
                        rows.add(data);
            }}
                                conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error reporte reporteVentas(): " + e);
        }
        return rows;
}
public ArrayList listSale(String cliente){
ArrayList rows = new ArrayList();
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql = conexion.getConexion().createStatement();
            ResultSet resultado = sql.executeQuery("select idventa, fecha, cliente,IFNULL(observacion,'N/A') as observ, usuario, repartidor, round(total,2) as tota, estado, descuento from venta where cliente='"+cliente+"'");
                   while (resultado.next()) {
                       ArrayList data=new ArrayList();
                        data.add(resultado.getString("idventa"));
                        data.add(resultado.getString("usuario"));
                        data.add(resultado.getString("cliente"));
                        data.add(resultado.getString("repartidor"));
                        data.add(resultado.getString("tota"));
                        data.add(resultado.getString("descuento"));
                        data.add(resultado.getString("observ"));
                        data.add(resultado.getString("fecha"));
                        data.add(resultado.getString("estado"));
                        rows.add(data);
                    }
                                conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error reporte reporteVentas() por cliente: " + e);
        }
        return rows;
}
public ArrayList recuperarVenta(String id){
   ArrayList data=new ArrayList ();
   Conexion conexion = new Conexion();
   conexion.conectar();
   try{
   PreparedStatement sql = conexion.getConexion().prepareStatement("select *from pruducto_venta where idVenta='"+id+"'");
   ResultSet resultado=sql.executeQuery();
   while(resultado.next()){
   ArrayList row=new ArrayList();
   row.add(resultado.getString("producto"));
   row.add(resultado.getString("partida"));
   row.add(resultado.getString("kilos"));
   row.add(resultado.getString("piezas"));
   row.add(resultado.getString("costo"));
   row.add(resultado.getString("cantidad"));
   row.add(resultado.getString("precio"));
   row.add(resultado.getString("subTotal"));
   data.add(row);
   }
   }catch(Exception e){
       System.out.println("Error recuperarVenta()"+e);
   }
           return data; 
}
public boolean update(String descuento, String id){
ArrayList data=new ArrayList ();
   Conexion conexion = new Conexion();
   conexion.conectar();
   try{
       PreparedStatement sql = conexion.getConexion().prepareStatement("update venta set descuento='"+descuento+"', estado='Pagado' where idventa='"+id+"'");
       sql.execute();
       return true;
   }catch(Exception e){
       System.out.println("Error updateVentas()"+e);
   return false;
   } 
}
public ArrayList listSale(){
ArrayList rows = new ArrayList();
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql = conexion.getConexion().createStatement();
            
                   ResultSet resultado = sql.executeQuery("select idventa, fecha, cliente, usuario, repartidor, round(total,2) as tota, estado, descuento from venta where estado='Pendiente'");
                   while (resultado.next()) {
                       ArrayList data=new ArrayList();
                        data.add(resultado.getString("idventa"));
                        data.add(resultado.getString("fecha"));
                        data.add(resultado.getString("cliente"));
                        data.add(resultado.getString("usuario"));
                        data.add(resultado.getString("repartidor"));
                        data.add(resultado.getString("tota"));
                        data.add(resultado.getString("estado"));
                        data.add(resultado.getString("descuento"));
                        rows.add(data);
                    }
                        conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error reporte reporteVentas(): " + e);
        }
        return rows;
}
}
