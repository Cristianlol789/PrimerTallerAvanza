/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ganimedes
 */
public class Bucket {
    private String tipoBucket;
    private List <PresaPollo> presas;
    private int capacidad;

    public Bucket(String tipoBucket,int capacidad) {
        this.tipoBucket = tipoBucket;
        this.capacidad = capacidad;
        this.presas = new ArrayList<>();
    }

    public String getTipoBucket() {
        return tipoBucket;
    }

    public void setTipoBucket(String tipoBucket) {
        this.tipoBucket = tipoBucket;
    }

    public List<PresaPollo> getPresas() {
        return presas;
    }

    public void setPresas(List<PresaPollo> presas) {
        this.presas = presas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    
    
    



    
    
}
