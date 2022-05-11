package control;
import vista.*;
import modelo.ConexionBaseDatos;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MANUEL
 */
public class ControladorMenuProcesoPrincipal {
    
    private MenuOperacionesProcesoPrincipal vistaMenuOperaciones;
    private ConexionBaseDatos miConexion;
    
  
    private  double montoPagar;
    private  double montoDivisa;
    private double montoIva;
    private double montoBase;
 
    
    public ControladorMenuProcesoPrincipal(){
        
        
        vistaMenuOperaciones = new MenuOperacionesProcesoPrincipal();
        
        miConexion = new ConexionBaseDatos();
                
        vistaMenuOperaciones.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        vistaMenuOperaciones.setEstableceUsuario(ControladorAcceso.getNombreUsuario().toUpperCase());
        
        //-----------------------------------------------------------------------------------------
        
        Oyentes miOyente = new Oyentes();
        
        //barra de menu
        
        vistaMenuOperaciones.getConsultarProductos().addActionListener(miOyente);
        
        vistaMenuOperaciones.getAgregarCliente().addActionListener(miOyente);
        
        vistaMenuOperaciones.getBtnCerrarSesion().addActionListener(miOyente);
        
        //menu atajo
        
        vistaMenuOperaciones.getBtnAtajoAgregarCliente().addActionListener(miOyente);
        
        vistaMenuOperaciones.getEliminarItem().addActionListener(miOyente);
        
        //cabecera de venta
        
        vistaMenuOperaciones.getBtnBuscarClienteCabVenta().addActionListener(miOyente);
        vistaMenuOperaciones.gettxtCliente().addFocusListener(miOyente);
        
        //cabecera de producto
        
        vistaMenuOperaciones.getBtnBuscarProductoCab().addActionListener(miOyente);
        
        vistaMenuOperaciones.getTxtCodigoArticulo().addFocusListener(miOyente);
        
        vistaMenuOperaciones.getBtnAgregarFactura().addActionListener(miOyente);
        
        // evento boton facturar
        
        vistaMenuOperaciones.getBtnFacturarPedido().addActionListener(miOyente);
      
       
    }
    
    
    
     
    public void configuraVentana(){
       
        
        vistaMenuOperaciones.setTitle("INVERSIONES MIRANDA 2020 C.A");
        
        vistaMenuOperaciones.setVisible(true);
        
        vistaMenuOperaciones.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        vistaMenuOperaciones.setResizable(false);
        
        DefaultTableModel modelo = vistaMenuOperaciones.getModeloTablaFactura();
        
        if(modelo.getValueAt(0, 0)==null){
            
            vistaMenuOperaciones.setEtiquetaItems("0");
            
            vistaMenuOperaciones.setEtiquetaTotalBolivare(String.valueOf(0));
            
            vistaMenuOperaciones.setEtiquetaTotalDivisa(String.valueOf(0));
        }
    }
 
    
    private class Oyentes implements ActionListener, FocusListener{

        private boolean estatusAgregarBoton = false;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object origen = e.getSource();
            if(origen == vistaMenuOperaciones.getConsultarProductos()){
               
               ControlConsultarProducto ir = new ControlConsultarProducto(ControladorMenuProcesoPrincipal.this);
               
               ir.iniciarVentana();
            }
            
            
            if(origen == vistaMenuOperaciones.getAgregarCliente()){
                
               ControlRegistrarCliente ir = new ControlRegistrarCliente();
                
            }
           
            if(origen == vistaMenuOperaciones.getBtnCerrarSesion()){
                
                vistaMenuOperaciones.dispose();
            }
            
            if(origen == vistaMenuOperaciones.getBtnAtajoAgregarCliente()){
                
                ControlRegistrarCliente ir = new ControlRegistrarCliente();
            }
            
