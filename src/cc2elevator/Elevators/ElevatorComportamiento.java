/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc2elevator.Elevators;

import java.util.ArrayList;

/**
 *
 * @author Jorge Aguilar
 */
public class ElevatorComportamiento implements Elevator {

    private int pisoactual, pesomax, idelevador;
    private int direccion;
    public static int ARRIBA = 1;
    public static int ABAJO = 0;

    ArrayList<Piso> PasajerosSuben, PasajerosBajan, Destinos;

    public ElevatorComportamiento(int pisoactual) {
        this.idelevador = idelevador;
        this.pisoactual = pisoactual;
        PasajerosSuben = new ArrayList<Piso>();
        PasajerosBajan = new ArrayList<Piso>();
        Destinos = new ArrayList<Piso>();
    }

    public int getPisoactual() {
        return pisoactual;
    }

    public void setPisoactual(int pisoactual) {
        this.pisoactual = pisoactual;
    }

    public int getPesomax() {
        return pesomax;
    }

    public void setPesomax(int pesomax) {
        this.pesomax = pesomax;
    }

    public int getId() {
        return idelevador;
    }

    public void setId(int id) {
        this.idelevador = id;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public static int getARRIBA() {
        return ARRIBA;
    }

    public static void setARRIBA(int ARRIBA) {
        ElevatorComportamiento.ARRIBA = ARRIBA;
    }

    public static int getABAJO() {
        return ABAJO;
    }

    public static void setABAJO(int ABAJO) {
        ElevatorComportamiento.ABAJO = ABAJO;
    }

    public ArrayList<Piso> getPasajerosSuben() {
        return PasajerosSuben;
    }

    public void setPasajerosSuben(ArrayList<Piso> PasajerosSuben) {
        this.PasajerosSuben = PasajerosSuben;
    }

    public ArrayList<Piso> getPasajerosBajan() {
        return PasajerosBajan;
    }

    public void setPasajerosBajan(ArrayList<Piso> PasajerosBajan) {
        this.PasajerosBajan = PasajerosBajan;
    }

    public ArrayList<Piso> getDestinos() {
        return Destinos;
    }

    public void setDestinos(ArrayList<Piso> Destinos) {
        this.Destinos = Destinos;
    }

    @Override
    public String addCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int pressButtonPiso(int piso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String resetElevator(int piso, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addTime(int time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String log(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
