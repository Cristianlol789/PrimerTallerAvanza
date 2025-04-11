package edu.progAvUD.taller1.modelo;

import java.awt.Image;
import java.util.HashMap;

/**
 *
 * @author Ganimedes
 */
public class Bucket extends OpcionesMenu {

    private int cantidadPresas;
    private HashMap<PresaPollo, Integer> presas;
    private static final int cantidadMax = 8;

    public Bucket(int cantidadPresas, String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String parte, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.presas = new HashMap<>();
        this.presas.put(new PresaPollo(parte, descripcion1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1), this.cantidadPresas);
    }

    public int getCantidadPresas() {
        return cantidadPresas;
    }

    public void setCantidadPresas(int cantidadPresas) {
        this.cantidadPresas = cantidadPresas;
    }

    public HashMap<PresaPollo, Integer> getPresas() {
        return presas;
    }

    public void setPresas(HashMap<PresaPollo, Integer> presas) {
        this.presas = presas;
    }

}
