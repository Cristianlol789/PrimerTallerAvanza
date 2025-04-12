package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;

/**
 * Representa una opción de menú tipo "Para Compartir", compuesta por varios
 * productos.
 *
 * Esta clase extiende {@link OpcionesMenu} e incluye una lista de productos que
 * pueden ser compartidos por varios comensales.
 *
 * Puede incluir 3 o 4 productos dependiendo del constructor utilizado.
 *
 * @author and
 */
public class ParaCompartir extends OpcionesMenu {

    /**
     * Arreglo de productos que conforman el menú para compartir.
     */
    private Producto[] producto;

    /**
     * Constructor que permite crear un menú para compartir con 3 productos.
     *
     * @param nombreMenu nombre del menú
     * @param precioTotalMenu precio total del menú
     * @param puntosEquivalentesMenu puntos equivalentes del menú
     * @param tipo tipo del primer producto
     * @param coccion cocción del primer producto
     * @param nombre nombre del primer producto
     * @param descripcion descripción del primer producto
     * @param precio precio del primer producto
     * @param puntosEquivalentes puntos del primer producto
     * @param identificador identificador del primer producto
     * @param tipo1 tipo del segundo producto
     * @param coccion1 cocción del segundo producto
     * @param nombre1 nombre del segundo producto
     * @param descripcion1 descripción del segundo producto
     * @param precio1 precio del segundo producto
     * @param puntosEquivalentes1 puntos del segundo producto
     * @param identificador1 identificador del segundo producto
     * @param tipo2 tipo del tercer producto
     * @param coccion2 cocción del tercer producto
     * @param nombre2 nombre del tercer producto
     * @param descripcion2 descripción del tercer producto
     * @param precio2 precio del tercer producto
     * @param puntosEquivalentes2 puntos del tercer producto
     * @param identificador2 identificador del tercer producto
     * @param controlProducto controlador para crear productos
     */
    public ParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String identificador2, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[3];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1);
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2);
    }

    /**
     * Constructor que permite crear un menú para compartir con 4 productos.
     *
     * @param nombreMenu nombre del menú
     * @param precioTotalMenu precio total del menú
     * @param puntosEquivalentesMenu puntos equivalentes del menú
     * @param tipo tipo del primer producto
     * @param coccion cocción del primer producto
     * @param nombre nombre del primer producto
     * @param descripcion descripción del primer producto
     * @param precio precio del primer producto
     * @param puntosEquivalentes puntos del primer producto
     * @param identificador identificador del primer producto
     * @param tipo1 tipo del segundo producto
     * @param coccion1 cocción del segundo producto
     * @param nombre1 nombre del segundo producto
     * @param descripcion1 descripción del segundo producto
     * @param precio1 precio del segundo producto
     * @param puntosEquivalentes1 puntos del segundo producto
     * @param identificador1 identificador del segundo producto
     * @param tipo2 tipo del tercer producto
     * @param coccion2 cocción del tercer producto
     * @param nombre2 nombre del tercer producto
     * @param descripcion2 descripción del tercer producto
     * @param precio2 precio del tercer producto
     * @param puntosEquivalentes2 puntos del tercer producto
     * @param identificador2 identificador del tercer producto
     * @param tipo3 tipo del tercer producto
     * @param coccion3 cocción del tercer producto
     * @param nombre3 nombre del tercer producto
     * @param descripcion3 descripción del tercer producto
     * @param precio3 precio del tercer producto
     * @param puntosEquivalentes3 puntos del tercer producto
     * @param identificador3 identificador del tercer producto
     * @param controlProducto controlador para crear productos
     */
    public ParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String identificador2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, String identificador3, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[4];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1);
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2);
        this.producto[3] = controlProducto.crearProducto(tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, identificador3);
    }

    /**
     * Obtiene el arreglo de productos del menú para compartir.
     *
     * @return arreglo de productos
     */
    public Producto[] getProducto() {
        return producto;
    }

    /**
     * Establece el arreglo de productos del menú para compartir.
     *
     * @param producto nuevo arreglo de productos
     */
    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

}
