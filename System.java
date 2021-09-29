package system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import system.businessLayer.Bloque;
import system.businessLayer.Curso;
import system.businessLayer.PlanDeEstudio;
import system.businessLayer.universidad.AreaAcademica;
import system.dataAccessLayer.Conexion;
import system.gui.paginaInicio;


/**
 * Clase principal.
 * 
 * @author Dylan Abrahan
 * @author Kemuel Chavarría
 * @author Daniela Martínez
 * @version 1.0
 */
public class System {
  private static ArrayList<AreaAcademica> areasAcademicas;
  private static ArrayList<PlanDeEstudio> planesDeEstudio;
  private static ArrayList<Bloque> bloques;
  private static ArrayList<Curso> cursos;
  private static final paginaInicio nuevaPagina = new paginaInicio();
  //
  
  public static void main(String[] args){
    areasAcademicas = new ArrayList<AreaAcademica>();
    planesDeEstudio = new ArrayList<PlanDeEstudio>();
    bloques = new ArrayList<Bloque>();
    cursos = new ArrayList<Curso>();
    //con.establecerConexion();
    nuevaPagina.setVisible(true);
  }
  
  public static void registrarCurso(Curso pCurso){
    cursos.add(pCurso);
  }
  
  public static void registrarArea(AreaAcademica pAreaAcademica){
    areasAcademicas.add(pAreaAcademica);
  }
  
  public static void insertarAreaBD(AreaAcademica pAreaAcademica){
    Conexion con = new Conexion();
    con.establecerConexion();
    con.excSentenciaSQL("INSERT INTO AreaAcademica VALUES(" + "'" + pAreaAcademica.getNombre() + "', '" + pAreaAcademica.getCodigo() + "')");
    con.desconectar();
  }
  
  public static void hacerVisible(){
    nuevaPagina.setVisible(true);
  }
  
  public static ArrayList<AreaAcademica> getAreaBD(){
    ArrayList<AreaAcademica> lista = new ArrayList<AreaAcademica>();
    Conexion con = new Conexion();
    con.establecerConexion();
    ResultSet resultado;
    AreaAcademica escuela = null;
    try{
        resultado = con.consultas("SELECT * FROM AreaAcademica");
        while(resultado.next()){
          String nombre = resultado.getString("nombre");
          String codigo = resultado.getString("codigo");
          escuela = new AreaAcademica(nombre, codigo);
          areasAcademicas.add(escuela);
        }
    }catch(SQLException ex){
       JOptionPane.showMessageDialog(null, ex.toString());
    }
    con.desconectar();
    return areasAcademicas;
  }
  
  
  public static ArrayList<Curso> getCursoBD(){
    ArrayList<Curso> lista = new ArrayList<Curso>();
    Conexion con = new Conexion();
    con.establecerConexion();
    ResultSet resultado;
    Curso pCurso = null;
    try{
      resultado = con.consultas("SELECT * FROM Curso");
      while(resultado.next()){
        String nombre = resultado.getString("nombre");
        String codigo = resultado.getString("codigoUnico");
        int creditos = resultado.getInt("cantidadCreditos");
        int horas = resultado.getInt("cantidadHoras");
        pCurso = new Curso(nombre, codigo, creditos, horas);
        cursos.add(pCurso);
      }
    }catch(SQLException ex){
       JOptionPane.showMessageDialog(null, ex.toString());
    }
    con.desconectar();
    return cursos;
  }
}
