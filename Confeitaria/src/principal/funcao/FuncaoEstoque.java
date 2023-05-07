package funcao;

import principal.modelos.Estoque;

import java.util.ArrayList;
import java.util.List;

public class FuncaoEstoque {
	
	private String nome;
	private int quantidade;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<Estoque> getLista() {
		return lista;
	}

	public void setLista(List<Estoque> lista) {
		this.lista = lista;
	}
	
	

	

}