            if(origen == vistaMenuOperaciones.getBtnBuscarClienteCabVenta()){
                
                miConexion.setEstableceConexion();
                String tipoDocumento = vistaMenuOperaciones.getSigla()+"-"+vistaMenuOperaciones.gettxtCliente().getText();
                
                boolean estatus = miConexion.getConsultarCliente(tipoDocumento);
                
                if(estatus){
                    
                    String []m = miConexion.getDataCliente();
              
                    vistaMenuOperaciones.setTxtNombreCliente(String.valueOf(m[0]));
                    vistaMenuOperaciones.setTxtTelefono(String.valueOf(m[1]));
                    vistaMenuOperaciones.setDireccionCliente(String.valueOf(m[2]));
                
                }else{
                   int opc = JOptionPane.showConfirmDialog(vistaMenuOperaciones, "CLIENTE NO REGISTRADO, ¿DESEA REGISTRARLO?",
                                                           "MENSAJE DEL SISTEMA", JOptionPane.YES_NO_OPTION);
                   if(opc == 0){
                       
                       String []m = {"V", "J", "E", "P","G"};
                       
                       DefaultComboBoxModel modelo = new DefaultComboBoxModel(m);
                       
                       vistaMenuOperaciones.setSigla(m);
                                              
                       vistaMenuOperaciones.setTxtCliente("");
                       
                       ControlRegistrarCliente ir = new ControlRegistrarCliente();
                       
                       
                   }
                }
                
                /*
                    HABILITA EL BOTON SOLO SI EL CLIENTE EXISTE
                    Y EL MODELO DE LA TABLA LA FILA 0 ES DIFERENTE 
                    DE NULL, OSEA QUE NO TENGA REGISTRO RECORDANDO QUE POR DEFECTO
                    EL MODELO DE LA TABLA FUE CREADO CON 24 FILA PERO TODAS VACIAS
                
                    LEER CODIGO DE LA CONDICION 
                
                   origen == vistaMenuOperaciones.getBtnAgregarFactura()
                */
                 
                if(!vistaMenuOperaciones.getTxtNombreCliente().getText().isEmpty()&&vistaMenuOperaciones.getModeloTablaFactura().getValueAt(0, 0)!=null ){
                    
                    vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnFacturarPedido(), true);
                }
                
            }
            
            
            if(origen == vistaMenuOperaciones.getBtnBuscarProductoCab()){
                
                int codigoArticulo = Integer.parseInt(vistaMenuOperaciones.getTxtCodigoArticulo().getText());
                
                miConexion.setEstableceConexion();
                
                Object r[] = miConexion.getConsultarProductoPorCodigo(vistaMenuOperaciones,codigoArticulo);
                
                for(int i=0; i<r.length; i++){
                    
                    if(r[0].equals("S/A")){
                        
                        vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnAgregarFactura(), false);
                        
                        this.estatusAgregarBoton = false;
                        
                        break;
                    }else{
                        
                        this.estatusAgregarBoton = true;
                    
                        vistaMenuOperaciones.setTxtNombreProducto(String.valueOf(r[0]));
                        vistaMenuOperaciones.setTxtPrecioArticulo(String.valueOf(r[1]));
                        
                        vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnAgregarFactura(), true);
                    }
                }
            }
            
            /*
                CONDICION QUE PERMITE LLENAR EL MODELO DE FACTURA 
                DONDE EL MODELO SE VA LLENANDO CUANDO SE HAGA CLICK EN EL BOTON 
                AGREGAR FACTURA 
            */
            if(origen == vistaMenuOperaciones.getBtnAgregarFactura()) {
                
                int cantidad = Integer.parseInt(vistaMenuOperaciones.getTxtCantidadProducto().getText()); 
                int codigoProducto = Integer.parseInt(vistaMenuOperaciones.getTxtCodigoArticulo().getText());
                String nombreProducto = vistaMenuOperaciones.getTxtNombreProducto().getText();
                double precioProducto = Double.parseDouble(vistaMenuOperaciones.getTxtPrecioArticulo().getText());
                
                
                ArrayList<ItemsFactura> agregar = new ArrayList<ItemsFactura>();
                agregar.add(new ItemsFactura(cantidad, codigoProducto, nombreProducto, precioProducto));
                
                DefaultTableModel modeloTabla = vistaMenuOperaciones.getModeloTablaFactura();
                
                int numeroFilaExistentes = modeloTabla.getRowCount();
                
                
                if((numeroFilaExistentes > 0) && (modeloTabla.getValueAt(0, 0)==null)){
                    
                    int contador = 0;
                    
                    do{
                        modeloTabla.removeRow(0); // siempre va a eliminar la fila 0
                        contador++;
                    }while(contador < numeroFilaExistentes);
                    
                }
                
                             
                for(int i=0; i<agregar.size();i++){
                    
                    ItemsFactura l = agregar.get(i);
                    
                    modeloTabla.addRow(new Object []{l.getCantidadProducto(),
                   l.getCodigoProducto(), l.getNombreProducto(), 
                   l.getPrecioProducto(), l.getMontoTotal()});
                   
                   
                }
                
                vistaMenuOperaciones.setEtiquetaItems(String.valueOf(modeloTabla.getRowCount()));
                
                vistaMenuOperaciones.setLlenarTablaFactura(modeloTabla);
                
                if(modeloTabla.getValueAt(0, 0)!=null){
                    
                    vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getEliminarItem(), true);
                    
                    
                }else{
                    
                    System.out.println("aqui programaremos cuando no haya regstro");
                }
                
                configuraMontosVentas();
            }
            
            if(origen == vistaMenuOperaciones.getBtnFacturarPedido()){
                
                
              ControlFormaDePago  control = new ControlFormaDePago();
              
              control.setConfiguraVentana();
              
              control.setCargaMontos(montoPagar, montoDivisa);
              
              DefaultTableModel modeloFactura = vistaMenuOperaciones.getModeloTablaFactura();
              
              control.setModeloFactura(modeloFactura);
              
              String cedula = vistaMenuOperaciones.getSigla()+"-"+vistaMenuOperaciones.gettxtCliente().getText();
              
              control.setCedulaCliente(cedula);
              
              control.setMontoIva(montoIva);
              
              control.setMontoBase(montoBase);
              
              
                
            }
            
            if(origen == vistaMenuOperaciones.getEliminarItem()){
                
                JTable tabla = vistaMenuOperaciones.getTablaFacturacion();
                
                int fila = tabla.getSelectedRow();
                                
                if(fila == -1){
                    
                    JOptionPane.showMessageDialog(vistaMenuOperaciones, "DEBES SELECCIONAR UNA FILA PARA ELIMINAR",
                                                  "MENSAJE DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
                }else{
                   
                    DefaultTableModel modelo = vistaMenuOperaciones.getModeloTablaFactura();
                    
                    
                    int confirmacion = JOptionPane.showConfirmDialog(vistaMenuOperaciones, "¿ESTAS SEGURO QUE DESEA ELIMINAR El PRODUCTO?", 
                                                                                            "MENSAJE DEL SISTEMA", JOptionPane.OK_CANCEL_OPTION);
                
                    if(confirmacion == 0){
                       
                        modelo.removeRow(fila);
                        
                        vistaMenuOperaciones.setEtiquetaItems(String.valueOf(modelo.getRowCount()));
                        
                        configuraMontosVentas();
                        
                        if(modelo.getRowCount()==0){
                            
                            vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getEliminarItem(), false);
                            
                            vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnFacturarPedido(), false);
                        }
                    }
                }
            }
        }

        @Override
        public void focusGained(FocusEvent fe) {
            
 
           
            if(fe.getSource()== vistaMenuOperaciones.gettxtCliente()){
                              
                vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnBuscarClienteCabVenta(),true);
                
            }
            
            if(fe.getSource() == vistaMenuOperaciones.getTxtCodigoArticulo()){
            
                
                    vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnBuscarProductoCab(),true);
                
            }
            
            
            if(fe.getSource() == vistaMenuOperaciones.getTxtCodigoArticulo()){
            
              
              vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnAgregarFactura(),false);
                   
                
            }
        }

        @Override
        public void focusLost(FocusEvent fe) {
            
            /*
                CONDICION QUE EVALUA Y ENTRA CUANDO EL CAMPO
                DEL NOMBRE DEL CLIENTE TENGA REGISTRO 
                
            */
            if(!vistaMenuOperaciones.getTxtNombreCliente().getText().isEmpty()){
                
                // CAPTURA EL MODELO DE LA TABLA FACTURA
                DefaultTableModel modelo = vistaMenuOperaciones.getModeloTablaFactura();
                
                /*
                    EVALUA SI LA PRIMERA FILA DEL MODELO DE LA TABLA FACTURA
                    SEA DIFERENTE A NULL OSEA TENGA AL MENOS UN REGISTRO.
                    CON LA FINALIDAD DE HABILITAR EL BOTON DE PAGAR FACTURA.
                */
                if(modelo.getValueAt(0, 0)!=null){
            
                    vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnFacturarPedido(), true);
                }
            }
            
        }

        
    }//fin de la clase gestionadora de eventos
    
 
    
    private double setFormatearDigito(double numero){
        
        double n = numero;
        
        
        DecimalFormat f = new DecimalFormat("0.00");
		
		String c = f.format(n);
		
		for(int i=0; i< c.length()-1; i++) {
			
			if(c.substring(0, c.length()-1).charAt(i)==',') {
				
				c = c.substring(0, i)+'.'+c.substring(i+1, c.length());
				
				n = Double.parseDouble(c);
			}
		}
        
        return n;
    }
    
    public DefaultTableModel getModeloControl(){
        
        return vistaMenuOperaciones.getModeloTablaFactura();
    }
    
    public void cargar(DefaultTableModel prueba){
       
        
       vistaMenuOperaciones.setLlenarTablaFactura(prueba);
       
       
    }
    
       public void configuraMontosVentas(){
        
        
        DefaultTableModel modelo = vistaMenuOperaciones.getModeloTablaFactura();
        
        
        double iva = 16; //OJO ESTE CAMPO TIENE QUE VENIR DESDE BASE DE DATOS.
        
        montoPagar = 0;
        double tasaCambioDolar = vistaMenuOperaciones.getEtiquetaDolar();
        montoDivisa =0;
        
               
        for(int i=0; i<modelo.getRowCount();i++){
          
            montoBase += Double.parseDouble(modelo.getValueAt(i, 4).toString());
            
        }
        

        montoBase = setFormatearDigito(montoBase);
        
        montoIva = (montoBase * iva)/100;
        
        montoIva = setFormatearDigito(montoIva);
                
        montoPagar = (montoBase + montoIva);
        
        montoPagar = setFormatearDigito(montoPagar);
        
        montoDivisa = montoPagar / tasaCambioDolar;
        
        montoDivisa = setFormatearDigito(montoDivisa);
        
        
        vistaMenuOperaciones.setEtiquetaTotalBolivare(String.valueOf(montoPagar));
        
        vistaMenuOperaciones.setEtiquetaTotalDivisa(String.valueOf(montoDivisa));
       
        //activar la edicion del boton
        
        if((modelo.getRowCount()>0)&& !(vistaMenuOperaciones.getTxtNombreCliente().getText().isEmpty())){
            
            vistaMenuOperaciones.setCambiarEstadoBoton(vistaMenuOperaciones.getBtnFacturarPedido(), true);
        }
        
    }
      
}
