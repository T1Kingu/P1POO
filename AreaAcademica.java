/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system.businessLayer.universidad;
import java.util.ArrayList;
import system.businessLayer.PlanDeEstudio;

/**
 * Esta clase describe el comportamiento de una área académica de una universidad.
 * 
 * @author Dylan Abrahan
 * @author Kemuel Chavarría
 * @author Daniela Martínez
 * @version 1.0
 */
public class AreaAcademica {
  private String nombre;
  private String codigo;
  private ArrayList<PlanDeEstudio> planesDeEstudio;
  
  /**
   * Constructor de la clase AreaAcademica.
   * 
   * @param pNombre
   * @param pCodigo 
   */
  public AreaAcademica(String pNombre, String pCodigo){
    this.planesDeEstudio = new ArrayList<PlanDeEstudio>();
    setNombre(pNombre);
    setCodigo(pCodigo);
  }
  
  /**
   * Asociar un plan de estudio con la área académica.
   * 
   * @param pPlanDeEstudio Plan de estudio.
   */
  public void asociarPlanDeEstudio(PlanDeEstudio pPlanDeEstudio){
    this.planesDeEstudio.add(pPlanDeEstudio);
  }

  //Métodos accesores.
  public void setNombre(String pNombre){
    this.nombre = pNombre;
  }
  public void setCodigo(String pCodigo){
    this.codigo = pCodigo;
  }
  public String getNombre(){
    return this.nombre;
  }
  public String getCodigo(){
    return this.codigo;
  }
}
