package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import principal.modelos.Produto;


public class ProdutoDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProdutoDAO() {
		//Criacao/configuracao da persistencia
		emf = Persistence.createEntityManagerFactory("ex_mysql");
		em = emf.createEntityManager();
	}
	
	public  Integer salvar(Produto p) {
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		return p.getId();
		
	}
	
	public  List<Produto> listar(){
		
		List<Produto> p = em.createQuery("From Produto", Produto.class).getResultList();
	
		return p;
		
	}
	
	public  Produto buscarPorId(Integer id) {
		
		Produto p = em.find(Produto.class, id);
		
		return p;
		
	}
	
	public  Integer atualizar (Produto p) {
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		
		return p.getId();
	}
	
	public  void excluir(Integer id) {
		
		excluir(buscarPorId(id));
		
	}
	
	public  void excluir(Produto p) {
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
	}
	
	public void close() {
		em.close();
		emf.close();
	}

}
