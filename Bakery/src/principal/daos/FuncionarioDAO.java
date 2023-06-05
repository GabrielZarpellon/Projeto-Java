package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import principal.modelos.Funcionario;


public class FuncionarioDAO {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static Integer salvar(Funcionario f) {
		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		
		return f.getId();
		
	}
	
	public static List<Funcionario> listar(){
		
		List<Funcionario> f = em.createQuery("From Funcionario", Funcionario.class).getResultList();
	
		return f;
		
	}
	
	public static Funcionario buscarPorId(Integer id) {
		
		Funcionario f = em.find(Funcionario.class, id);
		
		return f;
		
	}
	
	public static Integer atualizar (Funcionario f) {
		
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
		
		return f.getId();
	}
	
	public static void excluir(Integer id) {
		
		excluir(buscarPorId(id));
		
	}
	
	public static void excluir(Funcionario f) {
		
		em.getTransaction().begin();
		em.remove(f);
		em.getTransaction().commit();
		
	}

}
