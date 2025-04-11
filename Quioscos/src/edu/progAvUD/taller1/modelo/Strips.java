package edu.progAvUD.taller1.modelo;

import java.awt.Image;

/**
 *
 * @author Cristianlol789
 */
public class Strips extends Producto{
    
    private String especie;
    private String tipoTostado;

    public Strips(String especie, String tipoTostado, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.especie = especie;
        this.tipoTostado = tipoTostado;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTipoTostado() {
        return tipoTostado;
    }

    public void setTipoTostado(String tipoTostado) {
        this.tipoTostado = tipoTostado;
    }
    
}
