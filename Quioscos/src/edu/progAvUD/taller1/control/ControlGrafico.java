package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Esta clase es la encargda de gestionar los actionListeners de la ventana y
 * ademas de decir que se hara cada vez que pase algo en la ventana, ademas se
 * comunica constantemente con la venta y el control principal para poder mandar
 * o recibir informacion entre ellos
 *
 * @author Cristianlol789
 */
public class ControlGrafico implements ActionListener {

    private VentanaPrincipal ventanaPrincipal;
    private ControlPrincipal controlPrincipal;
    private Timer tiempoInactividad;
    private final int retrasoTiempoInactividad = 120000;
    private final HashMap<String, Double> preciosPaneles = new HashMap<>();

    /**
     * Este es el constructor, se encarga de adicionar los action listeners y de
     * manejar el tiempo de inactividad de una persona al ejecutarse el programa
     *
     * @param controlPrincipal es el parametro que utilizaremos como referencia
     * para comunicarnos con el control principal
     */
    public ControlGrafico(ControlPrincipal controlPrincipal) {
        this.ventanaPrincipal = new VentanaPrincipal(this);
        this.controlPrincipal = controlPrincipal;
        cargarDatosPreciosMaps();
        ponerPreciosEnPaneles();
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInicial);

        // Implementaciion de ActionListener del Panel Inial
        ventanaPrincipal.panelInicial.jButtonSiguiente.addActionListener(this);

        // implementacion de ActionListener de la MenuBar
        ventanaPrincipal.jMenuItemCrearCombo.addActionListener(this);
        ventanaPrincipal.jMenuItemCrearBucket.addActionListener(this);
        ventanaPrincipal.jMenuItemMasProductos.addActionListener(this);
        ventanaPrincipal.jMenuItemPagar.addActionListener(this);
        ventanaPrincipal.jMenuItemParaCompartir.addActionListener(this);

        //implementacion de ActionListener del Panel Bucket
        ventanaPrincipal.panelBuckets.jButtonAgregarPedidoBucket.addActionListener(this);

        // Método para actualizar el texto del JTextField de PrecioTotal del Bucket
        ChangeListener listenerToltalBucket = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int UnidadesAla = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesAla.getValue();
                int UnidadesPechuga = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesPechuga.getValue();
                int UnidadesPierna = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesPierna.getValue();
                int UnidadesCuadrito = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesCuadrito.getValue();

