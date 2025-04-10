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
    private ArrayList<Pedido> pedidos;
    
    public ControlQuiosco(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.pedidos = new ArrayList<>();
        crearQuiosco(pedidos);
    }
    
    public void crearQuiosco(ArrayList<Pedido> pedidos){
        Quiosco quiosco = new Quiosco(pedidos);
    }
    
    
}
