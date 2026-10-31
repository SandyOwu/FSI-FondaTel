
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JDOrdenes extends javax.swing.JDialog {
   
    private Conexion cnx;

    // Consultas para llenar las listas desplegables (código/id + nombre)
    private static final String CLIENTES = "SELECT codigoc, nombrec FROM clientes ORDER BY nombrec";
    private static final String MESAS = "SELECT numero FROM mesas ORDER BY numero";
    private static final String ALIMENTOS = "SELECT idalimentos, nombre FROM alimentos ORDER BY nombre";
    private static final String MESEROS = "SELECT codigo, nombree FROM empleados WHERE puesto = 'Mesero' ORDER BY nombree";
    private static final String COCINEROS = "SELECT codigo, nombree FROM empleados WHERE puesto = 'Cocinero' ORDER BY nombree";

    public JDOrdenes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        SFecha.setEditor(new javax.swing.JSpinner.DateEditor(SFecha, "yyyy-MM-dd HH:mm:ss"));
        SFecha.setValue(new Date()); // una orden nueva arranca con la fecha y hora actuales
    }

    // Debe llamarse ANTES de obtenerOrden(): aquí se llenan las listas desplegables
    public void obtenerConexion(Conexion cnx) {
        this.cnx = cnx;
        llenarCombo(CBCliente, CLIENTES, true);
        llenarCombo(CBMesa, MESAS, false);
        llenarCombo(CBAlimento, ALIMENTOS, true);
        llenarCombo(CBMesero, MESEROS, true);
        llenarCombo(CBCocinero, COCINEROS, true);
    }
    
    public void obtenerOrden(Orden order){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            TFFolio.setText(String.valueOf(order.folio));
            SFecha.setValue(format.parse(order.fecha));
            seleccionar(CBCliente, String.valueOf(order.cliente));
            seleccionar(CBMesa, String.valueOf(order.mesa));
            SSilla.setValue(order.silla);
            seleccionar(CBAlimento, String.valueOf(order.alimento));
            seleccionar(CBMesero, order.mesero);
            seleccionar(CBCocinero, order.cocinero);
            CBEstado.setSelectedItem(order.estado);
            TFObservaciones.setText(order.observaciones);
        } catch (ParseException ex) {
            Logger.getLogger(JDOrdenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Orden crearOrden() {
        if (CBCliente.getSelectedItem() == null
                || CBMesa.getSelectedItem() == null
                || CBAlimento.getSelectedItem() == null
                || CBMesero.getSelectedItem() == null
                || CBCocinero.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona cliente, mesa, alimento, mesero y cocinero");
            return null;
        }

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        int folio = 0; // el folio es automático; sólo existe cuando se está editando
        try {
            folio = Integer.parseInt(TFFolio.getText().trim());
        } catch (NumberFormatException ex) {
        }

        String obs = TFObservaciones.getText().trim();
        if (obs.isEmpty()) {
            obs = "N/A";
        }

        return new Orden(folio,
                s.format((Date) SFecha.getValue()),
                obs,
                CBEstado.getSelectedItem().toString(),
                (Integer) SSilla.getValue(),
                Integer.parseInt(idDe(CBCliente)),
                Integer.parseInt(idDe(CBMesa)),
                Integer.parseInt(idDe(CBAlimento)),
                idDe(CBMesero),
                idDe(CBCocinero)
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TFFolio = new javax.swing.JTextField();
        SFecha = new javax.swing.JSpinner();
        CBCliente = new javax.swing.JComboBox<>();
        CBMesa = new javax.swing.JComboBox<>();
        SSilla = new javax.swing.JSpinner();
        CBAlimento = new javax.swing.JComboBox<>();
        CBMesero = new javax.swing.JComboBox<>();
        CBCocinero = new javax.swing.JComboBox<>();
        CBEstado = new javax.swing.JComboBox<>();
        TFObservaciones = new javax.swing.JTextField();
        BRegistrar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(507, 486));
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(507, 760));

        jLabel1.setText("Folio:");

        jLabel2.setText("Fecha y hora:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Mesa:");

        jLabel5.setText("Silla:");

        jLabel6.setText("Alimento:");

        jLabel7.setText("Mesero:");

        jLabel8.setText("Cocinero:");

        jLabel9.setText("Estado:");

        jLabel10.setText("Observaciones:");

        TFFolio.setBackground(new java.awt.Color(204, 204, 255));
        TFFolio.setEditable(false);
        TFFolio.setForeground(new java.awt.Color(0, 0, 0));
        TFFolio.setText("Automático");

        SFecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1791931190653L), null, null, java.util.Calendar.DAY_OF_MONTH));

        SSilla.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenado", "Preparando", "Entregado", "Devuelto", "Cancelado", "Pagado" }));

        TFObservaciones.setBackground(new java.awt.Color(204, 204, 255));
        TFObservaciones.setForeground(new java.awt.Color(0, 0, 0));
        TFObservaciones.setText("N/A");

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

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel11.setText("DATOS DE LA ORDEN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                        )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSilla, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBCocinero, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CBMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SSilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CBAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CBMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CBCocinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TFObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
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
        Orden order = crearOrden();
        if (order == null) {
            return;
        }

        if (order.insertar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Orden registrada");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar el registro");
        }

    }//GEN-LAST:event_BRegistrarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        Orden order = crearOrden();
        if (order == null) {
            return;
        }

        if (order.actualizar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Datos de la orden actualizados");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar la actualización de datos");
        }

    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        Orden order = new Orden();
        try {
            order.folio = Integer.parseInt(TFFolio.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Selecciona una orden registrada para borrarla");
            return;
        }

        if (order.borrar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Datos de la orden borrados");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al borrar los datos (verifica que no tenga órdenes asociadas)");
        }
    }//GEN-LAST:event_BBorrarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BCancelarActionPerformed

    // Llena un combo con "id - nombre" (o sólo el id cuando conNombre es false)
    private void llenarCombo(javax.swing.JComboBox<String> combo, String sql, boolean conNombre) {
        combo.removeAllItems();
        try (Statement st = cnx.con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                if (conNombre) {
                    combo.addItem(rs.getString(1) + " - " + rs.getString(2));
                } else {
                    combo.addItem(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // Regresa sólo el id/código del elemento seleccionado ("M01 - Juan Perez" -> "M01")
    private String idDe(javax.swing.JComboBox<String> combo) {
        String item = combo.getSelectedItem().toString();
        int pos = item.indexOf(" - ");
        return (pos >= 0) ? item.substring(0, pos) : item;
    }

    // Selecciona en el combo el elemento cuyo id/código coincide
    private void seleccionar(javax.swing.JComboBox<String> combo, String id) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            String item = combo.getItemAt(i);
            if (item.equals(id) || item.startsWith(id + " - ")) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

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
            java.util.logging.Logger.getLogger(JDOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDOrdenes dialog = new JDOrdenes(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> CBAlimento;
    private javax.swing.JComboBox<String> CBCliente;
    private javax.swing.JComboBox<String> CBCocinero;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JComboBox<String> CBMesa;
    private javax.swing.JComboBox<String> CBMesero;
    private javax.swing.JSpinner SFecha;
    private javax.swing.JSpinner SSilla;
    private javax.swing.JTextField TFFolio;
    private javax.swing.JTextField TFObservaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
