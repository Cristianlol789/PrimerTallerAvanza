package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Cliente;
import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase se encarga de crear las clientes que van ha interactuar con el
 * quiosco ademas de cambiarle los puntos a estas clientes despues de realizar
 * una compra
 *
 * @author Cristianlol789
 */
public class ControlClientes {

    private ArrayList<Cliente> clientes;
    private ControlPrincipal controlPrincipal;

    /**
     * Este constructor nos sirve para crear un arreglo donde guardaremos los
     * clientes y ademas recibe la inyeccion de control principal
     *
     * @param controlPrincipal es el parametro que utilizaremos como referencia
     * para comunicarnos con el control principal
     */
    public ControlClientes(ControlPrincipal controlPrincipal) {
        this.clientes = new ArrayList<>();
        this.controlPrincipal = controlPrincipal;
        crearTresClientesPredeterminados();
        crearCliente();
    }

    /**
     * Se crean tres personas con atributos predeterminados
     */
    public void crearTresClientesPredeterminados() {
        // Cliente 1: Con cultura definida
        Cliente cliente1 = new Cliente(10123456, "Roberto García", 45, "Zenú", 30000);

        // Cliente 2: Sin cultura definida (usando el constructor sin parámetro de cultura)
        Cliente cliente2 = new Cliente(20234567, "María López", 32, 0);

        // Cliente 3: Con cultura definida
        Cliente cliente3 = new Cliente(30345678, "Elena Rodríguez", 58, "Nasa", 0);

        // Añadimos los clientes a la lista
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
    }

    /**
     * Este metodo se encarga de crear a la cliente con atributos aleatorios
     */
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

    /**
     * El siguiente metodo se encarga de buscar a una cliente mediante una
     * cedula, si la cliente ya existe le asigna los puntos nuevos mientras que
     * si no existe llama a otro metodo para que cree una cliente y le asigne
     * los puntos correspondientes
     *
     * @param cedula este parametro nos sirve como referencia para poder
     * localizar a la cliente que buscamos en el arreglo
     * @param puntosEquivalentes esta es la cantidad de puntos que se le debe
     * sumar a la cliente despues de realizar su compra
     * @return este retorno va hacia un JOptionPane para mostrarle a la cliente
     * que el proceso de logeo fue exitoso ademas le muestra la cantidad antigua
     * de puntos que tenia y la nueva suma que tiene ahora
     */
    public String buscarCliente(double cedula, double puntosEquivalentes) {
        boolean clienteExistenteCedula = clienteExistenteCedula(cedula);
        if (!clienteExistenteCedula) {
            for (Cliente cliente : clientes) {
                if (cliente.getCedula() == 0) {
                    ponerCedula(cedula, cliente);
                    return colocarPuntos(cliente, puntosEquivalentes);
                }
            }
            // Si no encontró ninguno con cédula 0, crea uno nuevo
            crearCliente();
            // Asigna cédula y puntos al último creado
            Cliente nuevo = clientes.get(clientes.size() - 1);
            ponerCedula(cedula, nuevo);
            return colocarPuntos(nuevo, puntosEquivalentes);
        } else {
            Cliente cliente = clienteEncontrado(cedula);
            return colocarPuntos(cliente, puntosEquivalentes);
        }
    }

    /**
     * El siguiente metodo busca un cliente por medio de la cedula y si existe
     * devuelve el cliente y si no lo devuelve como nulo, el objetivo de esto es
     * poder saber el cliente a quien debe asignarsele los puntos
     * correspondientes
     *
     * @param cedula este es el parametro que se usa como referencia para
     * encontrar un cliente en especifico ya que este es irrepetible
     * @return devuelve la cliente para poder asignarle los puntos
     */
    public Cliente clienteEncontrado(double cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Este metodo devuelve un true o un false con el objetivo de ver si ya
     * existe un cliente con la cedula recibida
     *
     * @param cedula es un parametro referenciador para localizar un cliete
     * @return devuelve un si existe o no existe alguien con esta cedula
     */
    public boolean clienteExistenteCedula(double cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                return true;
            }
        }
        return false;
    }

    /**
     * El metodo se encarga de asignar una cedula a un cliente ya existente
     *
     * @param cedula parametro que se busca cargar a un cliente
     * @param cliente persona que recibira un nuevo valor de cedula
     */
    public void ponerCedula(double cedula, Cliente cliente) {
        cliente.setCedula(cedula);
    }

    /**
     * Este metodo es el encarga de asignar el valor correspondiente de los
     * puntos a la persona para ello suma su antiguo puntaje con el nuevo que le
     * llega como parametro
     *
     * @param cliente es a quien se le asignaran los puntos
     * @param puntosEquivalentes este es el parametro que indica la cantidad de
     * puntos que obtuvo el cliente por su compra
     * @return un mensaje de exitoso y cuantos puntos se añadieron
     */
    public String colocarPuntos(Cliente cliente, double puntosEquivalentes) {
        double totalPuntos = puntosEquivalentes + cliente.getPuntos();
        String info = "Bienvenido " + cliente.getNombre() + ", usted tenía un total de " + cliente.getPuntos() + " y ahora con su compra tiene " + totalPuntos + " ademas su ticket ya se encuentra activo";
        cliente.setPuntos(totalPuntos);
        return info;
    }

    /**
     * Este metodo nos sirve para saber si la persona pertenece o no a una
     * cultura, esto se hace con el objetivo de poder saber si aplica o no para
     * un descuento
     *
     * @param cedula parametro identificador
     * @return retorna si pertenece o no a una cultura
     */
    public boolean tieneCultura(double cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                if (cliente.getCultura() != null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * El metodo se encarga de verificar si la persona que tiene esa cedula es o
     * no mayor de edad para aplicar a un descuento
     *
     * @param cedula parametro referenciador para la busqueda
     * @return retorna si es mayor o no de edad
     */
    public boolean mayorEdad(double cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getEdad() >= 50) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo es el encarga de asignar el valor correspondiente de los
     * puntos a el cliente para ello resta el valor gasto con lo que tenia antes
     *
     * @param cedula variable de referencia
     * @param puntosEquivalentes este es el parametro que indica la cantidad de
     * puntos que obtuvo el cliente por su compra
     * @return un string dando informacion de la transaccion
     */
    public String pagarPuntos(double cedula, double puntosEquivalentes) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                if (puntosEquivalentes > cliente.getPuntos()) {
                    return "No se puede realizar la transaccion por falta de puntos";
                } else {
                    double totalPuntos = cliente.getPuntos() - puntosEquivalentes;
                    String info = "Se realizo la compra con puntos, usted tenia " + cliente.getPuntos() + " ahora tiene un total de " + totalPuntos + " ademas su ticket ya se encuentra activo";
                    cliente.setPuntos(totalPuntos);
                    return info;
                }
            }
        }
        return "";
    }
}
