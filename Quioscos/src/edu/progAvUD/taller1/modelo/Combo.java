package edu.progAvUD.taller1.modelo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author and
 */
public class Combo extends OpcionesMenu{
    
    private Producto[] producto;
    private HashMap<String, Boolean> agrandados; 
    private ArrayList<String> adiciones;

    public Combo(HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3, String nombre4, String descripcion4, double precio4, double puntosEquivalentes4, Image imagen4) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[4];
        this.producto[0] = new Producto(nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1);
        this.producto[1] = new Producto(nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2);
        this.producto[2] = new Producto(nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3);
        this.producto[3] = new Producto(nombre4, descripcion4, precio4, puntosEquivalentes4, imagen4);
        this.agrandados = agrandados;
        this.adiciones = adiciones;
    }
    
    public HashMap<String, Boolean> getAgrandados() {
        return agrandados;
    }

    public void setAgrandados(HashMap<String, Boolean> agrandados) {
        this.agrandados = agrandados;
    }

    public ArrayList<String> getAdiciones() {
        return adiciones;
    }

    public void setAdiciones(ArrayList<String> adiciones) {
        this.adiciones = adiciones;
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

}
