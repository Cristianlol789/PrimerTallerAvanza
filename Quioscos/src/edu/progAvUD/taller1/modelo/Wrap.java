package edu.progAvUD.taller1.modelo;

import java.awt.Image;

public class Wrap extends Producto{
    
    private String tipoProteina;
    private String tipoQueso;

    public Wrap(String tipoProteina, String tipoQueso, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.tipoProteina = tipoProteina;
        this.tipoQueso = tipoQueso;
    }

    public String getTipoProteina() {
        return tipoProteina;
    }

    public void setTipoProteina(String tipoProteina) {
        this.tipoProteina = tipoProteina;
    }

    public String getTipoQueso() {
        return tipoQueso;
    }

    public void setTipoQueso(String tipoQueso) {
        this.tipoQueso = tipoQueso;
    }
    
}