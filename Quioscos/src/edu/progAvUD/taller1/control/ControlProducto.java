package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Bebida;
import edu.progAvUD.taller1.modelo.Hamburguesa;
import edu.progAvUD.taller1.modelo.Nugget;
import edu.progAvUD.taller1.modelo.Papas;
import edu.progAvUD.taller1.modelo.PresaPollo;
import edu.progAvUD.taller1.modelo.Producto;
import edu.progAvUD.taller1.modelo.Strips;
import edu.progAvUD.taller1.modelo.Wrap;

/**
 *Esta clase se encarga de crear cada producto individualmente y devolverlo para poder crear las opciones de menu
 * @author Cristianlol789
 */
public class ControlProducto {
    
    private ControlPrincipal controlPrincipal;

    /**
     *Este constructor se encarga de crear al control
     * @param controlPrincipal variable para poderse comunicar con el control
     */
    public ControlProducto(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }
    
    /**
     *
     * @param tipo especifica la clasificacion de cada producto
     * @param coccion especifica el sabor o tipo de coccion deseado
     * @param nombre dice el nombre del producto comprado
     * @param descripcion dice que lleva o como esta compuesto
     * @param precio el valor total a pagar por este
     * @param puntosEquivalentes el valor en puntos del producto
     * @param identificador el tipo de producto que se desea crear
     * @return devuelve el producto comprado
     */
    public Producto crearProducto(String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador){
        switch(identificador){
            case "Bebida":
                Producto bebida = new Bebida(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes);
                return bebida;
            case "Hamburguesa":
                Producto hamburguesa = new Hamburguesa(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes);
                return hamburguesa;
            case "Nugget":
                Producto nugget = new Nugget(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes);
                return nugget;
            case "Papas":
                Producto papas = new Papas(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes);
                return papas;
            case "PresaPollo":
                Producto presaPollo = new PresaPollo(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes);
                return presaPollo;
            case "Wrap":
                Producto wrap = new Wrap(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes);
                return wrap;
            case "Strips":
                Producto strips = new Strips(nombre, tipo, nombre, descripcion, precio, puntosEquivalentes);
                return strips;
            default:
                return null;
        }
    }
}
