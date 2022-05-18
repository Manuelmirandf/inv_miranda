package control;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import vista.*;
import modelo.ConexionBaseDatos;
/**
 *
 * @author MANUEL
 */
public class ControladorAcceso {
    
    private Acceso ejecutarFrameAcceso;
    
    private ConexionBaseDatos miConexionBD;
    
    private static String usuarioNombre ;

    private String var = "Hola";
    
    private boolean estado;
    
    public ControladorAcceso(){
        
                
        miConexionBD = new ConexionBaseDatos();
        
        estado = false;
        
        ejecutarFrameAcceso = new Acceso(); //instancia un objeto Acceso
        
        
       
        //------------------------Eventos-----------------------------------------------------
        
        OyenteControlador miOyente = new OyenteControlador();
        
        ejecutarFrameAcceso.getBtnAcceso().addActionListener(miOyente);
        
        ejecutarFrameAcceso.getBtnAcceso().addKeyListener(miOyente);
        
       
    }// fin del método constructor
     
    public void llamarVentana(){
        
        ejecutarFrameAcceso.setVisible(true); //hace visible la ventana
        
        ejecutarFrameAcceso.setTitle("INVERSIONES MIRANDA 2020 C.A"); //establece un titulo a la ventana
        
        ejecutarFrameAcceso.setResizable(false); //no permite que el usuario expanda o redimensiones la pantalla
        
        Toolkit awt = Toolkit.getDefaultToolkit(); //almacenado en un objeto de la clase Toolkit el objeto abstracto del sistema operativo
        
        Dimension dimensiones = awt.getScreenSize(); //almacenamo en un objeto dimension los pixeles de la pantalla 
        
        int alto = dimensiones.height; //almacenado en la variable alto. El alto de la pantalla en pixeles
        
        int ancho = dimensiones.width;//almacenado en la variable ancho. El ancho de la pantalla en pixeles
        
        ejecutarFrameAcceso.setLocation(ancho/4, alto/4); //ejecutamos el método donde centramos la ventana Acceso
        
        ejecutarFrameAcceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra el sistema al presionar x en la ventana Acceso
        
        
    }
        
    private class OyenteControlador implements ActionListener, KeyListener{
        

        @Override
        public void actionPerformed(ActionEvent e) {
            
            evaluaAcceso();
           
        }

        @Override
        public void keyTyped(KeyEvent ke) {
        
            evaluaAcceso();
           
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            
        }
        
        private void evaluaAcceso(){
            
            
            estado = true;
                        
            String usuario = ejecutarFrameAcceso.getTxtUsuario().getText();
           
            usuarioNombre = usuario;
           
            char []clave = ejecutarFrameAcceso.geTtxtPassword().getPassword();
             
            String caracterConcatenado = "";
            
            for(int i = 0 ;i < clave.length ; i++){
                
                caracterConcatenado += clave[i];
            }
            
             
            if(usuario.equals("") || caracterConcatenado.equals("")){
                
                System.out.println("usuario y/o clave viene en blanco");
                
            }else{
            
                estado = true;
            
                miConexionBD.setEstableceConexion();
            
                miConexionBD.getLogin(usuario, caracterConcatenado); 
            
                        
                String usuarioBd = miConexionBD.getUsuarioBD();
            
                String claveBD = miConexionBD.getClaveUsuarioBD();
            
                String privilegioBD = miConexionBD.getPrivilegio();
                        
                
            
                if(usuario.equals(usuarioBd) && caracterConcatenado.equals(claveBD)&& estado){
                
                    System.out.println("Bienvenido al sistema " + usuario);
                    
                    ControladorMenuProcesoPrincipal irMenuOperaciones = new ControladorMenuProcesoPrincipal();
                   
                    irMenuOperaciones.configuraVentana();
                    
                    ejecutarFrameAcceso.dispose();
            
                }else{
                
                    System.out.println("Clave y/o contraseña incorrecta");
                }

            }//fin de la condicion donde evalua si los campos usuarios y contraseña no estan vacios   
            
        }//fin del método 
        
    }//fin de la clase oyente
    
    public static String getNombreUsuario(){
        
        return usuarioNombre;
    }
    
}//fin de la clase ControladorAcceso
