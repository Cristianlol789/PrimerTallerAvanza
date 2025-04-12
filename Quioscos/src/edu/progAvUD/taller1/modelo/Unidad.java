package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;

/**
 *
 * @author and
 */
public class Unidad extends OpcionesMenu{
    
    private Producto producto;

    /**
     *
     * @param nombreMenu
     * @param precioTotalMenu
     * @param puntosEquivalentesMenu
     * @param tipo
     * @param coccion
     * @param nombre
     * @param descripcion
     * @param precio
     * @param puntosEquivalentes
     * @param identificador
     * @param controlProducto
     */
    public Unidad(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
    }

    /**
     *
     * @return
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     *
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}