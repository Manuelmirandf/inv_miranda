package control;

/**
 *
 * @author MANUEL
 */
public class RegistroFormaPagos {
    
    private String tipoPago;
    private String comprobanteBancario;
    private double monto;
    
    public RegistroFormaPagos(String tipo, String comprobante, double monto){
        
        this.tipoPago = tipo;
        this.comprobanteBancario = comprobante;
        this.monto = monto;
    }
    
    public String getTipoPago(){
        return tipoPago;
    }
    
    public String getComprobanteBancario(){
        return comprobanteBancario;
    }
    
    public double getMonto(){
        return monto;
    }
    
}
