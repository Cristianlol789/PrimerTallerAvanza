package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JCheckBox;
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
        ventanaPrincipal.panelCombos.jButtonAgregarPedidoCombo.addActionListener(this);
        ventanaPrincipal.panelParaCompartir.jButtonAgragarPedidoCompartir.addActionListener(this);
        ventanaPrincipal.panelOtrosProductos.jButtonAgragarPedidoProducto.addActionListener(this);

        actualizarPrecioTotalBucket();
        actualizarPrecioTotalCombo();

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
                ventanaPrincipal.getContentPane().removeAll();
                ventanaPrincipal.repaint();
                ventanaPrincipal.revalidate();
                ventanaPrincipal.jMenuPagar.setVisible(false);
            } else if(ventanaPrincipal.panelInicial.jRadioButtonLlevar.isSelected()) {
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
            ventanaPrincipal.panelPagar.CargarDatosPedido(controlPrincipal.enviarDatosTablaPedido());
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
        } else if ((unidadesAla + unidadesPechuga + unidadesPierna + unidadesCuadrito) == 0) {
            ventanaPrincipal.mostrarMensajeError("No se ha podido añadir al carrito porque no hay ningun producto seleccionado");
        } else {
            controlPrincipal.crearBucket("Bucket Personal", totalBucket, totalBucket,
                    "Ala", coccionAla, "Presa de pollo", "Ala de Pollo apanada al estilo FormFood", preciosPaneles.get("Ala"), preciosPaneles.get("Ala"), "presaPollo", unidadesAla,
                    "Pierna", coccionPierna, "Presa de pollo", "Pierna de Pollo apanada al estilo FormFood", preciosPaneles.get("Pierna"), preciosPaneles.get("Pierna"), unidadesPierna,
                    "Cuadrito", coccionCuadrito, "Presa de pollo", "Cuadrito de Pollo apanado al estilo FormFood", preciosPaneles.get("Cuadrito"), preciosPaneles.get("Cuadrito"), unidadesCuadrito,
                    "Pechuga", coccionPechuga, "Presa de pollo", "Pechuga de Pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"), preciosPaneles.get("Pechuga"), unidadesPechuga,
                    unidadesBucket);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el bucket al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        }
    }

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
                    partePollo, tipoCoccionPollo, "Presa Pollo", "Una presa de Pollo al estilo FormFood", preciosPaneles.get("Presa"), preciosPaneles.get("Presa"), "PresaPollo",
                    "Gaseosa", saborGaseosa, "Gaseosa", "Una Gaseosa para acompañar tu combo", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                    tipoPapa, terminoCoccionPapa, "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), "Papas",
                    tipoEspecieStrips, tipoCoccionStrips, "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPaneles.get("Strips"), "Strips",
                    agrandados, adiciones, unidadesCombo);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el combo al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        } else if (ventanaPrincipal.panelCombos.jRadioButtonNuggets.isSelected()) {
            precioTotalCombo += preciosPaneles.get("Nuggets");
            controlPrincipal.crearCombo("Combo Personalizado", precioTotalCombo, precioTotalCombo,
                    tipoNuggets, tipoCoccionNuggets, "Nuggets", "Los mejores Nuggets al estilo FormFood", preciosPaneles.get("Nuggets"), preciosPaneles.get("Nuggets"), "Nugget",
                    "Gaseosa", saborGaseosa, "Gaseosa", "Una Gaseosa para acompañar tu combo", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                    tipoPapa, terminoCoccionPapa, "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), "Papas",
                    tipoEspecieStrips, tipoCoccionStrips, "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPaneles.get("Strips"), "Strips",
                    agrandados, adiciones, unidadesCombo);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el combo al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        } else if (ventanaPrincipal.panelCombos.jRadioButtonHamburguesa.isSelected()) {
            precioTotalCombo += +preciosPaneles.get("Hamburguesa");
            controlPrincipal.crearCombo("Combo Personalizado", precioTotalCombo, precioTotalCombo,
                    tipoPanHamburguesa, tipoProteinaHamburguesa, "Hamburguesa", "La mejor hamburguesa al estilo FormFood", preciosPaneles.get("Hamburguesa"), preciosPaneles.get("Hamburguesa"), "Hamburguesa",
                    "Gaseosa", saborGaseosa, "Gaseosa", "Una Gaseosa para acompañar tu combo", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                    tipoPapa, terminoCoccionPapa, "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), "Papas",
                    tipoEspecieStrips, tipoCoccionStrips, "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPaneles.get("Strips"), "Strips",
                    agrandados, adiciones, unidadesCombo);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el combo al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        } else if (ventanaPrincipal.panelCombos.jRadioButtonWraps.isSelected()) {
            precioTotalCombo += preciosPaneles.get("Wraps");
            controlPrincipal.crearCombo("Combo Personalizado", precioTotalCombo, precioTotalCombo,
                    tipoQuesoWraps, tipoProteinaWraps, "Wraps", "Los mejores wraps al estilo FormFood", preciosPaneles.get("Wraps"), preciosPaneles.get("Wraps"), "Wrap",
                    "Gaseosa", saborGaseosa, "Gaseosa", "Una Gaseosa para acompañar tu combo", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                    tipoPapa, terminoCoccionPapa, "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), "Papas",
                    tipoEspecieStrips, tipoCoccionStrips, "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPaneles.get("Strips"), "Strips",
                    agrandados, adiciones, unidadesCombo);
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el combo al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        } else {
            ventanaPrincipal.mostrarMensajeError("No se ha seleccionado nada de producto principal");
        }

    }

    public void cargarParaCompartir() {
        if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir1.getValue() == 0 && (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir2.getValue() == 0 && (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir3.getValue() == 0 && (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir4.getValue() == 0 && (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir5.getValue() == 0) {
            ventanaPrincipal.mostrarMensajeError("No se ha podido añadir al carrito porque no hay ningun producto seleccionado");
        } else {
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir1.getValue() != 0) {
                controlPrincipal.crearParaCompartir3("Para Compartir #1", preciosPaneles.get("ParaCompartir1"), preciosPaneles.get("ParaCompartir1"),
                        "Integral", "Carne", "Hamburguesa", "La mejor hamburguesa al estilo FormFood", preciosPaneles.get("Hamburguesa"), preciosPaneles.get("Hamburguesa"), "Hamburguesa",
                        "Francesa", "Crocantes", "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), "Papas",
                        "Gaseosa", "Cola", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir1.getValue(), 2, 2, 2);
            }
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir2.getValue() != 0) {
                controlPrincipal.crearParaCompartir3("Para Compartir #2", preciosPaneles.get("ParaCompartir2"), preciosPaneles.get("ParaCompartir2"),
                        "Blanco", "Chedar", "Wrap", "Los mejores wraps al estilo FormFood", preciosPaneles.get("Wraps"), preciosPaneles.get("Wraps"), "Wrap",
                        "Pollo", "Original", "Nugget", "Los mejores nuggets al estilo FormFood", preciosPaneles.get("Nuggets"), preciosPaneles.get("Nuggets"), "Nugget",
                        "Jugo", "Naranja", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir2.getValue(), 2, 6, 2);
            }
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir3.getValue() != 0) {
                controlPrincipal.crearParaCompartir3("Para Compartir #3", preciosPaneles.get("ParaCompartir3"), preciosPaneles.get("ParaCompartir3"),
                        "Pechuga", "Crispy", "Presa pollo", "Pechuga de Pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"), preciosPaneles.get("Pechuga"), "PresaPollo",
                        "Francesa", "Crocantes", "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), "Papas",
                        "Gaseosa", "Limon", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir3.getValue(), 2, 2, 2);
            }
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir4.getValue() != 0) {
                controlPrincipal.crearParaCompartir4("Para Compartir #4", preciosPaneles.get("ParaCompartir3"), preciosPaneles.get("ParaCompartir3"),
                        "Blanco", "Chedar", "Wrap", "Los mejores wraps al estilo FormFood", preciosPaneles.get("Wraps"), preciosPaneles.get("Wraps"), "Wrap",
                        "Pollo", "Original", "Nugget", "Los mejores nuggets al estilo FormFood", preciosPaneles.get("Nuggets"), preciosPaneles.get("Nuggets"), "Nugget",
                        "Pechuga", "Crispy", "Presa pollo", "Pechuga de Pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"), preciosPaneles.get("Pechuga"), "PresaPollo",
                        "Gaseosa", "Cola", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir4.getValue(), 1, 6, 1, 2);
            }
            if ((int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir5.getValue() != 0) {
                controlPrincipal.crearParaCompartir4("Para Compartir #5", preciosPaneles.get("ParaCompartir3"), preciosPaneles.get("ParaCompartir3"),
                        "Integral", "Carne", "Hamburguesa", "La mejor hamburguesa al estilo FormFood", preciosPaneles.get("Hamburguesa"), preciosPaneles.get("Hamburguesa"), "Hamburguesa",
                        "Sal limon", "Original", "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPaneles.get("Strips"), "Strips",
                        "Francesa", "Crocantes", "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), "Papas",
                        "Gaseosa", "Uva", "Bebida", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida",
                        (int) ventanaPrincipal.panelParaCompartir.jSpinnerUnidadesCompartir5.getValue(), 1, 3, 1, 2);
            }
            ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el para compartir al pedido");
            ventanaPrincipal.jMenuPagar.setVisible(true);
        }
    }

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
                controlPrincipal.crearUnidad("Ala de Pollo", preciosPaneles.get("Ala"), preciosPaneles.get("Ala"), "Ala de Pollo", coccionAla, "Ala de pollo", "Ala de pollo apanada al estilo FormFood", preciosPaneles.get("Ala"), preciosPaneles.get("Ala"), "PresaPollo", unidadesAla);
            }
            if (unidadesBebida != 0) {
                if (tipoBebida.equalsIgnoreCase("Gaseosa")) {
                    controlPrincipal.crearUnidad("Bebida", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Gaseosa", (String) ventanaPrincipal.panelOtrosProductos.jComboBoxSaborGaseosa.getSelectedItem(), "Gaseosa", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida", unidadesBebida);
                }
                if (tipoBebida.equalsIgnoreCase("Jugo")) {
                    controlPrincipal.crearUnidad("Bebida", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Jugo", (String) ventanaPrincipal.panelOtrosProductos.jComboBoxSaborJugo.getSelectedItem(), "Jugo", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida", unidadesBebida);
                }
                if (tipoBebida.equalsIgnoreCase("Agua")) {
                    controlPrincipal.crearUnidad("Bebida", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Agua", "Insabora", "Agua", "Una bebida para acompañar", preciosPaneles.get("Bebida"), preciosPaneles.get("Bebida"), "Bebida", unidadesBebida);
                }
            }
            if (unidadesCuadrito != 0) {
                controlPrincipal.crearUnidad("Cuadrito", preciosPaneles.get("Cuadrito"), preciosPaneles.get("Cuadrito"), "Cuadrito", coccionCuadrito, "Cuadrito", "Cuadrito de pollo apanado al estilo FormFood", preciosPaneles.get("Cuadrito"), preciosPaneles.get("Cuadrito"), "PresaPollo", unidadesCuadrito);
            }
            if (unidadesHamburguesa != 0) {
                controlPrincipal.crearUnidad("Hamburguesa", preciosPaneles.get("Hamburguesa"), preciosPaneles.get("Hamburguesa"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxPanHamburguesa.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxProteinaHamburguesa.getSelectedItem(), "Hamburguesa", "La mejor hamburguesa al estilo FormFood", preciosPaneles.get("Hamburguesa"), preciosPaneles.get("Hamburguesa"), "Hamburguesa", unidadesHamburguesa);
            }
            if (unidadesNuggets != 0) {
                controlPrincipal.crearUnidad("Nuggets", preciosPaneles.get("Nuggets"), preciosPaneles.get("Nuggets"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxTipoNuggets.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionNuggets.getSelectedItem(), "Nuggets", "Los mejores nuggets al estilo FormFood", preciosPaneles.get("Nuggets"), preciosPaneles.get("Nuggets"), "Nugget", unidadesNuggets);
            }
            if (unidadesPapas != 0) {
                controlPrincipal.crearUnidad("Papas", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxTipoPapas.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionPapas.getSelectedItem(), "Papas", "Unas papas para acompañar tu combo", preciosPaneles.get("Papas"), preciosPaneles.get("Papas"), "Papas", unidadesPapas);
                if (unidadesPechuga != 0) {
                    controlPrincipal.crearUnidad("Pechuga de Pollo", preciosPaneles.get("Pechuga"), preciosPaneles.get("Pechuga"), "Pechuga de Pollo", coccionPierna, "Pechuga de pollo", "Pechuga de pollo apanada al estilo FormFood", preciosPaneles.get("Pechuga"), preciosPaneles.get("Pechuga"), "PresaPollo", unidadesPechuga);
                }
                if (unidadesPierna != 0) {
                    controlPrincipal.crearUnidad("Pierna", preciosPaneles.get("Pierna"), preciosPaneles.get("Pierna"), "Pierna de Pollo", coccionPechuga, "Pierna de pollo", "Pierna de pollo apanada al estilo FormFood", preciosPaneles.get("Pierna"), preciosPaneles.get("Pierna"), "PresaPollo", unidadesPierna);
                }
                if (unidadesStrips != 0) {
                    controlPrincipal.crearUnidad("Strips", preciosPaneles.get("Strips"), preciosPaneles.get("Strips"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxEspecieStrips.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxCoccionStrips.getSelectedItem(), "Strips", "Unos strips para acompañar tu combo", preciosPaneles.get("Strips"), preciosPaneles.get("Strips"), "Strips", unidadesStrips);
                }
                if (unidadesWraps != 0) {
                    controlPrincipal.crearUnidad("Wraps", preciosPaneles.get("Wraps"), preciosPaneles.get("Wraps"), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxProteinaWraps.getSelectedItem(), (String) ventanaPrincipal.panelOtrosProductos.jComboBoxQuesoWraps.getSelectedItem(), "Wraps", "Los mejores wraps al estilo FormFood", preciosPaneles.get("Wraps"), preciosPaneles.get("Wraps"), "Wrap", unidadesWraps);
                }
                ventanaPrincipal.mostrarMensajeExito("Se ha añadido correctamente el o los productos pedidos");
                ventanaPrincipal.jMenuPagar.setVisible(true);
            }
        }
    }

    public void actualizarPrecioTotalCombo() {
        //Método para actualizar el texto del JTextField de PrecioTotal del Combo
        ChangeListener listenerToltalCombo = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int cantidadAdiciones = (int) Arrays.asList(
                        ventanaPrincipal.panelCombos.jCheckBoxQuesoAdicion,
                        ventanaPrincipal.panelCombos.jCheckBoxSalsaPicanteAdicion,
                        ventanaPrincipal.panelCombos.jCheckBoxChipsAdicion,
                        ventanaPrincipal.panelCombos.jCheckBoxArrozAdicion,
                        ventanaPrincipal.panelCombos.jCheckBoxTocinoAdicion,
                        ventanaPrincipal.panelCombos.jCheckBoxJalapeñosAdicion,
                        ventanaPrincipal.panelCombos.jCheckBoxSalsaBbqAdicion,
                        ventanaPrincipal.panelCombos.jCheckBoxSourCreamAdicion
                ).stream()
                        .filter(JCheckBox::isSelected)
                        .count();

                int cantidadAgrandados = 0;
                if (!"No".equals(ventanaPrincipal.panelCombos.jComboBoxAgrandadoGaseosa.getSelectedItem())) {
                    cantidadAgrandados++;
                }
                if (!"No".equals(ventanaPrincipal.panelCombos.jComboBoxAgrandadoPapas.getSelectedItem())) {
                    cantidadAgrandados++;
                }

                double TotalCombo = preciosPaneles.get("Bebida")
                        + preciosPaneles.get("Papas")
                        + preciosPaneles.get("Strips")
                        + (5000 * cantidadAdiciones)
                        + (2000 * cantidadAgrandados);

                if (ventanaPrincipal.panelCombos.jRadioButtonPresa.isSelected()) {
                    TotalCombo += preciosPaneles.get("Presa");
                } else if (ventanaPrincipal.panelCombos.jRadioButtonNuggets.isSelected()) {
                    TotalCombo += preciosPaneles.get("Nuggets");
                } else if (ventanaPrincipal.panelCombos.jRadioButtonHamburguesa.isSelected()) {
                    TotalCombo += preciosPaneles.get("Hamburguesa");
                } else if (ventanaPrincipal.panelCombos.jRadioButtonWraps.isSelected()) {
                    TotalCombo += preciosPaneles.get("Wraps");
                }

                ventanaPrincipal.panelCombos.jTextFieldPrecioTotalCombo.setText("$ " + TotalCombo);

            }
        };

        ventanaPrincipal.panelCombos.jRadioButtonHamburguesa.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jRadioButtonNuggets.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jRadioButtonPresa.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jRadioButtonWraps.addChangeListener(listenerToltalCombo);

        ventanaPrincipal.panelCombos.jCheckBoxArrozAdicion.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jCheckBoxChipsAdicion.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jCheckBoxJalapeñosAdicion.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jCheckBoxQuesoAdicion.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jCheckBoxSalsaBbqAdicion.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jCheckBoxSalsaPicanteAdicion.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jCheckBoxSourCreamAdicion.addChangeListener(listenerToltalCombo);
        ventanaPrincipal.panelCombos.jCheckBoxTocinoAdicion.addChangeListener(listenerToltalCombo);
    }
    
    public void actualizarPrecioTotalBucket(){
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
    }
}
