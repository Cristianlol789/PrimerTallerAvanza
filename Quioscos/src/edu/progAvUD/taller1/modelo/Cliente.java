package edu.progAvUD.taller1.modelo;

/**
 * Representa a un cliente del sistema, el cual tiene información personal y un
 * sistema de puntos. Los puntos pueden ser usados como parte de un programa de
 * fidelización o descuentos.
 *
 * Esta clase almacena datos básicos del cliente como su cédula, nombre, edad,
 * cultura (opcional) y puntos acumulados.
 *
 * @author Cristianlol789
 */
public class Cliente {

    /**
     * Número de cédula del cliente.
     */
    private double cedula;

    /**
     * Nombre completo del cliente.
     */
    private String nombre;

    /**
     * Edad del cliente.
     */
    private int edad;

    /**
     * Cultura o grupo étnico del cliente (puede ser usado para estadísticas o
     * beneficios culturales).
     */
    private String cultura;

    /**
     * Puntos acumulados por el cliente, que pueden usarse en el sistema de
     * recompensas.
     */
    private double puntos;

    /**
     * Constructor completo para crear un cliente con todos los datos,
     * incluyendo la cultura.
     *
     * @param cedula número de cédula del cliente
     * @param nombre nombre del cliente
     * @param edad edad del cliente
     * @param cultura grupo cultural o étnico del cliente
     * @param puntos puntos acumulados por el cliente
     */
    public Cliente(double cedula, String nombre, int edad, String cultura, double puntos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.cultura = cultura;
        this.puntos = puntos;
    }

    /**
     * Constructor alternativo que omite el campo de cultura.
     *
     * @param cedula número de cédula del cliente
     * @param nombre nombre del cliente
     * @param edad edad del cliente
     * @param puntos puntos acumulados por el cliente
     */
    public Cliente(double cedula, String nombre, int edad, double puntos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.puntos = puntos;
    }

    /**
     * Obtiene la cédula del cliente.
     *
     * @return número de cédula
     */
    public double getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del cliente.
     *
     * @param cedula número de cédula
     */
    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del cliente.
     *
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del cliente.
     *
     * @param edad edad del cliente
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la cultura o grupo étnico del cliente.
     *
     * @return cultura
     */
    public String getCultura() {
        return cultura;
    }

    /**
     * Establece la cultura o grupo étnico del cliente.
     *
     * @param cultura cultura del cliente
     */
    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    /**
     * Obtiene los puntos acumulados del cliente.
     *
     * @return puntos acumulados
     */
    public double getPuntos() {
        return puntos;
    }

    /**
     * Establece los puntos acumulados del cliente.
     *
     * @param puntos puntos nuevos
     */
    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }
}
