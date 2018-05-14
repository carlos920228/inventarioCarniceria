package modelo;

import Controlador.Utilerias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class mSalidas {

    /**
     * Método que inserta los datos de la transferencia
     *
     * @param ArrayList
     * @return
     */
    public String insertDeparture(ArrayList data) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            PreparedStatement sql = conexion.getConexion().prepareStatement("insert into salidas (fecha, usuario, destino, chofer, surtio, total) values (?,?,?,?,?,?)");
            sql.setString(1, new Utilerias().fecha());
            sql.setString(2, new Utilerias().usuario());
            sql.setString(3, data.get(0).toString());
            sql.setString(4, data.get(1).toString());
            sql.setString(5, data.get(2).toString());
            sql.setString(6, data.get(3).toString());
            sql.execute();
            ResultSet r = sql.executeQuery("select LAST_INSERT_ID() as id");
            r.next();
            String id = r.getString("id");
            conexion.getConexion().close();
            return id;
        } catch (Exception e) {
            System.out.println("Error en insertarDeparture" + e);
            return "Error";
        }
    }

    public boolean insertRowDeparture(ArrayList l, String id) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            PreparedStatement sql = conexion.getConexion().prepareStatement("insert into productosSalida(producto,partida,kilos,piezas,merma,costo,cantidad,trf) values(?,?,?,?,?,?,?,?)");
            sql.setString(1, l.get(0).toString());
            sql.setString(2, l.get(1).toString());
            sql.setString(3, l.get(2).toString());
            sql.setString(4, l.get(3).toString());
            sql.setString(5, l.get(4).toString());
            sql.setString(6, l.get(5).toString());
            sql.setString(7, l.get(6).toString());
            sql.setString(8, id);
            boolean result = sql.execute();
            conexion.getConexion().close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * Método que devuelve la última TRF realizada
     * [folio,fehca,destino,usuario,surtio,chofer,total]
     *
     * @return
     */
    public ArrayList dataDeparture() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        ArrayList data = new ArrayList();
        try {
            Statement sql = conexion.getConexion().createStatement();
            ResultSet r = sql.executeQuery("SELECT * FROM salidas ORDER by folio desc LIMIT 1");
            r.next();
            data.add(r.getString("folio"));
            data.add(r.getString("fecha"));
            data.add(r.getString("destino"));
            data.add(r.getString("usuario"));
            data.add(r.getString("surtio"));
            data.add(r.getString("chofer"));
            data.add(r.getString("total"));
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recuperar metaDatos Trf: " + e);
        }
        return data;
    }

    /**
     * Recibe el id para recuperar la TRF
     *
     * @param id
     * @return
     */
    public ArrayList dataBuyLatest(String id) {
        ArrayList rows = new ArrayList();
        if (folio(id)) {
            Conexion conexion = new Conexion();
            conexion.conectar();
            try {
                Statement sql = conexion.getConexion().createStatement();
                ResultSet result = sql.executeQuery("SELECT * FROM productosSalida where trf='" + id + "'");
                while (result.next()) {
                    ArrayList r = new ArrayList();
                    r.add(result.getString("producto"));
                    r.add(result.getString("partida"));
                    r.add(result.getString("kilos"));
                    r.add(result.getString("piezas"));
                    r.add(result.getString("merma"));
                    r.add(result.getString("costo"));
                    r.add(result.getString("cantidad"));
                    rows.add(r);
                }
                conexion.getConexion().close();
            } catch (Exception e) {
                System.out.println("Error al recupera última trf: " + e);
            }
        }
        return rows;

    }

    public boolean folio(String id) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql = conexion.getConexion().createStatement();
            ResultSet result = sql.executeQuery("SELECT folio FROM salidas where folio='" + id + "'");
            return result.next();
        } catch (Exception e) {
            System.out.println("Error al buscar el folio: " + e);
            return false;
        }
    }

    /**
     * Método que devuelve la última TRF realizada recibe el
     * folio[folio,fehca,destino,usuario,surtio,chofer,total]
     *
     * @return
     */
    public ArrayList dataDeparture(String id) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        ArrayList data = new ArrayList();
        try {
            Statement sql = conexion.getConexion().createStatement();
            ResultSet r = sql.executeQuery("SELECT * FROM salidas where folio='" + id + "'");
            r.next();
            data.add(r.getString("folio"));
            data.add(r.getString("fecha"));
            data.add(r.getString("destino"));
            data.add(r.getString("usuario"));
            data.add(r.getString("surtio"));
            data.add(r.getString("chofer"));
            data.add(r.getString("total"));
            conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error al recuperar metaDatos Trf: " + e);
        }
        return data;
    }

    /**
     *
     * @param inicio
     * @param fin
     * @param estado
     * @param sucursal
     * @return
     */
    public ArrayList reporteTrf(String inicio, String fin, String rcp) {
        ArrayList rows = new ArrayList();
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            Statement sql = conexion.getConexion().createStatement();
            if(!rcp.equals("Todas")){
                   ResultSet resultado = sql.executeQuery("select *from salidas where fecha BETWEEN '"+ inicio + "' and '"+ fin+"' and recepcion='"+rcp+"'");
                   while (resultado.next()) {
                       ArrayList data=new ArrayList();
                        data.add(resultado.getString("folio"));
                        data.add(resultado.getString("fecha"));
                        data.add(resultado.getString("destino"));
                        data.add(resultado.getString("usuario"));
                        data.add(resultado.getString("chofer"));
                        data.add(resultado.getString("total"));
                        data.add(resultado.getString("recepcion"));
                        data.add(resultado.getString("recibio"));
                        data.add(resultado.getString("surtio"));
                        rows.add(data);
                    }}else{
                   ResultSet resultado = sql.executeQuery("select *from salidas where fecha BETWEEN '"+ inicio + "' and '"+ fin+"'");
                   while (resultado.next()) {
                       ArrayList data=new ArrayList();
                        data.add(resultado.getString("folio"));
                        data.add(resultado.getString("fecha"));
                        data.add(resultado.getString("destino"));
                        data.add(resultado.getString("usuario"));
                        data.add(resultado.getString("chofer"));
                        data.add(resultado.getString("total"));
                        data.add(resultado.getString("recepcion"));
                        data.add(resultado.getString("recibio"));
                        data.add(resultado.getString("surtio"));
                        rows.add(data);
            }}
                                conexion.getConexion().close();
        } catch (Exception e) {
            System.out.println("Error reporte TRF: " + e);
        }
        return rows;
    }

}
