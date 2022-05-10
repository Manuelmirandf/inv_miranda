/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MANUEL
 */
public class ConsultarProducto extends javax.swing.JFrame {

    
    /**
     * Creates new form ConsultarProducto
     */
    public ConsultarProducto() {
        initComponents();
        
        rbNombreProducto.setSelected(true);
        rbCodigoProducto.setSelected(false);
        
        ButtonGroup grupoSeleccion = new ButtonGroup();
        grupoSeleccion.add(rbNombreProducto);
        grupoSeleccion.add(rbCodigoProducto);
        
        btnBuscar.setEnabled(false);
        
        //btnAgregarFacturaPrincipal.setEnabled(false);
        
    }
    
    public JRadioButton getRBNombreProducto(){
        return rbNombreProducto;
    }
    
    public JRadioButton getRBCodigoProducto(){
        return rbCodigoProducto;
    }
    
    public JTextField getTxtBuscar(){
        return txtNombreArticulo;
    }
    
    
    public JButton getBtnBuscar(){
        return btnBuscar;
    }
    
    public JTable getTablaProducto(){
        
        return this.jtablaProductos;
    }
    
    public DefaultTableModel getModeloVista(){
        
        DefaultTableModel mVista = (DefaultTableModel)jtablaProductos.getModel();
        
        return mVista;
    }
    
    public void setLLenarTablaVistaProducto(DefaultTableModel m){
        
        DefaultTableModel modelo = m;
        
        jtablaProductos = new JTable(m){
            public boolean isCellEditable(int row,
                     int column){
                
                     return false;
                }
        };
        
        jtablaProductos.setModel(modelo);
        
        
        jScrollPane1.setViewportView(jtablaProductos);
        
    }
    
    public void setHabiltarBotonBusqueda(boolean e){
        this.btnBuscar.setEnabled(e);
    }
    
    public void setTxtCampoCodigo(String a){
        
        txtNombreArticulo.setText(a);
    }
    
    public void setCambiarTituloEtiqueta(String a){
        jlNombreDeBusqueda.setText(a);
        txtNombreArticulo.setToolTipText("Escriba el " + a + " a Buscar");
    }
    
    public JButton getBtnAgregarFacturaPrincipal(){
        
        return this.btnAgregarFacturaPrincipal;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsultarProducto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlNombreDeBusqueda = new javax.swing.JLabel();
        txtNombreArticulo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaProductos = new javax.swing.JTable()
        ;
        jPanel1 = new javax.swing.JPanel();
        rbNombreProducto = new javax.swing.JRadioButton();
        rbCodigoProducto = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarFacturaPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Consulta de Productos");

        jlNombreDeBusqueda.setText("Nombre Del Producto");

        txtNombreArticulo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNombreArticuloCaretUpdate(evt);
            }
        });

        btnBuscar.setText("Buscar");

        jtablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jtablaProductos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Búsqueda", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        rbNombreProducto.setText("Nombre");

        rbCodigoProducto.setText("Código");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbNombreProducto)
                    .addComponent(rbCodigoProducto))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbCodigoProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pasar Codigo a Facturación"));

        btnAgregarFacturaPrincipal.setText("Facturar Codigo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnAgregarFacturaPrincipal)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btnAgregarFacturaPrincipal)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelConsultarProductoLayout = new javax.swing.GroupLayout(panelConsultarProducto);
        panelConsultarProducto.setLayout(panelConsultarProductoLayout);
        panelConsultarProductoLayout.setHorizontalGroup(
            panelConsultarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelConsultarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarProductoLayout.createSequentialGroup()
                        .addGroup(panelConsultarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarProductoLayout.createSequentialGroup()
                                .addGroup(panelConsultarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarProductoLayout.createSequentialGroup()
                                        .addComponent(jlNombreDeBusqueda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarProductoLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82)))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarProductoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
        );
        panelConsultarProductoLayout.setVerticalGroup(
            panelConsultarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarProductoLayout.createSequentialGroup()
                .addGroup(panelConsultarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelConsultarProductoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelConsultarProductoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelConsultarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(txtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNombreDeBusqueda))
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsultarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsultarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreArticuloCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNombreArticuloCaretUpdate
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNombreArticuloCaretUpdate

    public JTable getTabla(){
        return jtablaProductos;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFacturaPrincipal;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlNombreDeBusqueda;
    private javax.swing.JTable jtablaProductos;
    private javax.swing.JPanel panelConsultarProducto;
    private javax.swing.JRadioButton rbCodigoProducto;
    private javax.swing.JRadioButton rbNombreProducto;
    private javax.swing.JTextField txtNombreArticulo;
    // End of variables declaration//GEN-END:variables
}
