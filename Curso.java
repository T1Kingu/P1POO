/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system.businessLayer;

import java.util.ArrayList;

/**
 * Esta clase describe el comportamiento de un curso.
 * 
 * @author Dylan Abrahan
 * @author Kemuel Chavarría
 * @author Daniela Martínez
 * @version 1.0
 */
public class Curso {
  private String nombre;
  private String codigo;
  private int cantidadDeCreditos;
  private int cantidadDeHorasLectivas;
  private ArrayList<Curso> correquisitos;
  private ArrayList<Curso> requisitos;
  
  /**
   * Constructor de la clase Curso.
   * 
   * @param pNombre                  Nombre del curso.
   * @param pCodigo                  Código alfanúmerico.
   * @param pCantidadDeCreditos      Creditos del curso.
   * @param pCantidadDeHorasLectivas Horas a la semana.
   */
  public Curso(String pNombre, String pCodigo, int pCantidadDeCreditos, int pCantidadDeHorasLectivas){
    correquisitos = new ArrayList<Curso>();
    requisitos = new ArrayList<Curso>();
    setNombre(pNombre);
    setCodigo(pCodigo);
    setCantidadDeCreditos(pCantidadDeCreditos);
    setCantidadDeHorasLectivas(pCantidadDeHorasLectivas);
  }
  
  /**
   * Asociar un curso como correquisito.
   * 
   * @param pCurso
   */
  public void asociarCorrequisito(Curso pCurso){
    this.correquisitos.add(pCurso);
  }

  /**
   * Asociar un curso como requisito.
   * 
   * @param pCurso
   */
  public void asociarRequisito(Curso pCurso){
    this.requisitos.add(pCurso);
  }

  //Métodos accesores.
  public void setNombre(String pNombre){
    this.nombre = pNombre;
  }
  public void setCodigo(String pCodigo){
    this.codigo = pCodigo;
  }
  public void setCantidadDeCreditos(int pCantidadDeCreditos){
    this.cantidadDeCreditos = pCantidadDeCreditos;
  }
  public void setCantidadDeHorasLectivas(int pCantidadDeHorasLectivas){
    this.cantidadDeHorasLectivas = pCantidadDeHorasLectivas;
  }
  public String getNombre(){
    return this.nombre;
  }
  public String getCodigo(){
    return this.codigo;
  }
  public int getCantidadDeCreditos(){
    return this.cantidadDeCreditos;
  }
  public int getCantidadDeHorasLectivas(){
    return this.cantidadDeHorasLectivas;
  }
}
