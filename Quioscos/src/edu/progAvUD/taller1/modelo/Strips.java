package edu.progAvUD.taller1.modelo;

import java.awt.Image;

/**
 *
 * @author Cristianlol789
 */
public class Strips extends Producto{
    
    private String especie;
    private String tipoCoccion;

    public Strips(String especie, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.especie = especie;
        this.tipoCoccion = tipoCoccion;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTipoCoccion() {
        return tipoCoccion;
    }

    public void setTipoCoccion(String tipoTostado) {
        this.tipoCoccion = tipoTostado;
    }
    
}
