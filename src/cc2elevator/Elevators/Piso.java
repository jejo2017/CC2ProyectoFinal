/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc2elevator.Elevators;

/**
 *
 * @author Jorge Aguilar
 */
 public class Piso implements Elevator{

    private int nro_piso;
    private int botonsubir = 3;
    private int botonbajar = 3;
    public static int ACTIVADO = 1;
    public static int DESACTIVADO = 0;
    public static int DESTINO = -1;
    private int indicadorDestino = 3;
    int y;

    public Piso(int nro_piso) {
        this.nro_piso = nro_piso;
    }

    public int getNro_piso() {
        return nro_piso;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBotonbajar() {
        return botonbajar;
    }

    public void setBotonbajar(int botonbajar) {
        this.botonbajar = botonbajar;
    }

    public int getBotonsubir() {
        return botonsubir;
    }

    public void setBotonsubir(int botonsubir) {
        this.botonsubir = botonsubir;
    }

    public int getIndicadorDestino() {
        return indicadorDestino;
    }

    public void setIndicadorDestino(int indicadorDestino) {
        this.indicadorDestino = indicadorDestino;
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
