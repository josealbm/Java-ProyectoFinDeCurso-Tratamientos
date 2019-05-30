/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Date fecha_nacimiento;
    private Date fecha_registro;

    public Cliente() {
    }

    public Cliente(String DNI, String nombre, String apellido, 
            String codigo_postal, int telefono, Date fecha_nacimiento, 
            Date fecha_registro) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo_postal = codigo_postal;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_registro = null;
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
    
    public void altaCliente(Connection con) throws SQLException, ParseException {
        Scanner sc = new Scanner(System.in);
        String insert = "INSERT INTO Clientes VALUES "
                        + "(?, ?, ?, ?, ?);";
        PreparedStatement pst = con.prepareStatement(insert);
        System.out.println("Vamos a dar de alta un cliente nuevo");
        System.out.println("Por favor, introduce el documento del cliente");
        pst.setString(1, sc.nextLine());
        System.out.println("Escribe el nombre");
        pst.setString(1, sc.nextLine());
        System.out.println("Ahora el apellido");
        pst.setString(2, sc.nextLine());
        System.out.println("Introduce el código postal");
        pst.setString(3, sc.nextLine());
        System.out.println("Escribe el número de contacto");
        pst.setInt(4, sc.nextInt());
        System.out.println("Escribe la fecha de nacimiento del cliente "
                + "año/mes/dia");
        /*Para darle formato a la fecha, primero la introducimos como String
        *para luego transformarla en clase Date. A la hora de introducirlo en 
        *la DB netbeans nos indica que tenemos que hacer cast a java.sql.Date.
        */
        sc.nextLine();
        String data = sc.nextLine();
        DateFormat format = new SimpleDateFormat("YYYY/MM/DD");
        Date fecha = format.parse(data);
        pst.setDate(5, (java.sql.Date) fecha);
        System.out.println("El nuevo cliente ha sido dado de alta correctamente");
                  
        
    }
    public void buscarCliente(Connection con, String nif) throws SQLException {
        Statement st = con.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el DNI del cliente para poder buscarlo:");
        nif = sc.nextLine();
        ResultSet rs = st.executeQuery("select * from clientes where nif="+nif);
         
         }
  
}
