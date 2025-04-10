package edu.progAvUD.taller1.modelo;

import java.awt.Image;

/**
 *
 * @author and
 */
public class Papas extends Producto{
    
    private String terminoCoccion;
    private String tipoPapa;

    public Papas(String terminoCoccion, String tipoPapa, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombre, descripcion, precio, puntosEquivalentes, imagen);
        this.terminoCoccion = terminoCoccion;
        this.tipoPapa = tipoPapa;
    }

    public String getTerminoCoccion() {
        return terminoCoccion;
    }

    public void setTerminoCoccion(String terminoCoccion) {
        this.terminoCoccion = terminoCoccion;
    }

    public String getTipoPapa() {
        return tipoPapa;
    }

    public void setTipoPapa(String tipoPapa) {
        this.tipoPapa = tipoPapa;
    }
    
}
