package edu.progAvUD.taller1.modelo;

/**
 * Representa una presa de pollo como un tipo específico de {@link Producto}.
 *
 * Contiene información sobre la parte del pollo (muslo, ala, pechuga, etc.) y
 * el tipo de cocción (asado, frito, al horno, etc.).
 *
 * Hereda de la clase {@link Producto}.
 *
 * @author User
 */
public class PresaPollo extends Producto {

    private String parte;
    private String tipoCoccion;

    /**
     * Constructor para crear una presa de pollo.
     *
     * @param parte la parte del pollo (ej. muslo, pechuga, etc.)
     * @param tipoCoccion el tipo de cocción (ej. asado, frito, etc.)
     * @param nombre nombre del producto
     * @param descripcion descripción del producto
     * @param precio precio unitario del producto
     * @param puntosEquivalentes puntos equivalentes del producto
     */
    public PresaPollo(String parte, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.parte = parte;
        this.tipoCoccion = tipoCoccion;
    }

    /**
     * Obtiene la parte del pollo.
     *
     * @return la parte del pollo (ej. muslo, ala)
     */
    public String getParte() {
        return parte;
    }

    /**
     * Establece la parte del pollo.
     *
     * @param parte nueva parte del pollo
     */
    public void setParte(String parte) {
        this.parte = parte;
    }

    /**
     * Obtiene el tipo de cocción del producto.
     *
     * @return el tipo de cocción (ej. asado, frito)
     */
    public String getTipoCoccion() {
        return tipoCoccion;
    }

    /**
     * Establece el tipo de cocción del producto.
     *
     * @param tipoCoccion nuevo tipo de cocción
     */
    public void setTipoCoccion(String tipoCoccion) {
        this.tipoCoccion = tipoCoccion;
    }

}
