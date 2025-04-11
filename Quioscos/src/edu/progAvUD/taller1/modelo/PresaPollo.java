package edu.progAvUD.taller1.modelo;

import java.awt.Image;

public class PresaPollo extends Producto {

    private String parte;

    public PresaPollo(String parte, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.parte = parte;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

}
