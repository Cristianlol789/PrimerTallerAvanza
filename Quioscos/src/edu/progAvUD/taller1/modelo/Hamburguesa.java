package edu.progAvUD.taller1.modelo;


/**
 *
 * @author Cristianlol789
 */
public class Hamburguesa extends Producto{
    
    private String tipoPan;
    private String tipoCarne;

    /**
     *
     * @param tipoPan
     * @param tipoCarne
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     */
    public Hamburguesa(String tipoPan, String tipoCarne, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoPan = tipoPan;
        this.tipoCarne = tipoCarne;
    }

    /**
     *
     * @return
     */
    public String getTipoPan() {
        return tipoPan;
    }

    /**
     *
     * @param tipoPan
     */
    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }

    /**
     *
     * @return
     */
    public String getTipoCarne() {
        return tipoCarne;
    }

    /**
     *
     * @param tipoCarne
     */
    public void setTipoCarne(String tipoCarne) {
        this.tipoCarne = tipoCarne;
    }
    
}