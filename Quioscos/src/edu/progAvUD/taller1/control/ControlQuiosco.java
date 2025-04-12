package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Pedido;
import edu.progAvUD.taller1.modelo.Quiosco;
import java.util.ArrayList;

/**
 *
 * @author Cristianlol789
 */
public class ControlQuiosco {

    private ControlPrincipal controlPrincipal;
    
    /**
     *
     * @param controlPrincipal
     */
    public ControlQuiosco(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }
    
    /**
     *
     * @param pedidos
     */
    public void crearQuiosco(ArrayList<Pedido> pedidos){
        Quiosco quiosco = new Quiosco(pedidos);
    }
      
}
