/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;



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
        this.num_fact = num_fact;
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
    
       
    public static void generarFactura(String factura) throws IOException{  
        
        BufferedWriter fileOutput = new BufferedWriter(new FileWriter(factura));
            
        
    
    }
}
