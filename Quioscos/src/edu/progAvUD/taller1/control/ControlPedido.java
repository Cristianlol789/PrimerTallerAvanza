package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Cliente;
import edu.progAvUD.taller1.modelo.OpcionesMenu;
import edu.progAvUD.taller1.modelo.Pedido;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Cristianlol789
 */
public class ControlPedido {

    private ControlPrincipal controlPrincipal;
    private int numeroPedido;
    private ArrayList<Pedido> pedidos;
    
    public ControlPedido(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.numeroPedido = 0;
    }
    
    public void generarNumPedido(){
        this.numeroPedido += 1; 
    }
    
    public void crearPedido(double cedula, String metodoDePago){
        generarNumPedido();
        Cliente cliente = controlPrincipal.getControlClientes().clienteEncontrado(cedula);
        HashMap<OpcionesMenu, Integer> opcionesMenu = controlPrincipal.getControlOpcionesMenu().getOpcionesMenu();
        double precioTotal = controlPrincipal.getControlOpcionesMenu().getPrecioTotalPedido();
        Pedido pedido = new Pedido(this.numeroPedido, cliente, opcionesMenu, precioTotal, metodoDePago);
        pedidos.add(pedido);
        controlPrincipal.getControlOpcionesMenu().vaciarHashMap();
        controlPrincipal.getControlOpcionesMenu().vaciarPrecio();
        controlPrincipal.getControlQuiosco().crearQuiosco(pedidos);
    }
}
