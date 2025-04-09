/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progAvUD.taller1.modelo;


public class PresaPollo {
    private String tipoPresa;
    private double precioPresa;
    private int cantidadPresas;

    public PresaPollo(String tipoPresa, double precioPresa, int cantidadPresas) {
        this.tipoPresa = tipoPresa;
        this.precioPresa = precioPresa;
        this.cantidadPresas = cantidadPresas;
    }

    public String getTipoPresa() {
        return tipoPresa;
    }

    public void setTipoPresa(String tipoPresa) {
        this.tipoPresa = tipoPresa;
    }

    public double getPrecioPresa() {
        return precioPresa;
    }

    public void setPrecioPresa(double precioPresa) {
        this.precioPresa = precioPresa;
    }

    public int getCantidadPresas() {
        return cantidadPresas;
    }

    public void setCantidadPresas(int cantidadPresas) {
        this.cantidadPresas = cantidadPresas;
    }
    
}
