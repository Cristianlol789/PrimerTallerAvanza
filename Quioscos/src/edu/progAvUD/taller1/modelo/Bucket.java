
package edu.progAvUD.taller1.modelo;

import java.util.HashMap;
/**
 *
 * @author Ganimedes
 */
public class Bucket extends OpcionesMenu{
    
    private HashMap<PresaPollo, Integer> presas;
    private static final int cantidadMax = 8;

    public Bucket(HashMap<PresaPollo, Integer> presas, String nombre, double precioTotal, double puntosEquivalentes) {
        super(nombre, precioTotal, puntosEquivalentes);
        this.presas = presas;
    }

    public HashMap<PresaPollo, Integer> getPresas() {
        return presas;
    }

    public void setPresas(HashMap<PresaPollo, Integer> presas) {
        this.presas = presas;
    }

    
}
