package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private final int retrasoTiempoInactividad = 60000;
    private final HashMap<String, Double> preciosPaneles = new HashMap<>();
    private final HashMap<String, Double> preciosPuntosPaneles = new HashMap<>();

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
        ventanaPrincipal.panelCombos.jButtonAgregarPedidoCombo.addActionListener(this);
        ventanaPrincipal.panelParaCompartir.jButtonAgragarPedidoCompartir.addActionListener(this);
        ventanaPrincipal.panelOtrosProductos.jButtonAgragarPedidoProducto.addActionListener(this);

        ventanaPrincipal.panelPagar.jButtonIrAPagar.addActionListener(this);

        actualizarPrecioTotalBucket();
        actualizarPrecioTotalCombo();
        actualizarBebidaPanelOtrosProductos();

        tiempoInactividad = new Timer(retrasoTiempoInactividad, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarMensajeExito("La seccion ha terminado debido a la inactividad ");
                ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInicial);
                ventanaPrincipal.panelInicial.setVisible(true);
                ventanaPrincipal.jMenuBar1.setVisible(false);
                
                ventanaPrincipal.panelPagar.limpiarCampos();
                controlPrincipal.getControlOpcionesMenu().vaciarHashMap();
                controlPrincipal.getControlOpcionesMenu().vaciarPrecio();
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

                ventanaPrincipal.panelInicial.setVisible(false);

                ventanaPrincipal.jMenuPagar.setVisible(false);
            } else if (ventanaPrincipal.panelInicial.jRadioButtonLlevar.isSelected()) {
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
            ventanaPrincipal.panelPagar.CargarDatosPedido(controlPrincipal.getControlOpcionesMenu().enviarDatosTablaPedido());
            ventanaPrincipal.panelPagar.jTextFieldTotalPagar.setText("$ " + controlPrincipal.getControlOpcionesMenu().getPrecioTotalPedido());
            ventanaPrincipal.panelPagar.jTextFieldTotalPagarPuntos.setText("" + controlPrincipal.getControlOpcionesMenu().getPrecioTotalPedido()/1000);
        }
        if (e.getSource() == ventanaPrincipal.jMenuItemParaCompartir) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelParaCompartir);
        }
        // Respuesta de panelBucket
        if (e.getSource() == ventanaPrincipal.panelBuckets.jButtonAgregarPedidoBucket) {
            cargarBucket();
            ventanaPrincipal.panelBuckets.limpiarCampos();

        }
        if (e.getSource() == ventanaPrincipal.panelCombos.jButtonAgregarPedidoCombo) {
            cargarCombo();
            ventanaPrincipal.panelCombos.limpiarCampos();
        }
        if (e.getSource() == ventanaPrincipal.panelParaCompartir.jButtonAgragarPedidoCompartir) {
            cargarParaCompartir();
            ventanaPrincipal.panelParaCompartir.limpiarCampos();
        }
        if (e.getSource() == ventanaPrincipal.panelOtrosProductos.jButtonAgragarPedidoProducto) {
            cargarUnidad();
            ventanaPrincipal.panelOtrosProductos.limpiarCampos();
        }
        if (e.getSource() == ventanaPrincipal.panelPagar.jButtonIrAPagar) {
            String cedula = ventanaPrincipal.panelPagar.jTextFieldCedula.getText();
            validarDescuento(cedula);
            ventanaPrincipal.panelPagar.setVisible(false);
            validarPago(cedula);
            ventanaPrincipal.panelPagar.setVisible(true);
            ventanaPrincipal.panelPagar.limpiarCampos();
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInicial);
            ventanaPrincipal.panelInicial.setVisible(true);
            ventanaPrincipal.jMenuBar1.setVisible(false);
            ventanaPrincipal.jMenuPagar.setVisible(false);
        }

    }

    /**
     * Se encarga de establecer los precios de los producto
     */
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

        preciosPuntosPaneles.put("Pierna", (6000.0) / 1000);
        preciosPuntosPaneles.put("Pechuga", (8000.0) / 1000);
        preciosPuntosPaneles.put("Ala", (6000.0) / 1000);
        preciosPuntosPaneles.put("Cuadrito", (7000.0) / 1000);

        preciosPuntosPaneles.put("Presa", (7000.0) / 1000);
        preciosPuntosPaneles.put("Nuggets", (15000.0) / 1000);
        preciosPuntosPaneles.put("Hamburguesa", (12000.0) / 1000);
        preciosPuntosPaneles.put("Wraps", (10000.0) / 1000);
        preciosPuntosPaneles.put("Papas", (6000.0) / 1000);
        preciosPuntosPaneles.put("Strips", (10000.0) / 1000);

        preciosPuntosPaneles.put("ParaCompartir1", (39900.0) / 1000);
        preciosPuntosPaneles.put("ParaCompartir2", (29900.0) / 1000);
        preciosPuntosPaneles.put("ParaCompartir3", (25900.0) / 1000);
        preciosPuntosPaneles.put("ParaCompartir4", (42900.0) / 1000);
        preciosPuntosPaneles.put("ParaCompartir5", (35900.0) / 1000);

        preciosPuntosPaneles.put("Bebida", (5000.0) / 1000);

    }

    /**
     * Le pone a los label los valores correspondientes de los precios para
     * mostrarlos al consumidor
     */
    public void ponerPreciosEnPaneles() {
        //Precio en pesos
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

        // Precio en puntos
        ventanaPrincipal.panelBuckets.jTextFieldPrecioPiernaPuntos.setText("" + preciosPuntosPaneles.get("Pierna"));
        ventanaPrincipal.panelBuckets.jTextFieldPrecioPechugaPuntos.setText("" + preciosPuntosPaneles.get("Pechuga"));
        ventanaPrincipal.panelBuckets.jTextFieldPrecioAlaPuntos.setText("" + preciosPuntosPaneles.get("Ala"));
        ventanaPrincipal.panelBuckets.jTextFieldPrecioCuadritoPuntos.setText("" + preciosPuntosPaneles.get("Cuadrito"));

        ventanaPrincipal.panelCombos.jTextFieldPrecioPresaPuntos.setText("" + preciosPuntosPaneles.get("Presa"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioNuggetsPuntos.setText("" + preciosPuntosPaneles.get("Nuggets"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioHamburguesaPuntos.setText("" + preciosPuntosPaneles.get("Hamburguesa"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioWrapsPuntos.setText("" + preciosPuntosPaneles.get("Wraps"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioGaseosaPuntos.setText("" + preciosPuntosPaneles.get("Bebida"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioPapasPuntos.setText("" + preciosPuntosPaneles.get("Papas"));
        ventanaPrincipal.panelCombos.jTextFieldPrecioStripsPuntos.setText("" + preciosPuntosPaneles.get("Strips"));

        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir1Puntos.setText("" + preciosPuntosPaneles.get("ParaCompartir1"));
        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir2Puntos.setText("" + preciosPuntosPaneles.get("ParaCompartir2"));
        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir3Puntos.setText("" + preciosPuntosPaneles.get("ParaCompartir3"));
        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir4Puntos.setText("" + preciosPuntosPaneles.get("ParaCompartir4"));
        ventanaPrincipal.panelParaCompartir.jTextFieldPrecioCompartir5Puntos.setText("" + preciosPuntosPaneles.get("ParaCompartir5"));

        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioPiernaPuntos.setText("" + preciosPuntosPaneles.get("Pierna"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioAlaPuntos.setText("" + preciosPuntosPaneles.get("Ala"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioPechugaPuntos.setText("" + preciosPuntosPaneles.get("Pechuga"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioCuadritoPuntos.setText("" + preciosPuntosPaneles.get("Cuadrito"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioBebidaPuntos.setText("" + preciosPuntosPaneles.get("Bebida"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioStripsPuntos.setText("" + preciosPuntosPaneles.get("Strips"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioNuggetsPuntos.setText("" + preciosPuntosPaneles.get("Nuggets"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioHamburguesaPuntos.setText("" + preciosPuntosPaneles.get("Hamburguesa"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioWrapsPuntos.setText("" + preciosPuntosPaneles.get("Wraps"));
        ventanaPrincipal.panelOtrosProductos.jTextFieldPrecioPapasPuntos.setText("" + preciosPuntosPaneles.get("Papas"));

    }

    /**
     * Se encarga de obtener los valores y datos del bucket para pasarselos al
     * controlPrincipal
     */
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
        } else if ((unidadesAla + unidadesPechuga + unidadesPierna + unidadesCuadrito) == 0) {
            ventanaPrincipal.mostrarMensajeError("No se ha podido añadir al carrito porque no hay ningun producto seleccionado");
        } else {
            controlPrincipal.crearBucket("Bucket Personal", totalBucket, totalBucket,
                    "Ala", coccionAla, "Presa de pollo", "Ala de Pollo apanada al estilo FormFood", preciosPaneles.get("Ala"), preciosPuntosPaneles.get("Ala"), "presaPollo", unidadesAla,
                    "Pierna", coccionPierna, "Presa de pollo", "Pierna de Pollo apanada al estilo FormFood", preciosPaneles.get("Pierna"), preciosPuntosPaneles.get("Pierna"), unidadesPierna,
                    "Cuadrito", coccionCuadrito, "Presa de pollo", "Cuadrito de Pollo apanado al estilo FormFood", preciosPaneles.get("Cuadrito"), preciosPuntosPaneles.get("Cuadrito"), unidadesCuadrito,
                    "Pechuga", coccionPechuga, "Presa de pollo", "Pechuga de Pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"), preciosPuntosPaneles.get("Pechuga"), unidadesPechuga,
                    unidadesBucket);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el bucket al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        }
    }

    /**
     * Se encarga de obtener los valores y datos del combo para pasarselos al
     * controlPrincipal
     */
    public void cargarCombo() {
        String partePollo = (String) ventanaPrincipal.panelCombos.jComboBoxPartePresa.getSelectedItem();
        String tipoCoccionPollo = (String) ventanaPrincipal.panelCombos.jComboBoxCoccionPresa.getSelectedItem();
        String tipoNuggets = (String) ventanaPrincipal.panelCombos.jComboBoxTipoNuggets.getSelectedItem();
        String tipoCoccionNuggets = (String) ventanaPrincipal.panelCombos.jComboBoxCoccionNuggets.getSelectedItem();
        String tipoPanHamburguesa = (String) ventanaPrincipal.panelCombos.jComboBoxPanHamburguesa.getSelectedItem();
        String tipoProteinaHamburguesa = (String) ventanaPrincipal.panelCombos.jComboBoxProteinaHamburguesa.getSelectedItem();
        String tipoQuesoWraps = (String) ventanaPrincipal.panelCombos.jComboBoxQuesoWraps.getSelectedItem();
        String tipoProteinaWraps = (String) ventanaPrincipal.panelCombos.jComboBoxProteinaWraps.getSelectedItem();

        String saborGaseosa = (String) ventanaPrincipal.panelCombos.jComboBoxSaborGaseosa.getSelectedItem();
        String agrandadoGaseosa = (String) ventanaPrincipal.panelCombos.jComboBoxAgrandadoGaseosa.getSelectedItem();

        String tipoPapa = (String) ventanaPrincipal.panelCombos.jComboBoxTipoPapas.getSelectedItem();
        String terminoCoccionPapa = (String) ventanaPrincipal.panelCombos.jComboBoxCoccionPapas.getSelectedItem();
        String agrandadoPapa = (String) ventanaPrincipal.panelCombos.jComboBoxAgrandadoPapas.getSelectedItem();

        String tipoEspecieStrips = (String) ventanaPrincipal.panelCombos.jComboBoxTipoPapas.getSelectedItem();
        String tipoCoccionStrips = (String) ventanaPrincipal.panelCombos.jComboBoxCoccionPapas.getSelectedItem();

        int unidadesCombo = (int) ventanaPrincipal.panelCombos.jSpinnerUnidadesCombo.getValue();

        ArrayList<String> adiciones = new ArrayList<>();
        double costoAdiciones = 0;
        HashMap<String, Boolean> agrandados = new HashMap<>();
        double costoAgrandados = 0;

        if ("No".equals(agrandadoGaseosa)) {
            agrandados.put("Gaseosa", false);
        } else {
            agrandados.put("Gaseosa", true);
            costoAgrandados += 7000;
        }
        if ("No".equals(agrandadoPapa)) {
            agrandados.put("Papas", false);
        } else {
            agrandados.put("Papas", true);
            costoAgrandados += 7000;
        }

        if (ventanaPrincipal.panelCombos.jCheckBoxQuesoAdicion.isSelected()) {
            adiciones.add("Extra Queso");
            costoAdiciones += 5000;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxSalsaPicanteAdicion.isSelected()) {
            adiciones.add("Salsa Picante");
            costoAdiciones += 5000;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxChipsAdicion.isSelected()) {
            adiciones.add("Chips Adicionales");
            costoAdiciones += 5000;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxArrozAdicion.isSelected()) {
            adiciones.add("Porcion de Arroz");
            costoAdiciones += 5000;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxTocinoAdicion.isSelected()) {
            adiciones.add("Tocino");
            costoAdiciones += 5000;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxJalapeñosAdicion.isSelected()) {
            adiciones.add("Jalapeños");
            costoAdiciones += 5000;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxSalsaBbqAdicion.isSelected()) {
            adiciones.add("Salsa BBQ");
            costoAdiciones += 5000;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxSourCreamAdicion.isSelected()) {
            adiciones.add("Sour Cream");
            costoAdiciones += 5000;
        }

        double precioTotalCombo = preciosPaneles.get("Bebida") + preciosPaneles.get("Papas") + preciosPaneles.get("Strips") + costoAdiciones + costoAgrandados;

        if (ventanaPrincipal.panelCombos.jRadioButtonPresa.isSelected()) {
            precioTotalCombo += preciosPaneles.get("Presa");
            controlPrincipal.crearCombo("Combo Personalizado", precioTotalCombo, precioTotalCombo,
                    partePollo, tipoCoccionPollo, "Presa Pollo", "Una presa de Pollo al estilo FormFood", preciosPaneles.get("Presa"), preciosPuntosPaneles.get("Presa"), "PresaPollo",
                    "Gaseosa", saborGaseosa, "Gaseosa", "Una Gaseosa para acompañar tu combo", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                    tipoPapa, terminoCoccionPapa, "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), "Papas",
                    tipoEspecieStrips, tipoCoccionStrips, "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPuntosPaneles.get("Strips"), "Strips",
                    agrandados, adiciones, unidadesCombo);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el combo al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        } else if (ventanaPrincipal.panelCombos.jRadioButtonNuggets.isSelected()) {
            precioTotalCombo += preciosPaneles.get("Nuggets");
            controlPrincipal.crearCombo("Combo Personalizado", precioTotalCombo, precioTotalCombo,
                    tipoNuggets, tipoCoccionNuggets, "Nuggets", "Los mejores Nuggets al estilo FormFood", preciosPaneles.get("Nuggets"), preciosPuntosPaneles.get("Nuggets"), "Nugget",
                    "Gaseosa", saborGaseosa, "Gaseosa", "Una Gaseosa para acompañar tu combo", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                    tipoPapa, terminoCoccionPapa, "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), "Papas",
                    tipoEspecieStrips, tipoCoccionStrips, "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPuntosPaneles.get("Strips"), "Strips",
                    agrandados, adiciones, unidadesCombo);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el combo al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        } else if (ventanaPrincipal.panelCombos.jRadioButtonHamburguesa.isSelected()) {
            precioTotalCombo += +preciosPaneles.get("Hamburguesa");
            controlPrincipal.crearCombo("Combo Personalizado", precioTotalCombo, precioTotalCombo,
                    tipoPanHamburguesa, tipoProteinaHamburguesa, "Hamburguesa", "La mejor hamburguesa al estilo FormFood", preciosPaneles.get("Hamburguesa"), preciosPuntosPaneles.get("Hamburguesa"), "Hamburguesa",
                    "Gaseosa", saborGaseosa, "Gaseosa", "Una Gaseosa para acompañar tu combo", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                    tipoPapa, terminoCoccionPapa, "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), "Papas",
                    tipoEspecieStrips, tipoCoccionStrips, "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPuntosPaneles.get("Strips"), "Strips",
                    agrandados, adiciones, unidadesCombo);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el combo al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        } else if (ventanaPrincipal.panelCombos.jRadioButtonWraps.isSelected()) {
            precioTotalCombo += preciosPaneles.get("Wraps");
            controlPrincipal.crearCombo("Combo Personalizado", precioTotalCombo, precioTotalCombo,
                    tipoQuesoWraps, tipoProteinaWraps, "Wraps", "Los mejores wraps al estilo FormFood", preciosPaneles.get("Wraps"), preciosPuntosPaneles.get("Wraps"), "Wrap",
                    "Gaseosa", saborGaseosa, "Gaseosa", "Una Gaseosa para acompañar tu combo", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                    tipoPapa, terminoCoccionPapa, "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), "Papas",
                    tipoEspecieStrips, tipoCoccionStrips, "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPuntosPaneles.get("Strips"), "Strips",
                    agrandados, adiciones, unidadesCombo);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el combo al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        } else {
            ventanaPrincipal.mostrarMensajeError("No se ha seleccionado nada de producto principal");
        }

    }

    /**
     * Se encarga de obtener los valores y datos del para Compartir para
     * pasarselos al controlPrincipal
     */
    public void cargarParaCompartir() {
        if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir1.getValue() == 0 && (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir2.getValue() == 0 && (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir3.getValue() == 0 && (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir4.getValue() == 0 && (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir5.getValue() == 0) {
            ventanaPrincipal.mostrarMensajeError("No se ha podido añadir al carrito porque no hay ningun producto seleccionado");
        } else {
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir1.getValue() != 0) {
                controlPrincipal.crearParaCompartir3("Para Compartir #1", preciosPaneles.get("ParaCompartir1"), preciosPuntosPaneles.get("ParaCompartir1"),
                        "Integral", "Carne", "Hamburguesa", "La mejor hamburguesa al estilo FormFood", preciosPaneles.get("Hamburguesa"), preciosPuntosPaneles.get("Hamburguesa"), "Hamburguesa",
                        "Francesa", "Crocantes", "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), "Papas",
                        "Gaseosa", "Cola", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir1.getValue(), 2, 2, 2);
            }
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir2.getValue() != 0) {
                controlPrincipal.crearParaCompartir3("Para Compartir #2", preciosPaneles.get("ParaCompartir2"), preciosPuntosPaneles.get("ParaCompartir2"),
                        "Blanco", "Chedar", "Wrap", "Los mejores wraps al estilo FormFood", preciosPaneles.get("Wraps"), preciosPuntosPaneles.get("Wraps"), "Wrap",
                        "Pollo", "Original", "Nugget", "Los mejores nuggets al estilo FormFood", preciosPaneles.get("Nuggets"), preciosPuntosPaneles.get("Nuggets"), "Nugget",
                        "Jugo", "Naranja", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir2.getValue(), 2, 6, 2);
            }
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir3.getValue() != 0) {
                controlPrincipal.crearParaCompartir3("Para Compartir #3", preciosPaneles.get("ParaCompartir3"), preciosPuntosPaneles.get("ParaCompartir3"),
                        "Pechuga", "Crispy", "Presa pollo", "Pechuga de Pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"), preciosPuntosPaneles.get("Pechuga"), "PresaPollo",
                        "Francesa", "Crocantes", "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), "Papas",
                        "Gaseosa", "Limon", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir3.getValue(), 2, 2, 2);
            }
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir4.getValue() != 0) {
                controlPrincipal.crearParaCompartir4("Para Compartir #4", preciosPaneles.get("ParaCompartir3"), preciosPuntosPaneles.get("ParaCompartir3"),
                        "Blanco", "Chedar", "Wrap", "Los mejores wraps al estilo FormFood", preciosPaneles.get("Wraps"), preciosPuntosPaneles.get("Wraps"), "Wrap",
                        "Pollo", "Original", "Nugget", "Los mejores nuggets al estilo FormFood", preciosPaneles.get("Nuggets"), preciosPuntosPaneles.get("Nuggets"), "Nugget",
                        "Pechuga", "Crispy", "Presa pollo", "Pechuga de Pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"), preciosPuntosPaneles.get("Pechuga"), "PresaPollo",
                        "Gaseosa", "Cola", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir4.getValue(), 1, 6, 1, 2);
            }
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir5.getValue() != 0) {
                controlPrincipal.crearParaCompartir4("Para Compartir #5", preciosPaneles.get("ParaCompartir3"), preciosPuntosPaneles.get("ParaCompartir3"),
                        "Integral", "Carne", "Hamburguesa", "La mejor hamburguesa al estilo FormFood", preciosPaneles.get("Hamburguesa"), preciosPuntosPaneles.get("Hamburguesa"), "Hamburguesa",
                        "Sal limon", "Original", "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPuntosPaneles.get("Strips"), "Strips",
                        "Francesa", "Crocantes", "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), "Papas",
                        "Gaseosa", "Uva", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir5.getValue(), 1, 3, 1, 2);
            }
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el para compartir al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        }
    }

    /**
     * Se encarga de obtener los valores y datos del producto para pasarselos al
     * controlPrincipal
     */
    public void cargarUnidad() {
        int unidadesAla = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesAla.getValue();
        int unidadesPechuga = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesPechuga.getValue();
        int unidadesPierna = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesPierna.getValue();
        int unidadesCuadrito = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesCuadrito.getValue();
        int unidadesBebida = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesBebida.getValue();
        int unidadesStrips = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesStrips.getValue();
        int unidadesNuggets = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesNuggets.getValue();
        int unidadesHamburguesa = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesHamburguesa.getValue();
        int unidadesWraps = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesWraps.getValue();
        int unidadesPapas = (int) ventanaPrincipal.panelOtrosProductos.jSpinnerUnidadesPapas.getValue();

        String coccionAla = (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionAla.getSelectedItem();
        String coccionPechuga = (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionPechuga.getSelectedItem();
        String coccionPierna = (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionPierna.getSelectedItem();
        String coccionCuadrito = (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionCuadrito.getSelectedItem();
        String tipoBebida = (String) ventanaPrincipal.panelOtrosProductos.jComboBoxTipoBebida.getSelectedItem();

        if (unidadesAla == 0 && unidadesPechuga == 0 && unidadesPierna == 0 && unidadesCuadrito == 0 && unidadesBebida == 0 && unidadesStrips == 0 && unidadesNuggets == 0 && unidadesHamburguesa == 0 && unidadesWraps == 0 && unidadesPapas == 0) {
            ventanaPrincipal.mostrarMensajeError("No se ha podido añadir al carrito porque no hay ningun producto seleccionado");
        } else {
            if (unidadesAla != 0) {
                controlPrincipal.crearUnidad("Ala de Pollo", preciosPaneles.get("Ala"), preciosPuntosPaneles.get("Ala"), "Ala de Pollo", coccionAla,
                        "Ala de pollo", "Ala de pollo apanada al estilo FormFood", preciosPaneles.get("Ala"), preciosPuntosPaneles.get("Ala"), "PresaPollo", unidadesAla);
            }
            if (unidadesPechuga != 0) {
                controlPrincipal.crearUnidad("Pechuga de Pollo", preciosPaneles.get("Pechuga"), preciosPuntosPaneles.get("Pechuga"), "Pechuga de Pollo", coccionPierna,
                        "Pechuga de pollo", "Pechuga de pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"), preciosPuntosPaneles.get("Pechuga"), "PresaPollo", unidadesPechuga);
            }
            if (unidadesPierna != 0) {
                controlPrincipal.crearUnidad("Pierna", preciosPaneles.get("Pierna"), preciosPuntosPaneles.get("Pierna"), "Pierna de Pollo", coccionPechuga, 
                        "Pierna de pollo", "Pierna de pollo apanada al estilo FormFood", preciosPaneles.get("Pierna"), preciosPuntosPaneles.get("Pierna"), "PresaPollo", unidadesPierna);
            }
            if (unidadesStrips != 0) {
                controlPrincipal.crearUnidad("Strips", preciosPaneles.get("Strips"), preciosPuntosPaneles.get("Strips"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxEspecieStrips.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionStrips.getSelectedItem(), 
                        "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPuntosPaneles.get("Strips"), "Strips", unidadesStrips);
            }
            if (unidadesWraps != 0) {
                controlPrincipal.crearUnidad("Wraps", preciosPaneles.get("Wraps"), preciosPuntosPaneles.get("Wraps"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxProteinaWraps.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxQuesoWraps.getSelectedItem(), 
                        "Wraps", "Los mejores wraps al estilo FormFood", preciosPaneles.get("Wraps"), preciosPuntosPaneles.get("Wraps"), "Wrap", unidadesWraps);
            }
            if (unidadesBebida != 0) {
                if (tipoBebida.equalsIgnoreCase("Gaseosa")) {
                    controlPrincipal.crearUnidad("Bebida", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Gaseosa", (String) ventanaPrincipal.panelOtrosProductos.jComboBoxSaborGaseosa.getSelectedItem(), 
                            "Gaseosa", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida", unidadesBebida);
                }
                if (tipoBebida.equalsIgnoreCase("Jugo")) {
                    controlPrincipal.crearUnidad("Bebida", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Jugo", (String) ventanaPrincipal.panelOtrosProductos.jComboBoxSaborJugo.getSelectedItem(), 
                            "Jugo", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida", unidadesBebida);
                }
                if (tipoBebida.equalsIgnoreCase("Agua")) {
                    controlPrincipal.crearUnidad("Bebida", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Agua", "Insabora", 
                            "Agua", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPuntosPaneles.get("Bebida"), "Bebida", unidadesBebida);
                }
            }
            if (unidadesCuadrito != 0) {
                controlPrincipal.crearUnidad("Cuadrito", preciosPaneles.get("Cuadrito"), preciosPuntosPaneles.get("Cuadrito"), "Cuadrito", coccionCuadrito, 
                        "Cuadrito", "Cuadrito de pollo apanado al estilo FormFood", preciosPaneles.get("Cuadrito"), preciosPuntosPaneles.get("Cuadrito"), "PresaPollo", unidadesCuadrito);
            }
            if (unidadesHamburguesa != 0) {
                controlPrincipal.crearUnidad("Hamburguesa", preciosPaneles.get("Hamburguesa"), preciosPuntosPaneles.get("Hamburguesa"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxPanHamburguesa.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxProteinaHamburguesa.getSelectedItem(),
                        "Hamburguesa", "La mejor hamburguesa al estilo FormFood", preciosPaneles.get("Hamburguesa"), preciosPuntosPaneles.get("Hamburguesa"), "Hamburguesa", unidadesHamburguesa);
            }
            if (unidadesNuggets != 0) {
                controlPrincipal.crearUnidad("Nuggets", preciosPaneles.get("Nuggets"), preciosPuntosPaneles.get("Nuggets"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxTipoNuggets.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionNuggets.getSelectedItem(),
                        "Nuggets", "Los mejores nuggets al estilo FormFood", preciosPaneles.get("Nuggets"), preciosPuntosPaneles.get("Nuggets"), "Nugget", unidadesNuggets);
            }
            if (unidadesPapas != 0) {
                controlPrincipal.crearUnidad("Papas", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxTipoPapas.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionPapas.getSelectedItem(),
                        "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPuntosPaneles.get("Papas"), "Papas", unidadesPapas);
            }
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el o los productos pedidos");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        }
    }

    /**
     * Se encarga de calcular el precio del combo
     */
    private void calcularPrecioCombo() {
        int cantidadAdiciones = 0;
        if (ventanaPrincipal.panelCombos.jCheckBoxQuesoAdicion.isSelected()) {
            cantidadAdiciones++;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxSalsaPicanteAdicion.isSelected()) {
            cantidadAdiciones++;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxChipsAdicion.isSelected()) {
            cantidadAdiciones++;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxArrozAdicion.isSelected()) {
            cantidadAdiciones++;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxTocinoAdicion.isSelected()) {
            cantidadAdiciones++;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxJalapeñosAdicion.isSelected()) {
            cantidadAdiciones++;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxSalsaBbqAdicion.isSelected()) {
            cantidadAdiciones++;
        }
        if (ventanaPrincipal.panelCombos.jCheckBoxSourCreamAdicion.isSelected()) {
            cantidadAdiciones++;
        }

        int cantidadAgrandados = 0;
        if (!"No".equals(ventanaPrincipal.panelCombos.jComboBoxAgrandadoGaseosa.getSelectedItem())) {
            cantidadAgrandados++;
        }
        if (!"No".equals(ventanaPrincipal.panelCombos.jComboBoxAgrandadoPapas.getSelectedItem())) {
            cantidadAgrandados++;
        }

        double total = preciosPaneles.get("Bebida") + preciosPaneles.get("Papas") + preciosPaneles.get("Strips");
        total += cantidadAdiciones * 5000;
        total += cantidadAgrandados * 7000;

        if (ventanaPrincipal.panelCombos.jRadioButtonPresa.isSelected()) {
            total += preciosPaneles.get("Presa");
        } else if (ventanaPrincipal.panelCombos.jRadioButtonNuggets.isSelected()) {
            total += preciosPaneles.get("Nuggets");
        } else if (ventanaPrincipal.panelCombos.jRadioButtonHamburguesa.isSelected()) {
            total += preciosPaneles.get("Hamburguesa");
        } else if (ventanaPrincipal.panelCombos.jRadioButtonWraps.isSelected()) {
            total += preciosPaneles.get("Wraps");
        }

        ventanaPrincipal.panelCombos.jTextFieldPrecioTotalCombo.setText("$ " + total);
        ventanaPrincipal.panelCombos.jTextFieldPrecioTotalComboPuntos.setText("" + total / 1000);
    }

    /**
     * Se encarga de actualizar el precio del combo
     */
    public void actualizarPrecioTotalCombo() {
        ChangeListener listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                calcularPrecioCombo();
            }
        };

        ActionListener comboBoxListenerCombo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPrecioCombo();
            }
        };

        // Añadir ChangeListeners a los RadioButtons y CheckBoxes
        ventanaPrincipal.panelCombos.jRadioButtonHamburguesa.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jRadioButtonNuggets.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jRadioButtonPresa.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jRadioButtonWraps.addChangeListener(listener);

        ventanaPrincipal.panelCombos.jCheckBoxArrozAdicion.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jCheckBoxChipsAdicion.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jCheckBoxJalapeñosAdicion.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jCheckBoxQuesoAdicion.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jCheckBoxSalsaBbqAdicion.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jCheckBoxSalsaPicanteAdicion.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jCheckBoxSourCreamAdicion.addChangeListener(listener);
        ventanaPrincipal.panelCombos.jCheckBoxTocinoAdicion.addChangeListener(listener);

        // Los JComboBox necesitan ActionListener
        ventanaPrincipal.panelCombos.jComboBoxAgrandadoGaseosa.addActionListener(comboBoxListenerCombo);
        ventanaPrincipal.panelCombos.jComboBoxAgrandadoPapas.addActionListener(comboBoxListenerCombo);
    }

    public void actualizarBebidaPanelOtrosProductos() {
        ventanaPrincipal.panelOtrosProductos.jLabelSaborJugo.setVisible(true);
        ventanaPrincipal.panelOtrosProductos.jComboBoxSaborJugo.setVisible(true);
        ventanaPrincipal.panelOtrosProductos.jLabelSaborGaseosa.setVisible(false);
        ventanaPrincipal.panelOtrosProductos.jComboBoxSaborGaseosa.setVisible(false);

        ActionListener comboBoxListenerOtrosProductos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoBebida = (String) ventanaPrincipal.panelOtrosProductos.jComboBoxTipoBebida.getSelectedItem();
                if ("Jugo".equals(tipoBebida)) {
                    ventanaPrincipal.panelOtrosProductos.jLabelSaborJugo.setVisible(true);
                    ventanaPrincipal.panelOtrosProductos.jComboBoxSaborJugo.setVisible(true);
                    ventanaPrincipal.panelOtrosProductos.jLabelSaborGaseosa.setVisible(false);
                    ventanaPrincipal.panelOtrosProductos.jComboBoxSaborGaseosa.setVisible(false);
                } else if ("Gaseosa".equals(tipoBebida)) {
                    ventanaPrincipal.panelOtrosProductos.jLabelSaborJugo.setVisible(false);
                    ventanaPrincipal.panelOtrosProductos.jComboBoxSaborJugo.setVisible(false);
                    ventanaPrincipal.panelOtrosProductos.jLabelSaborGaseosa.setVisible(true);
                    ventanaPrincipal.panelOtrosProductos.jComboBoxSaborGaseosa.setVisible(true);
                } else if ("Agua".equals(tipoBebida)) {
                    ventanaPrincipal.panelOtrosProductos.jLabelSaborJugo.setVisible(false);
                    ventanaPrincipal.panelOtrosProductos.jComboBoxSaborJugo.setVisible(false);
                    ventanaPrincipal.panelOtrosProductos.jLabelSaborGaseosa.setVisible(false);
                    ventanaPrincipal.panelOtrosProductos.jComboBoxSaborGaseosa.setVisible(false);
                }
            }
        };

        ventanaPrincipal.panelOtrosProductos.jComboBoxTipoBebida.addActionListener(comboBoxListenerOtrosProductos);
    }

    /**
     * Se encarga de ir actualizando el precio del bucket
     */
    public void actualizarPrecioTotalBucket() {
        // Método para actualizar el texto del JTextField de PrecioTotal del Bucket
        ChangeListener listenerToltalBucket = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int UnidadesAla = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesAla.getValue();
                int UnidadesPechuga = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesPechuga.getValue();
                int UnidadesPierna = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesPierna.getValue();
                int UnidadesCuadrito = (int) ventanaPrincipal.panelBuckets.jSpinnerUnidadesCuadrito.getValue();

                double TotalBucket = (preciosPaneles.get("Ala") * UnidadesAla) + (preciosPaneles.get("Pechuga") * UnidadesPechuga) + ((preciosPaneles.get("Pierna") * UnidadesPierna) + (preciosPaneles.get("Cuadrito") * UnidadesCuadrito));
                ventanaPrincipal.panelBuckets.jTextFieldPrecioTotalBucket.setText("$ " + TotalBucket);
                ventanaPrincipal.panelBuckets.jTextFieldPrecioTotalBucketPuntos.setText("" + TotalBucket / 1000);
            }
        };
        // Implementacion del metodo pasado
        ventanaPrincipal.panelBuckets.jSpinnerUnidadesAla.addChangeListener(listenerToltalBucket);
        ventanaPrincipal.panelBuckets.jSpinnerUnidadesCuadrito.addChangeListener(listenerToltalBucket);
        ventanaPrincipal.panelBuckets.jSpinnerUnidadesPechuga.addChangeListener(listenerToltalBucket);
        ventanaPrincipal.panelBuckets.jSpinnerUnidadesPierna.addChangeListener(listenerToltalBucket);
    }

    public void validarDescuento(String cedula) {
        double precioDePedido = controlPrincipal.getControlOpcionesMenu().getPrecioTotalPedido();
        try {
            double cedulaDouble = Double.parseDouble(cedula);
            boolean estadoMayorDeEdad = !this.controlPrincipal.getControlClientes().mayorEdad(cedulaDouble);
            boolean estadoIndigena = this.controlPrincipal.getControlClientes().tieneCultura(cedulaDouble);

            double precioDefinitivo;
            if (estadoMayorDeEdad) {
                precioDefinitivo = precioDePedido - (precioDePedido * 0.10);
                ventanaPrincipal.mostrarMensajeExito("Usted aplica para descuento de mayor de edad (10%). El costo ha pagar sera de " + precioDefinitivo);
                controlPrincipal.getControlOpcionesMenu().setPrecioTotalPedido(precioDefinitivo);
            } else if (estadoIndigena) {
                precioDefinitivo = precioDePedido - (precioDePedido * 0.08);
                ventanaPrincipal.mostrarMensajeExito("Usted aplica para descuento de Indigena (8%). El costo ha pagar sera de " + precioDefinitivo);
                controlPrincipal.getControlOpcionesMenu().setPrecioTotalPedido(precioDefinitivo);
            }

        } catch (NumberFormatException e) {
            ventanaPrincipal.mostrarMensajeError("No se ha digitado un valor correcto en el campo de cedula");
        }
    }

    public void validarPago(String cedula) {
        try {
            double cedulaDouble = Double.parseDouble(cedula);
            int opcion = ventanaPrincipal.preguntarMedioDePago();
            String metodoDePago;
            ventanaPrincipal.realizandoPago();
            double puntosObtenido = controlPrincipal.getControlOpcionesMenu().getPrecioTotalPedido() / 1000;
            switch (opcion) {
                case 0:
                    metodoDePago = "Tarjeta";
                    ventanaPrincipal.mostrarMensajeExito("Se ha generado su ticket");
                    String info1 = controlPrincipal.inicioSesionCliente(cedulaDouble, puntosObtenido, metodoDePago);
                    ventanaPrincipal.mostrarMensajeExito(info1);
                    break;
                case 1:
                    metodoDePago = "Efectivo";
                    ventanaPrincipal.mostrarMensajeExito("Se ha generado su ticket");
                    String info2 = controlPrincipal.inicioSesionCliente(cedulaDouble, puntosObtenido, metodoDePago);
                    ventanaPrincipal.mostrarMensajeExito(info2);
                    break;
                case 2:
                    metodoDePago = "Puntos";
                    String info3 = controlPrincipal.pagoPuntos(cedulaDouble, puntosObtenido, metodoDePago);
                    ventanaPrincipal.mostrarMensajeExito(info3);
                    if (info3.equalsIgnoreCase("No se puede realizar la transaccion por falta de puntos, pruebe otro metodo de pago")) {
                        validarPago(cedula);
                    }
                    break;
                default:
                    ventanaPrincipal.mostrarMensajeError("No se selecciono ninguna Opcion");
                    break;
            }
        } catch (NumberFormatException e) {
        }

    }

}
