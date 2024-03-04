package domain.cliente;

import domain.ObjectDBUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteDAO {

public Cliente insertarCliente(Cliente cliente){
    EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
    try {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

    }finally {
        em.close();
    }
    return cliente;
}
    public void saveAll(List<Cliente> clientes){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            em.getTransaction().begin();
            for(Cliente c : clientes){
                em.persist(c);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public Cliente getCliente(int id) {

        Cliente salida = null;
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            salida = em.find(Cliente.class, id);
        } finally {
            em.close();
        }
        return salida;
    }
    public void listarMejoresClientes(Long cantidad){
        List<Cliente> todosClientes = new ArrayList<>();
        List<Cliente> clientesAptos = new ArrayList<>();
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            TypedQuery<Cliente> query =em.createQuery("select c from Cliente c", Cliente.class);
            todosClientes = query.getResultList();
            for (Cliente cliente: todosClientes ){
                if (Objects.equals(cliente.getEstado(), "activo") && cliente.getTotalVentas()>=cantidad){
                    System.out.println(cliente);
                }
            }
        }finally {
            em.close();
        }
    }
    public Long totalVentas(){
        List<Cliente> todosClientes = new ArrayList<>();
        Long totVentas = 0L;

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            TypedQuery<Cliente> query =em.createQuery("select c from Cliente c", Cliente.class);
            todosClientes = query.getResultList();
            for (Cliente cliente : todosClientes){
                totVentas+=cliente.getTotalVentas();
            }
        }finally {
            em.close();
        }
        return totVentas;
    }

    public Long promedioVentas(){
        List<Cliente> todosClientes = new ArrayList<>();
        Long cantClientes = 0L;
        Long totVentas = 0L;

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            TypedQuery<Cliente> query =em.createQuery("select c from Cliente c", Cliente.class);
            todosClientes = query.getResultList();
            for (Cliente cliente : todosClientes){
                totVentas+=cliente.getTotalVentas();
                cantClientes++;
            }
        }finally {
            em.close();
        }
        return totVentas/cantClientes;
    }
    public Long inactivosConVentas(){
        List<Cliente> todosClientes = new ArrayList<>();
        Long clientesConMasDeCero = 0L;

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            TypedQuery<Cliente> query =em.createQuery("select c from Cliente c", Cliente.class);
            todosClientes = query.getResultList();
            for (Cliente cliente : todosClientes){
                if (Objects.equals(cliente.getEstado(), "inactivo") && cliente.getTotalVentas()>0){
                    clientesConMasDeCero++;
                }
            }
        }finally {
            em.close();
        }
        return clientesConMasDeCero;
    }
}
