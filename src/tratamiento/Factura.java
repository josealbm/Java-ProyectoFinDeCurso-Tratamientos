/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author josealberto
 */
public class Factura {
    private Date fecha;
    private int id_producto;
    private String DNI;

    public Factura(Date fecha, int id_producto, String DNI) {
        this.fecha = fecha;
        this.id_producto = id_producto;
        this.DNI = DNI;
    }

    public Factura() {
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
        int intCharacter;
               
        try (BufferedWriter fileOutput = new BufferedWriter(new FileWriter(factura))){
            
        
    }   catch (IOException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
