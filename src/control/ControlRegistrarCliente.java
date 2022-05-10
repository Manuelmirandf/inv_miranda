package control;

import java.awt.event.*;
import javax.swing.*;
import vista.*;
import modelo.ConexionBaseDatos;
/**
 *
 * @author MANUEL
 */
public class ControlRegistrarCliente {
    
    private RegistrarCliente vistaRegistroCliente;
    private ConexionBaseDatos miConexion;
    
    public ControlRegistrarCliente(){
        
        vistaRegistroCliente = new RegistrarCliente();
        vistaRegistroCliente.setVisible(true);
        vistaRegistroCliente.setResizable(false);
        vistaRegistroCliente.setTitle("REGISRAR NUEVO CLIENTE");
        vistaRegistroCliente.setLocation(50, 40);
        vistaRegistroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        miConexion = new ConexionBaseDatos();
        
        Oyente miOyente = new Oyente();
        
        vistaRegistroCliente.getBtnRegistrar().addActionListener(miOyente);
        vistaRegistroCliente.getBtnLimpiar().addActionListener(miOyente);
        vistaRegistroCliente.getTxtTipoDocumentoCliente().addFocusListener(miOyente);
        
    }
    
    private class Oyente implements ActionListener, FocusListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            if(e.getSource() == vistaRegistroCliente.getBtnRegistrar()){
                
                String sigla = vistaRegistroCliente.getTipoNacionalidad();
                String tipoDocumento = vistaRegistroCliente.getTxtTipoDocumentoCliente().getText();
                String tipoDocumentoCombinado = sigla +"-"+tipoDocumento;
                String razonSocial = vistaRegistroCliente.getTxtRazonSocialCliente().getText();
                String telefono = vistaRegistroCliente.getTxtTelefonoCliente().getText();
                String direccion = vistaRegistroCliente.getJTPDireccionCliente();
                
                for(int i=1; i<telefono.length();i++){
                    
                    if(telefono.charAt(4)=='-'){
                        break;
                    }else{
                        telefono = telefono.substring(0, 4) + "-" + telefono.substring(4,11);
                    }
                }
                
                miConexion.setEstableceConexion();
                
                
                if(miConexion.setRegistrarNuevoCliente(tipoDocumentoCombinado, razonSocial, telefono, direccion,
                                                       vistaRegistroCliente.getContentPane())){
                
                String []s ={"V", "J", "E", "P","G"}; 
                vistaRegistroCliente.setSigla(s);
                vistaRegistroCliente.setTxtTipoDocumentoCliente("");
                vistaRegistroCliente.setTxtRazonSocialCliente("");
                vistaRegistroCliente.setTxtTelefonoCliente("");
                vistaRegistroCliente.setDireccionCliente("");
                }else{
                    System.out.println("No se pudo registrar");
                }
            }
            
            if(e.getSource()== vistaRegistroCliente.getBtnLimpiar()){
                
                vistaRegistroCliente.setCambiarEstatusBoton(false);
                
                String []s ={"V", "J", "E", "P","G"}; 
                vistaRegistroCliente.setSigla(s);
                vistaRegistroCliente.setTxtTipoDocumentoCliente("");
                vistaRegistroCliente.setTxtRazonSocialCliente("");
                vistaRegistroCliente.setTxtTelefonoCliente("");
                vistaRegistroCliente.setDireccionCliente("");
            }
        }

        @Override
        public void focusGained(FocusEvent fe) {
        
            if(! vistaRegistroCliente.getTxtTipoDocumentoCliente().getText().isEmpty()){
                
              vistaRegistroCliente.setCambiarEstatusBoton(false);  
              
            }
           
        }

        @Override
        public void focusLost(FocusEvent fe) {
           
            
            
            if(! vistaRegistroCliente.getTxtTipoDocumentoCliente().getText().isEmpty()){
                
              vistaRegistroCliente.setCambiarEstatusBoton(true);  
              
            }
        }
        
    }
    
}
