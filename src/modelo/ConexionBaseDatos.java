package modelo;

import java.awt.*;
import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *Clase que se encarga de llevar los proceso internos de la conexion de bases de datos
 * @author Los autores 2022
 * @version 1.0
 */
public class ConexionBaseDatos {
    
    private Connection miConexion; //objeto de interfaz Connection
    private ResultSet rs; // objeto de interfaz ResultSet
    private Statement st; //objeto de la interfaz Statement.
    
    private String usuario, clave, privilegio; // variables para almacenar la data de la tabla usuario
    
    private String dataCliente[];
    
    private int ultimoId;
    
    public ConexionBaseDatos(){
        
        this.miConexion = null; // inicializamos la conexion null
        this.rs = null; //inicializamos el rs null;
        
        usuario = ""; //inicializamos variable usuario cadena vacia
        clave = ""; //inicializamos variable clave cadena vacia
        privilegio = ""; //inicializamos variable privilegio cadena vacia
    }
    
    /**
     * Método setter que establece la conexion de la base de datos
     */
    public void setEstableceConexion(){
        
            try {
                Class.forName("com.mysql.jdbc.Driver"); // driver del mysql.
                
                miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_inv_miranda", "root", "nelson.28"); //configuracion de la conexion
                
            } catch (ClassNotFoundException ex) {
                
                System.out.println("Error con el Driver Mysql");
                Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                
            } catch (SQLException ex) {
                System.out.println("Error al conectarse con el servidor");
                Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        
    }
    
    public void setRegistrarFactura(String cedulaCliente, double montoBase, double montoImpuesto,
                                    double totalTransaccion, double vuelto, DefaultTableModel modeloFactura){
        
        String sqlBuscarCliente = "SELECT * FROM CLIENTE WHERE CEDULA_CLIENTE = '" + cedulaCliente + "' LIMIT 1";
        
        
        try {
            st = miConexion.createStatement();
            
            rs = st.executeQuery(sqlBuscarCliente);
            
            if(rs.next()){
                                
                PreparedStatement stm = miConexion.prepareStatement("INSERT INTO FACTURA (id_factura, cliente_cedula_cliente, fecha_factura, monto_base, monto_impuesto, total_transaccion, vuelto) VALUE(DEFAULT,?,NOW(),?,?,?,?)");
                
                stm.setString(1, cedulaCliente);
                stm.setDouble(2, montoBase);
                stm.setDouble(3, montoImpuesto);
                stm.setDouble(4, totalTransaccion);
                stm.setDouble(5, vuelto);
                
                stm.executeUpdate();
                
                //trae el id de la ultima factura registrada
                
                String id = "SELECT MAX(id_factura) as numero_factura FROM factura LIMIT 1";
                
                st = miConexion.createStatement(); 
            
                rs = st.executeQuery(id);
                
                if(rs.next()){
                     
                    ultimoId = rs.getInt("numero_factura");
                    
                    
                      PreparedStatement stDos = miConexion.prepareStatement("INSERT INTO FACTURA_HAS_PRODUCTO (factura_id_factura, producto_id_producto, precio_unitario, cantidad) VALUES (?,?,?,?)");
                
                        for(int i=0; i<modeloFactura.getRowCount();i++){
                            
                            stDos.setInt(1, ultimoId);
                            stDos.setInt(2, Integer.parseInt(modeloFactura.getValueAt(0, 1).toString()));
                            stDos.setDouble(3, Double.parseDouble(modeloFactura.getValueAt(0, 3).toString()));
                            stDos.setInt(4, Integer.parseInt(modeloFactura.getValueAt(0, 0).toString()));
                            
                            stDos.executeUpdate();
                        }
                    
                }
              
                System.out.println("exito factura registrada");
                
                
                
            }else{
                
                System.out.println("Error Este cliente no existe");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setRegistrarFormasDePagos(String formaPago, double montoPago, String comprobante){
        /*
        System.out.println("vamos a registrar las formas de pago con la factura: " + ultimoId);
        System.out.println("Tipo: " + formaPago);
        System.out.println("Monto: " + montoPago);
        System.out.println("Comprobante: " + comprobante);
        */
        
        String sql = "SELECT IDFORMA_DE_PAGOS FROM FORMA_DE_PAGOS WHERE NOMBRE_FORMA_PAGO = '" + formaPago +"'";
        
        try {
            PreparedStatement stm = miConexion.prepareStatement(sql);
            
            rs = stm.executeQuery();
            
            if(rs.next()){
                
                int idFormaPago = rs.getInt("idforma_de_pagos");
               
                
                PreparedStatement stm2 = miConexion.prepareStatement("INSERT INTO  factura_has_forma_de_pagos (factura_id_factura, forma_de_pagos_idforma_de_pagos, monto_pago, mun_comprobante_bancario) VALUES (?,?,?,?)");
                
                stm2.setInt(1, ultimoId);
                stm2.setInt(2, idFormaPago);
                stm2.setDouble(3, montoPago);
                stm2.setString(4, comprobante);
                
                stm2.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean setRegistrarNuevoCliente(String tipoDocumento, String razonSocial, String telefono,
                                            String direccion, Component ventana){
        
        boolean estatusRegistro = false;
       
        try {
            PreparedStatement stm = miConexion.prepareStatement("INSERT INTO CLIENTE (cedula_cliente, razon_social, telefono_cliente, direccion_cliente) VALUE(?,?,?,?)");
            
            stm.setString(1, tipoDocumento.toUpperCase());
            stm.setString(2, razonSocial.toUpperCase());
            stm.setString(3, telefono);
            stm.setString(4, direccion.toUpperCase());
                        
            stm.executeUpdate();
            
            estatusRegistro = true; 
            
            JOptionPane.showMessageDialog(ventana, "CLIENTE REGISTRADO EXITOSAMENTE", "MENSAJE DEL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            
            if(ex.getErrorCode() == 1062){
                JOptionPane.showMessageDialog(ventana, "ESTA CEDULA YA SE ENCUENTRA REGISTRADA ", "MENSAJE DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
            }
            estatusRegistro = false;
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estatusRegistro;
    }
    
    
    /**
     * Método getter, el cual realiza una consulta a la base de datos para obtener la data del usuario filtrado
     * por nombreUsuario y claveUsuario.
     * @param nombreUsuario recibe la informacion del controlador donde trae el nombre de usuario del campo de Usuario
     * @param claveUsuario recibe la informacion del controlador donde trae la clave del usuario del campo de Usuario
     */
    
    public void getLogin(String nombreUsuario, String claveUsuario){
        
        
        //query deonde es filtrado por usuario y clave
        String query = "select * from usuario where nombre_usuario = " + "'"+nombreUsuario +"'"+ " and clave_usuario = " + "'"+claveUsuario+"'" ;
        
        
        
        try {
            st = miConexion.createStatement(); 
            
            rs = st.executeQuery(query);
            
            while(rs.next()){
    
                  usuario = rs.getString("nombre_usuario");
                  clave = rs.getString("clave_usuario");
                  privilegio = rs.getString("privilegio");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String[] getConsultarFormaDePagos(){
        
        String contador = "SELECT MAX(IDFORMA_DE_PAGOS) AS CONTADOR FROM FORMA_DE_PAGOS";
                
        String sql = "SELECT * FROM FORMA_DE_PAGOS ORDER BY IDFORMA_DE_PAGOS";
        
        String row[] = new String[7];
        
        try {
            
            st = miConexion.createStatement();
            
            rs = st.executeQuery(contador);
            
            if(rs.next()){
                
            }
            
            rs = st.executeQuery(sql);
            
            int c = 0;
            while(rs.next()){
                
                row[c] = rs.getString("nombre_forma_pago");
                c++;
            }
           
             
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return row;
    }
    
    public boolean getConsultarCliente(String tipoDocumento){
        
       String sql = "SELECT * FROM CLIENTE WHERE CEDULA_CLIENTE='" + tipoDocumento +"'";
       
       dataCliente = new String[3];
       
       boolean estatus;
        
        try {
            st = miConexion.createStatement();
            
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                
                estatus = true;
                
                dataCliente[0] = rs.getString("razon_social");
                dataCliente[1] = rs.getString("telefono_cliente");
                dataCliente[2] = rs.getString("direccion_cliente");
               
            }else{
                
               estatus = false; 
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            estatus = false;
        }
        
        return estatus;
    }
    
    public String[] getDataCliente(){
        return dataCliente;
    }
    
    public Object[] getConsultarProductoPorCodigo(Component vista,int codigoProducto){
        
        String sql = "SELECT * FROM PRODUCTO WHERE id_producto = " + codigoProducto;
        Object row[] = new Object[2];
        try {
            
            st = miConexion.createStatement();
            
            rs = st.executeQuery(sql);
            
            
            if(rs.next()&& rs.getRow()!=0){
                
                row[0] = rs.getString("nombre_producto");
                row[1] = rs.getDouble("precio_publico");
            }else{
                
                JOptionPane.showMessageDialog(vista, "EL CODIGO NO SE ENCUENTRA REGISTRADO","MENSAJE DEL SISTEMA",JOptionPane.INFORMATION_MESSAGE);
                
                row[0] = "S/A";
                row[1] = "S/A";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
    
    //--------------------------------------------------------------------------------------
    
    public DefaultTableModel getConsultaProducto(DefaultTableModel modeloVista){
        
        DefaultTableModel miModelo = modeloVista;
        
        String sql = "SELECT * FROM PRODUCTO";
        
        Object []row = new Object[4];
        
        try {
            st = miConexion.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                row[0] = String.valueOf(rs.getInt("id_producto"));
                row[1] = rs.getString("nombre_producto");
                row[2]= rs.getString("seccion_nombre_seccion");                
                row[3] = String.valueOf(rs.getDouble("precio_publico"));
            
                miModelo.addRow(row);
            }
            
                
                
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return miModelo;
    }
    
  
    public DefaultTableModel getBuscarProductoPorNombre(DefaultTableModel modelo ,String nombreProducto){
        
        DefaultTableModel modeloTablaVista = modelo;
        
        int filaMaxima = modeloTablaVista.getRowCount();
        int contador = 1;
        
        do{
           modeloTablaVista.removeRow(0); 
           contador++;
        }while(contador <= filaMaxima);
              
        String sql = "SELECT * FROM PRODUCTO WHERE NOMBRE_PRODUCTO LIKE '" + nombreProducto.toUpperCase() + "%'";
        
        try {
            st = miConexion.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Object []row = new Object[4];
                row[0] = String.valueOf(rs.getInt("id_producto"));
                row[1] = rs.getString("nombre_producto");
                row[2]= rs.getString("seccion_nombre_seccion");                
                row[3] = String.valueOf(rs.getDouble("precio_publico"));
            
                modeloTablaVista.addRow(row);
            }
              
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return modeloTablaVista;
    }
    
    public String getUsuarioBD(){
        return usuario;
    }
    
    public String getClaveUsuarioBD(){
        
        return clave;
    }
    
    public String getPrivilegio(){
        
        return privilegio;
    }
    
    //--------------------------------------------------------------------
    public void setCerrarConexion(){
        
         try {
            miConexion.close();
             System.out.println("Conexion finalizada");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
