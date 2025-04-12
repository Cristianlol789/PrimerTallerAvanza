package edu.progAvUD.taller1.modelo;

/**
 *
 * @author Cristianlol789
 */
public class Nugget extends Producto{
    
    private String tipoNugget;
    private String tipoCoccion;

    /**
     *
     * @param tipoNugget
     * @param tipoCoccion
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     */
    public Nugget(String tipoNugget, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoNugget = tipoNugget;
        this.tipoCoccion = tipoCoccion;
    }

    /**
     *
     * @return
     */
    public String getTipoNugget() {
        return tipoNugget;
    }

    /**
     *
     * @param tipoNugget
     */
    public void setTipoNugget(String tipoNugget) {
        this.tipoNugget = tipoNugget;
    }

    /**
     *
     * @return
     */
    public String getTipoCoccion() {
        return tipoCoccion;
    }

    /**
     *
     * @param terminoCoccion
     */
    public void setTipoCoccion(String terminoCoccion) {
        this.tipoCoccion = terminoCoccion;
    }
    
}