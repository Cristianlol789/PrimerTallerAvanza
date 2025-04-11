package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;
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

    public Combo(Producto[] producto, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, ControlProducto controlProducto, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1,String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2 , String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[4];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, "Bebida");
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, "Papas");
        this.producto[3] = controlProducto.crearProducto(tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, "Strips");
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