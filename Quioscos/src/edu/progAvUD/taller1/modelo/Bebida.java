package edu.progAvUD.taller1.modelo;

import java.awt.Image;

/**
 *
 * @author and
 */

public class Bebida extends Producto{
    
    private String tipoBebida;
    private String sabor;

    public Bebida(String tipoBebida, String sabor, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.tipoBebida = tipoBebida;
        this.sabor = sabor;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
}
