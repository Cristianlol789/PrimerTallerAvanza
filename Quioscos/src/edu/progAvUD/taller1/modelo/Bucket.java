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

    public Bucket(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String parte, String tipoCoccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.presas = new HashMap<>();
        this.presas.put(new PresaPollo(parte, tipoCoccion, nombre, descripcion, precio, puntosEquivalentes, imagen), cantidadPresas);
    }

    public HashMap<PresaPollo, Integer> getPresas() {
        return presas;
    }

    public void setPresas(HashMap<PresaPollo, Integer> presas) {
        this.presas = presas;
    }

}
