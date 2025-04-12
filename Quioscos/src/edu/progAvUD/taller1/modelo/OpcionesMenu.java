package edu.progAvUD.taller1.modelo;

/**
 *
 * @author and
 */
public class OpcionesMenu {
    
    /**
     *
     */
    protected String nombreMenu;

    /**
     *
     */
    protected double precioTotalMenu;

    /**
     *
     */
    protected double puntosEquivalentesMenu;

    /**
     *
     * @param nombreMenu
     * @param precioTotalMenu
     * @param puntosEquivalentesMenu
     */
    public OpcionesMenu(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu) {
        this.nombreMenu = nombreMenu;
        this.precioTotalMenu = precioTotalMenu;
        this.puntosEquivalentesMenu = puntosEquivalentesMenu;
    }

    /**
     *
     * @return
     */
    public String getNombreMenu() {
        return nombreMenu;
    }

    /**
     *
     * @param nombreMenu
     */
    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    /**
     *
     * @return
     */
    public double getPrecioTotalMenu() {
        return precioTotalMenu;
    }

    /**
     *
     * @param precioTotalMenu
     */
    public void setPrecioTotalMenu(double precioTotalMenu) {
        this.precioTotalMenu = precioTotalMenu;
    }

    /**
     *
     * @return
     */
    public double getPuntosEquivalentesMenu() {
        return puntosEquivalentesMenu;
    }

    /**
     *
     * @param puntosEquivalentesMenu
     */
    public void setPuntosEquivalentesMenu(double puntosEquivalentesMenu) {
        this.puntosEquivalentesMenu = puntosEquivalentesMenu;
    }

}