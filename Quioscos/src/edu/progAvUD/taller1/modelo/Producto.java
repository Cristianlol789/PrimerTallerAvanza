package edu.progAvUD.taller1.modelo;

/**
 *
 * @author User
 */
public class Producto {
    
    /**
     *
     */
    protected String nombre;

    /**
     *
     */
    protected String descripcion;

    /**
     *
     */
    protected double precio;

    /**
     *
     */
    protected double puntosEquivalentes;

    /**
     *
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     */
    public Producto(String nombre, String descripcion, double precio, double puntosEquivalentes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.puntosEquivalentes = puntosEquivalentes;
    }
    
    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public double getPuntosEquivalentes() {
        return puntosEquivalentes;
    }

    /**
     *
     * @param puntosEquivalentes
     */
    public void setPuntosEquivalentes(double puntosEquivalentes) {
        this.puntosEquivalentes = puntosEquivalentes;
    }
}