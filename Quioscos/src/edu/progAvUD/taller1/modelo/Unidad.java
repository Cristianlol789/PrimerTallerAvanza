package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;
import java.awt.Image;

/**
 *
 * @author and
 */
public class Unidad extends OpcionesMenu{
    
    private Producto producto;

    public Unidad(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen, String identificador, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}