package app;


import domain.cliente.Cliente;
import domain.cliente.ClienteDAO;
import domain.cliente.DataCliente;

public class App {
    public static void main(String[] args) {

        try{
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.saveAll(DataCliente.clientes());
        }catch (Exception e){

        }
        try{
            ClienteDAO clienteDAO = new ClienteDAO();

            System.out.println("Usando metodo insertarCliente para crear un nuevo cliente:\n");
            System.out.println("Cliente Creado: "+clienteDAO.insertarCliente(new Cliente("Josefa",100L,"activo")).getNombre());

            System.out.println("\n\nUsamos el metodo getCliente para comprobar que Josefa se ha creado correctamente:");
            System.out.println(clienteDAO.getCliente(6));

            System.out.println("\nListar mejores clientes: ");
            clienteDAO.listarMejoresClientes(10L);

            System.out.println("\nTotal ventas: "+clienteDAO.totalVentas());
            System.out.println("\nMedia de ventas: "+clienteDAO.promedioVentas());
            System.out.println("\nCantidad de clientes inactivos con más de 0 ventas: "+clienteDAO.inactivosConVentas());
        }catch (Exception e){

        }

    }
}