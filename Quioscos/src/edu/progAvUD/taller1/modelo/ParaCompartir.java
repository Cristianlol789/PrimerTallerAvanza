package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;
import java.awt.Image;

/**
 *
 * @author and
 */
public class ParaCompartir extends OpcionesMenu {
    
    private Producto[] producto;

    public ParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String identificador2, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[3];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, identificador1);
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, identificador2);
    }
    
    public ParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, Image imagen, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, Image imagen1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, Image imagen2, String identificador2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, Image imagen3, String identificador3, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[3];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, imagen, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, imagen1, identificador1);
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, imagen2, identificador2);
        this.producto[3] = controlProducto.crearProducto(tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, imagen3, identificador3);
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

}