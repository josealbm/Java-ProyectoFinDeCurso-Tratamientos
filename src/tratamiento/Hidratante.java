/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author josealberto
 */
public class Hidratante extends Tratamiento{
    private String descripcion;
    private String zona_aplicacion;
    private int Stock;
    private double precio_ud;
    

    public Hidratante() {       
           
    }

    public Hidratante(String descripcion, String zona_aplicacion, int Stock, 
            double precio_ud) {
        this.descripcion = descripcion;
        this.zona_aplicacion = zona_aplicacion;
        this.Stock = Stock;
        this.precio_ud = precio_ud;
    }

    public Hidratante(String descripcion, String zona_aplicacion, int Stock, 
            double precio_ud, Integer ean, String nombre) {
        super(ean, nombre);
        this.descripcion = descripcion;
        this.zona_aplicacion = zona_aplicacion;
        this.Stock = Stock;
        this.precio_ud = precio_ud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getZona_aplicacion() {
        return zona_aplicacion;
    }

    public void setZona_aplicacion(String zona_aplicacion) {
        this.zona_aplicacion = zona_aplicacion;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrecio_ud() {
        return precio_ud;
    }

    public void setPrecio_ud(double precio_ud) {
        this.precio_ud = precio_ud;
    }
   
    /**
     * Método para mostrarnos los atributos del objeto
     */
    @Override
    public void mostrarTratamiento() {
        super.mostrarTratamiento();
        
    }

    /**
     * Método para dar de alta por el usuario un nuevo tratamiento 
     * @throws java.sql.SQLException
     */
    @Override
    public void introducirTratamiento(Connection con) throws SQLException{
        super.introducirTratamiento(con);
        Scanner sc = new Scanner(System.in);
        String insert = "INSERT INTO hidratante (id, id_tratamiento, "
                + "descripcion, zona_aplicacion, stock, precio_ud) "
                + "VALUES (NULL, ?, ?, ?, ?, ?);";
        PreparedStatement pst = con.prepareStatement(insert);
        System.out.println("Vamos a introducir un tratamiento hidratante");
        System.out.println("Por favor, introduce el ean del tratamiento");
        pst.setInt(1, sc.nextInt());
        System.out.println("Escribe una pequeña descripción");
        pst.setString(2, sc.next());
        System.out.println("Ahora la zona de aplicación");
        sc.nextLine();
        pst.setString(3, sc.nextLine());
        System.out.println("¿Cuánto stock ha llegado?");
        pst.setInt(4, sc.nextInt());
        System.out.println("¿Cuál es el PVP?");
        pst.setDouble(5, sc.nextDouble());
        pst.execute();
        System.out.println("El nuevo tratamiento hidratante se ha introducido"
                + "correctamente");
    }
    
    
    
}
