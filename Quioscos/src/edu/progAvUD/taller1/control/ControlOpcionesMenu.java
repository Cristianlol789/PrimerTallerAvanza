
package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Bucket;
import edu.progAvUD.taller1.modelo.Combo;
import edu.progAvUD.taller1.modelo.OpcionesMenu;
import edu.progAvUD.taller1.modelo.ParaCompartir;
import edu.progAvUD.taller1.modelo.Unidad;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Cristianlol789
 */
public class ControlOpcionesMenu {

    private ControlPrincipal controlprincipal;
    
    public ControlOpcionesMenu(ControlPrincipal controlPrincipal) {
        this.controlprincipal = controlPrincipal;
    }
    
    public void crearOpcionesMenu(String identificador, String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3, String nombre4, String descripcion4, double precio4, double puntosEquivalentes4, Image imagen4, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, int cantidadPresas, String parte){
        if(identificador.equalsIgnoreCase("Bucket")){
            OpcionesMenu bucket = new Bucket(cantidadPresas, nombreMenu, precioTotalMenu, puntosEquivalentesMenu, parte, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1);
        }
        else if(identificador.equalsIgnoreCase("Combo")){
            OpcionesMenu combo = new Combo(agrandados, adiciones, nombreMenu, precioTotalMenu, puntosEquivalentesMenu, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, nombre4, descripcion4, precio4, puntosEquivalentes4, imagen4);
        }
        else if(identificador.equalsIgnoreCase("Para compartir")){
            OpcionesMenu paraCompartir = new ParaCompartir(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3);
        }else if(identificador.equalsIgnoreCase("Unidad")){
            OpcionesMenu unidad = new Unidad(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1);
        }
        else{
            return;
        }
    }
}
