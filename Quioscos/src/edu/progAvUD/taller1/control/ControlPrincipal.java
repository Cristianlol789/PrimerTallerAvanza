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

    public ControlPrincipal() {
        this.controlGrafico = new ControlGrafico(this);
        this.controlClientes = new ControlClientes(this);
        this.controlQuiosco = new ControlQuiosco(this);
        this.controlOpcionesMenu = new ControlOpcionesMenu(this);
        this.controlProductos = new ControlProducto(this);
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
