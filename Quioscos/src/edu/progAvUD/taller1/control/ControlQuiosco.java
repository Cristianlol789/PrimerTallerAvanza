package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Pedido;
import edu.progAvUD.taller1.modelo.Quiosco;
import java.util.ArrayList;

/**
 * Esta clase es la encargada de crear el quiosco y de actualizar su lista de productos
 * @author Cristianlol789
 */
public class ControlQuiosco {

    private ControlPrincipal controlPrincipal;
    private Quiosco quiosco;
    
    /**
     * Crea la clase
     * @param controlPrincipal variable para la identificacion y comunicacion con el control
     */
    public ControlQuiosco(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        this.quiosco = crearQuiosco(pedidos);
    }
    
    /**
     * Se encarga de crear el quiosco
     * @param pedidos recibe un arreglo para ir almacenando cada pedido echo en el tiempo
     * @return el objeto quiosco
     */
    public Quiosco crearQuiosco(ArrayList<Pedido> pedidos){
        Quiosco quiosco1 = new Quiosco(pedidos);
        return quiosco1;
    }
    
    /**
     *
     * @param pedidos recibe un arreglo para actualizar los pedidos
     */
    public void cambiarListaPedidos(ArrayList<Pedido> pedidos){
        this.quiosco.setPedidos(pedidos);
    }

    /**
     *
     * @return
     */
    public Quiosco getQuiosco() {
        return quiosco;
    }

    /**
     *
     * @param quiosco
     */
    public void setQuiosco(Quiosco quiosco) {
        this.quiosco = quiosco;
    }

}
