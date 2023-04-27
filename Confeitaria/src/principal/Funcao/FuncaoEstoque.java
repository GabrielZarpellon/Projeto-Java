package funcao;

import principal.modelos.Produto;
import principal.modelos.Estoque;
import java.util.ArrayList;
import java.util.List;

public class FuncaoEstoque {
	
	private String nome;
	private List<Estoque> lista = new ArrayList<>();
	
	public void adicionar(Estoque produto) {
		this.lista.add(produto);
	}

	public List<Estoque> getProdutos() {
		return lista;
	}

	public void setProdutos(List<Estoque> produtos) {
		lista = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
	

