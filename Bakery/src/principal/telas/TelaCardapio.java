package principal.telas;

import java.util.List;
import java.util.Scanner;
import principal.modelos.Produto;
import principal.daos.ProdutoDAO;

public class TelaCardapio {
	
	public static void ChamaCardapio() {
		
		Scanner leitor = new Scanner(System.in);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<Produto> produtos = produtoDAO.listar();
		System.out.println();
		System.out.println("_______________");
		System.out.println("Cardapio:");
		
		for(Produto produto : produtos) {
			System.out.println( produto.getId() + " \t " + produto.getNome() + " \t " + produto.getPreco() + " \t " + produto.getTipo());
		}
		
		
	}
	

}
