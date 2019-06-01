/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.text.ParseException;
import java.util.Scanner;
import static tratamiento.Cliente.buscarCliente;

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
        try (Connection con = DriverManager.getConnection
          ("jdbc:mysql://192.168.0.32:3306/naturness", "alumne", "alualualu")) {
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
                            System.out.println("2. Crear tratamiento hidratante");
                            System.out.println("3. Crear tratamiento antiedad");
                            System.out.println("4. Búsqueda de un tratamiento");
                            System.out.println("5. Salir");
                            int opcion2 = sc.nextInt();
                            switch (opcion2){
                                case 1: {
                                    Tratamiento trat = new Tratamiento();
                                    trat.introducirTratamiento(con);
                                    break;
                                }
                                case 2: {
                                    Hidratante hidr = new Hidratante();
                                    hidr.introducirTratamiento(con);
                                    break;
                                }
                                case 3: {
                                    Antiedad anti = new Antiedad();
                                    anti.introducirTratamiento(con);
                                    break;
                                }
                                case 4: {
                                    //buscarTratamiento()
                                    break;
                                }
                                case 5: {
                                    salir2=true;
                                    break;
                                    }
                                default:
                                    System.out.println("Por favor, escoge una "
                                            + "opción válida");
                            }

                        }
                        break;
                    }    
                    case 2: {
                        boolean salir2 = false;
                        while (!salir2){
                            System.out.println("Escoge una opción");
                            System.out.println("1. Dar de alta cliente");
                            System.out.println("2. Buscar un cliente por DNI");
                            System.out.println("3. Buscar un cliente por nº de teléfono");
                            System.out.println("4. Salir");
                            int opcion2 = sc.nextInt();

                            switch (opcion2){
                                case 1: {
                                    Cliente cust = new Cliente();
                                    cust.altaCliente(con);
                                    break;
                                }
                                case 2: {
                                    buscarCliente(con, sc.nextLine());
                                    break;
                                }
                                case 3: {
                                    buscarCliente(con, sc.nextInt());
                                    break;
                                      
                                }
                                case 4: {
                                    salir2=true;
                                    break;
                                }
                                default: {
                                    System.out.println("Por favor, escoge una"
                                            + "opción válida");
                                }
                            }
                        }
                    } 
                    case 3: {
                        //mierda
                        break;
                    }
                    default: {
                        System.out.println("Por favor, escoge una opción válida");
                    }
                           

                }

                }
        } catch (SQLException ex) {
            System.out.println("Error SQL " + ex.getMessage());
        } catch (Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }
}