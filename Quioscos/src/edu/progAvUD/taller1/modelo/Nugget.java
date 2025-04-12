package edu.progAvUD.taller1.modelo;

import java.awt.Image;

public class Nugget extends Producto{
    
    private String tipoNugget;
    private String tipoCoccion;

    public Nugget(String tipoNugget, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.tipoNugget = tipoNugget;
        this.tipoCoccion = tipoCoccion;
    }

    public String getTipoNugget() {
        return tipoNugget;
    }

    public void setTipoNugget(String tipoNugget) {
        this.tipoNugget = tipoNugget;
    }

    public String getTipoCoccion() {
        return tipoCoccion;
    }

    public void setTipoCoccion(String terminoCoccion) {
        this.tipoCoccion = terminoCoccion;
    }
    
}