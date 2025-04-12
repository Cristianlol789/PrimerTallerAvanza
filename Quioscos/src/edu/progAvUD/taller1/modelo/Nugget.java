package edu.progAvUD.taller1.modelo;

/**
 * Representa un producto de tipo Nugget dentro del sistema.
 *
 * Esta clase extiende {@link Producto} y añade características específicas de
 * los nuggets, como su tipo y el término de cocción.
 *
 * Puede formar parte de un combo o ser adquirido como producto individual.
 *
 * @author Cristianlol789
 */
public class Nugget extends Producto {

    /**
     * Tipo de nugget (ej. clásico, picante, vegetariano, etc.).
     */
    private String tipoNugget;

    /**
     * Tipo o término de cocción del nugget (ej. frito, al horno, aire caliente,
     * etc.).
     */
    private String tipoCoccion;

    /**
     * Constructor para crear un objeto Nugget con sus características
     * específicas.
     *
     * @param tipoNugget tipo del nugget
     * @param tipoCoccion tipo de cocción del nugget
     * @param nombre nombre del producto
     * @param descripcion descripción del producto
     * @param precio precio del producto
     * @param puntosEquivalentes puntos acumulables del producto
     */
    public Nugget(String tipoNugget, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoNugget = tipoNugget;
        this.tipoCoccion = tipoCoccion;
    }

    /**
     * Obtiene el tipo de nugget.
     *
     * @return tipo de nugget
     */
    public String getTipoNugget() {
        return tipoNugget;
    }

    /**
     * Establece el tipo de nugget.
     *
     * @param tipoNugget nuevo tipo de nugget
     */
    public void setTipoNugget(String tipoNugget) {
        this.tipoNugget = tipoNugget;
    }

    /**
     * Obtiene el tipo o término de cocción del nugget.
     *
     * @return tipo de cocción
     */
    public String getTipoCoccion() {
        return tipoCoccion;
    }

    /**
     * Establece el tipo o término de cocción del nugget.
     *
     * @param terminoCoccion nuevo tipo de cocción
     */
    public void setTipoCoccion(String terminoCoccion) {
        this.tipoCoccion = terminoCoccion;
    }
}
