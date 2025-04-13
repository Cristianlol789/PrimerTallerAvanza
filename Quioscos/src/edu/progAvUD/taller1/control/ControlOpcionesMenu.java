package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Bucket;
import edu.progAvUD.taller1.modelo.Combo;
import edu.progAvUD.taller1.modelo.OpcionesMenu;
import edu.progAvUD.taller1.modelo.ParaCompartir;
import edu.progAvUD.taller1.modelo.Producto;
import edu.progAvUD.taller1.modelo.Unidad;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta clase se encarga de crear y gestionar las opciones de menu que se van a
 * vender en el quiosco
 *
 * @author Cristianlol789
 */
public class ControlOpcionesMenu {

    private ControlPrincipal controlprincipal;
    private HashMap<OpcionesMenu, Integer> opcionesMenu;
    private double precioTotalPedido;

    /**
     * Inicializa las variables para guardar los parametros de los demas metodos
     *
     * @param controlPrincipal se usa como referencia para comunicarse con el
     * control principal
     */
    public ControlOpcionesMenu(ControlPrincipal controlPrincipal) {
        this.controlprincipal = controlPrincipal;
        this.opcionesMenu = new HashMap<>();
        this.precioTotalPedido = 0;
    }

    /**
     * El método se encarga de construir el menú correspondiente a partir de una
     * serie de parámetros que definen tanto las características generales del
     * menú (como su nombre, precio total y puntos equivalentes) como los
     * detalles específicos de uno o varios productos incluidos en dicho menú.
     *
     * @param nombreMenu Nombre del menú a crear.
     * @param precioTotalMenu Precio total del menú.
     * @param puntosEquivalentesMenu Puntos equivalentes asociados al menú.
     * @param tipo Tipo de producto del menú (para el producto principal).
     * @param coccion Estado o método de cocción del producto principal.
     * @param nombre Nombre del producto principal.
     * @param descripcion Descripción del producto principal.
     * @param precio Precio del producto principal.
     * @param puntosEquivalentes Puntos equivalentes asociados al producto
     * principal.
     * @param identificador Identificador único del producto principal.
     * @param tipo1 Tipo del primer producto adicional (en caso de Combo o
     * ParaCompartir).
     * @param coccion1 Estado o método de cocción del primer producto adicional.
     * @param nombre1 Nombre del primer producto adicional.
     * @param descripcion1 Descripción del primer producto adicional.
     * @param precio1 Precio del primer producto adicional.
     * @param puntosEquivalentes1 Puntos equivalentes del primer producto
     * adicional.
     * @param identificador1
     * @param tipo2 Tipo del segundo producto adicional (usado en Combo o
     * ParaCompartir).
     * @param coccion2 Estado o método de cocción del segundo producto
     * adicional.
     * @param nombre2 Nombre del segundo producto adicional.
     * @param descripcion2 Descripción del segundo producto adicional.
     * @param precio2 Precio del segundo producto adicional.
     * @param puntosEquivalentes2 Puntos equivalentes del segundo producto
     * adicional.
     * @param tipo3 Tipo del tercer producto adicional (usado en Combo o
     * ParaCompartir4).
     * @param identificador2
     * @param coccion3 Estado o método de cocción del tercer producto adicional.
     * @param nombre3 Nombre del tercer producto adicional.
     * @param descripcion3 Descripción del tercer producto adicional.
     * @param precio3 Precio del tercer producto adicional.
     * @param puntosEquivalentes3 Puntos equivalentes del tercer producto
     * adicional.
     * @param identificador3
     * @param agrandados Opciones que indican los productos que pueden ser
     * agrandados (para el Combo).
     * @param adiciones Lista de adiciones disponibles para el menú (para el
     * Combo).
     * @param identificadorMenu Identificador que determina el tipo de menú a
     * crear ("Bucket", "Combo", "ParaCompartir3", "ParaCompartir4" o "Unidad").
     * @param cantidadMenuComprado Cantidad de veces que se ha adquirido este
     * menú.
     * @param cantidadPresasCuadro
     * @param cantidadPresasAla
     * @param cantidadPresasPierna
     * @param cantidadPresasPechuga
     */
    public void crearMenu(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String identificador2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, String identificador3, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, String identificadorMenu, int cantidadPresasAla, int cantidadMenuComprado, int cantidadPresasPierna, int cantidadPresasCuadro, int cantidadPresasPechuga) {
        ControlProducto controlProducto = controlprincipal.getControlProductos();
        switch (identificadorMenu) {
            case "Bucket":
                HashMap presas = new HashMap<>();
                Producto presaAla = controlprincipal.getControlProductos().crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
                Producto presaPierna = controlprincipal.getControlProductos().crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador);
                Producto presaCuadro = controlprincipal.getControlProductos().crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador);
                Producto presaPechuga = controlprincipal.getControlProductos().crearProducto(tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, identificador);
                presas.put(presaAla, cantidadPresasAla);
                presas.put(presaPierna, cantidadPresasPierna);
                presas.put(presaCuadro, cantidadPresasCuadro);
                presas.put(presaPechuga, cantidadPresasPechuga);
                OpcionesMenu bucket = new Bucket(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, presas);
                this.opcionesMenu.put(bucket, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            case "Combo":
                OpcionesMenu combo = new Combo(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, agrandados, adiciones, controlProducto);
                this.opcionesMenu.put(combo, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            case "ParaCompartir3":
                OpcionesMenu paraCompartir3 = new ParaCompartir(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2, controlProducto, cantidadPresasAla, cantidadPresasPierna, cantidadPresasCuadro);
                this.opcionesMenu.put(paraCompartir3, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            case "ParaCompartir4":
                OpcionesMenu paraCompartir4 = new ParaCompartir(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2, tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, identificador3, controlProducto, cantidadPresasAla, cantidadPresasPierna, cantidadPresasCuadro, cantidadPresasPechuga);
                this.opcionesMenu.put(paraCompartir4, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            case "Unidad":
                OpcionesMenu unidad = new Unidad(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, controlProducto);
                this.opcionesMenu.put(unidad, cantidadMenuComprado);
                this.precioTotalPedido += precioTotalMenu;
                break;
            default:
                break;
        }
    }

    /**
     * Se encarga de devolver la tabla
     *
     * @return el hashmap para poderse utilizar en la creacion del pedido
     */
    public HashMap<OpcionesMenu, Integer> getOpcionesMenu() {
        return opcionesMenu;
    }

    /**
     * Se encarga de vaciar el HashMap para que el siguiente cliente pueda hacer
     * su pedido
     */
    public void vaciarHashMap() {
        this.opcionesMenu = new HashMap<>();
    }

    /**
     * Se encarga de dejar la variable global en 0 para no tener problemas con
     * la acumulacion de valores no correspondientes a esta compra
     */
    public void vaciarPrecio() {
        this.precioTotalPedido = 0;
    }

    /**
     * El metodo manda todo el valor que el cliente debe pagar por cada cosa que
     * puso en el carro
     *
     * @return el precio total a pagar por todo lo pedido
     */
    public double getPrecioTotalPedido() {
        return precioTotalPedido;
    }

    /**
     *
     * @return
     */
    public Object[][] enviarDatosTablaPedido() {
        int cantidadProductos = opcionesMenu.size();
        Object[][] datos = new Object[cantidadProductos][4];

        int i = 0;
        for (OpcionesMenu productoPedido : opcionesMenu.keySet()) {
            int cantidad = opcionesMenu.get(productoPedido);
            double precioUnitario = productoPedido.getPrecioTotalMenu();
            double total = cantidad * precioUnitario;

            datos[i][0] = productoPedido.getNombreMenu();
            datos[i][1] = cantidad;
            datos[i][2] = precioUnitario;
            datos[i][3] = total;

            i++;
        }

        return datos;
    }

}
