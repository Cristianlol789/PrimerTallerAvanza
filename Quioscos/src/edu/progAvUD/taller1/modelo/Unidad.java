package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;

/**
 * Representa una opción de menú individual que contiene un único producto.
 * Hereda de {@link OpcionesMenu} y encapsula un objeto {@link Producto}
 * generado a través de la clase {@link ControlProducto}.
 *
 * Esta clase es útil para agrupar productos individuales dentro de un menú más
 * amplio.
 *
 * Autor: and
 */
public class Unidad extends OpcionesMenu {

    /**
     * Producto asociado a esta unidad del menú
     */
    private Producto producto;

    /**
     * Crea una nueva unidad del menú que representa un solo producto. El
     * producto se crea mediante un {@link ControlProducto}, con los parámetros
     * dados.
     *
     * @param nombreMenu Nombre de la unidad de menú.
     * @param precioTotalMenu Precio total del menú (en este caso, de un solo
     * producto).
     * @param puntosEquivalentesMenu Puntos de fidelidad del menú.
     * @param tipo Tipo de producto a crear (ej. Strips, Combo, etc.).
     * @param coccion Tipo de cocción del producto.
     * @param nombre Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param precio Precio del producto.
     * @param puntosEquivalentes Puntos equivalentes del producto.
     * @param identificador Identificador único del producto.
     * @param controlProducto Objeto de control encargado de crear el producto.
     */
    public Unidad(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
    }

    /**
     * Obtiene el producto contenido en esta unidad del menú.
     *
     * @return El objeto {@link Producto} asociado.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece un nuevo producto para esta unidad del menú.
     *
     * @param producto Nuevo producto a asignar.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
