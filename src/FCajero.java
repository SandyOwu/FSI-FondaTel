
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FCajero extends javax.swing.JFrame {

    Conexion cnx = new Conexion();
    ImageIcon icono = new ImageIcon(getClass().getResource("img/espaguetis.png"));
    String todo = "SELECT * FROM tickets";

    public FCajero() {
        initComponents();
        setLocationRelativeTo(this);
        setIconImage(icono.getImage());
        setTitle("Tickets de FondaTel");

        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            cnx.entablar(todo, TCajero);
        } else {
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
        BTodos = new javax.swing.JButton();
        BTotal = new javax.swing.JButton();
        BRecientes = new javax.swing.JButton();
        BTotalMesas = new javax.swing.JButton();
        BTotalCliente = new javax.swing.JButton();
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

        BTodos.setText("TODOS LOS PEDIDOS");
        BTodos.setFocusable(false);
        BTodos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTodos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTodosActionPerformed(evt);
            }
        });
        jToolBar1.add(BTodos);

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

        BTotalMesas.setText("TOTAL POR MESA");
        BTotalMesas.setFocusable(false);
        BTotalMesas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTotalMesas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTotalMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTotalMesasActionPerformed(evt);
            }
        });
        jToolBar1.add(BTotalMesas);

        BTotalCliente.setText("TOTAL POR CLIENTE");
        BTotalCliente.setFocusable(false);
        BTotalCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTotalCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTotalCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTotalClienteActionPerformed(evt);
            }
        });
        jToolBar1.add(BTotalCliente);

        LTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LTotal.setText("$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(LTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTotalActionPerformed
        String total = cnx.obtenerDato("SELECT SUM(precio) AS total FROM tickets");
        LTotal.setText("$" + total);
    }//GEN-LAST:event_BTotalActionPerformed

    private void BRecientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRecientesActionPerformed
        String recientes = "SELECT * FROM tickets ORDER BY folio DESC";
        cnx.entablar(recientes, TCajero);
    }//GEN-LAST:event_BRecientesActionPerformed

    private void BTotalMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTotalMesasActionPerformed
        String total_mesas = "SELECT mesas_numero, SUM(precio) AS total FROM tickets GROUP BY mesas_numero";
        cnx.entablar(total_mesas, TCajero);
    }//GEN-LAST:event_BTotalMesasActionPerformed

    private void BTotalClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTotalClienteActionPerformed
        String total_cliente = "SELECT clientes_codigoc, nombrec, SUM(precio) AS total FROM tickets GROUP BY clientes_codigoc, nombrec";
        cnx.entablar(total_cliente, TCajero);
    }//GEN-LAST:event_BTotalClienteActionPerformed

    private void BTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTodosActionPerformed
        cnx.entablar(todo, TCajero);
    }//GEN-LAST:event_BTodosActionPerformed

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
    private javax.swing.JButton BRecientes;
    private javax.swing.JButton BTodos;
    private javax.swing.JButton BTotal;
    private javax.swing.JButton BTotalCliente;
    private javax.swing.JButton BTotalMesas;
    private javax.swing.JLabel LTotal;
    private javax.swing.JTable TCajero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
