
package edu.progAvUD.taller1.modelo;

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

    public Combo(Producto[] producto, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, String nombre, double precioTotal, double puntosEquivalentes) {
        super(nombre, precioTotal, puntosEquivalentes);
        this.producto = new Producto[4];
        this.producto[0] = producto[0];
        this.producto[1] = producto[1];
        this.producto[2] = producto[2];
        this.producto[3] = producto[3];
    
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
