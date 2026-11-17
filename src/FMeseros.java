
import javax.swing.JOptionPane;

public class FMeseros extends javax.swing.JFrame {

    Conexion cnx = new Conexion();
    String todo = "SELECT * FROM pedidos";
    String meseros = "SELECT DISTINCT empleados_codigo_mesero FROM pedidos";
    String por_meseros = "SELECT * FROM pedidos WHERE empleados_codigo_mesero = '%s' ORDER BY nombree";
    String estado = "SELECT DISTINCT estadoo FROM pedidos";
    String por_estado = "SELECT * FROM pedidos WHERE estadoo = '%s'";

    public FMeseros() {
        initComponents();

        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            cnx.entablar(todo, TMeseros);
            cnx.seleccionar(meseros, CBMeseros);
            cnx.seleccionar(estado, CBEstado);
        } else {
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TMeseros = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        BTodos = new javax.swing.JButton();
        BEstado = new javax.swing.JButton();
        BHoy = new javax.swing.JButton();
        CBMeseros = new javax.swing.JComboBox<>();
        CBEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TMeseros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TMeseros);

        jToolBar1.setRollover(true);

        BTodos.setText("TODOS");
        BTodos.setFocusable(false);
        BTodos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTodos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTodosActionPerformed(evt);
            }
        });
        jToolBar1.add(BTodos);

        BEstado.setText("ESTADOS");
        BEstado.setFocusable(false);
        BEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BEstado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEstadoActionPerformed(evt);
            }
        });
        jToolBar1.add(BEstado);

        BHoy.setText("HOY");
        BHoy.setFocusable(false);
        BHoy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BHoy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHoyActionPerformed(evt);
            }
        });
        jToolBar1.add(BHoy);

        CBMeseros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBMeseros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MESEROS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        CBMeseros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMeserosActionPerformed(evt);
            }
        });
        jToolBar1.add(CBMeseros);

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VER POR ESTADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        CBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBEstadoActionPerformed(evt);
            }
        });
        jToolBar1.add(CBEstado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBMeserosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMeserosActionPerformed
        String codmes = CBMeseros.getSelectedItem().toString();

        if (codmes.equals("Todos")) {
            cnx.entablar(todo, TMeseros);
        } else {
            String sql = String.format(por_meseros, codmes);
            cnx.entablar(sql, TMeseros);
        }
    }//GEN-LAST:event_CBMeserosActionPerformed

    private void BEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEstadoActionPerformed
        String cont_estado = "SELECT estadoo, COUNT(*) AS ordenes FROM pedidos GROUP BY estadoo";
        cnx.entablar(cont_estado, TMeseros);
    }//GEN-LAST:event_BEstadoActionPerformed

    private void BTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTodosActionPerformed
        cnx.entablar(todo, TMeseros);
    }//GEN-LAST:event_BTodosActionPerformed

    private void BHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHoyActionPerformed
        String pedidos_hoy = "SELECT * FROM pedidos WHERE DATE(fecha_hora) = CURDATE() ORDER BY fecha_hora DESC";
        cnx.entablar(pedidos_hoy, TMeseros);
    }//GEN-LAST:event_BHoyActionPerformed

    private void CBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBEstadoActionPerformed
        String estado = CBEstado.getSelectedItem().toString();

        if (estado.equals("Todos")) {
            cnx.entablar(todo, TMeseros);
        } else {
            String sql = String.format(por_estado, estado);
            cnx.entablar(sql, TMeseros);
        }
    }//GEN-LAST:event_CBEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(FMeseros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMeseros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMeseros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMeseros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMeseros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEstado;
    private javax.swing.JButton BHoy;
    private javax.swing.JButton BTodos;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JComboBox<String> CBMeseros;
    private javax.swing.JTable TMeseros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
