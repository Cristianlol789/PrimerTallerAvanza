package edu.progAvUD.taller1.modelo;

import java.awt.Image;

/**
 *
 * @author and
 */
public class Unidad extends OpcionesMenu{
    
    private Producto producto;

    public Unidad(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto(nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}