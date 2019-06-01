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
public class Tratamiento{
    protected Integer ean;
    protected String marca;
    

    public Tratamiento() {
    }

    public Tratamiento(Integer ean, String marca) {
        this.ean = ean;
        this.marca = marca;
    }

     
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

        
    public void mostrarTratamiento(){
        System.out.println("Ean del producto: " + this.ean);
        System.out.println("Nombre del producto: "+ this.marca);
        
    }
    /**
     * Método para dar de alta un nuevo tratamiento 
     * @param con 
     * @throws java.sql.SQLException 
     */
    public void introducirTratamiento(Connection con) throws SQLException{
        Scanner sc = new Scanner(System.in);
        String insert = "INSERT INTO tratamiento (ean, marca)"
                        + " VALUES (?, ?);";
        PreparedStatement pst = con.prepareStatement(insert);
        System.out.println("Vamos a dar de alta un nuevo producto");
        System.out.println("Escribe el código ean");
        pst.setInt(1, sc.nextInt());
        System.out.println("Dime el nombre del producto a introducir: ");
        //si no introducimos esta línea de entrada, la siguiente no funciona
        sc.nextLine(); 
        pst.setString(2, sc.nextLine());
        pst.execute();
        System.out.println("El nuevo tratamiento se ha introducido "
                + "correctamente");
        }
    
}
    

