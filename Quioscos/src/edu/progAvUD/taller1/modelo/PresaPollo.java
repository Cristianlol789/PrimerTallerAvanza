package edu.progAvUD.taller1.modelo;

import java.awt.Image;


public class PresaPollo extends Producto{

    private String parte;
    private String tipoCoccion;

    public PresaPollo(String parte, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.parte = parte;
        this.tipoCoccion = tipoCoccion;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public String getTipoCoccion() {
        return tipoCoccion;
    }

    public void setTipoCoccion(String tipoCoccion) {
        this.tipoCoccion = tipoCoccion;
    }
    
}
