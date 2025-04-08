package edu.progAvUD.taller1.modelo;

public class Cliente {
    private String nombreCliente;
    private double dineroDisponible;
    private double puntosAcumulados;

    public Cliente() {
    }

    public Cliente(String nombreCliente, double dineroDisponible, double puntosAcumulados) {
        this.nombreCliente = nombreCliente;
        this.dineroDisponible = dineroDisponible;
        this.puntosAcumulados = puntosAcumulados;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getDineroDisponible() {
        return dineroDisponible;
    }

    public double getPuntosAcumulados() {
        return puntosAcumulados;
    }
    
    
}
