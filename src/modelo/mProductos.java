package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class mProductos {
public boolean agregarProducto(ArrayList datos){
Conexion conexion=new Conexion();
conexion.conectar();
    try {
        Statement sql=conexion.getConexion().createStatement();
        sql.executeUpdate("insert into Productos (descripcion, um) values ('"+datos.get(0).toString()+"','"+datos.get(0).toString()+"')");
        conexion.getConexion().close();
        return true;    
    } catch (Exception e) {
        System.out.println("Error al agregar producto "+e);
        return false;
    }
}
/**
 * Método que regresa la lista de productos registrados en el sistema.
 * @param No recibe parametros
 * @return ArrayList con la lista de productos [id,name]
 */
public ArrayList<ArrayList> productList(){
Conexion conexion=new Conexion();
conexion.conectar();
ArrayList<ArrayList> data=new ArrayList();
    try {
        Statement sql=conexion.getConexion().createStatement();
        ResultSet result=sql.executeQuery("select idProductos, descripcion from Productos");
        while(result.next()){
         ArrayList<String> product=new ArrayList();
         product.add(result.getString("idProductos"));
         product.add(result.getString("descripcion"));
         data.add(product);
        }
        conexion.getConexion().close();
    } catch (Exception e) {
        System.out.println("Error consult productList "+e);
    }
    return data;
}
/**
 * Método que acualiza la existencia de un producto, recibe la cantidad y la descripción del producto
 * @param sum
 * @param des
 * @return 
 */

public boolean updateExistence(String sum,String des){
Conexion conexion=new Conexion();
conexion.conectar();
    try {
        Statement sql=conexion.getConexion().createStatement();
        sql.executeUpdate("update Productos set exitencia=exitencia+"+sum+" where descripcion='"+des+"'");
        conexion.getConexion().close();
        return true;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Erro al afectar existencias,enviar foto a sistemas: "+e);
        return false;
    }
}
}