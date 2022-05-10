package principal;

import java.awt.*;
import javax.swing.*;
import vista.*;
import control.ControladorAcceso;

/**
 *
 * @author AUTORES 2022 MIRANDA
 * @version 1.0.0
 * @since 03/2022
 * 
 * Clase que lleva el método principal.
 */

public class Principal {

    /**
     * @param args recibe un array de tipo String
     * Cuyo método da inicio a la ejecución del Sistema
     */
    public static void main(String[] args) {
        
        ControladorAcceso controlAcceso = new ControladorAcceso();
        
        controlAcceso.llamarVentana();
    }//fin del método main
    
}//fin de la clase Principal.
