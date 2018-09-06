package playafero;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ControlEstacionamient extends javax.swing.JFrame {

    Estacionamiento estacionar = new Estacionamiento();
    private Auto Auto;
    private ArrayList<Auto> lista = new ArrayList<Auto>();
    private JScrollPane jsc=new JScrollPane();
        
   public ControlEstacionamient() {
        setResizable(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sacarAuto = new javax.swing.JButton();
        ingresarAuto = new javax.swing.JButton();
        autosCochera = new javax.swing.JButton();
        buscarAuto = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sacarAuto.setText("Sacar Auto");
        sacarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacarAutoActionPerformed(evt);
            }
        });

        ingresarAuto.setText("Ingresar Auto");
        ingresarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarAutoActionPerformed(evt);
            }
        });

        autosCochera.setText("Lista de Autos en la cochera");
        autosCochera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autosCocheraActionPerformed(evt);
            }
        });

        buscarAuto.setText("Buscar auto");
        buscarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAutoActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ingresarAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(autosCochera, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sacarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sacarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autosCochera, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sacarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacarAutoActionPerformed
        // TODO add your handling code here:
        String patente = JOptionPane.showInputDialog("Patente del auto:");
        boolean pudoSacar = estacionar.sacarAuto(patente);
        if (pudoSacar) 
        {
            JOptionPane.showMessageDialog(null,"El auto se retiró del estacionamiento exitosamente");
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"No se encuentra estacionado un auto con esa patente");
        }
        
    }//GEN-LAST:event_sacarAutoActionPerformed

    private void ingresarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarAutoActionPerformed
        // TODO add your handling code here:
         String patente = JOptionPane.showInputDialog("Patente del auto:");

            if (estacionar.buscarAuto(patente) == null) 
            {
                String marca = JOptionPane.showInputDialog("Marca del auto:");
                String modeloCadena = JOptionPane.showInputDialog("Año del auto:");
                int modelo = Integer.parseInt(modeloCadena);
                Auto nuevo = new Auto(patente, marca, modelo);
                lista.add(nuevo);           
                boolean pudoEstacionar = estacionar.estacionarAuto(nuevo);
                if (pudoEstacionar) 
                {
                   JOptionPane.showMessageDialog(null,"El auto fue estacionado exitosamente.");
                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"No fue posible estacionar el auto. Intente más tarde");
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Ya hay un auto estacionado con esa patente.");
            }
    }//GEN-LAST:event_ingresarAutoActionPerformed

    private void autosCocheraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autosCocheraActionPerformed
        // TODO add your handling code here:
        if (!lista.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Autos en la cochera son \n");
            JOptionPane.showMessageDialog(null,lista.toString());    
            }
        else{ 
            JOptionPane.showMessageDialog(null,"No se encuentran autos en la playa en este momento");
            } 
    }//GEN-LAST:event_autosCocheraActionPerformed

    private void buscarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAutoActionPerformed
        // TODO add your handling code here:
        String patente = JOptionPane.showInputDialog("Patente del auto:");
        Auto auto = estacionar.buscarAuto(patente);
        if (auto == null) 
        {
            JOptionPane.showMessageDialog(null,"No se encuentra estacionado un auto con esa patente");
        }
        else
        {
             JOptionPane.showMessageDialog(null,"Los datos del auto son:  \n" +
                                    "Patente: "+ auto.getPatente() + "\n"+
                                    "Marca: "+ auto.getMarca() + "\n" +
                                    "Modelo: " + auto.getModelo());
        }
    }//GEN-LAST:event_buscarAutoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();                
    }//GEN-LAST:event_SalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton autosCochera;
    private javax.swing.JButton buscarAuto;
    private javax.swing.JButton ingresarAuto;
    private javax.swing.JButton sacarAuto;
    // End of variables declaration//GEN-END:variables
}