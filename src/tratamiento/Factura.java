/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;




/**
 *
 * @author josealberto
 */
public class Factura {
    private Integer num_fact; //para poder inicializarlo a null y que la DB se
                              //encargue de asignarle el número, en lugar de 
                              //utilizar int, tenemos que utilizar Integer
    private Date fecha;
    private int ean_tratamiento;
    private String nif_cliente;
    private int cantidad;
    private double precio;

    
    public Factura() {
    }

    public Factura(Integer num_fact, Date fecha, int ean_tratamiento, 
            String nif_cliente, int cantidad, double precio) {
        this.num_fact = null;
        this.fecha = fecha;
        this.ean_tratamiento = ean_tratamiento;
        this.nif_cliente = nif_cliente;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getNum_fact() {
        return num_fact;
    }

    public void setNum_fact(Integer num_fact) {
        this.num_fact = num_fact;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEan_tratamiento() {
        return ean_tratamiento;
    }

    public void setEan_tratamiento(int ean_tratamiento) {
        this.ean_tratamiento = ean_tratamiento;
    }

    public String getNif_cliente() {
        return nif_cliente;
    }

    public void setNif_cliente(String nif_cliente) {
        this.nif_cliente = nif_cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * 
     * @param con
     * @throws SQLException 
     */
    public static void realizarVenta(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String select = "INSERT INTO facturas VALUES (NULL, ?, ?, ?, ?, now());";
        PreparedStatement pst = con.prepareStatement(select);
        System.out.println("Introduce el dni del cliente");
        String dni = sc.nextLine();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from clientes where nif=\""
                + dni +"\"");
        if (rs.last()){
            pst.setString(1, dni);  
            //Cliente cli = new Cliente();
            //cli.altaCliente(con);
        }else{
            System.out.println("El cliente no existe, vamos a crearlo");
            Cliente cli = new Cliente();
            cli.altaCliente(con);
            //pst.setString(1, dni);        
        }
        System.out.println("Introduce el ean del producto");
        int ean = sc.nextInt();
        ResultSet rs2 = st.executeQuery("Select * from tratamiento where "
                + "ean="+ean);
        if (rs2.wasNull()){
            System.out.println("El producto no se ha encontrado");
            System.out.println("Indica si se trata de un tratamiento hidratante"
                    + "o de uno antiedad");
            String tipo = sc.nextLine();
            if (tipo.equals("antiedad")){
                Antiedad anti = new Antiedad();
                anti.introducirTratamiento(con);
            }else{
                Hidratante hidra = new Hidratante();
                hidra.introducirTratamiento(con);
            }
        
        }else{
            pst.setInt(2, ean);
        }
        System.out.println("¿Qué cantidad se lleva el cliente de este producto?");
        int cantidad = sc.nextInt();
        while (rs2.next()){
            while (cantidad>rs2.getInt("stock")){
            System.out.println("No hay unidades suficientes, las unidades disponibles"
                    + "son " + rs2.getInt("stock"));
            cantidad = sc.nextInt();
            }
        }   
        pst.setInt(3, cantidad);
        int result = st.executeUpdate("update tratamiento set "
                    + "stock=stock-" + cantidad +" where ean="+ean);
        if (result == 1){
            System.out.println("Se han restado "+ cantidad + "unidades "
                    + "del stock");
        }
        pst.setDouble(4, rs2.getDouble("precio_unidad")*cantidad);
        pst.execute();
        System.out.println("La venta se ha realizado correctamente");
                
    }
    
       
    public static void generarFactura(String factura) throws IOException{  
        
        BufferedWriter fileOutput = new BufferedWriter(new FileWriter(factura));
            
        
    
    }
}
