
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JDAlimentos extends javax.swing.JDialog {
   
    private Conexion cnx;
    private byte[] foto = new byte[0];
    ImageIcon = cartel;

    public JDAlimentos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    public void obtenerConexion(Conexion cnx) {
        this.cnx = cnx;
    }
    
    public void obtenerAlimento(Alimento food){
        TFId.setText(String.valueOf(food.id));
        TFNombre.setText(food.nombre);
        TFDescripcion.setText(food.descripcion);
        TFPrecio.setText(String.valueOf(food.precio));
        CBCategoria.setSelectedItem(food.categoria);
        CBEstado.setSelectedItem(food.estado);
        foto = (food.foto != null) ? food.foto : new byte[0];
        mostrarFoto();
    }

    private Alimento crearAlimento() {
        if (TFNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escribe el nombre del alimento");
            return null;
        }

        float precio;
        try {
            precio = Float.parseFloat(TFPrecio.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido");
            return null;
        }

        int id = 0; 
        try {
            id = Integer.parseInt(TFId.getText().trim());
        } catch (NumberFormatException ex) {
        }

        return new Alimento(id,
                TFNombre.getText().trim(),
                TFDescripcion.getText().trim(),
                precio,
                foto,
                CBCategoria.getSelectedItem().toString(),
                CBEstado.getSelectedItem().toString()
        );
    }

    private void mostrarFoto() {
        if (foto != null && foto.length > 0) {
            Image img = new ImageIcon(foto).getImage().getScaledInstance(160, 110, Image.SCALE_SMOOTH);
            LFoto.setIcon(new ImageIcon(img));
            LFoto.setText("");
        } else {
            LFoto.setIcon(null);
            LFoto.setText("Sin foto");
        }
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
        TFId = new javax.swing.JTextField();
        TFNombre = new javax.swing.JTextField();
        TFDescripcion = new javax.swing.JTextField();
        TFPrecio = new javax.swing.JTextField();
        CBCategoria = new javax.swing.JComboBox<>();
        CBEstado = new javax.swing.JComboBox<>();
        LFoto = new javax.swing.JLabel();
        BFoto = new javax.swing.JButton();
        BRegistrar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        BConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(507, 486));
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(507, 720));

        jLabel1.setText("ID:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descripción:");

        jLabel4.setText("Precio:");

        jLabel5.setText("Categoría:");

        jLabel6.setText("Estado:");

        jLabel7.setText("Foto:");

        TFId.setEditable(false);
        TFId.setBackground(new java.awt.Color(204, 204, 255));
        TFId.setForeground(new java.awt.Color(0, 0, 0));

        TFNombre.setBackground(new java.awt.Color(204, 204, 255));
        TFNombre.setForeground(new java.awt.Color(0, 0, 0));

        TFDescripcion.setBackground(new java.awt.Color(204, 204, 255));
        TFDescripcion.setForeground(new java.awt.Color(0, 0, 0));

        TFPrecio.setBackground(new java.awt.Color(204, 204, 255));
        TFPrecio.setForeground(new java.awt.Color(0, 0, 0));

        CBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Plato principal", "Postre", "Bebida" }));

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Agotado" }));

        LFoto.setBackground(new java.awt.Color(204, 204, 255));
        LFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LFoto.setText("Sin foto");
        LFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LFoto.setOpaque(true);

        BFoto.setText("SELECCIONAR FOTO");
        BFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFotoActionPerformed(evt);
            }
        });

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
        jLabel8.setText("DATOS DEL ALIMENTO");

        TConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Precio", "Categoria", "Estado", "Foto"
            }
        ));
        jScrollPane1.setViewportView(TConsultas);

        BConsultar.setText("CONSULTAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(32, 32, 32)
                                .addComponent(LFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(BFoto)
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(32, 32, 32)
                                        .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BRegistrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(BActualizar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BBorrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(BCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(BConsultar)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(338, 338, 338))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BFoto)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BRegistrar)
                            .addComponent(BActualizar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BBorrar)
                            .addComponent(BCancelar)
                            .addComponent(BConsultar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegistrarActionPerformed
        Alimento food = crearAlimento();
        if (food == null) {
            return;
        }

        if (food.insertar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Alimento registrado");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar el registro");
        }
        
        
        
        
        
        
        
        String id = TFId.getText().trim();
    String nom = TFNombre.getText().trim();
    String des = TFDescripcion.getText().trim();
        String prec = TFPrecio.getText();
        String cat = (String) CBCategoria.getSelectedItem();
        String est = (String) CBEstado.getSelectedItem();

    // Validar campos de texto
    if (id.isEmpty() || nom.isEmpty() || des.isEmpty() || prec.isEmpty() || cat.isEmpty() || est.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese la clave y el título.");
        return;
    }

    // Validar que se haya seleccionado un cartel
    if (cartel == null) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen de cartel antes de registrar.");
        return;
    }

    Alimentos aa = new Alimento(id, nom, des, prec, cat, est, a);
    if (pp.insertar(cnx) == 1) {
        JOptionPane.showMessageDialog(this, "Película registrada correctamente.");
        cnx.entablar("SELECT * FROM peliculas", TConsultas, 20, 40, 40);
        
        // Limpiar controles
        TClave.setText("");
        TTitulo.setText("");
        LCartel.setIcon(null);
        cartel = null;
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo registrar la película.");
    }
        
        
    }//GEN-LAST:event_BRegistrarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        Alimento food = crearAlimento();
        if (food == null) {
            return;
        }

        if (food.actualizar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Datos del alimento actualizados");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar la actualización de datos");
        }

    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        Alimento food = new Alimento();
        try {
            food.id = Integer.parseInt(TFId.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Selecciona un alimento registrado para borrarlo");
            return;
        }

        if (food.borrar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Datos del alimento borrados");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al borrar los datos (verifica que no tenga órdenes asociadas)");
        }
    }//GEN-LAST:event_BBorrarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BFotoActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Imágenes (jpg, png, gif)", "jpg", "jpeg", "png", "gif"));

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                foto = Files.readAllBytes(fc.getSelectedFile().toPath());
                mostrarFoto();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo leer la imagen");
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
            java.util.logging.Logger.getLogger(JDAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDAlimentos dialog = new JDAlimentos(new javax.swing.JFrame(), true);
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
}
