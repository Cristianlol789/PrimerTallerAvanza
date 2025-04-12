package edu.progAvUD.taller1.modelo;

/**
 * Representa un producto de tipo Papas dentro del sistema.
 *
 * Esta clase extiende {@link Producto} y agrega atributos específicos
 * relacionados con el tipo de papa y el término de cocción.
 *
 * Puede ser parte de un combo o adquirirse individualmente.
 *
 * @author and
 */
public class Papas extends Producto {

    /**
     * Tipo de papa (ej. a la francesa, rústica, wedges, etc.).
     */
    private String tipoPapa;

    /**
     * Término de cocción de las papas (ej. crocantes, suaves, al horno, etc.).
     */
    private String terminoCoccion;

    /**
     * Constructor para crear una nueva instancia de Papas con sus atributos
     * específicos.
     *
     * @param terminoCoccion término de cocción de las papas
     * @param tipoPapa tipo de papa
     * @param nombre nombre del producto
     * @param descripcion descripción del producto
     * @param precio precio del producto
     * @param puntosEquivalentes puntos acumulables por el producto
     */
    public Papas(String terminoCoccion, String tipoPapa, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoPapa = tipoPapa;
        this.terminoCoccion = terminoCoccion;
    }

    /**
     * Obtiene el término de cocción de las papas.
     *
     * @return término de cocción
     */
    public String getTerminoCoccion() {
        return terminoCoccion;
    }

    /**
     * Establece el término de cocción de las papas.
     *
     * @param terminoCoccion nuevo término de cocción
     */
    public void setTerminoCoccion(String terminoCoccion) {
        this.terminoCoccion = terminoCoccion;
    }

    /**
     * Obtiene el tipo de papa.
     *
     * @return tipo de papa
     */
    public String getTipoPapa() {
        return tipoPapa;
    }

    /**
     * Establece el tipo de papa.
     *
     * @param tipoPapa nuevo tipo de papa
     */
    public void setTipoPapa(String tipoPapa) {
        this.tipoPapa = tipoPapa;
    }

}
