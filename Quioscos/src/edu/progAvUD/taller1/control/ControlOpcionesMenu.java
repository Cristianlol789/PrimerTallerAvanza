package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Bucket;
import edu.progAvUD.taller1.modelo.Combo;
import edu.progAvUD.taller1.modelo.OpcionesMenu;
import edu.progAvUD.taller1.modelo.ParaCompartir;
import edu.progAvUD.taller1.modelo.Producto;
import edu.progAvUD.taller1.modelo.Unidad;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Cristianlol789
 */
public class ControlOpcionesMenu {

    private ControlPrincipal controlprincipal;
    private HashMap<OpcionesMenu, Integer> opcionesMenu;
    private double precioTotalPedido;
    
    public ControlOpcionesMenu(ControlPrincipal controlPrincipal) {
        this.controlprincipal = controlPrincipal;
        this.opcionesMenu = new HashMap<>();
        this.precioTotalPedido = 0;
    }
    
    public void crearMenu(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1,String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, String identificadorMenu, int cantidadPresas, int cantidadMenuComprado){
        ControlProducto controlProducto = controlprincipal.getControlProductos();
        switch(identificadorMenu){
            case "Bucket":
                HashMap presas = new HashMap<>();
                Producto presa1 = controlprincipal.getControlProductos().crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador);
                presas.put(presa1, cantidadPresas);
                OpcionesMenu bucket = new Bucket(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, presas);
                this.opcionesMenu.put(bucket, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            case "Combo":
                OpcionesMenu combo = new Combo(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, agrandados, adiciones, controlProducto);
                this.opcionesMenu.put(combo, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            case "ParaCompartir3":
                OpcionesMenu paraCompartir3 = new ParaCompartir(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, identificador, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, identificador, controlProducto);
                this.opcionesMenu.put(paraCompartir3, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            case "ParaCompartir4":
                OpcionesMenu paraCompartir4 = new ParaCompartir(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, identificador, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, identificador, tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, identificador, controlProducto);
                this.opcionesMenu.put(paraCompartir4, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            case "Unidad":
                OpcionesMenu unidad = new Unidad(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador, controlProducto);
                this.opcionesMenu.put(unidad, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            default:
                break;
        }
    }

    public HashMap<OpcionesMenu, Integer> getOpcionesMenu() {
        return opcionesMenu;
    }

    public void vaciarHashMap(){
        this.opcionesMenu = new HashMap<>();
    }
    
    public void vaciarPrecio(){
        this.precioTotalPedido = 0;
    }

    public double getPrecioTotalPedido() {
        return precioTotalPedido;
    }
    
}
