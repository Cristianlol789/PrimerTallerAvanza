package edu.progAvUD.taller1.modelo;

import java.awt.Image;

public class Nugget extends Producto{
    
    private String tipoNugget;
    private String terminoCoccion;

    public Nugget(String tipoNugget, String terminoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.tipoNugget = tipoNugget;
        this.terminoCoccion = terminoCoccion;
    }

    public String getTipoNugget() {
        return tipoNugget;
    }

    public void setTipoNugget(String tipoNugget) {
        this.tipoNugget = tipoNugget;
    }

    public String getTerminoCoccion() {
        return terminoCoccion;
    }

    public void setTerminoCoccion(String terminoCoccion) {
        this.terminoCoccion = terminoCoccion;
    }
    
}