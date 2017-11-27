/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc2elevator.Elevators;

import cc2elevator.SelectLevel;

/**
 *
 * @author ejuarez
 */
 
public class MiCallable implements Runnable {
    int atributo=40;
    Thread hilo;
    long timesl=10;
    int ID;
    int direccion=-1;
    int cantpeticion=3;


   
    
    public void start(){
     if(hilo==null){
        hilo=new Thread(this);
        hilo.start();
     }
    }
     @Override
    public void run() {
         while (true) {
        try{
            Thread.sleep(timesl);
            atributo--;
            
            if (atributo==10){
                
            }
            //System.out.println("ELEVADOR "+ID+" atributo "+atributo);
            
        }catch (InterruptedException e) { }
       //tareas a realizar...
    }
    }
     public void stop(){
       hilo=null;
  }
     public int getAtributo(){
         return atributo;
     }
     public void setTime(long t){
         timesl=t;
     }
     public void setID(int i){
         ID=i;
     }
     public int getDireccion(){
         return direccion;
     }
     public int getCantPet(){
         return cantpeticion;
     }
}
