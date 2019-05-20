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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir){    
            System.out.println("Escoge una opción");
            System.out.println("1. Gestión de stock");
            System.out.println("2. Gestión de clientes");
            System.out.println("3. Venta");
            System.out.println("4. Salir");
            int opcion = sc.nextInt();
            switch(opcion){
                case(1):{
                    boolean salir2=false;
                    while (!salir2){
                        System.out.println("Escoge una opción");
                        System.out.println("1. Introducir producto nuevo");
                        System.out.println("2. Introducir albarán");
                        System.out.println("3. Mostrar producto");
                        System.out.println("4. Salir");                                       
                        int opcion2 = sc.nextInt();
                        switch (opcion2){
                            case 1: {
                                //introducirTratamiento();
                                break;
                            }
                            case 2: {
                                //introducirAlbaran();
                                break;
                            }
                            case 3: {
                                //mostrarTratamiento();
                            }
                            case 4: {
                                salir2=true;
                                break;
                                }
                            default:
                                System.out.println("Por favor, escoge una opción"
                                        + "válida");
                        }
                        
                    }
                    break;
                }    
                case 2: {
                    boolean salir2 = false;
                    while (!salir2){
                        System.out.println("Escoge una opción");
                        System.out.println("1. Dar de alta cliente");
                        System.out.println("2. Aplicar descuento a clientes");
                        System.out.println("3. Salir");
                        int opcion2 = sc.nextInt();
                        
                        switch (opcion2){
                            case 1: {
                                Cliente cust = new Cliente();
                                cust.altaCliente();
                                break;
                            }
                            case 2: {
                                //aplicarDescuento();
                                break;
                            }
                            case 3: {
                                salir2=true;
                                break;
                            }
                        }
                    }
                } 
                case 3: {
                    //mierda
                    break;
                }
                
                
                    
                
                 }
    
            }
        }
    }