/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system.businessLayer;

import java.util.ArrayList;

/**
 * Abstracción de la clase Bloque para la organización de los planes de estudio.
 * 
 * @author Dylan Abrahan
 * @author Kemuel Chavarría
 * @author Daniela Martínez
 */
public class Bloque {
  private int numeroDeBloque;
  private ArrayList<Curso> cursos;
  
  /**
   * Constructor de la clase Bloque.
   * 
   * @param pNumeroDeBloque Valor del entero que representa el semestre.
   */
  public Bloque(int pNumeroDeBloque){
    cursos = new ArrayList<Curso>();
    this.numeroDeBloque = pNumeroDeBloque;
  }
  
  /**
   * Agregar un curso al bloque.
   * 
   * @param pCurso Objeto de la clase Curso. 
   */
  public void agregarCurso(Curso pCurso){
    cursos.add(pCurso);
  }
  
  /**
   * Remover un curso del bloque.
   * 
   * @param pCurso Objeto de la clase curso.
   * @return El estado de la búsqueda.
   */
  public boolean quitarCurso(Curso pCurso){
    boolean encontrado = false;
    for(Curso buscar: cursos){
      if(buscar.getCodigo().equals(pCurso.getCodigo())){
        cursos.remove(buscar);
        System.out.println("Curso removido.");
        encontrado = true;
        break;
      }
    }
    return encontrado;
  }
  
  // Métodos accesores
  public void setNumeroDeBloque(int pNumeroDeBloque){
    this.numeroDeBloque = pNumeroDeBloque;
  }
  public int getNumeroDeBloque(){
    return this.numeroDeBloque;
  }
}
