package edu.progAvUD.taller1.modelo;

/**
 *
 * @author User
 */
public class Wrap extends Producto{
    
    private String tipoProteina;
    private String tipoQueso;

    /**
     *
     * @param tipoProteina
     * @param tipoQueso
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     */
    public Wrap(String tipoProteina, String tipoQueso, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoProteina = tipoProteina;
        this.tipoQueso = tipoQueso;
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

    /**
     *
     * @return
     */
    public String getTipoQueso() {
        return tipoQueso;
    }

    /**
     *
     * @param tipoQueso
     */
    public void setTipoQueso(String tipoQueso) {
        this.tipoQueso = tipoQueso;
    }
    
}