package edu.progAvUD.taller1.modelo;

/**
 *
 * @author and
 */
public class ParaCompartir extends OpcionesMenu {
    
    private Producto[] producto;

    public ParaCompartir(Producto[] producto, String nombre) {
        super(nombre);
        this.producto = producto;
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = new Producto[4];
        this.producto[0] = producto[0];
        this.producto[1] = producto[1];
        this.producto[2] = producto[2];
        this.producto[3] = producto[3];
    }    
    
}
