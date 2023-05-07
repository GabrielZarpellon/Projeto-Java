package funcao;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import principal.modelos.Estoque;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class FuncaoListaEstoque {
	public static void MenuEstoque() throws FileNotFoundException {
		
	String arquivoEstoque = "C:\\Users\\Acer\\git\\Teste\\Confeitaria\\src\\arquivosTxt\\Estoque";
	File arquivo = new File (arquivoEstoque);
	Scanner leitorArquivo = new Scanner(arquivo);
	Formatter gravador = new Formatter(arquivoEstoque);
	
	Scanner leitor = new Scanner (System.in);

	int op; int qntd; String item;
	
	List<Estoque> listaDeEstoque = new ArrayList<>();
	
	int cont = 0;
	
	while(leitorArquivo.hasNextLine()) {
		
		try {
		String linha = leitorArquivo.nextLine();
		String[] valores = linha.split(",");
		
		Estoque e = new Estoque();
		e.setNome(valores[0]);
		e.setQuantidade(Integer.parseInt(valores[1]));
		
		listaDeEstoque.add(e);
		cont++;
		}catch(NumberFormatException e) {
			System.out.println("Erro ao ler o produto na linha " + cont + ": " + e.getMessage());
		}
	}
	
	PrintWriter registro = new PrintWriter(arquivo);
	
	do {
		System.out.println(" _ Menu Estoque _ \n[1]Adicionar item \n[2]Remover item \n[3]Listar Estoque \n[4]Sair");
		op = leitor.nextInt();
		
		switch(op) {
	
		case 1:
			System.out.println("Informe o item: ");
			item = leitor.next(); 
	
			System.out.println("Informe a quantidade: ");
			qntd = leitor.nextInt();
			
			gravador.format(item + "\t" + qntd);
			
			Estoque inserir = new Estoque(item, qntd);

			listaDeEstoque.add(inserir);
			
			registro.println(item + "," + qntd);
			registro.flush();
			
			for(Estoque estoque : listaDeEstoque) {
				gravador.format(item + qntd);
				
			}

		
		break;
		
		case 2:
			
			System.out.println("Qual item deseja remover ?");
			
		break;
		
		
		case 3:
			for(Estoque estoque : listaDeEstoque) {
				System.out.println("\nIngrediente: " + estoque.getNome() + "\tQuantidade: " + estoque.getQuantidade());
			}
		break;
		
		case 4:
		
		break;
		
		}
	}while(op != 4);
	
	
	for (Estoque estoque : listaDeEstoque) {
        registro.println(estoque.getNome() + "," + estoque.getQuantidade());
    }
    registro.close();
	
	leitor.close();
	gravador.close();
	leitorArquivo.close();

	}


}
