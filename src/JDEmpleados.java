
import javax.swing.JOptionPane;

public class JDEmpleados extends javax.swing.JDialog {
   
    private Conexion cnx;

    public JDEmpleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    public void obtenerConexion(Conexion cnx) {
        this.cnx = cnx;
    }
    
    public void obtenerEmpleado(Empleado emp){
        TFCodigo.setText(emp.codigo);
        TFNombre.setText(emp.nombre);
        CBPuesto.setSelectedItem(emp.puesto);
        TFUsuario.setText(emp.usuario);
        PFNip.setText(emp.nip);
        CBTurno.setSelectedItem(emp.turno);
        CBEstado.setSelectedItem(emp.estado);
    }

    private Empleado crearEmpleado() {
        if (TFCodigo.getText().trim().isEmpty()
                || TFNombre.getText().trim().isEmpty()
                || TFUsuario.getText().trim().isEmpty()
                || PFNip.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Completa código, nombre, usuario y NIP");
            return null;
        }

        return new Empleado(TFCodigo.getText().trim(),
                TFNombre.getText().trim(),
                CBPuesto.getSelectedItem().toString(),
                TFUsuario.getText().trim(),
                new String(PFNip.getPassword()),
                CBTurno.getSelectedItem().toString(),
                CBEstado.getSelectedItem().toString()
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TFCodigo = new javax.swing.JTextField();
        TFNombre = new javax.swing.JTextField();
        CBPuesto = new javax.swing.JComboBox<>();
        TFUsuario = new javax.swing.JTextField();
        PFNip = new javax.swing.JPasswordField();
        CBTurno = new javax.swing.JComboBox<>();
        CBEstado = new javax.swing.JComboBox<>();
        BRegistrar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(507, 486));
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(507, 620));

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Puesto:");

        jLabel4.setText("Usuario:");

        jLabel5.setText("NIP:");

        jLabel6.setText("Turno:");

        jLabel7.setText("Estado:");

        TFCodigo.setBackground(new java.awt.Color(204, 204, 255));
        TFCodigo.setForeground(new java.awt.Color(0, 0, 0));

        TFNombre.setBackground(new java.awt.Color(204, 204, 255));
        TFNombre.setForeground(new java.awt.Color(0, 0, 0));

        CBPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cocinero", "Mesero", "Cajero", "Gerente" }));

        TFUsuario.setBackground(new java.awt.Color(204, 204, 255));
        TFUsuario.setForeground(new java.awt.Color(0, 0, 0));

        PFNip.setBackground(new java.awt.Color(204, 204, 255));
        PFNip.setForeground(new java.awt.Color(0, 0, 0));

        CBTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Nocturno", "Completo" }));

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

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

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("DATOS DEL EMPLEADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                        )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PFNip, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PFNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CBTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
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
        Empleado emp = crearEmpleado();
        if (emp == null) {
            return;
        }

        if (emp.insertar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Empleado registrado");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar el registro");
        }

    }//GEN-LAST:event_BRegistrarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        Empleado emp = crearEmpleado();
        if (emp == null) {
            return;
        }

        if (emp.actualizar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Datos del empleado actualizados");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar la actualización de datos");
        }

    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        Empleado emp = new Empleado();
        emp.codigo = TFCodigo.getText().trim();
        if (emp.codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escribe el código del empleado");
            return;
        }

        if (emp.borrar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Datos del empleado borrados");
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
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDEmpleados dialog = new JDEmpleados(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JComboBox<String> CBPuesto;
    private javax.swing.JComboBox<String> CBTurno;
    private javax.swing.JPasswordField PFNip;
    private javax.swing.JTextField TFCodigo;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
