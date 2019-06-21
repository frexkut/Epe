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
import javax.swing.JTable;

 
        
        
public class GestionBD {
     
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String Driver = "org.sqlite.JDBC";
    String NOMBREBD = "empresa.sqlite";
    String url = "jdbc:sqlite:" +NOMBREBD;
    
    public static void main(String[] args) {
       
    }
    
    public void crearTablaUsuario(){
        try{
            Class.forName(Driver);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement();
            
           String sql = "CREATE TABLE Usuario ("
                   + "ID     INT PRIMARY KEY NOT NULL,"
                   + "NOMBRE   VARCHAR(50) NOT NULL,"
                   + "APELLIDO VARCHAR(50) NOT NULL,"
                   + "RUT      INT         NOT NULL,"
                   + "EDAD     INT         NOT NULL,"
                   + "DIRECCION VARCHAR(50) NOT NULL,"
                   + "SEXO     TEXT         NOT NULL)";
           
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
         JOptionPane.showMessageDialog(null ,"Tabla creada");
    }
    public void insertarDatosU(int id, String nom, String ape, int rut, int edad, String dire, String sexo){
        try{
            Class.forName(Driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO Usuario("
                    + "ID, NOMBRE, APELLIDO, RUT, EDAD, DIRECCION, SEXO)"
                    + "VALUES('"+id+"', '"+nom+"', '"+ape+"', '"+rut+"', '"+edad+"', '"+dire+"', '"+sexo+"')";
                      
            
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
         JOptionPane.showMessageDialog(null,"DATOS INGRESADOS CON EXITO");
    }
    public void seleccionar(JTable tablaseleccionar){
         try{
            Class.forName(Driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM Clientes";
             
            resultados = sentencia.executeQuery(sql);
            int fila = 0;
            while(resultados.next()){
                tablaseleccionar.setValueAt(resultados.getInt("ID"), fila, 0);
                tablaseleccionar.setValueAt(resultados.getInt("Nombre"), fila, 1);
                tablaseleccionar.setValueAt(resultados.getInt("Apellido"), fila, 2);
                tablaseleccionar.setValueAt(resultados.getInt("Rut"), fila, 0);
                tablaseleccionar.setValueAt(resultados.getInt("Edad"), fila, 0);
                tablaseleccionar.setValueAt(resultados.getInt("Direccion"), fila, 0);
                tablaseleccionar.setValueAt(resultados.getInt("Sexo"), fila, 0);
                fila++;  
                
            }
            
            resultados.close();
            sentencia.close();
            conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
 }

