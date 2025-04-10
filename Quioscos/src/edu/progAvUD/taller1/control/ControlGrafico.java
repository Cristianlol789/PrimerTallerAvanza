package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlGrafico implements ActionListener {
    
    private VentanaPrincipal ventanaPrincipal;
    private ControlPrincipal controlPrincipal;

    public ControlGrafico() {
        this.ventanaPrincipal = new VentanaPrincipal(this);
        this.controlPrincipal = new ControlPrincipal(this);
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInicial);
        
        ventanaPrincipal.panelInicial.jButtonSiguiente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ventanaPrincipal.panelInicial.jButtonSiguiente){
            
        }
    }
    
    
    
    
}
