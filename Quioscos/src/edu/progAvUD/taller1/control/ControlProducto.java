package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Bebida;
import edu.progAvUD.taller1.modelo.Hamburguesa;
import edu.progAvUD.taller1.modelo.Nugget;
import edu.progAvUD.taller1.modelo.Papas;
import edu.progAvUD.taller1.modelo.PresaPollo;
import edu.progAvUD.taller1.modelo.Producto;
import edu.progAvUD.taller1.modelo.Strips;
import edu.progAvUD.taller1.modelo.Wrap;
import java.awt.Image;

/**
 *
 * @author Cristianlol789
 */
public class ControlProducto {
    
    private ControlPrincipal controlPrincipal;

    public ControlProducto(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }
    
    public Producto crearProducto(String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen, String identificador){
        switch(identificador){
            case "Bebida":
                Producto bebida = new Bebida(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen);
                return bebida;
            case "Hamburguesa":
                Producto hamburguesa = new Hamburguesa(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen);
                return hamburguesa;
            case "Nugget":
                Producto nugget = new Nugget(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen);
                return nugget;
            case "Papas":
                Producto papas = new Papas(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen);
                return papas;
            case "PresaPollo":
                Producto presaPollo = new PresaPollo(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen);
                return presaPollo;
            case "Wrap":
                Producto wrap = new Wrap(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen);
                return wrap;
            case "Strips":
                Producto strips = new Strips(nombre, tipo, nombre, descripcion, precio, puntosEquivalentes, imagen);
                return strips;
            default:
                return null;
        }
    }
}
