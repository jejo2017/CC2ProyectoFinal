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

    String addCommand();
    int pressButtonPiso(int piso);
    String resetElevator(int piso, String direccion);
    int addTime(int time);
    String log(String texto);
    
}