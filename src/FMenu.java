
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FMenu extends javax.swing.JFrame {

    Conexion cnx = new Conexion();
    ImageIcon icono = new ImageIcon(getClass().getResource("img/espaguetis.png"));

    String todo = "SELECT * FROM menu";
    String categorias = "SELECT DISTINCT categoria FROM menu";
    String por_categoria = "SELECT * FROM menu WHERE categoria = '%s' ORDER BY nombre";

    public FMenu() {
        initComponents();
        setLocationRelativeTo(this);
        setIconImage(icono.getImage());
        setTitle("Menú de FondaTel");
        TMenu.setRowHeight(100);

        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            cnx.entablar(todo, TMenu);
            cnx.seleccionar(categorias, CBCategoria);
        } else {
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BCompleto = new javax.swing.JButton();
        CBCategoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setRollover(true);

        BCompleto.setText("COMPLETO");
        BCompleto.setFocusable(false);
        BCompleto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BCompleto.setMaximumSize(new java.awt.Dimension(100, 64));
        BCompleto.setMinimumSize(new java.awt.Dimension(100, 64));
        BCompleto.setPreferredSize(new java.awt.Dimension(100, 64));
        BCompleto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCompletoActionPerformed(evt);
            }
        });
        jToolBar1.add(BCompleto);

        CBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CATEGORÍA:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        CBCategoria.setMaximumSize(new java.awt.Dimension(200, 64));
        CBCategoria.setMinimumSize(new java.awt.Dimension(200, 64));
        CBCategoria.setName(""); // NOI18N
        CBCategoria.setPreferredSize(new java.awt.Dimension(200, 64));
        CBCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBCategoriaItemStateChanged(evt);
            }
        });
        jToolBar1.add(CBCategoria);

        TMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBCategoriaItemStateChanged
        String cat = CBCategoria.getSelectedItem().toString();

        if (cat.equals("Todos")) {
            cnx.entablar(todo, TMenu);
        } else {
            String sql = String.format(por_categoria, cat);
            cnx.entablar(sql, TMenu);
        }

    }//GEN-LAST:event_CBCategoriaItemStateChanged

    private void BCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCompletoActionPerformed
        cnx.entablar(todo, TMenu);
    }//GEN-LAST:event_BCompletoActionPerformed

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
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCompleto;
    private javax.swing.JComboBox<String> CBCategoria;
    private javax.swing.JTable TMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
