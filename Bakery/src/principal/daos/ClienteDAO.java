package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import principal.modelos.Cliente;


public class ClienteDAO {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static Integer salvar(Cliente cliente) {
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		return cliente.getId();
		
	}
	
	public static List<Cliente> listar(){
		
		List<Cliente> clientes = em.createQuery("From Cliente", Cliente.class).getResultList();
	
		return clientes;
		
	}
	
	public static Cliente buscarPorId(Integer id) {
		
		Cliente cliente = em.find(Cliente.class, id);
		
		return cliente;
		
	}
	
	public static Integer atualizar (Cliente cliente) {
		
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		
		return cliente.getId();
	}
	
	public static void excluir(Integer id) {
		
		excluir(buscarPorId(id));
		
	}
	
	public static void excluir(Cliente cliente) {
		
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		
	}

}
