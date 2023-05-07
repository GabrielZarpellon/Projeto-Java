package funcao;

import java.io.File;

import java.util.Scanner;

import principal.modelos.Produto;

import java.io.FileNotFoundException;

public class FuncaoProd {
public static void LerProdutos () throws FileNotFoundException {
	String arquivoProdutos = "C:\\Users\\Acer\\git\\Teste\\Confeitaria\\src\\arquivosTxt\\Produtos";
	File arquivo = new File(arquivoProdutos);
	Scanner produtos = new Scanner(arquivo);
	
	Produto[] vetorDeProdutos = new Produto[23];
	
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
		
		vetorDeProdutos[cont] = p;
		cont++;
		}catch(NumberFormatException e) {
			System.out.println("Erro ao ler o produto na linha " + cont + ": " + e.getMessage());
		}
	}
	
	
	System.out.println("Lista de Produtos: \n\n");
	
	for(int i = 0; i < vetorDeProdutos.length; i++) {
		
		Produto p = vetorDeProdutos[i];
		System.out.println(p.getId_produto() + "\t" + p.getNome() + "\t" + p.getPreco() + "\t" + p.getTipo());
		System.out.println();
		
	}
	
	
	
	produtos.close();
	
	
}

}
