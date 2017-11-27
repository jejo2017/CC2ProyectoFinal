/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc2elevator.ElevatorManager;

import cc2elevator.Elevators.MiCallable;
import static java.lang.Math.abs;




/**
 *
 * @author ejuarez
 */
public class ElevatorManager implements Manager{
    private long stopt;
    private long movet;
    private int levels;
    private int nelevator;
    MiCallable[] poolElevator;
    
    
    public ElevatorManager(){}
    
    public void pushUp(int level) {
        
        int nl=10000;
        int val=-1;
        for (int i=0;i<nelevator;i++){
            
            System.out.println("valor absoluto"+abs(poolElevator[i].getAtributo()-level));
            
            if (abs(poolElevator[i].getAtributo()-level)<nl){
                if (poolElevator[i].getAtributo()<level){
                    if ((poolElevator[i].getDireccion()==1) || (poolElevator[i].getDireccion()==0)){
                        System.out.println("entra");
                        val=i;
                        nl=abs(poolElevator[i].getAtributo()-level);
                    }
                }else{
                    //cuando el elevador se encuentra arriba del nivel actual, va hacia abajo y 
                    if ((poolElevator[i].getDireccion()==-1) || (poolElevator[i].getDireccion()==0)){
                        System.out.println("entra");
                        val=i;
                        nl=abs(poolElevator[i].getAtributo()-level);
                    }
                }
                
            }
        }
        
        int cp=5000;
        
        if (val==-1){
            for (int i=0;i<nelevator;i++){
            
                if ((abs(poolElevator[i].getAtributo()-level)+poolElevator[i].getCantPet())<cp){
                    System.out.println("entra");
                    val=i;
                    cp=(abs(poolElevator[i].getAtributo()-level)+poolElevator[i].getCantPet());
                }
            }
            
        }
        
        
        
        System.out.println("elevador mas cerca"+val);
        System.out.println("ELEVADOR 0 " +poolElevator[0].getAtributo());
        System.out.println("ELEVADOR 1 " +poolElevator[1].getAtributo());
        System.out.println("ELEVADOR 2 " +poolElevator[2].getAtributo());
        
        if (val<0){
            System.out.println("NO SE ENCUENTRA ELEVADOR PARA DICHA ACCION");
        }else{
            //agrega el comando de detenerse en nivel para que ingresen personas
            //poolElevator[val].addComand
        }
        
    }
    

    
    public void pushDown(int level) {
       
        int nl=10000;
        int val=-1;
        for (int i=0;i<nelevator;i++){
            
            System.out.println("valor absoluto"+abs(poolElevator[i].getAtributo()-level));
            
            if (abs(poolElevator[i].getAtributo()-level)<nl){
                if (poolElevator[i].getAtributo()>level){
                    if ((poolElevator[i].getDireccion()==-1) || (poolElevator[i].getDireccion()==0)){
                        System.out.println("entra");
                        val=i;
                        nl=abs(poolElevator[i].getAtributo()-level);
                    }
                }else{
                    if ((poolElevator[i].getDireccion()==1) || (poolElevator[i].getDireccion()==0)){
                        System.out.println("entra");
                        val=i;
                        nl=abs(poolElevator[i].getAtributo()-level);
                    }
                }
                
            }
        }
        
        int cp=5000;
        
        if (val==-1){
            for (int i=0;i<nelevator;i++){
            
                if ((abs(poolElevator[i].getAtributo()-level)+poolElevator[i].getCantPet())<cp){
                    System.out.println("entra");
                    val=i;
                    cp=(abs(poolElevator[i].getAtributo()-level)+poolElevator[i].getCantPet());
                }
            }
            
        }
        
        
    }

    
    public void setTimeSettings(long stopTime, long moveTime,int level,int qtelevator) {
        stopt=stopTime;
        movet=moveTime;
        levels=level;
        nelevator=qtelevator;
        
        poolElevator=new MiCallable[nelevator];
        
        
        
        
        for (int i=0;i<nelevator;i++){
            
            poolElevator[i]=new MiCallable();
            poolElevator[i].setTime(1000+(1000*i));
            poolElevator[i].setID(i);
            poolElevator[i].start();
        }

    }
    
    
    
}
