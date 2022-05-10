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

public class MenuOperacionesProcesoPrincipal extends javax.swing.JFrame {

    
    
    /**
     * Creates new form MenuOperacionesProcesoPrincipal
     */
    public MenuOperacionesProcesoPrincipal() {
        initComponents();
        
        this.eliminarItem.setEnabled(false);
        
        this.txtNombreCliente.setEditable(false);
        this.txtTelefono.setEditable(false);
        this.direccionCliente.setEditable(false);
        
        this.btnBuscarClienteCabVenta.setEnabled(false);
        
        this.txtNombreProducto.setEditable(false);
        this.txtPrecioArticulo.setEditable(false);
        
        this.btnBuscarProductoCab.setEnabled(false);
        this.btnAgregarFactura.setEnabled(false);
        
        this.txtCantidadProducto.setText("1");
        
        
        this.btnFacturarPedido.setEnabled(false);
        
        
        
    }

  
    
    public void setEstableceUsuario(String a){
        labelUsuario.setText(a);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelNavegacionAtajo = new javax.swing.JPanel();
        btnImprimirFactura = new javax.swing.JButton();
        panelInformativo = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAtajoAgregarCliente = new javax.swing.JButton();
        btnDespacho = new javax.swing.JButton();
        btnDevolucion = new javax.swing.JButton();
        eliminarItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaFacturacion = new javax.swing.JTable();
        panelCabeceraFacturacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        direccionCliente = new javax.swing.JTextArea();
        btnBuscarClienteCabVenta = new javax.swing.JButton();
        panelProductos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoArticulo = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioArticulo = new javax.swing.JTextField();
        btnBuscarProductoCab = new javax.swing.JButton();
        btnAgregarFactura = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        siglaDocumento = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnFacturarPedido = new javax.swing.JButton();
        etiquetaItems = new javax.swing.JLabel();
        etiquetaTotal = new javax.swing.JLabel();
        etiquetaDivisa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        etiquetaDolar = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        jmProductos = new javax.swing.JMenu();
        jmiConsultarProducto = new javax.swing.JMenuItem();
        jmClientes = new javax.swing.JMenu();
        jmiAggCliente = new javax.swing.JMenuItem();
        jmPresupuesto = new javax.swing.JMenu();
        jmiNvoPresupuesto = new javax.swing.JMenuItem();
        jmiConsultarPresupuesto = new javax.swing.JMenuItem();
        jmDevolucion = new javax.swing.JMenu();
        jmiDevolucionTotal = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();
        jmiManualAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(214, 230, 250));
        panelPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                panelPrincipalKeyTyped(evt);
            }
        });

        panelNavegacionAtajo.setBackground(new java.awt.Color(193, 219, 252));

        btnImprimirFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/facturacion.png"))); // NOI18N
        btnImprimirFactura.setText("Pausar Facturacion");
        btnImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirFacturaActionPerformed(evt);
            }
        });

        panelInformativo.setBackground(new java.awt.Color(193, 219, 252));
        panelInformativo.setBorder(javax.swing.BorderFactory.createTitledBorder("información"));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnCerrarSesion.setText("Salir");

        jLabel1.setText("Vendedor");

        javax.swing.GroupLayout panelInformativoLayout = new javax.swing.GroupLayout(panelInformativo);
        panelInformativo.setLayout(panelInformativoLayout);
        panelInformativoLayout.setHorizontalGroup(
            panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformativoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelInformativoLayout.createSequentialGroup()
                        .addGroup(panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrarSesion)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInformativoLayout.setVerticalGroup(
            panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformativoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        btnAtajoAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aggPersona.png"))); // NOI18N
        btnAtajoAgregarCliente.setText("Persona");

        btnDespacho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/despacho_mercancia.png"))); // NOI18N
        btnDespacho.setText("Despacho");

        btnDevolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/devolucion.png"))); // NOI18N
        btnDevolucion.setText("Devolucion");

        eliminarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarProducto.png"))); // NOI18N
        eliminarItem.setText("Eliminar Articulo");

        javax.swing.GroupLayout panelNavegacionAtajoLayout = new javax.swing.GroupLayout(panelNavegacionAtajo);
        panelNavegacionAtajo.setLayout(panelNavegacionAtajoLayout);
        panelNavegacionAtajoLayout.setHorizontalGroup(
            panelNavegacionAtajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavegacionAtajoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImprimirFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtajoAgregarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDespacho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevolucion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInformativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelNavegacionAtajoLayout.setVerticalGroup(
            panelNavegacionAtajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNavegacionAtajoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelInformativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelNavegacionAtajoLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panelNavegacionAtajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtajoAgregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimirFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDespacho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtablaFacturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "cant", "codigo", "nombre articulo", "precio unidad", "monto total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtablaFacturacion);

        panelCabeceraFacturacion.setBackground(new java.awt.Color(193, 219, 252));
        panelCabeceraFacturacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("C.I/RIF");

        jLabel3.setText("Razon Social");

        jLabel4.setText("Telefono");

        jLabel5.setText("Dirección");

        direccionCliente.setColumns(20);
        direccionCliente.setRows(5);
        jScrollPane2.setViewportView(direccionCliente);

        btnBuscarClienteCabVenta.setText("Buscar");

        panelProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel Articulo"));

        jLabel6.setText("Codigo Articulo");

        jLabel7.setText("Nombre Articulo");

        jLabel8.setText("Precio");

        btnBuscarProductoCab.setText("Buscar");

        btnAgregarFactura.setText("Agg Factura");

        jLabel15.setText("cantidad");

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8)
                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreProducto)
                    .addGroup(panelProductosLayout.createSequentialGroup()
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarFactura)
                            .addGroup(panelProductosLayout.createSequentialGroup()
                                .addComponent(txtCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProductoCab))
                            .addComponent(txtPrecioArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProductoCab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarFactura))
        );

        siglaDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "J", "E", "P","G"}));

        javax.swing.GroupLayout panelCabeceraFacturacionLayout = new javax.swing.GroupLayout(panelCabeceraFacturacion);
        panelCabeceraFacturacion.setLayout(panelCabeceraFacturacionLayout);
        panelCabeceraFacturacionLayout.setHorizontalGroup(
            panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCabeceraFacturacionLayout.createSequentialGroup()
                        .addComponent(siglaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarClienteCabVenta))
                    .addComponent(txtNombreCliente)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        panelCabeceraFacturacionLayout.setVerticalGroup(
            panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCabeceraFacturacionLayout.createSequentialGroup()
                        .addGroup(panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarClienteCabVenta)
                            .addComponent(siglaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCabeceraFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(193, 219, 252));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles De Factura"));

        btnFacturarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagar_factura.png"))); // NOI18N
        btnFacturarPedido.setToolTipText("");

        etiquetaItems.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        etiquetaTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        etiquetaDivisa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiquetaItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(etiquetaDivisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(btnFacturarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(etiquetaItems, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaDivisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFacturarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tasa Cambio del Dia"));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Dolar $");

        etiquetaDolar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        etiquetaDolar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaDolar.setText("4.46");

        jLabel16.setText("BS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiquetaDolar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDolar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNavegacionAtajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCabeceraFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelNavegacionAtajo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCabeceraFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jmProductos.setText("Productos");

        jmiConsultarProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jmiConsultarProducto.setText("Consultar Productos");
        jmProductos.add(jmiConsultarProducto);

        barraMenu.add(jmProductos);

        jmClientes.setText("Clientes");

        jmiAggCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jmiAggCliente.setText("Nvo Cliente");
        jmiAggCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAggClienteActionPerformed(evt);
            }
        });
        jmClientes.add(jmiAggCliente);

        barraMenu.add(jmClientes);

        jmPresupuesto.setText("Presupuestos");

        jmiNvoPresupuesto.setText("Nvo Presupuesto");
        jmPresupuesto.add(jmiNvoPresupuesto);

        jmiConsultarPresupuesto.setText("Consulta Presupuesto");
        jmPresupuesto.add(jmiConsultarPresupuesto);

        barraMenu.add(jmPresupuesto);

        jmDevolucion.setText("Devoluciones");

        jmiDevolucionTotal.setText("Devolucion Parcial");
        jmDevolucion.add(jmiDevolucionTotal);

        jMenuItem1.setText("Devolucion Total");
        jmDevolucion.add(jMenuItem1);

        barraMenu.add(jmDevolucion);

        jmAyuda.setText("Ayuda");

        jmiManualAyuda.setText("Manual de Ayuda");
        jmAyuda.add(jmiManualAyuda);

        barraMenu.add(jmAyuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnCerrarSesion(){
        return btnCerrarSesion;
    }
    public JPanel getPanel(){
        return jPanel1;
    }
    
    //---------------------------- JMITEM -------------------------------------
    
    public JMenuItem getConsultarProductos(){
        return jmiConsultarProducto;
    }
    
    public JMenuItem getAgregarCliente(){
       return jmiAggCliente; 
    }
    
    //**************************************************************************
    
    
    public void setCambiarEstadoBoton(JButton boton, boolean estatus){
        //this.btnBuscarClienteCabVenta.setEnabled(estatus);
        
        JButton cambia = boton;
        
        cambia.setEnabled(estatus);
    }
    
    //**************************************************************************
    
    //----------------------- MENU ATAJO -----------------------------------------
    
    public JButton getBtnAtajoAgregarCliente(){
        
        return btnAtajoAgregarCliente;
    }
    
    public JButton getEliminarItem(){
        
        return this.eliminarItem;
    }
    
    //---------------------- CABECERA DE VENTAS----------------------------------
    
    public JButton getBtnBuscarClienteCabVenta(){
        return btnBuscarClienteCabVenta;
    }
    
    public String getSigla(){
        
        String sigla = (String) siglaDocumento.getSelectedItem();
        
        return sigla;
    }
    
    public JTextField gettxtCliente(){
        
        return txtCliente;
    }
    
    public JTextField getTxtNombreCliente(){
        return txtNombreCliente;
    }
    
    public JTextField getTxtTelefono(){
        return txtTelefono;
    }
    
    public String getDireccionCliente(){
        return direccionCliente.getText();
    }
    
    public void setSigla(String []modelo){
        DefaultComboBoxModel miModelo = new DefaultComboBoxModel(modelo);
        siglaDocumento.setModel(miModelo);
    }
    
    public void setTxtCliente(String texto){
        
        this.txtCliente.setText(texto);
    }
    
    public void setTxtNombreCliente(String texto){
        this.txtNombreCliente.setText(texto);
    }
    
    public void setTxtTelefono(String texto){
        this.txtTelefono.setText(texto);
    }
    
    public void setDireccionCliente(String texto){
        this.direccionCliente.setText(texto);
    }
       
    // --------------------- CABECERA DE PRODUCTO ---------------------------
    
    public JButton getBtnBuscarProductoCab(){
        return this.btnBuscarProductoCab;
    }
    
    public JButton getBtnAgregarFactura(){
        
        return this.btnAgregarFactura;
    }
    
    
    public JTextField getTxtCodigoArticulo(){
        return this.txtCodigoArticulo;
    }
    
    public JTextField getTxtNombreProducto(){
        return this.txtNombreProducto;
    }
    
    public JTextField getTxtPrecioArticulo(){
        return this.txtPrecioArticulo;
    }
    
    public JTextField getTxtCantidadProducto(){
        return this.txtCantidadProducto;
    }
    
    public void setTxtCodigoArticulo(String texto){
        this.txtCodigoArticulo.setText(texto);
    }
    
    public void setTxtNombreProducto(String texto){
        this.txtNombreProducto.setText(texto);
    }
    
    public void setTxtPrecioArticulo(String texto){
     
        this.txtPrecioArticulo.setText(texto);
    }
    
    public void setTxtCantidadProducto(String texto){
        this.txtCantidadProducto.setText(texto);
    }
    
    //***************FACTURA********************************************
    
    public JTable getTablaFacturacion(){
        return this.jtablaFacturacion;
    }
    
    public DefaultTableModel getModeloTablaFactura(){
        DefaultTableModel modelo = (DefaultTableModel)jtablaFacturacion.getModel();
        
        return modelo;
    }
    
    public void setLlenarTablaFactura(DefaultTableModel modelo){
        DefaultTableModel m = modelo;
        jtablaFacturacion.setModel(m);
         
        jScrollPane1.setViewportView(jtablaFacturacion);
     
    }
    
    
    public double getEtiquetaDolar(){
        double dolar = Double.parseDouble(etiquetaDolar.getText());
        return dolar;
    }
    
    public void setEtiquetaDolar(String valor){
        this.etiquetaDolar.setText(valor);
    }
    
 
    public void setEtiquetaTotalBolivare(String bolivares){
        this.etiquetaTotal.setText(bolivares + " Bs");
    }
    
    
    public void setEtiquetaItems(String texto){
        
       this.etiquetaItems.setText(texto + " Items");
    }
    
    public void setEtiquetaTotalDivisa(String texto){
       
        this.etiquetaDivisa.setText(texto + " $");
    }
    
    //----------------boton facturar-----------------------------------------
    
    public JButton getBtnFacturarPedido(){
        
        return this.btnFacturarPedido;
    }
    
    
    private void jmiAggClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAggClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiAggClienteActionPerformed

    private void btnImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirFacturaActionPerformed

    private void panelPrincipalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelPrincipalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_panelPrincipalKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnAgregarFactura;
    private javax.swing.JButton btnAtajoAgregarCliente;
    private javax.swing.JButton btnBuscarClienteCabVenta;
    private javax.swing.JButton btnBuscarProductoCab;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnDespacho;
    private javax.swing.JButton btnDevolucion;
    private javax.swing.JButton btnFacturarPedido;
    private javax.swing.JButton btnImprimirFactura;
    private javax.swing.JTextArea direccionCliente;
    private javax.swing.JButton eliminarItem;
    private javax.swing.JLabel etiquetaDivisa;
    private javax.swing.JLabel etiquetaDolar;
    private javax.swing.JLabel etiquetaItems;
    private javax.swing.JLabel etiquetaTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu jmAyuda;
    private javax.swing.JMenu jmClientes;
    private javax.swing.JMenu jmDevolucion;
    private javax.swing.JMenu jmPresupuesto;
    private javax.swing.JMenu jmProductos;
    private javax.swing.JMenuItem jmiAggCliente;
    private javax.swing.JMenuItem jmiConsultarPresupuesto;
    private javax.swing.JMenuItem jmiConsultarProducto;
    private javax.swing.JMenuItem jmiDevolucionTotal;
    private javax.swing.JMenuItem jmiManualAyuda;
    private javax.swing.JMenuItem jmiNvoPresupuesto;
    private javax.swing.JTable jtablaFacturacion;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelCabeceraFacturacion;
    private javax.swing.JPanel panelInformativo;
    private javax.swing.JPanel panelNavegacionAtajo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JComboBox<String> siglaDocumento;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigoArticulo;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioArticulo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
