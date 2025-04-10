
package edu.progAvUD.taller1.control;

/**
 *
 * @author Cristianlol789
 */
public class ControlPrincipal {
    
    private ControlGrafico controlGrafico;
    private ControlClientes controlClientes;
    private ControlQuiosco controlQuiosco;
    private ControlOpcionesMenu controlOpcionesMenu;

    public ControlPrincipal(ControlGrafico controlGrafico) {
        this.controlGrafico = controlGrafico;
        this.controlClientes = new ControlClientes(this);
        this.controlQuiosco = new ControlQuiosco(this);
        this.controlOpcionesMenu = new ControlOpcionesMenu(this);
    }
    
}
