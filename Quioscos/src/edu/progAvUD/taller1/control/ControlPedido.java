package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Cliente;
import edu.progAvUD.taller1.modelo.OpcionesMenu;
import edu.progAvUD.taller1.modelo.Pedido;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *Esta clase se encarga de hacer el pedido de el cliente, para ello crea un numero de pedido y lo guarda en un arreglo, en el pedido se puede ver como pago la persona
 * @author Cristianlol789
 */
public class ControlPedido {

    private ControlPrincipal controlPrincipal;
    private int numeroTicket;
    private ArrayList<Pedido> pedidos;
    
    /**
     *Inicializa las variables para guardar los parametros de los demas metodos
     *@param controlPrincipal se usa como referencia para comunicarse con el control principal
     */
    public ControlPedido(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.numeroTicket = 0;
    }
    
    /**
     *Da el numero de ticket de para reclamar el pedido
     */
    public void generarNumTicket(){
        this.numeroTicket += 1; 
    }
    
    /**
     *El metodo crea el pedido de la persona y pone el ticket en activo para poder reclamar su pedido
     * @param cedula se usa para buscar la persona por medio de su control
     * @param metodoDePago se mira con que opcion la persona pago;
     */
    public void crearPedido(double cedula, String metodoDePago){
        generarNumTicket();
        Cliente cliente = controlPrincipal.getControlClientes().clienteEncontrado(cedula);
        HashMap<OpcionesMenu, Integer> opcionesMenu = controlPrincipal.getControlOpcionesMenu().getOpcionesMenu();
        double precioTotal = controlPrincipal.getControlOpcionesMenu().getPrecioTotalPedido();
        Pedido pedido = new Pedido(this.numeroTicket, cliente, opcionesMenu, precioTotal, metodoDePago);
        pedido.setEstadoTicket(true);
        pedidos.add(pedido);
        controlPrincipal.getControlOpcionesMenu().vaciarHashMap();
        controlPrincipal.getControlOpcionesMenu().vaciarPrecio();
        controlPrincipal.getControlQuiosco().cambiarListaPedidos(pedidos);
    }
}
