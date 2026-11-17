
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class FAlimentos extends javax.swing.JFrame {
    
    Conexion cnx;
    ImageIcon icono = new ImageIcon(getClass().getResource("img/espaguetis.png"));
    ImageIcon foto;
    
    public FAlimentos() {
        initComponents();
        setIconImage(icono.getImage());
        setLocationRelativeTo(this);
        setTitle("Administración de alimentos");
        TConsultas.setRowHeight(130);
        
        cnx = new Conexion();
        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            cnx.entablar("SELECT * FROM alimentos", TConsultas);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos");
            System.exit(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CBCategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        CBEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        LFoto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BFoto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        BActualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        BBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        BCancelar = new javax.swing.JButton();
        TFNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BConsultar = new javax.swing.JButton();
        TFDescripcion = new javax.swing.JTextField();
        TFPrecio = new javax.swing.JTextField();
        TFId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        CBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Plato principal", "Postre", "Bebida" }));

        jLabel2.setText("Nombre:");

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Agotado" }));

        jLabel3.setText("Descripción:");

        LFoto.setBackground(new java.awt.Color(204, 204, 255));
        LFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LFoto.setText("Sin foto");
        LFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LFoto.setOpaque(true);

        jLabel4.setText("Precio:");

        BFoto.setText("SELECCIONAR FOTO");
        BFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFotoActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoría:");

        BRegistrar.setText("REGISTRAR");
        BRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegistrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado:");

        BActualizar.setText("ACTUALIZAR");
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });

        jLabel7.setText("Foto:");

        BBorrar.setText("BORRAR");
        BBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBorrarActionPerformed(evt);
            }
        });

        TConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Precio", "Categoria", "Estado", "Foto"
            }
        ));
        jScrollPane1.setViewportView(TConsultas);

        BCancelar.setText("CANCELAR");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        TFNombre.setBackground(new java.awt.Color(204, 204, 255));
        TFNombre.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("DATOS DEL ALIMENTO");

        BConsultar.setText("CONSULTAR");
        BConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConsultarActionPerformed(evt);
            }
        });

        TFDescripcion.setBackground(new java.awt.Color(204, 204, 255));
        TFDescripcion.setForeground(new java.awt.Color(0, 0, 0));

        TFPrecio.setBackground(new java.awt.Color(204, 204, 255));
        TFPrecio.setForeground(new java.awt.Color(0, 0, 0));

        TFId.setBackground(new java.awt.Color(204, 204, 255));
        TFId.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(347, 347, 347))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(43, 43, 43)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(32, 32, 32)
                                            .addComponent(LFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17)
                                            .addComponent(BFoto))
                                        .addComponent(CBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(43, 43, 43)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(BRegistrar)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(BActualizar))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(BBorrar)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(BCancelar)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(BConsultar))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(13, 13, 13)
                                            .addComponent(jLabel6)
                                            .addGap(45, 45, 45)
                                            .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(TFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BRegistrar)
                            .addComponent(BActualizar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BBorrar)
                            .addComponent(BCancelar)
                            .addComponent(BConsultar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BFoto)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFotoActionPerformed
        JFileChooser fc = new JFileChooser(System.getProperty("user.dif"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            foto = new ImageIcon(archivo.getPath());
            LFoto.setIcon(new ImageIcon(cnx.escalarImagen(foto.getImage(), 194, 235)));
            
        }
    }//GEN-LAST:event_BFotoActionPerformed

    private void BRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegistrarActionPerformed
       String nom = TFNombre.getText().trim();
        String des = TFDescripcion.getText().trim();
        String cat = (String) CBCategoria.getSelectedItem();
        String est = (String) CBEstado.getSelectedItem();

        // 1) Validar los campos de texto
        if (nom.isEmpty() || des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene el nombre y la descripción.");
            return;
        }

        // 2) Validar el precio (antes de convertirlo, para que no truene si está vacío o tiene letras)
        float prec;
        try {
            prec = Float.parseFloat(TFPrecio.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número, por ejemplo 125.50");
            return;
        }
        if (Float.isNaN(prec) || Float.isInfinite(prec) || prec <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser mayor que cero.");
            return;
        }

        // 3) Validar que se haya seleccionado una foto
        if (foto == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen representativa antes de registrar.");
            return;
        }

        // 4) Registrar. El id va en 0 porque la base de datos lo genera sola (AUTO_INCREMENT)
        Alimento aa = new Alimento(0, nom, des, prec, foto, cat, est);
        if (aa.insertar(cnx) == 1) {
            JOptionPane.showMessageDialog(this, "Alimento registrado correctamente.");
            cnx.entablar("SELECT * FROM alimentos", TConsultas);

            // Limpiar controles
            TFId.setText("");
            TFNombre.setText("");
            TFDescripcion.setText("");
            TFPrecio.setText("");
            CBCategoria.setSelectedIndex(0);
            CBEstado.setSelectedIndex(0);
            LFoto.setIcon(null);
            LFoto.setText("Sin foto");
            foto = null;
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar el alimento.");
        }

    }//GEN-LAST:event_BRegistrarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        int id;
        try {
            id = Integer.parseInt(TFId.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Escribe el ID del alimento a actualizar.");
            return;
        }

        String nom = TFNombre.getText().trim();
        String des = TFDescripcion.getText().trim();
        String cat = (String) CBCategoria.getSelectedItem();
        String est = (String) CBEstado.getSelectedItem();

        // 2) Validar texto (igual que en REGISTRAR)
        if (nom.isEmpty() || des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene el nombre y la descripción.");
            return;
        }

        // 3) Validar precio (igual que en REGISTRAR)
        float prec;
        try {
            prec = Float.parseFloat(TFPrecio.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número, por ejemplo 125.50");
            return;
        }
        if (Float.isNaN(prec) || Float.isInfinite(prec) || prec <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser mayor que cero.");
            return;
        }

        // 4) Actualizar. Si foto es null (no eligieron una nueva), se conserva la que ya tiene
        Alimento aa = new Alimento(id, nom, des, prec, foto, cat, est);
        if (aa.actualizar(cnx) == 1) {
            JOptionPane.showMessageDialog(this, "Datos del alimento actualizados.");
            cnx.entablar("SELECT * FROM alimentos", TConsultas);

            // Limpiar controles
            TFId.setText("");
            TFNombre.setText("");
            TFDescripcion.setText("");
            TFPrecio.setText("");
            CBCategoria.setSelectedIndex(0);
            CBEstado.setSelectedIndex(0);
            LFoto.setIcon(null);
            LFoto.setText("Sin foto");
            foto = null;
        } else {
            JOptionPane.showMessageDialog(this, "No se actualizó ningún dato (verifica que el ID exista).");
        }
    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        Alimento food = new Alimento();
        try {
            food.id = Integer.parseInt(TFId.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Escribe el ID del alimento a borrar.");
            return;
        }

        // Confirmar antes de borrar
        int resp = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres borrar el alimento con ID " + food.id + "?",
                "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) {
            return;
        }

        if (food.borrar((cnx)) == 1) {
            JOptionPane.showMessageDialog(this, "Datos del alimento borrados.");
            cnx.entablar("SELECT * FROM alimentos", TConsultas);

            // Limpiar controles (ya no se cierra la ventana)
            TFId.setText("");
            TFNombre.setText("");
            TFDescripcion.setText("");
            TFPrecio.setText("");
            CBCategoria.setSelectedIndex(0);
            CBEstado.setSelectedIndex(0);
            LFoto.setIcon(null);
            LFoto.setText("Sin foto");
            foto = null;
        } else {
            JOptionPane.showMessageDialog(this, "Error al borrar los datos (verifica que el ID exista y que no tenga órdenes asociadas).");
        }
    }//GEN-LAST:event_BBorrarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConsultarActionPerformed
                // Sin ID escrito: se muestran todos los alimentos
        if (TFId.getText().trim().isEmpty()) {
            cnx.entablar("SELECT * FROM alimentos", TConsultas);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(TFId.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
            return;
        }

        // Traer el alimento con ese ID y llenar los controles
        String sql = "SELECT nombre, descripcion, precio, foto, categoria, estado FROM alimentos WHERE idalimentos = ?";
        try (PreparedStatement ps = (PreparedStatement) cnx.con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this, "No existe un alimento con ID " + id + ".");
                    return;
                }
                TFNombre.setText(rs.getString("nombre"));
                TFDescripcion.setText(rs.getString("descripcion"));
                TFPrecio.setText(String.valueOf(rs.getFloat("precio")));
                CBCategoria.setSelectedItem(rs.getString("categoria"));
                CBEstado.setSelectedItem(rs.getString("estado"));

                byte[] bytes = rs.getBytes("foto");
                if (bytes != null && bytes.length > 0) {
                    LFoto.setText("");
                    LFoto.setIcon(new ImageIcon(Conexion.escalarImagen(new ImageIcon(bytes).getImage(), 194, 235)));
                } else {
                    LFoto.setIcon(null);
                    LFoto.setText("Sin foto");
                }
                foto = null; // la foto guardada se conserva, salvo que elijan otra con SELECCIONAR FOTO
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar: " + ex.getMessage());
            return;
        }

        // Mostrar solo ese alimento en la tabla (id es un int validado, por eso es seguro concatenarlo)
        cnx.entablar("SELECT * FROM alimentos WHERE idalimentos = " + id, TConsultas);
    }//GEN-LAST:event_BConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(FAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAlimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BConsultar;
    private javax.swing.JButton BFoto;
    private javax.swing.JButton BRegistrar;
    private javax.swing.JComboBox<String> CBCategoria;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JLabel LFoto;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTextField TFDescripcion;
    private javax.swing.JTextField TFId;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        TFId.setText("");
        TFNombre.setText("");
        TFDescripcion.setText("");
        TFPrecio.setText("");
        CBCategoria.setSelectedIndex(0);
        CBEstado.setSelectedIndex(0);
        LFoto.setIcon(null);
        LFoto.setText("Sin foto");
        foto = null;
        TConsultas.clearSelection();
    }
    
}
