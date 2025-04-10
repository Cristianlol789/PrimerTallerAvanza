
package edu.progAvUD.taller1.modelo;

/**
 *
 * @author and
 */
public class Unidad extends OpcionesMenu{
    
    private Producto producto;

    public Unidad(Producto producto, String nombre) {
        super(nombre,0,0);
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
