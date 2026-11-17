
import javax.swing.JOptionPane;


public class FCajero extends javax.swing.JFrame {

    Conexion cnx = new Conexion();
    String todo = "SELECT * FROM tickets";
    String meseros = "SELECT DISTINCT empleados_codigo_mesero FROM tickets";
    String por_meseros = "SELECT * FROM tickets WHERE empleados_codigo_mesero = '%s' ORDER BY nombree";
    
    
    public FCajero() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Tickets de FondaTel");
        
        
        
        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            cnx.entablar(todo, TCajero);
            cnx.seleccionar(meseros, CBMeseros);
        } else{
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        }   
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TCajero = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        BTotal = new javax.swing.JButton();
        BRecientes = new javax.swing.JButton();
        BMayor = new javax.swing.JButton();
        CBMeseros = new javax.swing.JComboBox<>();
        LTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TCajero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TCajero);

        jToolBar1.setRollover(true);

        BTotal.setText("TOTAL DE VENTAS");
        BTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTotalActionPerformed(evt);
            }
        });
        jToolBar1.add(BTotal);

        BRecientes.setText("PEDIDIOS RECIENTES");
        BRecientes.setFocusable(false);
        BRecientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BRecientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BRecientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRecientesActionPerformed(evt);
            }
        });
        jToolBar1.add(BRecientes);

        BMayor.setText("MAYOR PRECIO");
        BMayor.setFocusable(false);
        BMayor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BMayor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMayorActionPerformed(evt);
            }
        });
        jToolBar1.add(BMayor);

        CBMeseros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBMeseros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMeserosActionPerformed(evt);
            }
        });
        jToolBar1.add(CBMeseros);

        LTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LTotal.setText("$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTotalActionPerformed
        String total = "SELECT SUM(precio) AS total FROM tickets";
        LTotal.setText(total);
    }//GEN-LAST:event_BTotalActionPerformed

    private void BRecientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRecientesActionPerformed
        String recientes = "SELECT * FROM tickets ORDER BY folio DESC";
        cnx.entablar(recientes, TCajero);
    }//GEN-LAST:event_BRecientesActionPerformed

    private void BMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMayorActionPerformed
        String mayor = "SELECT * FROM tickets ORDER BY precio DESC";
        cnx.entablar(mayor, TCajero);
    }//GEN-LAST:event_BMayorActionPerformed

    private void CBMeserosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMeserosActionPerformed
        String cat = CBMeseros.getSelectedItem().toString();
        
        if (cat.equals("Todos")) {
            cnx.entablar(todo, TCajero);
        } else {
            String sql = String.format(por_meseros, cat);
            cnx.entablar(sql, TCajero);
        }
        
    }//GEN-LAST:event_CBMeserosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BMayor;
    private javax.swing.JButton BRecientes;
    private javax.swing.JButton BTotal;
    private javax.swing.JComboBox<String> CBMeseros;
    private javax.swing.JLabel LTotal;
    private javax.swing.JTable TCajero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
