package edu.progAvUD.taller1.modelo;

import java.awt.Image;

/**
 *
 * @author and
 */
public class Unidad extends OpcionesMenu{
    
    private Producto producto;

    public Unidad(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto(nombre, descripcion, precio, puntosEquivalentes, imagen);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
