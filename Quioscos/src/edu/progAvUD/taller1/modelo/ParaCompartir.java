package edu.progAvUD.taller1.modelo;

import java.awt.Image;

/**
 *
 * @author and
 */
public class ParaCompartir extends OpcionesMenu {
    
    private Producto[] producto;

    public ParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[3];
        this.producto[0] = new Producto(nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1);
        this.producto[1] = new Producto(nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2);
        this.producto[2] = new Producto(nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3);
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

}