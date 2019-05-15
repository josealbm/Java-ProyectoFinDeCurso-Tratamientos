/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamiento;

/**
 *
 * @author josealberto
 */
public abstract class Tratamiento{
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
    
    public abstract void mostrarTratamiento();
    
    public abstract void introducirTratamiento();
    
}
    

