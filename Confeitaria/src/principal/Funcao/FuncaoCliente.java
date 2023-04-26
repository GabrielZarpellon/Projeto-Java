package Funcao;

import java.io.File;

import java.util.Scanner;
import java.io.FileNotFoundException;
import principal.modelos.Cliente;
import principal.modelos.Produto;

public class FuncaoCliente {
	
	public static void LerClientes()  throws FileNotFoundException{
		
		String arquivoClientes = "C:\\Users\\Acer\\git\\Teste\\Confeitaria\\src\\arquivosTxt\\Clientes";
		File arquivo = new File(arquivoClientes);
		Scanner clientes = new Scanner(arquivo);
		
		Cliente[] vetorDeClientes = new Cliente[8];
		
		int cont = 0;
		
		while(clientes.hasNextLine()) {
			
			try {
			String linha = clientes.nextLine();
			String[] valores = linha.split("\t");
			
			Cliente c = new Cliente();
			c.setIdCliente(Integer.parseInt(valores[0]));
			c.setNome(valores[1]);
			c.setTelefone(valores[2]);
			
			vetorDeClientes[cont] = c;
			cont++;
			}catch(NumberFormatException e) {
				System.out.println("Erro ao ler o produto na linha " + cont + ": " + e.getMessage());
			}
		}
		
		
		System.out.println("Historico de Clientes: \n\n");
		
		for(int i = 0; i < vetorDeClientes.length; i++) {
			
			Cliente c = vetorDeClientes[i];
			System.out.println(c.getIdCliente() + "\t" + c.getNome() + "\t" + c.getTelefone());
			System.out.println();
			
		}
		
		clientes.close();
		
	}

}
