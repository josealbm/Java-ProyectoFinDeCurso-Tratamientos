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
    private int id_producto;
    private String DNI;

    public Factura(Integer num_fact, Date fecha, int id_producto, String DNI) {
        this.num_fact = null;
        this.fecha = fecha;
        this.id_producto = id_producto;
        this.DNI = DNI;
    }

    public Factura() {
    }
    
    public Factura(Factura fact){
        this.num_fact = fact.num_fact;
        this.fecha = fact.fecha;
        this.id_producto = fact.id_producto;
        this.DNI = fact.DNI;
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

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    public static void generarFactura(String factura){  
        
        try (BufferedWriter fileOutput = new BufferedWriter(new FileWriter(factura))){
            
        
    }   catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
}
