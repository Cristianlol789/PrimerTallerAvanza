package edu.progAvUD.taller1.modelo;

/**
 * Representa un producto general que puede ser parte de un sistema de ventas o catálogo.
 * Contiene información básica como nombre, descripción, precio y puntos equivalentes.
 * 
 * @author User
 */
public class Producto {

    /** Nombre del producto */
    protected String nombre;

    /** Descripción detallada del producto */
    protected String descripcion;

    /** Precio del producto en la moneda local */
    protected double precio;

    /** Puntos equivalentes que otorga el producto (por ejemplo, para programas de fidelidad) */
    protected double puntosEquivalentes;

    /**
     * Crea una nueva instancia de Producto con los datos especificados.
     *
     * @param nombre Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param precio Precio del producto.
     * @param puntosEquivalentes Puntos equivalentes asociados al producto.
     */
    public Producto(String nombre, String descripcion, double precio, double puntosEquivalentes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.puntosEquivalentes = puntosEquivalentes;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el producto.
     *
     * @param nombre Nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece una nueva descripción para el producto.
     *
     * @param descripcion Nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece un nuevo precio para el producto.
     *
     * @param precio Nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene los puntos equivalentes del producto.
     *
     * @return La cantidad de puntos equivalentes.
     */
    public double getPuntosEquivalentes() {
        return puntosEquivalentes;
    }

    /**
     * Establece una nueva cantidad de puntos equivalentes para el producto.
     *
     * @param puntosEquivalentes Nueva cantidad de puntos equivalentes.
     */
    public void setPuntosEquivalentes(double puntosEquivalentes) {
        this.puntosEquivalentes = puntosEquivalentes;
    }
}
