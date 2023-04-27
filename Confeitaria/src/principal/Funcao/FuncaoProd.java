package funcao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import principal.modelos.Produto;

import java.io.FileNotFoundException;

public class FuncaoProd {
public static List<Produto> LerProdutos () throws FileNotFoundException {
	String arquivoProdutos = "C:\\Mari\\Confeitaria\\src\\arquivosTxt\\Produtos";
	File arquivo = new File(arquivoProdutos);
	Scanner produtos = new Scanner(arquivo);
	
	//Produto[] produtosDisponiveis = new Produto[23];
	List<Produto> produtosDisponiveis = new ArrayList<>();
	
	int cont = 0;
	
	while(produtos.hasNextLine()) {
		
		try {
		String linha = produtos.nextLine();
		String[] valores = linha.split("\t");
		
		Produto p = new Produto();
		p.setId_produto(Integer.parseInt(valores[0]));
		p.setNome(valores[1]);
		p.setPreco(Double.parseDouble(valores[2]));
		p.setTipo(valores[3]);
		
		//produtosDisponiveis[cont] = p;
		produtosDisponiveis.add(p);
		cont++;
		}catch(NumberFormatException e) {
			System.out.println("Erro ao ler o produto na linha " + cont + ": " + e.getMessage());
		}
		
		return produtosDisponiveis;
	}
	
	
	System.out.println("Lista de Produtos: \n\n");
	
	//Colocar lista
	
	//for(int i = 0; i < produtosDisponiveis; i++) {
		
		Produto p = produtosDisponiveis[i];
		System.out.println(p.getId_produto() + "\t" + p.getNome() + "\t" + p.getPreco() + "\t" + p.getTipo());
		System.out.println();
		
	}
	
	
	
	produtos.close();
	
	
}

}
