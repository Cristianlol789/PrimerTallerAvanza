package edu.progAvUD.taller1.control;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase principal que actúa como el controlador central del sistema. Encapsula
 * y coordina los diferentes controles de la aplicación: gráfico, clientes,
 * quiosco, opciones de menú, productos y pedidos.
 *
 * La clase se encarga de iniciar la sesión de un cliente, crear pedidos y
 * delegar la creación de opciones de menú a su correspondiente controlador.
 * Además, provee métodos getter y setter para cada uno de sus controles,
 * facilitando la interacción entre las distintas partes del sistema.
 *
 * @author Cristianlol789
 */
public class ControlPrincipal {

    private ControlGrafico controlGrafico;
    private ControlClientes controlClientes;
    private ControlQuiosco controlQuiosco;
    private ControlOpcionesMenu controlOpcionesMenu;
    private ControlProducto controlProductos;
    private ControlPedido controlPedido;

    /**
     * Inicializa cada uno de los controles utilizados en la aplicación, pasando
     * la referencia de esta instancia para permitir la comunicación entre
     * ellos.
     */
    public ControlPrincipal() {
        this.controlGrafico = new ControlGrafico(this);
        this.controlClientes = new ControlClientes(this);
        this.controlQuiosco = new ControlQuiosco(this);
        this.controlOpcionesMenu = new ControlOpcionesMenu(this);
        this.controlProductos = new ControlProducto(this);
        this.controlPedido = new ControlPedido(this);
    }

    /**
     * proceso de inicio de sesión implica buscar al cliente en el sistema
     * mediante el controlador de clientes, utilizando el número de cédula
     *
     * @param cedula Número de cédula del cliente
     * @param puntosEquivalentes Puntos equivalentes asociados al cliente
     * @param metodoDePago puntosEquivalentes
     */
    public void inicioSesionCliente(double cedula, double puntosEquivalentes, String metodoDePago) {
        controlClientes.buscarCliente(cedula, puntosEquivalentes);
        crearPedido(cedula, metodoDePago);
    }

    /**
     * El método delega la creación del pedido al controlador de pedidos
     */
    public void crearPedido(double cedula, String metodoDePago) {
        controlPedido.crearPedido(cedula, metodoDePago);
    }
    
    public void crearBucket(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, int cantidadPresas){
        String identificicadorMenu = "Bucket";
        HashMap<String, Boolean> agrandados = new HashMap<>();
        ArrayList<String> adiciones = new ArrayList<>();
        controlOpcionesMenu.crearMenu(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificicadorMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificicadorMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificicadorMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificicadorMenu, agrandados, adiciones, identificicadorMenu, cantidadPresas, cantidadPresas);
    }
    
    public void crearCombo(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2,  String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3,  HashMap<String, Boolean> agrandados, ArrayList<String> adiciones){
        
    }
    
    public void crearParaCompartir3(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1,  String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2,  String identificador2){
        
    }
    
    public void crearParaCompartir4(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1,  String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2,  String identificador2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3,  String identificador3){
        
    }
    
    public void crearUnidad(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador){
        
    }

    /**
     * Retorna la instancia del controlador gráfico asociado.
     *
     * @return La instancia actual del {@link ControlGrafico} utilizado en la
     * aplicación.
     */
    public ControlGrafico getControlGrafico() {
        return controlGrafico;
    }

    /**
     * Asigna una nueva instancia para el controlador gráfico.
     *
     * @param controlGrafico Nueva instancia del controlador gráfico.
     */
    public void setControlGrafico(ControlGrafico controlGrafico) {
        this.controlGrafico = controlGrafico;
    }

    /**
     * Retorna la instancia del controlador de clientes.
     *
     * @return La instancia actual del {@link ControlClientes} utilizado en el
     * sistema.
     */
    public ControlClientes getControlClientes() {
        return controlClientes;
    }

    /**
     * Asigna una nueva instancia para el controlador de clientes.
     *
     * @param controlClientes Nueva instancia del controlador de clientes.
     */
    public void setControlClientes(ControlClientes controlClientes) {
        this.controlClientes = controlClientes;
    }

    /**
     * Retorna la instancia del controlador del quiosco.
     *
     * @return La instancia actual del {@link ControlQuiosco} utilizado en la
     * aplicación.
     */
    public ControlQuiosco getControlQuiosco() {
        return controlQuiosco;
    }

    /**
     * Asigna una nueva instancia para el controlador del quiosco.
     *
     * @param controlQuiosco Nueva instancia del controlador del quiosco.
     */
    public void setControlQuiosco(ControlQuiosco controlQuiosco) {
        this.controlQuiosco = controlQuiosco;
    }

    /**
     * Retorna la instancia del controlador de opciones de menú.
     *
     * @return La instancia actual del {@link ControlOpcionesMenu} encargado de
     * gestionar las opciones de menú.
     */
    public ControlOpcionesMenu getControlOpcionesMenu() {
        return controlOpcionesMenu;
    }

    /**
     * Asigna una nueva instancia para el controlador de opciones de menú.
     *
     * @param controlOpcionesMenu Nueva instancia del controlador de opciones de
     * menú.
     */
    public void setControlOpcionesMenu(ControlOpcionesMenu controlOpcionesMenu) {
        this.controlOpcionesMenu = controlOpcionesMenu;
    }

    /**
     * Retorna la instancia del controlador de productos.
     *
     * @return La instancia actual del {@link ControlProducto} utilizado para
     * gestionar la información de productos.
     */
    public ControlProducto getControlProductos() {
        return controlProductos;
    }

    /**
     * Asigna una nueva instancia para el controlador de productos.
     *
     * @param controlProductos Nueva instancia del controlador de productos.
     */
    public void setControlProductos(ControlProducto controlProductos) {
        this.controlProductos = controlProductos;
    }
}
