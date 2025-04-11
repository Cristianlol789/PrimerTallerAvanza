package edu.progAvUD.taller1.modelo;

/**
 *
 * @author and
 */
public class OpcionesMenu {
    
    protected String nombreMenu;
    protected double precioTotalMenu;
    protected double puntosEquivalentesMenu;

    public OpcionesMenu(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu) {
        this.nombreMenu = nombreMenu;
        this.precioTotalMenu = precioTotalMenu;
        this.puntosEquivalentesMenu = puntosEquivalentesMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public double getPrecioTotalMenu() {
        return precioTotalMenu;
    }

    public void setPrecioTotalMenu(double precioTotalMenu) {
        this.precioTotalMenu = precioTotalMenu;
    }

    public double getPuntosEquivalentesMenu() {
        return puntosEquivalentesMenu;
    }

    public void setPuntosEquivalentesMenu(double puntosEquivalentesMenu) {
        this.puntosEquivalentesMenu = puntosEquivalentesMenu;
    }

}