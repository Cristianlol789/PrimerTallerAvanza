package edu.progAvUD.taller1.modelo;

/**
 *
 * @author User
 */
public class Cliente {
    
    private double cedula;
    private String nombre;
    private int edad;
    private String cultura;
    private double puntos;

    /**
     *
     * @param cedula
     * @param nombre
     * @param edad
     * @param cultura
     * @param puntos
     */
    public Cliente(double cedula, String nombre, int edad, String cultura, double puntos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.cultura = cultura;
        this.puntos = puntos;
    }

    /**
     *
     * @param cedula
     * @param nombre
     * @param edad
     * @param puntos
     */
    public Cliente(double cedula, String nombre, int edad, double puntos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.puntos = puntos;
    }

    /**
     *
     * @return
     */
    public double getCedula() {
        return cedula;
    }

    /**
     *
     * @param cedula
     */
    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     *
     * @return
     */
    public String getCultura() {
        return cultura;
    }

    /**
     *
     * @param cultura
     */
    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    /**
     *
     * @return
     */
    public double getPuntos() {
        return puntos;
    }

    /**
     *
     * @param puntos
     */
    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }
    
}