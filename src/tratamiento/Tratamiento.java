/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;

import java.util.Scanner;

/**
 *
 * @author josealberto
 */
public class Tratamiento{
    protected String nombre;
    protected String descripcion;
    protected int referencia;
    protected double precioventa;

    public Tratamiento() {
    }

    public Tratamiento(String nombre, String descripcion, int referencia, double precioventa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.precioventa = precioventa;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }
    
    public void mostrarTratamiento(){
        System.out.println("Nombre del producto: "+ this.nombre);
        System.out.println("Referencia: "+ this.referencia);
        System.out.println("Descripción: "+ this.descripcion);
        System.out.println("Precio de venta al público: " + this.precioventa);
    }
    
    public void introducirTratamiento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a dar de alta un tratamiento facial nuevo");
        System.out.println("Dime el nombre del producto a introducir: ");
        setNombre(sc.nextLine());
        System.out.println("Dime la referencia/código EAN del producto:");
        setReferencia(sc.nextInt());
        System.out.println("Dime una descripción corta del producto");
        setDescripcion(sc.nextLine());
        System.out.println("Y para finalizar, danos el PVP");
        setPrecioventa(sc.nextDouble());
        System.out.println("El nuevo producto ha sido agregado, muchas gracias");
    }
    
}
    

