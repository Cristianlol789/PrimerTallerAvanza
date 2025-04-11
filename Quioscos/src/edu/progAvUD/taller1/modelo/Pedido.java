package edu.progAvUD.taller1.modelo;

import java.util.HashMap;

/**
 *
 * @author Andres Felipe
 */
public class Pedido {

    private int numeroPedido;
    private Cliente cliente;
    private HashMap<OpcionesMenu, Integer> opcionesMenu;
    private double precioTotal;
    private String metodoDePago;

    public Pedido(int numeroPedido, Cliente cliente, HashMap<OpcionesMenu, Integer> opcionesMenu, double precioTotal, String metodoDePago) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.opcionesMenu = new HashMap<>();
        this.precioTotal = precioTotal;
        this.metodoDePago = metodoDePago;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public HashMap<OpcionesMenu, Integer> getOpcionesMenu() {
        return opcionesMenu;
    }

    public void setOpcionesMenu(HashMap<OpcionesMenu, Integer> opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

}