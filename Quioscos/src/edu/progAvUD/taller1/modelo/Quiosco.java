package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;

/**
 * Representa un quiosco donde se gestionan pedidos realizados por los clientes.
 * Contiene una lista de pedidos y una constante que define el tiempo máximo
 * de inactividad permitido.
 * 
 * @author User
 */
public class Quiosco {

    /** Lista de pedidos registrados en el quiosco */
    private ArrayList<Pedido> pedidos;

    /** Tiempo máximo de inactividad permitido en segundos (2 minutos) */
    private static final int inactividadMaximaSegundos = 120;

    /**
     * Crea una nueva instancia de Quiosco con una lista de pedidos inicial.
     *
     * @param pedidos Lista de pedidos asociados al quiosco.
     */
    public Quiosco(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * Obtiene la lista de pedidos registrados en el quiosco.
     *
     * @return Lista de objetos {@code Pedido}.
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Establece una nueva lista de pedidos para el quiosco.
     *
     * @param pedidos Nueva lista de objetos {@code Pedido}.
     */
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
