
import javax.swing.JOptionPane;

public class JDClientes extends javax.swing.JDialog {
   
    private Conexion cnx;

    public JDClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    public void obtenerConexion(Conexion cnx) {
        this.cnx = cnx;
    }
    
    public void obtenerCliente(Cliente client){
        TFCodigo.setText(String.valueOf(client.codigo));
        TFNombre.setText(client.nombre);
        TFRfc.setText(client.rfc == null ? "" : client.rfc);
    }

    private Cliente crearCliente() {
        int codigo;
        try {
            codigo = Integer.parseInt(TFCodigo.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El código debe ser un número entero");
            return null;
        }

        if (TFNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escribe el nombre del cliente");
            return null;
        }

        String rfc = TFRfc.getText().trim().toUpperCase();

        return new Cliente(codigo,
                TFNombre.getText().trim(),
                rfc.isEmpty() ? null : rfc // el RFC es opcional en la base de datos
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFCodigo = new javax.swing.JTextField();
        TFNombre = new javax.swing.JTextField();
        TFRfc = new javax.swing.JTextField();
        BRegistrar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(507, 486));
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(507, 460));

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("RFC:");

        TFCodigo.setBackground(new java.awt.Color(204, 204, 255));
        TFCodigo.setForeground(new java.awt.Color(0, 0, 0));

        TFNombre.setBackground(new java.awt.Color(204, 204, 255));
        TFNombre.setForeground(new java.awt.Color(0, 0, 0));

        TFRfc.setBackground(new java.awt.Color(204, 204, 255));
        TFRfc.setForeground(new java.awt.Color(0, 0, 0));

        BRegistrar.setText("REGISTRAR");
        BRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegistrarActionPerformed(evt);
            }
        });

        BActualizar.setText("ACTUALIZAR");
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });

        BBorrar.setText("BORRAR");
        BBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBorrarActionPerformed(evt);
            }
        });

        BCancelar.setText("CANCELAR");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("DATOS DEL CLIENTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                        )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        ))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BRegistrar)
                        .addGap(18, 18, 18)
                        .addComponent(BActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(BBorrar)
                        .addGap(18, 18, 18)
                        .addComponent(BCancelar))
                )
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BRegistrar)
                    .addComponent(BActualizar)
                    .addComponent(BBorrar)
                    .addComponent(BCancelar))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegistrarActionPerformed
        Cliente client = crearCliente();
        if (client == null) {
            return;
        }

        if (client.insertar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Cliente registrado");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar el registro");
        }

    }//GEN-LAST:event_BRegistrarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        Cliente client = crearCliente();
        if (client == null) {
            return;
        }

        if (client.actualizar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Datos del cliente actualizados");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar la actualización de datos");
        }

    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        Cliente client = new Cliente();
        try {
            client.codigo = Integer.parseInt(TFCodigo.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El código debe ser un número entero");
            return;
        }

        if (client.borrar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Datos del cliente borrados");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al borrar los datos (verifica que no tenga órdenes asociadas)");
        }
    }//GEN-LAST:event_BBorrarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(JDClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDClientes dialog = new JDClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BRegistrar;
    private javax.swing.JTextField TFCodigo;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFRfc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
