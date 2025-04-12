package edu.progAvUD.taller1.modelo;


/**
 *
 * @author Cristianlol789
 */
public class Hamburguesa extends Producto{
    
    private String tipoPan;
    private String tipoProteina;

    /**
     *
     * @param tipoPan
     * @param tipoProteina
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     */
    public Hamburguesa(String tipoPan, String tipoProteina, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoPan = tipoPan;
        this.tipoProteina = tipoProteina;
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
    public String getTipoProteina() {
        return tipoProteina;
    }

    /**
     *
     * @param tipoProteina
     */
    public void setTipoProteina(String tipoProteina) {
        this.tipoProteina = tipoProteina;
    }
    
}