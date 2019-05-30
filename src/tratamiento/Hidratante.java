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
public class Hidratante extends Tratamiento{
    private String ingrediente_principal;

    public Hidratante() {
    }

    public Hidratante(String ingrediente_principal, String nombre, String descripcion, int referencia, double precioventa) {
        super(nombre, descripcion, referencia, precioventa);
        this.ingrediente_principal = ingrediente_principal;
    }

    public String getIngrediente_principal() {
        return ingrediente_principal;
    }

    public void setIngrediente_principal(String ingrediente_principal) {
        this.ingrediente_principal = ingrediente_principal;
    }     

    /**
     * Método para mostrarnos los atributos del objeto
     */
    @Override
    public void mostrarTratamiento() {
        super.mostrarTratamiento();
        System.out.println("Ingrediente principal: "+ this.ingrediente_principal);
    }

    /**
     * Método para dar de alta por el usuario un nuevo tratamiento 
     */
    @Override
    public void introducirTratamiento() {
        Scanner sc = new Scanner(System.in);
        super.introducirTratamiento();
        System.out.println("¿Cuál es el ingrediente principal?");
        setIngrediente_principal(sc.nextLine());
        System.out.println("El nuevo producto ha sido agregado, muchas gracias");
                
    }
    
    
}
