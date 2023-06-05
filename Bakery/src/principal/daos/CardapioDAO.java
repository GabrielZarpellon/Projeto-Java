package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import principal.modelos.Produto;

public class CardapioDAO {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static void Cardapio() {
		List<Produto> produtos = ProdutoDAO.listar();
		System.out.println();
		System.out.println("_______________");
		System.out.println("Cardapio:");
		
		for(Produto produto : produtos) {
			System.out.println( produto.getId() + " \t " + produto.getNome() + " \t " + produto.getPreco() + " \t " + produto.getTipo());
		}
	}

}
