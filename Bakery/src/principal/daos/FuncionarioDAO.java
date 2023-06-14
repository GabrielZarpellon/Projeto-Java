package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import principal.modelos.Funcionario;


public class FuncionarioDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public FuncionarioDAO() {
		//Criacao/configuracao da persistencia
		emf = Persistence.createEntityManagerFactory("ex_mysql");
		em = emf.createEntityManager();
	}
	
	public  Integer salvar(Funcionario f) {
		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		
		return f.getId();
		
	}
	
	public  List<Funcionario> listar(){
		
		List<Funcionario> f = em.createQuery("From Funcionario", Funcionario.class).getResultList();
	
		return f;
		
	}
	
	public  Funcionario buscarPorId(Integer id) {
		
		Funcionario f = em.find(Funcionario.class, id);
		
		return f;
		
	}
	
	public  Integer atualizar (Funcionario f) {
		
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
		
		return f.getId();
	}
	
	public  void excluir(Integer id) {
		
		excluir(buscarPorId(id));
		
	}
	
	public  void excluir(Funcionario f) {
		
		em.getTransaction().begin();
		em.remove(f);
		em.getTransaction().commit();
		
	}
	
	public void close() {
		em.close();
		emf.close();
	}

}
