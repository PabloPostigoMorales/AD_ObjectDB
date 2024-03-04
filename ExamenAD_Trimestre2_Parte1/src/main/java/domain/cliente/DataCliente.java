package domain.cliente;

import java.util.ArrayList;
import java.util.List;

public class DataCliente {
    public static List<Cliente> clientes(){
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente("Juan"));
        listaClientes.add(new Cliente("Pablo","inactivo"));
        listaClientes.add(new Cliente("Antonio",5L));
        listaClientes.add(new Cliente("Juan Alberto",100L,"inactivo"));
        listaClientes.add(new Cliente("Maria",40L,"activo"));

        return listaClientes;
    }
}
