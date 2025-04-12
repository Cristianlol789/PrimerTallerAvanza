package edu.progAvUD.taller1.modelo;

/**
 * Clase base que representa una opción genérica del menú.
 *
 * Esta clase agrupa los atributos comunes a cualquier opción de menú, como el
 * nombre, el precio total y los puntos equivalentes que puede acumular un
 * cliente.
 *
 * Es utilizada como clase padre para elementos específicos como {@link Combo} y
 * {@link Bucket}.
 *
 * @author and
 */
public class OpcionesMenu {

    /**
     * Nombre de la opción de menú.
     */
    protected String nombreMenu;

    /**
     * Precio total de la opción de menú.
     */
    protected double precioTotalMenu;

    /**
     * Puntos equivalentes que se otorgan por adquirir esta opción de menú.
     */
    protected double puntosEquivalentesMenu;

    /**
     * Constructor para crear una nueva opción de menú.
     *
     * @param nombreMenu nombre de la opción de menú
     * @param precioTotalMenu precio total de la opción
     * @param puntosEquivalentesMenu puntos acumulables por esta opción
     */
    public OpcionesMenu(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu) {
        this.nombreMenu = nombreMenu;
        this.precioTotalMenu = precioTotalMenu;
        this.puntosEquivalentesMenu = puntosEquivalentesMenu;
    }

    /**
     * Obtiene el nombre de la opción de menú.
     *
     * @return nombre del menú
     */
    public String getNombreMenu() {
        return nombreMenu;
    }

    /**
     * Establece el nombre de la opción de menú.
     *
     * @param nombreMenu nuevo nombre
     */
    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    /**
     * Obtiene el precio total de la opción de menú.
     *
     * @return precio total
     */
    public double getPrecioTotalMenu() {
        return precioTotalMenu;
    }

    /**
     * Establece el precio total de la opción de menú.
     *
     * @param precioTotalMenu nuevo precio
     */
    public void setPrecioTotalMenu(double precioTotalMenu) {
        this.precioTotalMenu = precioTotalMenu;
    }

    /**
     * Obtiene la cantidad de puntos equivalentes otorgados por esta opción.
     *
     * @return puntos equivalentes
     */
    public double getPuntosEquivalentesMenu() {
        return puntosEquivalentesMenu;
    }

    /**
     * Establece la cantidad de puntos equivalentes para esta opción.
     *
     * @param puntosEquivalentesMenu nuevos puntos equivalentes
     */
    public void setPuntosEquivalentesMenu(double puntosEquivalentesMenu) {
        this.puntosEquivalentesMenu = puntosEquivalentesMenu;
    }

}
