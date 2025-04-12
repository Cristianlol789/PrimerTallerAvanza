package edu.progAvUD.taller1.modelo;

/**
 *
 * @author Cristianlol789
 */
public class Strips extends Producto{
    
    private String especie;
    private String tipoCoccion;

    /**
     *
     * @param especie
     * @param tipoCoccion
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     */
    public Strips(String especie, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.especie = especie;
        this.tipoCoccion = tipoCoccion;
    }

    /**
     *
     * @return
     */
    public String getEspecie() {
        return especie;
    }

    /**
     *
     * @param especie
     */
    public void setEspecie(String especie) {
        this.especie = especie;
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
     * @param tipoTostado
     */
    public void setTipoCoccion(String tipoTostado) {
        this.tipoCoccion = tipoTostado;
    }
    
}
