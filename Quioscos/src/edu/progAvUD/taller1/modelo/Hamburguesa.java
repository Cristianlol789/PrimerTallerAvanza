
package edu.progAvUD.taller1.modelo;

import java.awt.Image;

public class Hamburguesa extends Producto{
    
    private String tipoPan;
    private String tipoCarne;

    public Hamburguesa(String tipoDePan, String tipoDeCarne, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.tipoPan = tipoDePan;
        this.tipoCarne = tipoDeCarne;
    }

    public String getTipoPan() {
        return tipoPan;
    }

    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }

    public String getTipoCarne() {
        return tipoCarne;
    }

    public void setTipoCarne(String tipoCarne) {
        this.tipoCarne = tipoCarne;
    }
    
}
