package edu.progAvUD.taller1.modelo;

/**
 * Representa un producto de tipo "Wrap", que extiende las propiedades generales
 * de un producto agregando características específicas como el tipo de proteína
 * y el tipo de queso utilizados en su preparación.
 *
 * Esta clase es útil para modelar wraps personalizados dentro de un sistema de
 * pedidos.
 *
 * Autor: User
 */
public class Wrap extends Producto {

    /**
     * Tipo de proteína incluida en el wrap (ej. pollo, res, vegetariana)
     */
    private String tipoProteina;

    /**
     * Tipo de queso añadido al wrap (ej. cheddar, mozzarella, suizo)
     */
    private String tipoQueso;

    /**
     * Crea una nueva instancia de Wrap con todos los atributos necesarios.
     *
     * @param tipoProteina Tipo de proteína utilizada en el wrap.
     * @param tipoQueso Tipo de queso que contiene el wrap.
     * @param nombre Nombre del producto.
     * @param descripcion Descripción detallada del wrap.
     * @param precio Precio del wrap.
     * @param puntosEquivalentes Puntos de fidelidad que otorga el producto.
     */
    public Wrap(String tipoProteina, String tipoQueso, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoProteina = tipoProteina;
        this.tipoQueso = tipoQueso;
    }

    /**
     * Obtiene el tipo de proteína del wrap.
     *
     * @return Tipo de proteína.
     */
    public String getTipoProteina() {
        return tipoProteina;
    }

    /**
     * Establece el tipo de proteína del wrap.
     *
     * @param tipoProteina Nueva proteína a utilizar.
     */
    public void setTipoProteina(String tipoProteina) {
        this.tipoProteina = tipoProteina;
    }

    /**
     * Obtiene el tipo de queso del wrap.
     *
     * @return Tipo de queso.
     */
    public String getTipoQueso() {
        return tipoQueso;
    }

    /**
     * Establece el tipo de queso del wrap.
     *
     * @param tipoQueso Nuevo tipo de queso a utilizar.
     */
    public void setTipoQueso(String tipoQueso) {
        this.tipoQueso = tipoQueso;
    }
}
