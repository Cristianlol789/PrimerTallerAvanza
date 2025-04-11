package edu.progAvUD.taller1.modelo;

public class Cliente {
    
    private double cedula;
    private String nombre;
    private int edad;
    private String cultura;
    private double puntos;

    public Cliente(double cedula, String nombre, int edad, String cultura, double puntos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.cultura = cultura;
        this.puntos = puntos;
    }

    public Cliente(double cedula, String nombre, int edad, double puntos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.puntos = puntos;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }
    
}