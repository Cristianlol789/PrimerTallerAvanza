
package edu.progAvUD.taller1.modelo;

import java.awt.Image;

public class Wrap extends Producto{
    
    private String proteina;

    public Wrap(String proteina, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.proteina = proteina;
    }

    public String getProteina() {
        return proteina;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }
    
}
