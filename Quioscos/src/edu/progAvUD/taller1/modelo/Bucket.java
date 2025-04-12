package edu.progAvUD.taller1.modelo;

import java.util.HashMap;

/**
 * Representa un tipo específico de menú llamado "Bucket", que contiene una
 * cantidad limitada de presas de pollo. Esta clase hereda de
 * {@link OpcionesMenu}.
 *
 * Un Bucket puede contener diferentes tipos de presas de pollo, con una
 * cantidad máxima total definida por la constante {@code cantidadMax}.
 *
 * @author Ganimedes
 */
public class Bucket extends OpcionesMenu {

    /**
     * Mapa que asocia cada tipo de {@link PresaPollo} con la cantidad
     * correspondiente incluida en el Bucket.
     */
    private HashMap<PresaPollo, Integer> presas;

    /**
     * Cantidad máxima total de presas que puede contener un Bucket.
     */
    private static final int cantidadMax = 8;

    /**
     * Crea una nueva instancia de Bucket con los datos proporcionados.
     *
     * @param nombreMenu nombre del menú tipo Bucket
     * @param precioTotalMenu precio total del menú
     * @param puntosEquivalentesMenu puntos acumulables o equivalentes del menú
     * @param presas mapa con los tipos de presas de pollo y su cantidad
     * correspondiente
     */
    public Bucket(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, HashMap<PresaPollo, Integer> presas) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.presas = presas;
    }

    /**
     * Devuelve el mapa de presas de pollo que contiene el Bucket.
     *
     * @return un {@link HashMap} con las presas y su cantidad
     */
    public HashMap<PresaPollo, Integer> getPresas() {
        return presas;
    }

    /**
     * Establece las presas de pollo que contendrá el Bucket.
     *
     * @param presas un {@link HashMap} con los tipos de presas de pollo y sus
     * cantidades
     */
    public void setPresas(HashMap<PresaPollo, Integer> presas) {
        this.presas = presas;
    }

}
