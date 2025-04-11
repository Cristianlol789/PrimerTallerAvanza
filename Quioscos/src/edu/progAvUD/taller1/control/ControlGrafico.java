package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlGrafico implements ActionListener {

    private VentanaPrincipal ventanaPrincipal;
    private ControlPrincipal controlPrincipal;

    public ControlGrafico(ControlPrincipal controlPrincipal) {
        this.ventanaPrincipal = new VentanaPrincipal(this);
        this.controlPrincipal = controlPrincipal;
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInicial);

        ventanaPrincipal.panelInicial.jButtonSiguiente.addActionListener(this);

        ventanaPrincipal.jMenuItemCrearCombo.addActionListener(this);
        ventanaPrincipal.jMenuItemCrearBucket.addActionListener(this);
        ventanaPrincipal.jMenuItemMasProductos.addActionListener(this);
        ventanaPrincipal.jMenuItemPagar.addActionListener(this);
        ventanaPrincipal.jMenuItemParaCompartir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaPrincipal.panelInicial.jButtonSiguiente) {
            if (ventanaPrincipal.panelInicial.jRadioButtonComerAqui.isSelected()) {
                ventanaPrincipal.jMenuBar1.setVisible(true);
                ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelBuckets);
            } else {
                ventanaPrincipal.mostrarMensajeError("Seccion en desarrollo. Gracias por su paciencia");
            }
        }

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
    }

}
