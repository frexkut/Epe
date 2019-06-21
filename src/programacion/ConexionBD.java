/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin
 */
public class ConexionBD {
     Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String Driver = "org.sqlite.JDBC";
    String NOMBREBD = "empresa.sqlite";
    String url = "jdbc:sqlite:" +NOMBREBD;
    
    
    public void crearBD(){
        try{
             Class.forName(Driver);
            conexion = DriverManager.getConnection(url);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
         JOptionPane.showMessageDialog(null, "Base de datsos creado con exito");

    }
}
