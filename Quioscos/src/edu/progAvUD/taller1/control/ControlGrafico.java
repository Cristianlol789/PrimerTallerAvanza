package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *Esta clase es la encargda de gestionar los actionListeners de la ventana y ademas de decir que se hara cada vez que pase algo en la ventana, ademas se comunica constantemente con la venta y el control principal para poder mandar o recibir informacion entre ellos
 * @author Cristianlol789
 */
public class ControlGrafico implements ActionListener {

    private VentanaPrincipal ventanaPrincipal;
    private ControlPrincipal controlPrincipal;
    private Timer tiempoInactividad;
    private final int retrasoTiempoInactividad = 120000;

    /**
     *Este es el constructor, se encarga de adicionar los action listeners y de manejar el tiempo de inactividad de una persona al ejecutarse el programa
     * @param controlPrincipal es el parametro que utilizaremos como referencia para comunicarnos con el control principal
     */
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

        tiempoInactividad = new Timer(retrasoTiempoInactividad, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInicial);
                ventanaPrincipal.jMenuBar1.setVisible(true);
            }
        });
        tiempoInactividad.setRepeats(false);
        tiempoInactividad.start();
    }

    /**
     *Este metodo se encarga de gestionar lo que pasa en la simulacion cuando una persona toca un boton o hace cualquier cosas en la ventana
     * @param e hace referencia a los objetos que son tocados o utilizados por el usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        tiempoInactividad.restart();
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
