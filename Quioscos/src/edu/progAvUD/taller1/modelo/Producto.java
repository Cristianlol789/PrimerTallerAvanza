package edu.progAvUD.taller1.modelo;

import java.awt.Image;

public class Producto {
    
    private String nombre;
    private String descripcion;
    private double precio;
    private double puntosEquivalentes;
    private Image imagen;

    public Producto(String nombre, String descripcion, double precio, Image imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.puntosEquivalentes = precio/1000;
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
