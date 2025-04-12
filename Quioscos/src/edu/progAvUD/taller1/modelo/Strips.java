package edu.progAvUD.taller1.modelo;

/**
 * Representa un producto de tipo "Strips", que extiende las propiedades
 * generales de un producto agregando detalles específicos como la especie (tipo
 * de carne) y el tipo de cocción.
 *
 * Ejemplo: Strips de pollo, cocidos al horno.
 *
 * Hereda de la clase {@link Producto}.
 *
 * Autor: Cristianlol789
 */
public class Strips extends Producto {

    /**
     * Especie del animal del que provienen los strips (ej. pollo, res, cerdo)
     */
    private String especie;

    /**
     * Tipo de cocción aplicado al producto (ej. frito, al horno, a la plancha)
     */
    private String tipoCoccion;

    /**
     * Crea una nueva instancia de Strips con la información completa del
     * producto.
     *
     * @param especie Especie de origen del producto.
     * @param tipoCoccion Tipo de cocción del producto.
     * @param nombre Nombre general del producto.
     * @param descripcion Descripción detallada del producto.
     * @param precio Precio del producto.
     * @param puntosEquivalentes Puntos de fidelidad asociados al producto.
     */
    public Strips(String especie, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.especie = especie;
        this.tipoCoccion = tipoCoccion;
    }

    /**
     * Obtiene la especie del producto.
     *
     * @return La especie (ej. pollo, res).
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Establece la especie del producto.
     *
     * @param especie Nueva especie del producto.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Obtiene el tipo de cocción del producto.
     *
     * @return Tipo de cocción (ej. frito, al horno).
     */
    public String getTipoCoccion() {
        return tipoCoccion;
    }

    /**
     * Establece el tipo de cocción del producto.
     *
     * @param tipoTostado Nuevo tipo de cocción.
     */
    public void setTipoCoccion(String tipoTostado) {
        this.tipoCoccion = tipoTostado;
    }
}
