package edu.progAvUD.taller1.modelo;

/**
 *
 * @author User
 */
public class PresaPollo extends Producto {

    private String parte;
    private String tipoCoccion;

    /**
     *
     * @param parte
     * @param tipoCoccion
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     */
    public PresaPollo(String parte, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.parte = parte;
        this.tipoCoccion = tipoCoccion;
    }

    /**
     *
     * @return
     */
    public String getParte() {
        return parte;
    }

    /**
     *
     * @param parte
     */
    public void setParte(String parte) {
        this.parte = parte;
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
     * @param tipoCoccion
     */
    public void setTipoCoccion(String tipoCoccion) {
        this.tipoCoccion = tipoCoccion;
    }

}