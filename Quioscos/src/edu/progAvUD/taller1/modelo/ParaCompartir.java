package edu.progAvUD.taller1.modelo;

import java.awt.Image;

/**
 *
 * @author and
 */
public class ParaCompartir extends OpcionesMenu {
    
    private Producto[] producto;

    public ParaCompartir(String nombre, double precioTotal, double puntosEquivalentes,String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3) {
        super(nombre, precioTotal, puntosEquivalentes);
        this.producto = new Producto[3];
        this.producto[0] = new Producto(nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1);
        this.producto[1] = new Producto(nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2);
        this.producto[2] = new Producto(nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3);
    }

    public ParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3, String nombre4, String descripcion4, double precio4, double puntosEquivalentes4, Image imagen4, String nombre5, String descripcion5, double precio5, double puntosEquivalentes5, Image imagen5, String nombre6, String descripcion6, double precio6, double puntosEquivalentes6, Image imagen6) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[6];
        this.producto[0] = new Producto(nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1);
        this.producto[1] = new Producto(nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2);
        this.producto[2] = new Producto(nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3);
        this.producto[3] = new Producto(nombre4, descripcion4, precio4, puntosEquivalentes4, imagen4);
        this.producto[4] = new Producto(nombre5, descripcion5, precio5, puntosEquivalentes5, imagen5);
        this.producto[5] = new Producto(nombre6, descripcion6, precio6, puntosEquivalentes6, imagen6);
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

}
