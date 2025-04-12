package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa un combo de productos dentro del menú, que agrupa varios elementos
 * (como bebida, papas, strips y otro producto principal) en una sola opción con
 * precio y puntos equivalentes.
 *
 * Esta clase extiende {@link OpcionesMenu} y permite definir si algunos
 * productos están "agrandados", así como incluir adiciones personalizadas.
 *
 * @author and
 */
public class Combo extends OpcionesMenu {

    /**
     * Arreglo de productos que componen el combo. Contiene 4 productos: [0]
     * Producto principal [1] Bebida [2] Papas [3] Strips
     */
    private Producto[] producto;

    /**
     * Mapa que indica si cada componente del combo está agrandado (por ejemplo,
     * bebida o papas grandes).
     */
    private HashMap<String, Boolean> agrandados;

    /**
     * Lista de adiciones especiales solicitadas por el cliente (por ejemplo,
     * salsas extra).
     */
    private ArrayList<String> adiciones;

    /**
     * Constructor que crea un combo a partir de múltiples parámetros para
     * definir los cuatro productos, sus características, si están agrandados y
     * sus adiciones.
     *
     * @param nombreMenu nombre del combo
     * @param precioTotalMenu precio total del combo
     * @param puntosEquivalentesMenu puntos acumulables del combo
     * @param tipo tipo del producto principal
     * @param coccion cocción del producto principal
     * @param nombre nombre del producto principal
     * @param descripcion descripción del producto principal
     * @param precio precio del producto principal
     * @param puntosEquivalentes puntos del producto principal
     * @param identificador identificador del producto principal
     * @param tipo1 tipo de la bebida
     * @param coccion1 cocción de la bebida
     * @param nombre1 nombre de la bebida
     * @param descripcion1 descripción de la bebida
     * @param precio1 precio de la bebida
     * @param puntosEquivalentes1 puntos de la bebida
     * @param tipo2 tipo de papas
     * @param coccion2 cocción de papas
     * @param nombre2 nombre de papas
     * @param descripcion2 descripción de papas
     * @param precio2 precio de papas
     * @param puntosEquivalentes2 puntos de papas
     * @param tipo3 tipo de strips
     * @param coccion3 cocción de strips
     * @param nombre3 nombre de strips
     * @param descripcion3 descripción de strips
     * @param precio3 precio de strips
     * @param puntosEquivalentes3 puntos de strips
     * @param agrandados mapa que indica si ciertos componentes están agrandados
     * @param adiciones lista de adiciones especiales para el combo
     * @param controlProducto clase encargada de la creación de productos
     */
    public Combo(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, ControlProducto controlProducto){
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[4];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, "Bebida");
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, "Papas");
        this.producto[3] = controlProducto.crearProducto(tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, "Strips");
        this.agrandados = agrandados;
        this.adiciones = adiciones;
    }

    /**
     * Obtiene el mapa de agrandados del combo.
     *
     * @return un {@link HashMap} que indica si cada componente está agrandado
     */
    public HashMap<String, Boolean> getAgrandados() {
        return agrandados;
    }

    /**
     * Establece qué componentes del combo están agrandados.
     *
     * @param agrandados mapa con los estados de agrandamiento
     */
    public void setAgrandados(HashMap<String, Boolean> agrandados) {
        this.agrandados = agrandados;
    }

    /**
     * Obtiene la lista de adiciones del combo.
     *
     * @return una {@link ArrayList} de adiciones
     */
    public ArrayList<String> getAdiciones() {
        return adiciones;
    }

    /**
     * Establece las adiciones del combo.
     *
     * @param adiciones lista de adiciones a incluir
     */
    public void setAdiciones(ArrayList<String> adiciones) {
        this.adiciones = adiciones;
    }

    /**
     * Devuelve el arreglo de productos que conforman el combo.
     *
     * @return arreglo de {@link Producto}
     */
    public Producto[] getProducto() {
        return producto;
    }

    /**
     * Establece el arreglo de productos del combo.
     *
     * @param producto nuevo arreglo de productos
     */
    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }
}
