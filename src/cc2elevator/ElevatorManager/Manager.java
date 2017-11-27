/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc2elevator.ElevatorManager;

/**
 *
 * @author ejuarez
 */
public interface Manager {
    public void pushUp(int level);
    public void pushDown(int level);
    public void setTimeSettings(long stopTime,long moveTime,int level,int qtelevator);
    
}
