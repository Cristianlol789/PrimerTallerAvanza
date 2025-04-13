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
     * @param metodoDePago forma en la que el cliente desidio pagar
     */
    public String inicioSesionCliente(double cedula, double puntosEquivalentes, String metodoDePago) {
        String info = controlClientes.buscarCliente(cedula, puntosEquivalentes);
        crearPedido(cedula, metodoDePago);
        return info;
    }

    /**
     * El método delega la creación del pedido al controlador de pedidos
     *
     * @param cedula Número de cédula del cliente
     * @param metodoDePago forma en la que el cliente desidio pagar
     */
    public void crearPedido(double cedula, String metodoDePago) {
        controlPedido.crearPedido(cedula, metodoDePago);
    }
    
    public String pagoPuntos(double cedula, double puntosEquivalentes, String metodoDePago){
        String info = controlClientes.pagarPuntos(cedula, puntosEquivalentes);
        crearPedido(cedula, metodoDePago);
        return info;
    }

    /**
     * Crea un menú de tipo "Bucket" utilizando los parámetros de configuración
     * para el menú
     *
     * @param nombreMenu Nombre del menú tipo Bucket.
     * @param precioTotalMenu Precio total del menú.
     * @param puntosEquivalentesMenu Puntos equivalentes otorgados por el menú.
     * @param tipo Tipo del primer producto.
     * @param coccion Tipo de cocción del primer producto.
     * @param nombre Nombre del primer producto.
     * @param descripcion Descripción del primer producto.
     * @param precio Precio del primer producto.
     * @param puntosEquivalentes Puntos equivalentes del primer producto.
     * @param identificador Identificador común para todos los productos del
     * bucket.
     * @param cantidadPresasAla Cantidad de presas tipo ala en el bucket.
     * @param tipo1 Tipo del segundo producto.
     * @param coccion1 Tipo de cocción del segundo producto.
     * @param nombre1 Nombre del segundo producto.
     * @param descripcion1 Descripción del segundo producto.
     * @param precio1 Precio del segundo producto.
     * @param puntosEquivalentes1 Puntos equivalentes del segundo producto.
     * @param cantidadPresasPierna Cantidad de presas tipo pierna en el bucket.
     * @param tipo2 Tipo del tercer producto.
     * @param coccion2 Tipo de cocción del tercer producto.
     * @param nombre2 Nombre del tercer producto.
     * @param descripcion2 Descripción del tercer producto.
     * @param precio2 Precio del tercer producto.
     * @param puntosEquivalentes2 Puntos equivalentes del tercer producto.
     * @param cantidadPresasCuadro Cantidad de presas tipo cuadro en el bucket.
     * @param tipo3 Tipo del cuarto producto.
     * @param coccion3 Tipo de cocción del cuarto producto.
     * @param nombre3 Nombre del cuarto producto.
     * @param descripcion3 Descripción del cuarto producto.
     * @param precio3 Precio del cuarto producto.
     * @param puntosEquivalentes3 Puntos equivalentes del cuarto producto.
     * @param cantidadPresasPechuga Cantidad de presas tipo pechuga en el
     * bucket.
     * @param cantidadMenuComprado Número de veces que se compró este menú
     * (cantidad total del combo).
     */
    public void crearBucket(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, int cantidadPresasAla, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, int cantidadPresasPierna, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, int cantidadPresasCuadro, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, int cantidadPresasPechuga, int cantidadMenuComprado) {
        String identificicadorMenu = "Bucket";
        HashMap<String, Boolean> agrandados = new HashMap<>();
        ArrayList<String> adiciones = new ArrayList<>();
        controlOpcionesMenu.crearMenu(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador, tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, identificador, agrandados, adiciones, identificicadorMenu, cantidadPresasAla, cantidadMenuComprado, cantidadPresasPierna, cantidadPresasCuadro, cantidadPresasPechuga);
    }

    /**
     * Crea un menú de tipo "Combo" que integra varios productos
     *
     * @param nombreMenu Nombre del menú principal.
     * @param precioTotalMenu Precio total del menú.
     * @param puntosEquivalentesMenu Puntos o equivalencia en puntos del menú.
     * @param tipo Tipo del producto o categoría principal.
     * @param coccion Tipo de cocción o preparación.
     * @param nombre Nombre del primer producto o sección.
     * @param descripcion Descripción del primer producto.
     * @param precio Precio del primer producto.
     * @param puntosEquivalentes Puntos equivalentes del primer producto.
     * @param identificador Identificador del primer componente.
     * @param tipo1 Tipo del segundo componente.
     * @param coccion1 Cocción del segundo componente.
     * @param nombre1 Nombre del segundo componente.
     * @param descripcion1 Descripción del segundo componente.
     * @param precio1 Precio del segundo componente.
     * @param puntosEquivalentes1 Puntos equivalentes del segundo componente.
     * @param identificador1 Identificador del segundo componente.
     * @param tipo2 Tipo del tercer componente.
     * @param coccion2 Cocción del tercer componente.
     * @param nombre2 Nombre del tercer componente.
     * @param descripcion2 Descripción del tercer componente.
     * @param precio2 Precio del tercer componente.
     * @param puntosEquivalentes2 Puntos equivalentes del tercer componente.
     * @param identificador2 Identificador del tercer componente.
     * @param tipo3 Tipo del cuarto componente.
     * @param coccion3 Cocción del cuarto componente.
     * @param nombre3 Nombre del cuarto componente.
     * @param descripcion3 Descripción del cuarto componente.
     * @param precio3 Precio del cuarto componente.
     * @param puntosEquivalentes3 Puntos equivalentes del cuarto componente.
     * @param identificador3 Identificador del cuarto componente.
     * @param agrandados Mapa de opciones indicadas como "agrandadas" para el
     * combo.
     * @param adiciones Lista de adiciones o extras asociados.
     * @param cantidadMenuComprado Cantidad total
     */
    public void crearCombo(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String identificador2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, String identificador3, HashMap<String, Boolean> agrandados, ArrayList<String> adiciones, int cantidadMenuComprado) {
        String identificadorMenu = "Combo";
        controlOpcionesMenu.crearMenu(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2, tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, identificador3, agrandados, adiciones, identificadorMenu, 0, cantidadMenuComprado, 0, 0, 0);
    }

    /**
     * Crea un menú de tipo "ParaCompartir3", pensado para grupos o
     * presentaciones que se comparten entre varios
     *
     * @param nombreMenu Nombre del menú principal.
     * @param precioTotalMenu Precio total del menú.
     * @param puntosEquivalentesMenu Puntos o equivalencia en puntos del menú.
     * @param tipo Tipo del producto o categoría.
     * @param coccion Tipo de cocción o preparación.
     * @param nombre Nombre del producto principal.
     * @param descripcion Descripción del producto.
     * @param precio Precio del producto.
     * @param puntosEquivalentes Puntos equivalentes del producto.
     * @param identificador Identificador del primer componente.
     * @param tipo1 Tipo del segundo componente.
     * @param coccion1 Cocción del segundo componente.
     * @param nombre1 Nombre del segundo componente.
     * @param descripcion1 Descripción del segundo componente.
     * @param precio1 Precio del segundo componente.
     * @param puntosEquivalentes1 Puntos equivalentes del segundo componente.
     * @param identificador1 Identificador del segundo componente.
     * @param tipo2 Tipo del tercer componente.
     * @param coccion2 Cocción del tercer componente.
     * @param nombre2 Nombre del tercer componente.
     * @param descripcion2 Descripción del tercer componente.
     * @param precio2 Precio del tercer componente.
     * @param puntosEquivalentes2 Puntos equivalentes del tercer componente.
     * @param identificador2 Identificador del tercer componente.
     * @param cantidadMenuComprado Cantidad asociada al menú
     * @param cantidadProducto
     * @param cantidadProducto1
     * @param cantidadProducto2
     */
    public void crearParaCompartir3(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String identificador2, int cantidadMenuComprado, int cantidadProducto, int cantidadProducto1, int cantidadProducto2) {
        String identificadorMenu = "ParaCompartir3";
        HashMap<String, Boolean> agrandados = new HashMap<>();
        ArrayList<String> adiciones = new ArrayList<>();
        controlOpcionesMenu.crearMenu(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2, agrandados, adiciones, identificadorMenu, cantidadProducto, cantidadMenuComprado, cantidadProducto1, cantidadProducto2, 0);
    }

    /**
     * Similar al método anterior pero diseñado para grupos o presentaciones
     *
     * @param nombreMenu Nombre del menú principal.
     * @param precioTotalMenu Precio total del menú.
     * @param puntosEquivalentesMenu Puntos o equivalencia en puntos del menú.
     * @param tipo Tipo general del producto o categoría.
     * @param coccion Tipo de cocción o preparación.
     * @param nombre Nombre del primer producto o sección.
     * @param descripcion Descripción del primer producto.
     * @param precio Precio del primer producto.
     * @param puntosEquivalentes Puntos equivalentes del primer producto.
     * @param identificador Identificador del primer componente.
     * @param tipo1 Tipo del segundo componente.
     * @param coccion1 Cocción del segundo componente.
     * @param nombre1 Nombre del segundo componente.
     * @param descripcion1 Descripción del segundo componente.
     * @param precio1 Precio del segundo componente.
     * @param puntosEquivalentes1 Puntos equivalentes del segundo componente.
     * @param identificador1 Identificador del segundo componente.
     * @param tipo2 Tipo del tercer componente.
     * @param coccion2 Cocción del tercer componente.
     * @param nombre2 Nombre del tercer componente.
     * @param descripcion2 Descripción del tercer componente.
     * @param precio2 Precio del tercer componente.
     * @param puntosEquivalentes2 Puntos equivalentes del tercer componente.
     * @param identificador2 Identificador del tercer componente.
     * @param tipo3 Tipo del cuarto componente.
     * @param coccion3 Cocción del cuarto componente.
     * @param nombre3 Nombre del cuarto componente.
     * @param descripcion3 Descripción del cuarto componente.
     * @param precio3 Precio del cuarto componente.
     * @param puntosEquivalentes3 Puntos equivalentes del cuarto componente.
     * @param identificador3 Identificador del cuarto componente.
     * @param cantidadMenuComprado Indica la cantidad o medida del menú
     * comprado.
     * @param cantidadProducto
     * @param cantidadProducto1
     * @param cantidadProducto2
     * @param cantidadProducto3
     */
    public void crearParaCompartir4(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String identificador2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, String identificador3, int cantidadMenuComprado, int cantidadProducto, int cantidadProducto1, int cantidadProducto2, int cantidadProducto3) {
        String identificadorMenu = "ParaCompartir4";
        HashMap<String, Boolean> agrandados = new HashMap<>();
        ArrayList<String> adiciones = new ArrayList<>();
        controlOpcionesMenu.crearMenu(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1, tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2, tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, identificador3, agrandados, adiciones, identificadorMenu, cantidadProducto, cantidadMenuComprado, cantidadProducto1, cantidadProducto2, cantidadProducto3);
    }

    /**
     * Crea un menú de tipo "Unidad", destinado a productos que se venden
     * individualmente.
     *
     * @param nombreMenu Nombre del menú principal.
     * @param precioTotalMenu Precio total del menú.
     * @param puntosEquivalentesMenu Puntos o equivalencia en puntos del menú.
     * @param tipo Tipo o categoría del producto.
     * @param coccion Tipo de cocción o preparación.
     * @param nombre Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param precio Precio individual del producto.
     * @param puntosEquivalentes Puntos equivalentes para el producto.
     * @param identificador Identificador del componente específico.
     * @param cantidadMenuComprado Cantidad de unidades a comprar
     */
    public void crearUnidad(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, int cantidadMenuComprado) {
        String identificadorMenu = "Unidad";
        HashMap<String, Boolean> agrandados = new HashMap<>();
        ArrayList<String> adiciones = new ArrayList<>();
        controlOpcionesMenu.crearMenu(nombreMenu, precioTotalMenu, puntosEquivalentesMenu, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador, agrandados, adiciones, identificadorMenu, 0, cantidadMenuComprado, 0, 0, 0);
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
