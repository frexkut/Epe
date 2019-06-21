
package producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Producto {
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String Driver = "org.sqlite.JDBC";
    String NOMBREBD = "empresa.sqlite";
    String url = "jdbc:sqlite:" +NOMBREBD;
    
      public void crearTablaProducto(){
        try{
            Class.forName(Driver);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement();
            
           String sql = "CREATE TABLE Producto ("
                   + "ID     INT PRIMARY KEY NOT NULL,"
                   + "NOMBRE   VARCHAR(50) NOT NULL,"
                   + "PRECIO  INT          NOT NULL,"
                   + "STOCK   TEXT         NOT NULL)";
           
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
         JOptionPane.showMessageDialog(null ,"Tabla creada");
    }
    
      public void InsertarProducto(int id, String nom, int prec, String stok){
        try{
            Class.forName(Driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO Productp("
                    + "ID, NOMBRE, PRECIO, STOCK)"
                    + "VALUES('"+id+"', '"+nom+"', '"+prec+"', '"+stok+"')";
                      
            
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
         JOptionPane.showMessageDialog(null,"DATOS INGRESADOS CON EXITO");
      }
}
