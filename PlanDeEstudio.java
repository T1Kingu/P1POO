/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system.businessLayer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Esta clase describe el comportamiento de un plan de estudio.
 * 
 * @author Dylan Abrahan
 * @author Kemuel Chavarría
 * @author Daniela Martínez
 * @version 1.0
 */
public class PlanDeEstudio {
  private int numeroDePlan;
  private LocalDate fechaDeEntrada;
  private ArrayList<Bloque> bloques;
  
  /**
   * Constructor de la clase PlanDeEstudio.
   * 
   * @param pNumeroDePlan   Código consecutivo númerico de cuatro dígitos.
   * @param pFechaDeEntrada Fecha en la que el plan de estudios entra en vigencia.
   */
  public PlanDeEstudio(int pNumeroDePlan, String pFechaDeEntrada){
    this.bloques = new ArrayList<Bloque>();
    setNumeroDePlan(pNumeroDePlan);
    setFechaDeEntrada(pFechaDeEntrada);
  }
 
  /**
   * Agregar un bloque al plan de estudios.
   * 
   * @param pBloque Objeto de la clase bloque. 
   */
  public void agregarBloque(Bloque pBloque){
    this.bloques.add(pBloque);
  }

  //Métodos accesores.
  public void setNumeroDePlan(int pNumeroDePlan){
    this.numeroDePlan = pNumeroDePlan;
  }
  public void setFechaDeEntrada(String pFechaDeEntrada){
    //"2020-07-06"
    this.fechaDeEntrada = LocalDate.parse(pFechaDeEntrada);
  }
  public int getNumeroDePlan(){
    return this.numeroDePlan;
  }
  public String getFechaDeEntrada(){
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return this.fechaDeEntrada.format(formato);
  }
}
