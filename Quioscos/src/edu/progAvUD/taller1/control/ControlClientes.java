
package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Cristianlol789
 */
public class ControlClientes {
    
    private ArrayList<Cliente> clientes;
    private ControlPrincipal controlPrincipal;

    public ControlClientes(ControlPrincipal controlPrincipal) {
        this.clientes = new ArrayList<>();
        this.controlPrincipal = controlPrincipal;
        crearCliente();
    }
    
    public void crearCliente(){
        Cliente cliente1 = new Cliente(1, "Carlos", 22, 0);
        Cliente cliente2 = new Cliente(2, "Juan", 20, "Wayuu", 0);
        Cliente cliente3 = new Cliente(3, "Andres", 80, 0);
        Cliente cliente4 = new Cliente(4, "Giovanni", 30, "Zenú", 0);
        Cliente cliente5 = new Cliente(5, "Nicolas", 70, 0);
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
    }
    
    public String buscarClienteExisten(int cedula){
        for (Cliente cliente : clientes){
            if (cliente.getCedula() == cedula){
                return "Existe";
            }
            else{
                return "No encontrado";
            }
        }
        return "No encontrado";
    }
}
