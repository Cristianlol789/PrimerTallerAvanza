package edu.progAvUD.taller1.modelo;

import java.util.HashMap;

/**
 *
 * @author Andres Felipe
 */
public class Pedido {

    private int numeroTicket;
    private boolean estadoTicket;
    private Cliente cliente;
    private HashMap<OpcionesMenu, Integer> opcionesMenu;
    private double precioTotal;
    private String metodoDePago;

    /**
     *
     * @param numeroTicket
     * @param cliente
     * @param opcionesMenu
     * @param precioTotal
     * @param metodoDePago
     */
    public Pedido(int numeroTicket, Cliente cliente, HashMap<OpcionesMenu, Integer> opcionesMenu, double precioTotal, String metodoDePago) {
        this.numeroTicket = numeroTicket;
        this.estadoTicket = false;
        this.cliente = cliente;
        this.opcionesMenu = opcionesMenu;
        this.precioTotal = precioTotal;
        this.metodoDePago = metodoDePago;
    }

    /**
     *
     * @return
     */
    public int getNumeroTicket() {
        return numeroTicket;
    }

    /**
     *
     * @param numeroTicket
     */
    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    /**
     *
     * @return
     */
    public boolean isEstadoTicket() {
        return estadoTicket;
    }

    /**
     *
     * @param estadoTicket
     */
    public void setEstadoTicket(boolean estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return
     */
    public HashMap<OpcionesMenu, Integer> getOpcionesMenu() {
        return opcionesMenu;
    }

    /**
     *
     * @param opcionesMenu
     */
    public void setOpcionesMenu(HashMap<OpcionesMenu, Integer> opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }

    /**
     *
     * @return
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     *
     * @param precioTotal
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     *
     * @return
     */
    public String getMetodoDePago() {
        return metodoDePago;
    }

    /**
     *
     * @param metodoDePago
     */
    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

}