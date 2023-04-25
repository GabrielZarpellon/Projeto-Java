package principal.modelos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private List<Produto> Produtos = new ArrayList<>();

	public List<Produto> getProdutos() {
		return Produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		Produtos = produtos;
	}
	
	
}
