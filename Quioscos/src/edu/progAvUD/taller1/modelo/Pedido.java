package edu.progAvUD.taller1.modelo;

import java.util.HashMap;

/**
 * Representa un pedido realizado por un cliente.
 *
 * Cada pedido tiene un número de ticket, un estado (pendiente o finalizado), un
 * cliente asociado, una lista de opciones de menú y otros detalles como el
 * método de pago y el precio total.
 *
 * @author Andres
 */
public class Pedido {

    private int numeroTicket;
    private boolean estadoTicket;
    private Cliente cliente;
    private HashMap<OpcionesMenu, Integer> opcionesMenu;
    private double precioTotal;
    private String metodoDePago;

    /**
     * Constructor para crear un pedido.
     *
     * @param numeroTicket número único del ticket
     * @param cliente cliente que realiza el pedido
     * @param opcionesMenu mapa de opciones de menú con su cantidad
     * @param precioTotal precio total del pedido
     * @param metodoDePago método de pago utilizado (efectivo, tarjeta, etc.)
     */
    public Pedido(int numeroTicket, Cliente cliente, HashMap<OpcionesMenu, Integer> opcionesMenu, double precioTotal, String metodoDePago) {
        this.numeroTicket = numeroTicket;
        this.estadoTicket = false; // Se inicializa como pendiente
        this.cliente = cliente;
        this.opcionesMenu = opcionesMenu;
        this.precioTotal = precioTotal;
        this.metodoDePago = metodoDePago;
    }

    /**
     * Devuelve el número de ticket.
     *
     * @return número del ticket
     */
    public int getNumeroTicket() {
        return numeroTicket;
    }

    /**
     * Establece el número de ticket.
     *
     * @param numeroTicket nuevo número de ticket
     */
    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    /**
     * Verifica si el ticket está finalizado.
     *
     * @return true si está finalizado, false si está pendiente
     */
    public boolean isEstadoTicket() {
        return estadoTicket;
    }

    /**
     * Cambia el estado del ticket.
     *
     * @param estadoTicket true para finalizado, false para pendiente
     */
    public void setEstadoTicket(boolean estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    /**
     * Devuelve el cliente asociado al pedido.
     *
     * @return cliente del pedido
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente del pedido.
     *
     * @param cliente nuevo cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve el mapa de opciones de menú del pedido y su cantidad.
     *
     * @return mapa de opciones de menú
     */
    public HashMap<OpcionesMenu, Integer> getOpcionesMenu() {
        return opcionesMenu;
    }

    /**
     * Establece las opciones de menú del pedido.
     *
     * @param opcionesMenu nuevo mapa de opciones de menú
     */
    public void setOpcionesMenu(HashMap<OpcionesMenu, Integer> opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }

    /**
     * Devuelve el precio total del pedido.
     *
     * @return precio total
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Establece el precio total del pedido.
     *
     * @param precioTotal nuevo precio total
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     * Devuelve el método de pago.
     *
     * @return método de pago usado
     */
    public String getMetodoDePago() {
        return metodoDePago;
    }

    /**
     * Establece el método de pago del pedido.
     *
     * @param metodoDePago nuevo método de pago
     */
    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

}
