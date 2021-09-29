package system.dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import system.businessLayer.universidad.AreaAcademica;

/**
 * Esta clase permite conectarse con la base de datos.
 * 
 * @author Dylan Abrahan
 * @author Kemuel Chavarría
 * @author Daniela Martínez
 * @version 1.0
 */
public class Conexion {
  Connection conectar = null;
  String usuario = "usersql1";
  String contra = "dkd123";
  String db = "ProyectoPOO";
  String ip = "localhost";
  String puerto = "1433";
  
  String cadena = "jdbc:sqlserver://"+ip+":"+puerto+"/"+db;
  
  /**
   * Comprobar si se puede realizar la conexión.
   * 
   * @return La conexión.
   */
  public Connection establecerConexion(){
    try{
      String str = "jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+db;
      conectar = DriverManager.getConnection(str,usuario,contra);
      JOptionPane.showMessageDialog(null, "Conexión exitosa");
    }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Error: " + e.toString());
    }
    return conectar;
  }
  
  public void desconectar(){
    try{
      conectar.close();
      JOptionPane.showMessageDialog(null, "DESCONECTADO");
    }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Error: " + e.toString());
    }
  }
  
  
  /**
   * Ejecutar una sentencia de SQL Server.
   * 
   * @param pStrSentenciaSQL String de la sentencia.
   * @return Uno si se ejecutó, cero lo contrario.
   */
  public int excSentenciaSQL(String pStrSentenciaSQL){
    try{
      PreparedStatement ps = conectar.prepareStatement(pStrSentenciaSQL);
      ps.execute();
      return 1;
    }catch(SQLException e){
       JOptionPane.showMessageDialog(null, "Error: " + e.toString());
       return 0;
    }
  }
 
  /**
   * Consultar información de la base de datos.
   * 
   * @param pStrSentenciaSQL String de la sentencia.
   * @return Los datos recuperados.
   */
  public ResultSet consultas(String pStrSentenciaSQL){
    try{
      PreparedStatement ps = conectar.prepareStatement(pStrSentenciaSQL);
      ResultSet respuesta = ps.executeQuery();
      return respuesta;
    }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Error: " + e.toString());
       return null;
    }
  }
}

