/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc2elevator.Elevators;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.DefaultListModel;
import java.util.logging.Logger;

/**
 *
 * @author ejuarez
 */
public class ElevatorPanel extends javax.swing.JPanel implements Runnable,Elevator {
    
    
    //cantidad de niveles del elevador
    int levels;
    ArrayList<Integer> selectedind = new ArrayList<Integer>();
    public boolean pausa=false;
    Logger logger = Logger.getLogger(ElevatorPanel.class.getName());
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
    
    public void agregarComando(String texto){
        String text1=this.jTextArea1.getText();
        text1+="\n";
        text1+=texto;
        this.jTextArea1.setText(text1);
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
        
        agregarComando("INICIALIZANDO ELEVADOR");
        
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
            
            if ((colaPeticion.isEmpty())){
                Thread.sleep(10000);
            }else{
                if (!pausa){
                    int pisoobjetivo=colaPeticion.peek();


                    if (pisoobjetivo>Actual){
                        Thread.sleep(movetime);
                        Actual++;
                        direccion=1;
                        this.jTextField3.setText(String.valueOf(Actual+1));
                        this.jTextField2.setText(String.valueOf(direccion));
                        //if (!selectedind.isEmpty()){
                            selectedind.set(0, Actual);
                            jList1.setSelectedIndices(arrayselect());
                        //}
                        agregarComando("MOVIENDO DEL PISO "+(Actual+1)+" AL "+(pisoobjetivo+1));

                    }else{
                        if (pisoobjetivo<Actual){
                            Thread.sleep(movetime);
                            Actual--;
                            direccion=-1;
                            this.jTextField3.setText(String.valueOf(Actual+1));
                            this.jTextField2.setText(String.valueOf(direccion));

                                selectedind.set(0, Actual);
                                jList1.setSelectedIndices(arrayselect());
                                agregarComando("MOVIENDO DEL PISO "+(Actual+1)+" AL "+(pisoobjetivo+1));

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
                            if (!colaPeticion.isEmpty()){
                                colaPeticion.remove();
                            }

                            agregarComando("ESPERANDO INSTRUCCION ");

                            this.jTextField3.setText(String.valueOf(Actual+1));
                            this.jTextField2.setText(String.valueOf(direccion));



                            //agregando nueva peticion.




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
            
            
        }catch (InterruptedException e) { 
            System.out.println("EXCEPCION-----");
        }
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
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("IR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(68, 68, 68))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton1)))))
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
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(3, 3, 3)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jLabel4.setEnabled(false);
        this.jTextField4.setEnabled(false);
        
        if (!(this.jTextField4.getText()==null) && (!this.jTextField4.getText().equals(""))){
                            colaPeticion.add(Integer.parseInt(this.jTextField4.getText())-1);
                        }
        selectedind.add(Integer.parseInt(this.jTextField4.getText())-1);
        agregarComando("INSTRUCCION USUARIO AL PISO "+this.jTextField4.getText());
        jList1.setSelectedIndices(arrayselect());
        this.jTextField4.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
        agregarComando("PETICION DE MOVIMIENTO HACIA EL PISO "+(level+1));
    }

    @Override
    public void pushDown(int level) {
        colaPeticion.add(level);
        selectedind.add(level);
        
        jList1.setSelectedIndices(arrayselect());
        agregarComando("PETICION DE MOVIMIENTO HACIA EL PISO "+(level+1));
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
        agregarComando("RESET ");
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
