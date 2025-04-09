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
}
