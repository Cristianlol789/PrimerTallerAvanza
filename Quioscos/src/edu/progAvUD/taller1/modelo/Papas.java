package edu.progAvUD.taller1.modelo;

/**
 *
 * @author and
 */
public class Papas extends Producto{
   
    private String tipoPapa;
    private String terminoCoccion;

    /**
     *
     * @param terminoCoccion
     * @param tipoPapa
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     */
    public Papas(String terminoCoccion, String tipoPapa, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoPapa = tipoPapa;
        this.terminoCoccion = terminoCoccion;
    }

    /**
     *
     * @return
     */
    public String getTerminoCoccion() {
        return terminoCoccion;
    }

    /**
     *
     * @param terminoCoccion
     */
    public void setTerminoCoccion(String terminoCoccion) {
        this.terminoCoccion = terminoCoccion;
    }

    /**
     *
     * @return
     */
    public String getTipoPapa() {
        return tipoPapa;
    }

    /**
     *
     * @param tipoPapa
     */
    public void setTipoPapa(String tipoPapa) {
        this.tipoPapa = tipoPapa;
    }
    
}