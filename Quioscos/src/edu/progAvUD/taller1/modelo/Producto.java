package edu.progAvUD.taller1.modelo;

import java.awt.Image;

public class Producto {
    
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected double puntosEquivalentes;
    protected Image imagen;

    public Producto(String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.puntosEquivalentes = puntosEquivalentes;
        this.imagen = imagen;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPuntosEquivalentes() {
        return puntosEquivalentes;
    }

    public void setPuntosEquivalentes(double puntosEquivalentes) {
        this.puntosEquivalentes = puntosEquivalentes;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
}
