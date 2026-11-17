
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class FCocinero extends javax.swing.JFrame {
    
    Conexion cnx = new Conexion();
    ImageIcon icono = new ImageIcon(getClass().getResource("img/espaguetis.png"));
    String todo = "SELECT * FROM comandas";
    
    public FCocinero() {
        initComponents();    
        setLocationRelativeTo(this);
        setIconImage(icono.getImage());
        setTitle("órdenes de FondaTel");
        
        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            cnx.entablar(todo, TCocinero);
        } else{
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        } 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TCocinero = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        BEstado = new javax.swing.JButton();
        BObservaciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TCocinero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TCocinero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TCocineroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TCocinero);

        jToolBar1.setRollover(true);

        jButton1.setText("TODOS");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        BEstado.setText("CAMBIAR ESTADO");
        BEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEstadoActionPerformed(evt);
            }
        });
        jToolBar1.add(BEstado);

        BObservaciones.setText("OBSERVACIONES");
        BObservaciones.setFocusable(false);
        BObservaciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BObservaciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BObservacionesActionPerformed(evt);
            }
        });
        jToolBar1.add(BObservaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TCocineroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TCocineroMouseClicked

    }//GEN-LAST:event_TCocineroMouseClicked

    private void BEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEstadoActionPerformed
        int fila = TCocinero.getSelectedRow();
    
    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona un pedido de la tabla.");
        return;
    }

    String id = TCocinero.getValueAt(fila, 0).toString();

    String sql = "UPDATE comandas SET estadoo = 'Preparado' WHERE folio = ?";

    try (PreparedStatement ps = cnx.con.prepareStatement(sql)) {
        ps.setString(1, id);
        ps.executeUpdate();
        
        TCocinero.setValueAt("Preparando", fila, 3);
        
        JOptionPane.showMessageDialog(null, "Estado actualizado a Preparado.");
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
    }
       
    }//GEN-LAST:event_BEstadoActionPerformed

    private void BObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BObservacionesActionPerformed
        String observaciones = "SELECT folio, nombre, observaciones FROM comandas WHERE observaciones <> 'N/A'";
        cnx.entablar(observaciones, TCocinero);
    }//GEN-LAST:event_BObservacionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cnx.entablar(todo, TCocinero);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FCocinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCocinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCocinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCocinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCocinero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEstado;
    private javax.swing.JButton BObservaciones;
    private javax.swing.JTable TCocinero;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
