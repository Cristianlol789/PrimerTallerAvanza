package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.PresaPollo;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Cristianlol789
 */
public class ControlPrincipal {

    private ControlGrafico controlGrafico;
    private ControlClientes controlClientes;
    private ControlQuiosco controlQuiosco;
    private ControlOpcionesMenu controlOpcionesMenu;

    public ControlPrincipal(ControlGrafico controlGrafico) {
        this.controlGrafico = controlGrafico;
        this.controlClientes = new ControlClientes(this);
        this.controlQuiosco = new ControlQuiosco(this);
        this.controlOpcionesMenu = new ControlOpcionesMenu(this);
    }

    public void crearBucket(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String parte, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1) {
        String identificador = "Bucket";
        HashMap agrandados = new HashMap<>();
        ArrayList adiciones = new ArrayList<>();
        controlOpcionesMenu.crearOpcionesMenu(identificador, nombreMenu, precioTotalMenu, puntosEquivalentesMenu, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, agrandados, adiciones, 0, parte);
    }

    public void crearCombo(HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3, String nombre4, String descripcion4, double precio4, double puntosEquivalentes4, Image imagen4) {
        String identificador = "Combo";
        controlOpcionesMenu.crearOpcionesMenu(identificador, nombreMenu, precioTotalMenu, puntosEquivalentesMenu, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, nombre4, descripcion4, precio4, puntosEquivalentes4, imagen4, agrandados, adiciones, 0, "");
    }

    public void crearParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3) {
        String identificador = "Para compartir";
        HashMap agrandados = new HashMap<>();
        ArrayList adiciones = new ArrayList<>();
        controlOpcionesMenu.crearOpcionesMenu(identificador, nombreMenu, precioTotalMenu, puntosEquivalentesMenu, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, agrandados, adiciones, 0, "");
    }

    public void crearUnidad(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1) {
        String identificador = "Unidad";
        HashMap agrandados = new HashMap<>();
        ArrayList adiciones = new ArrayList<>();
        controlOpcionesMenu.crearOpcionesMenu(identificador, nombreMenu, precioTotalMenu, puntosEquivalentesMenu, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, agrandados, adiciones, 0, "");
    }
}
