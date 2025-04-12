package edu.progAvUD.taller1.modelo;

import edu.progAvUD.taller1.control.ControlProducto;

/**
 *
 * @author and
 */
public class ParaCompartir extends OpcionesMenu {
    
    private Producto[] producto;

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
     * @param tipo1
     * @param coccion1
     * @param nombre1
     * @param descripcion1
     * @param precio1
     * @param puntosEquivalentes1
     * @param identificador1
     * @param tipo2
     * @param coccion2
     * @param nombre2
     * @param descripcion2
     * @param precio2
     * @param puntosEquivalentes2
     * @param identificador2
     * @param controlProducto
     */
    public ParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String identificador2, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[3];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1);
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2);
    }
    
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
     * @param tipo1
     * @param coccion1
     * @param nombre1
     * @param descripcion1
     * @param precio1
     * @param puntosEquivalentes1
     * @param identificador1
     * @param tipo2
     * @param coccion2
     * @param nombre2
     * @param descripcion2
     * @param precio2
     * @param puntosEquivalentes2
     * @param identificador2
     * @param tipo3
     * @param coccion3
     * @param nombre3
     * @param descripcion3
     * @param precio3
     * @param puntosEquivalentes3
     * @param identificador3
     * @param controlProducto
     */
    public ParaCompartir(String nombreMenu, double precioTotalMenu, double puntosEquivalentesMenu, String tipo, String coccion, String nombre, String descripcion, double precio, double puntosEquivalentes, String identificador, String tipo1, String coccion1, String nombre1, String descripcion1, double precio1, double puntosEquivalentes1, String identificador1, String tipo2, String coccion2, String nombre2, String descripcion2, double precio2, double puntosEquivalentes2, String identificador2, String tipo3, String coccion3, String nombre3, String descripcion3, double precio3, double puntosEquivalentes3, String identificador3, ControlProducto controlProducto) {
        super(nombreMenu, precioTotalMenu, puntosEquivalentesMenu);
        this.producto = new Producto[3];
        this.producto[0] = controlProducto.crearProducto(tipo, coccion, nombre, descripcion, precio, puntosEquivalentes, identificador);
        this.producto[1] = controlProducto.crearProducto(tipo1, coccion1, nombre1, descripcion1, precio1, puntosEquivalentes1, identificador1);
        this.producto[2] = controlProducto.crearProducto(tipo2, coccion2, nombre2, descripcion2, precio2, puntosEquivalentes2, identificador2);
        this.producto[3] = controlProducto.crearProducto(tipo3, coccion3, nombre3, descripcion3, precio3, puntosEquivalentes3, identificador3);
    }

    /**
     *
     * @return
     */
    public Producto[] getProducto() {
        return producto;
    }

    /**
     *
     * @param producto
     */
    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

}