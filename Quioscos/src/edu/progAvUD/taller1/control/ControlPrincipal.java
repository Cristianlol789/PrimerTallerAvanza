package edu.progAvUD.taller1.control;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Cristianlol789
 */
public class ControlPrincipal {

    private ControlGrafico controlGrafico;
    private ControlClientes controlClientes;
    private ControlQuiosco controlQuiosco;
    private ControlOpcionesMenu controlOpcionesMenu;
    private ControlProducto controlProductos;
    private ControlPedido controlPedido;

    public ControlPrincipal() {
        this.controlGrafico = new ControlGrafico(this);
        this.controlClientes = new ControlClientes(this);
        this.controlQuiosco = new ControlQuiosco(this);
        this.controlOpcionesMenu = new ControlOpcionesMenu(this);
        this.controlProductos = new ControlProducto(this);
        this.controlPedido = new ControlPedido(this);
    }

    public void inicioSesionCliente(double cedula, double puntos, String metodoDePago){
        controlClientes.buscarCliente(cedula, puntos);
        crearPedido(cedula, metodoDePago);
    }
    
    public void crearPedido(double cedula, String metodoDePago){
        controlPedido.crearPedido(cedula, metodoDePago);
    }
    
    public void crearOpcionMenu(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1,String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, String identificadorMenu, int cantidadPresas, int cantidadMenuComprado){
        controlOpcionesMenu.crearMenu(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, agrandados, adiciones, identificadorMenu, cantidadPresas, cantidadMenuComprado);
    }
    
    public ControlGrafico getControlGrafico() {
        return controlGrafico;
    }

    public void setControlGrafico(ControlGrafico controlGrafico) {
        this.controlGrafico = controlGrafico;
    }

    public ControlClientes getControlClientes() {
        return controlClientes;
    }

    public void setControlClientes(ControlClientes controlClientes) {
        this.controlClientes = controlClientes;
    }

    public ControlQuiosco getControlQuiosco() {
        return controlQuiosco;
    }

    public void setControlQuiosco(ControlQuiosco controlQuiosco) {
        this.controlQuiosco = controlQuiosco;
    }

    public ControlOpcionesMenu getControlOpcionesMenu() {
        return controlOpcionesMenu;
    }

    public void setControlOpcionesMenu(ControlOpcionesMenu controlOpcionesMenu) {
        this.controlOpcionesMenu = controlOpcionesMenu;
    }

    public ControlProducto getControlProductos() {
        return controlProductos;
    }

    public void setControlProductos(ControlProducto controlProductos) {
        this.controlProductos = controlProductos;
    }

}
