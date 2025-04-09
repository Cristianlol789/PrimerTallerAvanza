package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;

public class Quiosco {
    
    private ArrayList<Pedido> pedidos;
    private static final int inactividadMaximaSegundos = 120 ;

    public Quiosco() {
    }
    
    public Quiosco(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
}
