package principal.daos;

import java.util.List;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import principal.modelos.Pedido;

public class PedidoDAO {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public PedidoDAO() {
		//Criacao/configuracao da persistencia
		emf = Persistence.createEntityManagerFactory("ex_mysql");
		em = emf.createEntityManager();
	}
	
	
	public  Integer salvar(Pedido p) {
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		return p.getId();
		
	}
	
	public  List<Pedido> listar(){
		
		List<Pedido> p = em.createQuery("From Pedido", Pedido.class).getResultList();
	
		return p;
		
	}
	
	public  Pedido buscarPorId(Integer id) {
		
		Pedido p = em.find(Pedido.class, id);
		
		return p;
		
	}
	
	public  Integer atualizar (Pedido p) {
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		
		return p.getId();
	}
	
	public  void excluir(Integer id) {
		
		excluir(buscarPorId(id));
		
	}
	
	public  void excluir(Pedido p) {
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
	}
	public void close() {
		em.close();
		emf.close();
	}

}
