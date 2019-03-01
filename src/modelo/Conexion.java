package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;//
public class Conexion {
    public int cools;
    //public String cadena="jdbc:mysql://localhost/prodep2i_pruebaMood";
    public  String cadena = "jdbc:mysql://104.238.111.62:3306/prodep2i_pruebaMood";
    public String driver="com.mysql.jdbc.Driver";
    Connection conexion;
    
    public void conectar(){
        
        try{
            Class.forName(driver);
            //conexion=DriverManager.getConnection(cadena,"root","123456"); 
            conexion=DriverManager.getConnection(cadena,"prodep2i_test","rocc920228_C");
        }catch(ClassNotFoundException e1){
            System.out.println("Error en los drivers");
            System.out.println(e1);
        }catch(SQLException e2){
            System.out.println("Error en la conexión");
            System.out.println(e2);
            
        }   
    }
     
        public Connection getConexion(){
        return conexion;
        }
}    

