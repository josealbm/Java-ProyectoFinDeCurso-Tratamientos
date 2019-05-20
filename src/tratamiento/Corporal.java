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
      
    /**
     * Método para mostrar los atributos del objeto Corporal
     */
    @Override
    public void mostrarTratamiento() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Referencia: "+ this.referencia);
        System.out.println("Descripción: "+ this.descripcion);
        System.out.println("Ingrediente principal: "+ this.ingrediente_principal);
        System.out.println("Zona corporal del tratamiento: "+ this.zona_cuerpo);
        System.out.println("Precio de venta al público: " + this.precioventa);
    }

    /**
     * Método para introducir un tratamiento Corporal nuevo
     */
    @Override
    public void introducirTratamiento() {
        Scanner sc = new Scanner(System.in);
        super.introducirTratamiento();
        System.out.println("¿A qué zona del cuerpo pertenece este tratamiento?");
        setZona_cuerpo(sc.nextLine());
        System.out.println("¿Cuál es el ingrediente principal?");
        setIngrediente_principal(sc.nextLine());
        System.out.println("El nuevo producto ha sido agregado, muchas gracias");
    }
    
}
