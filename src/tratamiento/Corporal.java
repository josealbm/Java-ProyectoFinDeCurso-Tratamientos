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
public class Corporal extends Tratamiento{
    private String zona_cuerpo;
    private String ingrediente_principal;

    public Corporal() {
    }

    public Corporal(String zona_cuerpo, String ingrediente_principal, String nombre, String descripcion, int referencia, double precioventa) {
        super(nombre, descripcion, referencia, precioventa);
        this.zona_cuerpo = zona_cuerpo;
        this.ingrediente_principal = ingrediente_principal;
    }

    public String getZona_cuerpo() {
        return zona_cuerpo;
    }

    public void setZona_cuerpo(String zona_cuerpo) {
        this.zona_cuerpo = zona_cuerpo;
    }

    public String getIngrediente_principal() {
        return ingrediente_principal;
    }

    public void setIngrediente_principal(String ingrediente_principal) {
        this.ingrediente_principal = ingrediente_principal;
    } 
      
    @Override
    public void mostrarTratamiento() {
        System.out.println("Referencia: "+ this.referencia);
        System.out.println("Descripción: "+ this.descripcion);
        System.out.println("Ingrediente principal: "+ this.ingrediente_principal);
        System.out.println("Zona corporal del tratamiento: "+ this.zona_cuerpo);
        System.out.println("Precio de venta al público: " + this.precioventa);
    }

    @Override
    public void introducirTratamiento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a dar de alta un tratamiento facial nuevo");
        System.out.println("Dime la referencia/código EAN del producto:");
        setReferencia(sc.nextInt());
        System.out.println("Cuál es el nombre del producto");
        setNombre(sc.nextLine());
        System.out.println("Dime una descripción corta del producto");
        setDescripcion(sc.nextLine());
        System.out.println("¿Cuál es el ingrediente principal?");
        setIngrediente_principal(sc.nextLine());
        System.out.println("¿A qué zona del cuerpo pertenece este tratamiento?");
        setZona_cuerpo(sc.nextLine());
        System.out.println("Y para finalizar, danos el PVP");
        setPrecioventa(sc.nextDouble());
        System.out.println("El nuevo producto ha sido agregado, muchas gracias");
    }
    
}
