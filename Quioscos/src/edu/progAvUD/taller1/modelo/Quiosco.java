package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Quiosco {
    
    private ArrayList<Pedido> pedidos;
    private static final int inactividadMaximaSegundos = 120 ;
    
    /**
     *
     * @param pedidos
     */
    public Quiosco(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     *
     * @param pedidos
     */
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
}