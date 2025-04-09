/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progAvUD.taller1.modelo;

import java.util.HashMap;

/**
 *
 * @author Andres Felipe
 */
public class Pedido {
    public int numeroPedido;
    public HashMap<Producto, Integer> productos;
    public Cliente cliente;
    public double precioTotal;
    public String metodoDePago;

    public Pedido(int numeroPedido, HashMap<Producto, Integer> productos, Cliente cliente, double precioTotal, String metodoDePago) {
        this.numeroPedido = numeroPedido;
        this.productos = productos;
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.metodoDePago = metodoDePago;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public HashMap<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Producto, Integer> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
