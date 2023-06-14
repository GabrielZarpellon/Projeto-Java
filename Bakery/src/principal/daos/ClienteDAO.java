package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import principal.modelos.Cliente;


public class ClienteDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ClienteDAO() {
		//Criacao/configuracao da persistencia
		emf = Persistence.createEntityManagerFactory("ex_mysql");
		em = emf.createEntityManager();
	}
	
	public  Integer salvar(Cliente cliente) {
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		return cliente.getId();
		
	}
	
	public  List<Cliente> listar(){
		
		List<Cliente> clientes = em.createQuery("From Cliente", Cliente.class).getResultList();
	
		return clientes;
		
	}
	
	public  Cliente buscarPorId(Integer id) {
		
		Cliente cliente = em.find(Cliente.class, id);
		
		return cliente;
		
	}
	
	public  Integer atualizar (Cliente cliente) {
		
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		
		return cliente.getId();
	}
	
	public  void excluir(Integer id) {
		
		excluir(buscarPorId(id));
		
	}
	
	public  void excluir(Cliente cliente) {
		
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		
	}
	
	public void close() {
		em.close();
		emf.close();
	}

}
