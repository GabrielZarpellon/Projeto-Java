package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import principal.modelos.Produto;


public class ProdutoDAO {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static Integer salvar(Produto p) {
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		return p.getId();
		
	}
	
	public static List<Produto> listar(){
		
		List<Produto> p = em.createQuery("From Produto", Produto.class).getResultList();
	
		return p;
		
	}
	
	public static Produto buscarPorId(Integer id) {
		
		Produto p = em.find(Produto.class, id);
		
		return p;
		
	}
	
	public static Integer atualizar (Produto p) {
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		
		return p.getId();
	}
	
	public static void excluir(Integer id) {
		
		excluir(buscarPorId(id));
		
	}
	
	public static void excluir(Produto p) {
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
	}

}