                double TotalBucket = (preciosPaneles.get("Ala") * UnidadesAla) + (preciosPaneles.get("Pechuga") * UnidadesPechuga) + ((preciosPaneles.get("Pierna") * UnidadesPierna) + (preciosPaneles.get("Cuadrito") * UnidadesCuadrito));
                ventanaPrincipal.panelBuckets.jTextFieldPrecioTotalBucket.setText("$ " + TotalBucket);
            }
        };
        // Implementacion del metodo pasado
        ventanaPrincipal.panelBuckets.jSpinnerUnidadesAla.addChangeListener(listenerToltalBucket);
        ventanaPrincipal.panelBuckets.jSpinnerUnidadesCuadrito.addChangeListener(listenerToltalBucket);
        ventanaPrincipal.panelBuckets.jSpinnerUnidadesPechuga.addChangeListener(listenerToltalBucket);
        ventanaPrincipal.panelBuckets.jSpinnerUnidadesPierna.addChangeListener(listenerToltalBucket);

        tiempoInactividad = new Timer(retrasoTiempoInactividad, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInicial);
                ventanaPrincipal.jMenuBar1.setVisible(false);
            }
        });
        tiempoInactividad.setRepeats(false);
        tiempoInactividad.start();
    }

    /**
     * Este metodo se encarga de gestionar lo que pasa en la simulacion cuando
     * una persona toca un boton o hace cualquier cosas en la ventana
     *
     * @param e hace referencia a los objetos que son tocados o utilizados por
     * el usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        tiempoInactividad.restart();
        // Respuesta del panel Inicial
        if (e.getSource() == ventanaPrincipal.panelInicial.jButtonSiguiente) {
            if (ventanaPrincipal.panelInicial.jRadioButtonComerAqui.isSelected()) {
                ventanaPrincipal.jMenuBar1.setVisible(true);
                ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelBuckets);
            } else {
                ventanaPrincipal.mostrarMensajeError("Seccion en desarrollo. Gracias por su paciencia");
            }
        }
        // Respuesta del JMenuBar
        if (e.getSource() == ventanaPrincipal.jMenuItemCrearCombo) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelCombos);
        }
        if (e.getSource() == ventanaPrincipal.jMenuItemCrearBucket) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelBuckets);
        }
        if (e.getSource() == ventanaPrincipal.jMenuItemMasProductos) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOtrosProductos);
        }
        if (e.getSource() == ventanaPrincipal.jMenuItemPagar) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelPagar);
        }
        if (e.getSource() == ventanaPrincipal.jMenuItemParaCompartir) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelParaCompartir);
        }
        // Respuesta de panelBucket
        if (e.getSource() == ventanaPrincipal.panelBuckets.jButtonAgregarPedidoBucket) {
            cargarBucket();
        }
    }

    public void cargarDatosPreciosMaps() {
        preciosPaneles.put("Pierna", 6000.0);
        preciosPaneles.put("Pechuga", 8000.0);
        preciosPaneles.put("Ala", 6000.0);
        preciosPaneles.put("Cuadrito", 7000.0);

        preciosPaneles.put("Presa", 7000.0);
        preciosPaneles.put("Nuggets", 15000.0);
        preciosPaneles.put("Hamburguesa", 12000.0);
        preciosPaneles.put("Wraps", 10000.0);
        preciosPaneles.put("Papas", 6000.0);
        preciosPaneles.put("Strips", 10000.0);

        preciosPaneles.put("ParaCompartir1", 39900.0);
        preciosPaneles.put("ParaCompartir2", 29900.0);
        preciosPaneles.put("ParaCompartir3", 25900.0);
        preciosPaneles.put("ParaCompartir4", 42900.0);
        preciosPaneles.put("ParaCompartir5", 35900.0);

        preciosPaneles.put("Bebida", 5000.0);

    }

    public void ponerPreciosEnPaneles() {
        ventanaPrincipal.panelBuckets.jTextFieldPrecioPierna.setText("$ " + preciosPaneles.get("Pierna"));
        ventanaPrincipal.panelBuckets.jTextFieldPrecioPechuga.setText("$ " + preciosPaneles.get("Pechuga"));
        ventanaPrincipal.panelBuckets.jTextFieldPrecioAla.setText("$ " + preciosPaneles.get("Ala"));
        ventanaPrincipal.panelBuckets.jTextFieldPrecioCuadrito.setText("$ " + preciosPaneles.get("Cuadrito"));

        ventanaPrincipal.panelCombos.jTextFieldPrecioPresa.setText("$ " + preciosPaneles.get("Presa"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioNuggets.setText("$ " + preciosPaneles.get("Nuggets"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioHamburguesa.setText("$ " + preciosPaneles.get("Hamburguesa"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioWraps.setText("$ " + preciosPaneles.get("Wraps"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioGaseosa.setText("$ " + preciosPaneles.get("Bebida"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioPapas.setText("$ " + preciosPaneles.get("Papas"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioStrips.setText("$ " + preciosPaneles.get("Strips"));

        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir1.setText("$ " + preciosPaneles.get("ParaCompartir1"));
        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir2.setText("$ " + preciosPaneles.get("ParaCompartir2"));
        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir3.setText("$ " + preciosPaneles.get("ParaCompartir3"));
        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir4.setText("$ " + preciosPaneles.get("ParaCompartir4"));
        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir5.setText("$ " + preciosPaneles.get("ParaCompartir5"));

        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioPierna.setText("$ " + preciosPaneles.get("Pierna"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioAla.setText("$ " + preciosPaneles.get("Ala"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioPechuga.setText("$ " + preciosPaneles.get("Pechuga"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioCuadrito.setText("$ " + preciosPaneles.get("Cuadrito"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioBebida.setText("$ " + preciosPaneles.get("Bebida"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioStrips.setText("$ " + preciosPaneles.get("Strips"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioNuggets.setText("$ " + preciosPaneles.get("Nuggets"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioHamburguesa.setText("$ " + preciosPaneles.get("Hamburguesa"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioWraps.setText("$ " + preciosPaneles.get("Wraps"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioPapas.setText("$ " + preciosPaneles.get("Papas"));

    }

    public void cargarBucket() {
        int unidadesAla = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesAla.getValue();
        int unidadesPechuga = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesPechuga.getValue();
        int unidadesPierna = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesPierna.getValue();
        int unidadesCuadrito = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesCuadrito.getValue();
        int unidadesBucket = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesBucket.getValue();
        
        String coccionAla = (String) ventanaPrincipal.panelBuckets.jComboBoxCoccionAla.getSelectedItem();
        String coccionPechuga = (String) ventanaPrincipal.panelBuckets.jComboBoxCoccionPechuga.getSelectedItem();
        String coccionPierna = (String) ventanaPrincipal.panelBuckets.jComboBoxCoccionPierna.getSelectedItem();
        String coccionCuadrito = (String) ventanaPrincipal.panelBuckets.jComboBoxCoccionCuadrito.getSelectedItem();

        
        double totalBucket = (preciosPaneles.get("Ala") * unidadesAla) + (preciosPaneles.get("Pechuga") * unidadesPechuga) + ((preciosPaneles.get("Pierna") * unidadesPierna) + (preciosPaneles.get("Cuadrito") * unidadesCuadrito));
        
        if ((unidadesAla + unidadesPechuga + unidadesPierna + unidadesCuadrito) > 8) {
            ventanaPrincipal.mostrarMensajeError("El bucket tiene mas de 8 presas");
        } else {
            controlPrincipal.crearBucket("Bucket Personal", totalBucket, totalBucket, 
                    "Ala", coccionAla, "Presa de pollo", "Ala de Pollo apanada al estilo FormFood",  preciosPaneles.get("Ala"),  preciosPaneles.get("Ala"), "presaPollo", unidadesAla, 
                    "Pierna", coccionPierna, "Presa de pollo", "Pierna de Pollo apanada al estilo FormFood", preciosPaneles.get("Pierna"), preciosPaneles.get("Pierna"), unidadesPierna, 
                    "Cuadrito", coccionCuadrito, "Presa de pollo", "Cuadrito de Pollo apanado al estilo FormFood", preciosPaneles.get("Cuadritos"), preciosPaneles.get("Cuadritos"), unidadesCuadrito,
                    "Pechuga", coccionPechuga, "Presa de pollo", "Pechuga de Pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"),  preciosPaneles.get("Pechuga"), unidadesPechuga, 
                    unidadesBucket);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el bucket al pedido");
        }
    }
}
