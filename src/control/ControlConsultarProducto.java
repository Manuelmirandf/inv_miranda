package control;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import vista.*;
import modelo.ConexionBaseDatos;
import javax.swing.event.*;
/**
 *
 * @author MANUEL
 */
public class ControlConsultarProducto {
    
    private ConsultarProducto vistaProducto;
    private ConexionBaseDatos conexion;
    private boolean prueba = false;
    private boolean busquedaPorNombre=true, busquedaPorCodigo=false;
    
    
    private ControladorMenuProcesoPrincipal control;
    
    
    /**
     * método que inicia la ventana de consultar producto
     */
    public void iniciarVentana(){
        
        vistaProducto.setVisible(true);
        vistaProducto.setTitle("CONSULTAR PRODUCTOS");
        vistaProducto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vistaProducto.setLocation(50, 40);
        vistaProducto.setResizable(false);
        
    }
    
    
    public ControlConsultarProducto(ControladorMenuProcesoPrincipal control){
        
        this.control = control;
        setConfiguraObjetosDeClaseControlConsultar();
        
    }
    
    public ControlConsultarProducto(){
        
        
        setConfiguraObjetosDeClaseControlConsultar();
         
    }
    
    private void setConfiguraObjetosDeClaseControlConsultar(){
        
        vistaProducto = new ConsultarProducto();
        
        conexion = new ConexionBaseDatos();
        
        conexion.setEstableceConexion();
        
        setCargarElModeloDeTabla();
        
        Oyente miOyente = new Oyente();
        
        vistaProducto.getBtnBuscar().addActionListener(miOyente);
        vistaProducto.getTxtBuscar().addFocusListener(miOyente);
        
        vistaProducto.getRBNombreProducto().addActionListener(miOyente);
        vistaProducto.getRBCodigoProducto().addActionListener(miOyente);
        
        vistaProducto.getBtnAgregarFacturaPrincipal().addActionListener(miOyente);
        
        
    }
    
    private class Oyente implements ActionListener, FocusListener/*,CaretListener*/{

        
        @Override
        public void actionPerformed(ActionEvent e) {
         
            Object origenSeleccion = e.getSource();
            
            if(origenSeleccion == vistaProducto.getBtnBuscar()){
                
               if(busquedaPorNombre){
                   
                    String buscarNombreProducto = vistaProducto.getTxtBuscar().getText();
                        
                    vistaProducto.setLLenarTablaVistaProducto(conexion.getBuscarProductoPorNombre(vistaProducto.getModeloVista()
                                                                                              ,buscarNombreProducto));
            
                    prueba = true;
                    busquedaPorCodigo = false;
                    
                    
               }
               
               if(busquedaPorCodigo){
                   
                   // tenemos que hacer una consulta interna al modelo de la tabla
                  String codigoBuscarProducto = vistaProducto.getTxtBuscar().getText();
                  
                   int cantidadFilaDelModelo = vistaProducto.getModeloVista().getRowCount();
                   int cantidadColumnDelModelo = vistaProducto.getModeloVista().getColumnCount();
                   DefaultTableModel modelo = vistaProducto.getModeloVista();
                   
                   
                   for(int i =0; i<modelo.getRowCount(); i++){
                       
                       if(modelo.getValueAt(i, 0).equals(codigoBuscarProducto)){
                            vistaProducto.getTabla().changeSelection(i, 0, false, false);
                       }
                   }
                
               }
                
                
            }
            
            if(origenSeleccion == vistaProducto.getRBNombreProducto()){
                
                vistaProducto.setCambiarTituloEtiqueta("Nombre Del Producto");
                busquedaPorNombre = true;
                busquedaPorCodigo = false;
            }
            
            if(origenSeleccion == vistaProducto.getRBCodigoProducto()){
                vistaProducto.setCambiarTituloEtiqueta("Codigo Del Producto");
                busquedaPorCodigo = true;
                busquedaPorNombre = false;
            }
            
            if(origenSeleccion == vistaProducto.getBtnAgregarFacturaPrincipal()){
                
                
                JTable tablaProducto = vistaProducto.getTabla();
        
                int filaSeleccionada = tablaProducto.getSelectedRow();
        
                if(filaSeleccionada == -1){
            
                    JOptionPane.showMessageDialog(tablaProducto, "DEBES SELECCIONAR UN PRODUCTO",
                                                                "ERROR DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
                
                }else{
                     
                    try{
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(tablaProducto, "INDIQUE LA CANTIDAD A FACTURAR POR FAVOR"));
                        
                         // calculo interno;
                    
                        DefaultTableModel modelo = vistaProducto.getModeloVista();
                    
                        int codigoProducto = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());
                        String nombreProducto = modelo.getValueAt(filaSeleccionada, 1).toString();
                        double precioProducto = Double.parseDouble(modelo.getValueAt(filaSeleccionada, 3).toString());
                      
                    Object fila[] = {cantidad,codigoProducto, nombreProducto, precioProducto, (cantidad*precioProducto)};
                    
                   
                    DefaultTableModel modeloFacturaMenuOperacionesProcesoPrincipal = control.getModeloControl();
                    
                    int numeroFilaExistentes = modeloFacturaMenuOperacionesProcesoPrincipal.getRowCount();
                
                
                    if((numeroFilaExistentes > 0) && (modeloFacturaMenuOperacionesProcesoPrincipal.getValueAt(0, 0)==null)){
                    
                    int contador = 0;
                    
                    do{
                        modeloFacturaMenuOperacionesProcesoPrincipal.removeRow(0); // siempre va a eliminar la fila 0
                        contador++;
                    }while(contador < numeroFilaExistentes);
                    
                }
                    
                    
                    modeloFacturaMenuOperacionesProcesoPrincipal.addRow(fila);
                    
                    control.cargar(modeloFacturaMenuOperacionesProcesoPrincipal);                    
                    
                    control.configuraMontosVentas(); //METODO QUE REALIZA LOS CALCULOS PERTINENTES PARA SUBTOTAL, ETC.
                    
                    }catch(Exception a){
                      
                        DefaultTableModel modeloTablaVista = vistaProducto.getModeloVista();
        
                        int filaMaxima = modeloTablaVista.getRowCount();
                        int contador = 1;
        
                        do{
                             modeloTablaVista.removeRow(0); 
                            contador++;
                        }while(contador <= filaMaxima);
                
                
                        setCargarElModeloDeTabla();
                    }
                  
                }
            }
            
        }

        @Override
        public void focusGained(FocusEvent fe) {
            
            vistaProducto.setTxtCampoCodigo("");
            
            vistaProducto.setHabiltarBotonBusqueda(true);
            
            if(prueba){
                
                DefaultTableModel modeloTablaVista = vistaProducto.getModeloVista();
        
                int filaMaxima = modeloTablaVista.getRowCount();
                int contador = 1;
        
                do{
                    modeloTablaVista.removeRow(0); 
                    contador++;
                }while(contador <= filaMaxima);
                
                
                //resetearModeloTablaProducto();
                setCargarElModeloDeTabla();
                
            }
            
            
        }

        @Override
        public void focusLost(FocusEvent fe) {
            
        }


        
    }// fin de la clase Oyente
    
    
    private void setCargarElModeloDeTabla(){
        
        vistaProducto.setLLenarTablaVistaProducto(conexion.getConsultaProducto(vistaProducto.getModeloVista()));
    }
    
}
