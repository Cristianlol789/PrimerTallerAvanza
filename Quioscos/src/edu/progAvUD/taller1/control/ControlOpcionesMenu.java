
package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Bucket;
import edu.progAvUD.taller1.modelo.Combo;
import edu.progAvUD.taller1.modelo.OpcionesMenu;
import edu.progAvUD.taller1.modelo.ParaCompartir;
import edu.progAvUD.taller1.modelo.PresaPollo;
import edu.progAvUD.taller1.modelo.Producto;
import edu.progAvUD.taller1.modelo.Unidad;
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
    
    public void crearOpcionesMenu(HashMap<PresaPollo, Integer> presas, Producto[] producto, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, String nombre, String identificador, Producto productoUnidad, double precioTotal, double puntosEquivalentes){
        if(identificador.equalsIgnoreCase("Bucket")){
            
        }
        else if(identificador.equalsIgnoreCase("Combo")){
            
        }
        else if(identificador.equalsIgnoreCase("Para compartir")){
            
        }else if(identificador.equalsIgnoreCase("Unidad")){
            
        }
        else{
            return;
        }
    }
}
