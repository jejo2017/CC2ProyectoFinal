/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc2elevator.Elevators;

/**
 *
 * @author ejuarez
 */
public interface Elevator {
    public void pushUp(int level);
    public void pushDown(int level);  
    public void setTime(long stopt,long movet);
    public int getID();
    public void setID(int ident);
    public int getDireccion();
    public void setDireccion(int dir);
    public int getPisoActual();
    public void setPisoActual(int pact);
    public int Reset();
    public int getCantidadPeticionesCola();
    
}
