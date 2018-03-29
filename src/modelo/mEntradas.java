package modelo;

import java.sql.ResultSet;
import java.sql.Statement;

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
}
