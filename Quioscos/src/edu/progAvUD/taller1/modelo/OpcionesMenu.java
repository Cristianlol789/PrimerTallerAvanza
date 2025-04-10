
package edu.progAvUD.taller1.modelo;

/**
 *
 * @author and
 */
public class OpcionesMenu {
    
    private String nombre;
    private double precioTotal;
    private double puntosEquivalentes;

    public OpcionesMenu(String nombre, double precioTotal, double puntosEquivalentes) {
        this.nombre = nombre;
        this.precioTotal = precioTotal;
        this.puntosEquivalentes = puntosEquivalentes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPuntosEquivalentes() {
        return puntosEquivalentes;
    }

    public void setPuntosEquivalentes(double puntosEquivalentes) {
        this.puntosEquivalentes = puntosEquivalentes;
    }
    
    
    
}
