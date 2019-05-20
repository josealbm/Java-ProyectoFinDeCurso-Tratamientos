/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;


import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author infor15
 */
public class Cliente {
    private String DNI;
    private String nombre;
    private String apellido;
    private String codigo_postal;
    private int telefono;
    private Date fecha_registro;

    public Cliente() {
    }

    public Cliente(String DNI, String nombre, String apellido, 
            String codigo_postal, int telefono, Date fecha_registro) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo_postal = codigo_postal;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

     public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    public void altaCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a dar de alta un cliente nuevo");
        System.out.println("Por favor, introduce el documento del cliente");
        setDNI(sc.nextLine());
        System.out.println("Escribe el nombre");
        setNombre(sc.nextLine());
        System.out.println("Ahora el apellido");
        setApellido(sc.nextLine());
        System.out.println("Introduce el código postal");
        setCodigo_postal(sc.nextLine());
        System.out.println("Escribe el número de contacto");
        setTelefono(sc.nextInt());
        System.out.println("");
                
        
    }
    
    
}
