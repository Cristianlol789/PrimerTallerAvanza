package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;
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

    /**
     *
     * @param nombreMenu
     * @param precioTotalMenu
     * @param puntosEquivalentesMenu
     * @param tipo
     * @param coccion
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     * @param identificador
     * @param tipo1
     * @param coccion1
     * @param nombre1
     * @param descripcion1
     * @param precio1
     * @param puntosEquivalentes1
     * @param tipo2
     * @param coccion2
     * @param nombre2
     * @param descripcion2
     * @param precio2
     * @param puntosEquivalentes2
     * @param tipo3
     * @param coccion3
     * @param nombre3
     * @param descripcion3
     * @param precio3
     * @param puntosEquivalentes3
     * @param agrandados
     * @param adiciones
     * @param controlProducto
     */
    public Combo(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[4];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, "Bebida");
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, "Papas");
        this.producto[3] = controlProducto.crearProducto(tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, "Strips");
        this.agrandados = agrandados;
        this.adiciones = adiciones;
    }
    
    /**
     *
     * @return
     */
    public HashMap<String, Boolean> getAgrandados() {
        return agrandados;
    }

    /**
     *
     * @param agrandados
     */
    public void setAgrandados(HashMap<String, Boolean> agrandados) {
        this.agrandados = agrandados;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getAdiciones() {
        return adiciones;
    }

    /**
     *
     * @param adiciones
     */
    public void setAdiciones(ArrayList<String> adiciones) {
        this.adiciones = adiciones;
    }

    /**
     *
     * @return
     */
    public Producto[] getProducto() {
        return producto;
    }

    /**
     *
     * @param producto
     */
    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

}