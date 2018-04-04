/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author softlution
 */
public class Utilerias {
   public String fecha(){
   java.text.SimpleDateFormat fecha = new java.text.SimpleDateFormat("yyyy-MM-dd");
   java.util.Date date = new java.util.Date();
   return fecha.format(date);
   
   }
}
