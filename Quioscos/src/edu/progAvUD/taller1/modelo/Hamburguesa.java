package edu.progAvUD.taller1.modelo;

/**
 * Representa una hamburguesa dentro del sistema, como un tipo específico de
 * {@link Producto}.
 *
 * Esta clase extiende la clase base `Producto` añadiendo características
 * específicas de una hamburguesa, como el tipo de pan y el tipo de proteína.
 *
 * Puede utilizarse como parte de un combo o como producto individual en el
 * menú.
 *
 * @author Cristianlol789
 */
public class Hamburguesa extends Producto {

    /**
     * Tipo de pan utilizado en la hamburguesa (ej. pan brioche, pan integral,
     * etc.).
     */
    private String tipoPan;

    /**
     * Tipo de proteína en la hamburguesa (ej. carne de res, pollo, vegetariana,
     * etc.).
     */
    private String tipoProteina;

    /**
     * Crea una nueva hamburguesa con sus características específicas, además de
     * los atributos generales del producto.
     *
     * @param tipoPan tipo de pan usado en la hamburguesa
     * @param tipoProteina tipo de proteína (carne) en la hamburguesa
     * @param nombre nombre del producto
     * @param descripcion descripción del producto
     * @param precio precio del producto
     * @param puntosEquivalentes puntos otorgados por la compra del producto
     */
    public Hamburguesa(String tipoPan, String tipoProteina, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoPan = tipoPan;
        this.tipoProteina = tipoProteina;
    }

    /**
     * Obtiene el tipo de pan de la hamburguesa.
     *
     * @return tipo de pan
     */
    public String getTipoPan() {
        return tipoPan;
    }

    /**
     * Establece el tipo de pan de la hamburguesa.
     *
     * @param tipoPan nuevo tipo de pan
     */
    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }

    /**
     * Obtiene el tipo de proteína de la hamburguesa.
     *
     * @return tipo de proteína
     */
    public String getTipoProteina() {
        return tipoProteina;
    }

    /**
     * Establece el tipo de proteína de la hamburguesa.
     *
     * @param tipoProteina nuevo tipo de proteína
     */
    public void setTipoProteina(String tipoProteina) {
        this.tipoProteina = tipoProteina;
    }
}
