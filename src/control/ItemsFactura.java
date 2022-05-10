package control;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author MANUEL
 */
public class ItemsFactura {

    private int cantidadProducto;
    private int codigoProducto;
    private String nombreProducto;
    private double precioProducto;
    
    
    
    public ItemsFactura(int cantidad, int codigoProducto, String nombreProducto, double precioUnidad){
        
        this.cantidadProducto = cantidad;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioUnidad;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioProducto() {
        
        
        return precioProducto;
    }
    
    public double getMontoTotal(){
        
        double montoTotal = precioProducto * cantidadProducto;
        
        return montoTotal;
        
    }
    
}
