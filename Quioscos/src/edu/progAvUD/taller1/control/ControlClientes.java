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
    }

    public String crearCliente(double cedula, double puntos) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                double puntosIniciales = cliente.getPuntos();
                double totalPuntos = puntosIniciales + puntos;
                cliente.setPuntos(totalPuntos);
                return "Bienvenido " + cliente.getNombre() + ". Esperamos que disfrute su comida. Los puntos obtenidos por su compra fueron " + puntos + " y su total actual de puntos es " + cliente.getPuntos();
            }
        }
        String[] nombres = {"Ana", "Luis", "Camila", "Andrés", "Mariana", "Juan", "Carlos", "Isabella",
            "Ricardo", "Valeria", "Santiago", "Laura", "Miguel", "Paula", "Gabriel",
            "Daniela", "Julián", "Natalia", "Sebastián", "Andrea"};
        int[] edades = {18, 20, 25, 30, 40, 45, 50, 60, 70, 75, 80, 90};
        String[] culturas = {"Wayuu", "Kogi", "Arhuaco", "Nasa", "Embera", "Wounaan", "Inga",
            "Zenú", "Sikuani", "U'wa", "Misak", "Ticuna"};
        Random random = new Random();
        String nombreSeleccionado = nombres[random.nextInt(nombres.length)];
        int edadSeleccionada = edades[random.nextInt(edades.length)];
        Cliente clienteNuevo;
        int valor = random.nextInt(2);  
        if (valor == 1) {
            String culturaSeleccionada = culturas[random.nextInt(culturas.length)];
            clienteNuevo = new Cliente(cedula, nombreSeleccionado, edadSeleccionada, culturaSeleccionada, puntos);
        } else {
            clienteNuevo = new Cliente(cedula, nombreSeleccionado, edadSeleccionada, puntos);
        }
        clientes.add(clienteNuevo);  
        return "Bienvenido " + clienteNuevo.getNombre() + ". Gracias por registrarse. Los puntos obtenidos por su compra fueron " + puntos + " y su total actual de puntos es " + clienteNuevo.getPuntos();
    }
}
