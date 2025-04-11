package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Cliente;
import java.util.ArrayList;
import java.util.Random;

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

    public void crearCliente() {
        String[] nombres = {"Ana", "Luis", "Camila", "Andrés", "Mariana", "Juan", "Carlos", "Isabella", "Ricardo", "Valeria", "Santiago", "Laura", "Miguel", "Paula", "Gabriel", "Daniela", "Julián", "Natalia", "Sebastián", "Andrea"};
        int[] edades = {18, 20, 25, 30, 40, 45, 50, 60, 70, 75, 80, 90};
        String[] culturas = {"Wayuu", "Kogi", "Arhuaco", "Nasa", "Embera", "Wounaan", "Inga", "Zenú", "Sikuani", "U'wa", "Misak", "Ticuna"};
        Random random = new Random();
        String nombreSeleccionado = nombres[random.nextInt(nombres.length)];
        int edadSeleccionada = edades[random.nextInt(edades.length)];
        Cliente clienteNuevo;
        int valor = random.nextInt(2);
        if (valor == 1) {
            String culturaSeleccionada = culturas[random.nextInt(culturas.length)];
            clienteNuevo = new Cliente(0, nombreSeleccionado, edadSeleccionada, culturaSeleccionada, 0);
        } else {
            clienteNuevo = new Cliente(0, nombreSeleccionado, edadSeleccionada, 0);
        }
        clientes.add(clienteNuevo);
    }

    public String buscarCliente(double cedula, double puntos) {
        boolean clienteExistenteCedula = clienteExistenteCedula(cedula);
        if (clienteExistenteCedula == false) {
            for (Cliente cliente : clientes) {
                if (cliente.getCedula() == 0) {
                    ponerCedula(cedula, cliente);
                    return colocarPuntos(cliente, puntos);
                } else {
                    crearCliente();
                }
            }
        } else {
            Cliente cliente = clienteEncontrado(cedula);
            return colocarPuntos(cliente, puntos);
        }
        return null;
    }

    public Cliente clienteEncontrado(double cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                return cliente;
            }
        }
        return null;
    }

    public boolean clienteExistenteCedula(double cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                return true;
            }
        }
        return false;
    }

    public void ponerCedula(double cedula, Cliente cliente) {
        cliente.setCedula(cedula);
    }

    public String colocarPuntos(Cliente cliente, double puntos) {
        double totalPuntos = puntos + cliente.getPuntos();
        String info = "Bienvenido de vuelta " + cliente.getNombre() + ", usted tenía un total de " + cliente.getPuntos() + " y ahora con su compra tiene " + totalPuntos;
        cliente.setPuntos(totalPuntos);
        return info;
    }

    public boolean tieneCultura(double cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCultura() != null){
                return true;
            }
        }
        return false;
    }
}
