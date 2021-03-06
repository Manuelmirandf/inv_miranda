package control;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import modelo.ConexionBaseDatos;
import vista.FormaDePago;
import javax.swing.table.*;
import net.sf.jasperreports.engine.JasperReport;
/**
 *
 * @author MANUEL
 */
public class ControlFormaDePago {
    
    private FormaDePago vistaFormaDePago;
    private ConexionBaseDatos conexionBD;
    private double montoAcumulado,  faltante;
    private ArrayList<RegistroFormaPagos>  agregarPago;
    private DefaultTableModel miModeloRecibidoFactura;
    private String cedulaCliente;
    private double montoBase, montoIva;
    
    int contador;
    
    public ControlFormaDePago(){
    
        agregarPago = new ArrayList<>();
        
        montoAcumulado = 0;
        
        faltante =0;
        
        contador = 0;
        
        vistaFormaDePago = new FormaDePago();                          
        
        conexionBD = new ConexionBaseDatos();        
        
        vistaFormaDePago.getBtnPagar().addActionListener(new Oyente());
        
        
    }
    
    public void setConfiguraVentana(){
        
        vistaFormaDePago.setVisible(true);
                    
        vistaFormaDePago.setTitle("FORMA DE PAGO");
                    
        vistaFormaDePago.setResizable(false);
                    
        vistaFormaDePago.setLocation(320, 200);
                    
        vistaFormaDePago.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        conexionBD.setEstableceConexion();        
        
        String []row = conexionBD.getConsultarFormaDePagos();
                
        vistaFormaDePago.setCargarTipo(row);
        
    }
    
    
    
    public void setCargaMontos(double totalBolivares, double totalDivisa){
        
        vistaFormaDePago.setTxtTotalBolivares(String.valueOf(totalBolivares));
        
        vistaFormaDePago.setTxtDivisa(String.valueOf(totalDivisa));
    }
    
    
    private class Oyente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            double precioTotal = Double.parseDouble(vistaFormaDePago.getTxtTotalBolivares().getText());
            
            double montoIntroducido = Double.parseDouble(vistaFormaDePago.getTxtMontoIntroducido().getText());
            
            String tipoPago = vistaFormaDePago.getTipoPago().getSelectedItem().toString();
            
            String comprobanteBancario = vistaFormaDePago.getTxtComprobante().getText();
            
            
            
            if(montoIntroducido >= precioTotal){
                
                double vuelto = montoIntroducido - precioTotal;
                
                vuelto = setFormatearDigito(vuelto);
                
                
                if(comprobanteBancario.isEmpty()){
                    
                    comprobanteBancario = "NO ES REQUERIDO";
                }
                
                agregarPago.add(new RegistroFormaPagos(tipoPago, comprobanteBancario, montoIntroducido));
                
                JOptionPane.showMessageDialog(vistaFormaDePago, "SU VUELTO ES " + vuelto +" Bs", "MENSAJE DEL SISTEMA", JOptionPane.QUESTION_MESSAGE);
                
                faltante = vuelto;
                
                setProcesarFactura();
                
            }else{
                
                if(comprobanteBancario.isEmpty()){
                    
                    comprobanteBancario = "NO ES REQUERIDO";
                }
               
                agregarPago.add(new RegistroFormaPagos(tipoPago, comprobanteBancario, montoIntroducido));
                
                montoAcumulado += montoIntroducido;
            
                montoAcumulado = setFormatearDigito(montoAcumulado);
                
                vistaFormaDePago.setAcumulado(String.valueOf(montoIntroducido));
                
                faltante = Math.abs(precioTotal - montoAcumulado);
                
                faltante = setFormatearDigito(faltante);
                
                if(montoAcumulado >= precioTotal){
                    
                    
                    vistaFormaDePago.setAcumulado(String.valueOf(montoAcumulado));
                    
                    JOptionPane.showMessageDialog(vistaFormaDePago, "SU VUELTO ES " + faltante +" Bs", "MENSAJE DEL SISTEMA", JOptionPane.QUESTION_MESSAGE);
                
                    vistaFormaDePago.setEtiquetaFaltante(String.valueOf(0));
                    
                    setProcesarFactura(); //registra la factura y los tipos de pagos
                    
                }else{
                    
                    JOptionPane.showMessageDialog(vistaFormaDePago, "FALTA POR CANCELAR " + faltante +" Bs", "MENSAJE DEL SISTEMA", JOptionPane.QUESTION_MESSAGE);
                    
                    vistaFormaDePago.setEtiquetaFaltante(String.valueOf(faltante));
                    
                    vistaFormaDePago.setTxtMontoIntroducido("");
                }
                
                
            }
        
        
    }
        
   
    
    public void setProcesarFactura(){
       
        conexionBD.setEstableceConexion();
        
        //traeremos las formas de pagos de la clase RegistroFormaPagos
        double totalTransaccion = Double.parseDouble(vistaFormaDePago.getTxtTotalBolivares().getText());
        double vuelto = faltante;
                
        conexionBD.setRegistrarFactura(cedulaCliente,montoBase,montoIva,totalTransaccion,vuelto,miModeloRecibidoFactura);
        
        for(RegistroFormaPagos rp : agregarPago){
            
            conexionBD.setRegistrarFormasDePagos(rp.getTipoPago(), rp.getMonto(), rp.getComprobanteBancario());
            
        }
    
        setImprimirFactura();
    }
    
    public void setImprimirFactura(){
        
        
        
        /*
        File ruta = new File("R://Documentos//prueba//");
        
        if(ruta.exists()){
            
            try {
                
                conexionBD.setEstableceConexion();
                
                int numeroFactura = conexionBD.getCorrelativoFactura();
                
                FileOutputStream salida = new FileOutputStream(ruta + "//factura"+numeroFactura+".pdf");
                
                Document documento = new Document();
                
                PdfWriter.getInstance(documento, salida);
                
                documento.open();                
                
                Paragraph titulo =  new Paragraph("INVERSIONES MIRANDA 2020 C.A",
                                                    FontFactory.getFont("arial",22,Font.BOLD));
                
                titulo.setAlignment(Paragraph.ALIGN_CENTER);
                
                documento.add(titulo);
                
                
                PdfPTable a = new PdfPTable(3);
                
                a.addCell("codigo");
                a.addCell("nombre");
                a.addCell("apellido");
                
                documento.add(a);
                
                documento.close();
                
                System.out.println("se creo correctamente en ruta " + ruta);
                
            } catch (Exception ex) {
                Logger.getLogger(ControlFormaDePago.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            System.out.println("no existe");
        }
        
        
        */
        
    }
    
    private double setFormatearDigito(double numero){
        
        double d = numero;
        
        DecimalFormat f = new DecimalFormat("0.00");
		
                    String c = f.format(d);
		
                    for(int i=0; i< c.length()-1; i++) {
			
			if(c.substring(0, c.length()-1).charAt(i)==',') {
				
				c = c.substring(0, i)+'.'+c.substring(i+1, c.length());
				
				d = Double.parseDouble(c);
			}
                    }
        
      return d;
    }
}
    public void setCedulaCliente(String cedula){
        
        this.cedulaCliente = cedula;
    }
    
     public void setModeloFactura(DefaultTableModel modelo){
        
         miModeloRecibidoFactura = modelo;
         
    }
    
    public void setMontoBase(double montoBase){
        this.montoBase = montoBase;
    }
     
    public void setMontoIva(double montoIva){
        this.montoIva = montoIva;
    }
    
    
   
}
