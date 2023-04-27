package principal.modelos;

import java.util.ArrayList;
import java.util.List;
import principal.modelos.Produto;
import funcao.FuncaoEstoque;

public class Estoque{

	private String nome;
	private int quantidade;
	
	public Estoque(){
		
	}
	
	public Estoque(String nome, int quantidade ) {
		this.nome = nome;
		this.quantidade = quantidade;
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
	
}