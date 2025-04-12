package edu.progAvUD.taller1.modelo;


/**
 *Esta clase es una hija de Producto y no tiene metodos abstractos.
 * @author and
 */

public class Bebida extends Producto{
    
    private String tipoBebida;
    private String sabor;

    /**
     *
     * @param tipoBebida Este parametro es recibido desde las instacias, se usa para saber el tipo de bebida que la persona desea pedir
     * @param sabor Junto al parametro tipoBebida este sirve para saber especificamente que quiere el cliente en este caso hablando del sabor
     * @param nombre Este parametro se encarga de decir cual es el producto que la persona pidio por medio del nombre de este mismo
     * @param descripcion Este parametro se usa para describir cosas del producto como lo son cantidad de unidades, salsa adicionada, tipo de pieza, etc.
     * @param precio Este indica el valor de este producto sin ser adicionado a algun tipo de menu es decir indica el precio solo de la unidad de este
     * @param puntosEquivalentes Este representa el valor en puntos del precio del producto
     */
    public Bebida(String tipoBebida, String sabor, String nombre, String descripcion, double precio, double puntosEquivalentes) {
        super(nombre, descripcion, precio, puntosEquivalentes);
        this.tipoBebida = tipoBebida;
        this.sabor = sabor;
    }

    /**
     *
     * @return el tipo de bebida que esta guarda en el programa
     */
    public String getTipoBebida() {
        return tipoBebida;
    }

    /**
     *
     * @param tipoBebida sirve para cambiar el tipo de bebida si esta ya se encuentra cargada
     */
    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    /**
     *
     * @return el sabor de la bebida guarda en su atributo
     */
    public String getSabor() {
        return sabor;
    }

    /**
     *
     * @param sabor se utiliza para cambiar el valor de algun producto ya creado, aunque en el codigo no tiene funcion ya que la persona puede cambiar el producto despues de creado.
     */
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
}
