/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc2elevator.Elevators;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.DefaultListModel;

/**
 *
 * @author ejuarez
 */
public class ElevatorPanel extends javax.swing.JPanel implements Runnable,Elevator {
    
    
    //cantidad de niveles del elevador
    int levels;
    ArrayList<Integer> selectedind = new ArrayList<Integer>();
    
    
    Thread hilo;
    
    
    
    long movetime;
    long stoptime;
    int ID;
    int direccion;
    int Actual;
    int cantpeticion;
    
    Queue<Integer> colaPeticion=new LinkedList();
//    int atributo=40;
    
    DefaultListModel listModel = new DefaultListModel();
    /**
     * Creates new form ElevatorPanel
     */
    public ElevatorPanel() {
        initComponents();
    }
    //LLENA LA LISTA de niveles
    public void startlevel(int level){
        
        
        for (int j=0;j<level;j++){
           listModel.addElement(String.valueOf(j+1));
        }
        this.jList1.setModel(listModel);
        jList1.setSelectedIndex(0);
        
        this.jTextField1.setText(String.valueOf(ID));
        this.jTextField3.setText(String.valueOf(Actual+1));
        this.jTextField2.setText(String.valueOf(direccion));
        selectedind.add(Actual);
        
        
        
    }
    
 
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
            
            if (colaPeticion.isEmpty()){
                Thread.sleep(10000);
            }else{
                int pisoobjetivo=colaPeticion.peek();
                this.jLabel4.setEnabled(false);
                        this.jTextField4.setEnabled(false);
                
                if (pisoobjetivo>Actual){
                    Thread.sleep(movetime);
                    Actual++;
                    direccion=1;
                    this.jTextField3.setText(String.valueOf(Actual+1));
                    this.jTextField2.setText(String.valueOf(direccion));
                    selectedind.set(0, Actual);
                    jList1.setSelectedIndices(arrayselect());
                }else{
                    if (pisoobjetivo<Actual){
                        Thread.sleep(movetime);
                        Actual--;
                        direccion=-1;
                        this.jTextField3.setText(String.valueOf(Actual+1));
                        this.jTextField2.setText(String.valueOf(direccion));
                        selectedind.set(0, Actual);
                        jList1.setSelectedIndices(arrayselect());
                    }else{
                        this.jLabel4.setEnabled(true);
                        this.jTextField4.setEnabled(true);
                        Thread.sleep(stoptime);
                        Actual=pisoobjetivo;
                        for (int p=0;p<selectedind.size();p++){
                            if (selectedind.get(p)==Actual){
                                selectedind.remove(p);
                                 jList1.setSelectedIndices(arrayselect());
                                 
                            }
                        }
                        
                        
                        direccion=0;
                        colaPeticion.remove();
                        
                        
                        this.jTextField3.setText(String.valueOf(Actual+1));
                        this.jTextField2.setText(String.valueOf(direccion));
                        
                        
                        
                        //agregando nueva peticion.
                        
                        
                        
                        if (!(this.jTextField4.getText()==null) && (!this.jTextField4.getText().equals(""))){
                            colaPeticion.add(Integer.parseInt(this.jTextField4.getText()));
                        }
                    }
                }
            }
            //ESTO ES PARA EL MOVIMIENTO AQUI DEBERIAN IR LOS MOVIMIENTOS*************************************************
            /*
            Thread.sleep(timesl);
            atributo--;
            this.jTextField1.setText(String.valueOf(atributo));
            if (atributo==10){
                
            }
            */
            //ESTO ES PARA EL MOVIMIENTO AQUI DEBERIAN IR LOS MOVIMIENTOS*************************************************
            
            
        }catch (InterruptedException e) { }
       //tareas a realizar...
    }
    }
     public void stop(){
       hilo=null;
  }
     
    public int[] arrayselect(){
        int[] intArray = new int[selectedind.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = selectedind.get(i);
        }
        return intArray;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);

        jLabel1.setText("Direccion");

        jLabel2.setText("Piso Actual");

        jLabel3.setText("ID");

        jTextField3.setEditable(false);

        jButton2.setText("Mostrar Log");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setViewportView(jList1);

        jLabel4.setText("Piso al que desea ir:");
        jLabel4.setEnabled(false);

        jTextField4.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jTextField4))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<Integer> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void pushUp(int level) {
        colaPeticion.add(level);
        selectedind.add(level);
        
        jList1.setSelectedIndices(arrayselect());
        
    }

    @Override
    public void pushDown(int level) {
        colaPeticion.add(level);
        selectedind.add(level);
        
        jList1.setSelectedIndices(arrayselect());
    }

    @Override
    public int getID() {
        return ID;
    }


    @Override
    public int getPisoActual() {
        return Actual;
    }


    @Override
    public int Reset() {
        while (!colaPeticion.isEmpty()){
               colaPeticion.remove();
        }
        colaPeticion.add(0);        
        return 0;

    }

    @Override
    public int getCantidadPeticionesCola() {
       return colaPeticion.size();
    }

    @Override
    public int getDireccion() {
       return direccion;
    }

    @Override
    public void setTime(long stopt, long movet) {
        
        stoptime=stopt;
        movetime=movet;
        System.out.println("tiempo de parada"+stoptime);
        System.out.println("tiempo de movimiento"+movetime);
    }

    @Override
    public void setID(int ident) {
       ID=ident;
    }

    @Override
    public void setDireccion(int dir) {
        direccion=dir;
    }

    @Override
    public void setPisoActual(int pact) {
        Actual=pact;
    }
}
