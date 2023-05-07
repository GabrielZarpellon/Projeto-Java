package funcao;

import java.io.File;
import java.util.Scanner;
import principal.modelos.Funcionario;

import java.io.FileNotFoundException;

public class FuncaoFuncionario {
	public static void LerFuncionario() throws FileNotFoundException{
		
		String arquivoFuncionarios = "C:\\Users\\Acer\\git\\Teste\\Confeitaria\\src\\arquivosTxt\\Funcionarios";
		File arquivo = new File(arquivoFuncionarios);
		Scanner funcionarios = new Scanner(arquivo);
		
		Funcionario[] vetorDeFuncionarios = new Funcionario[5];
		
		int cont = 0;
		
		while(funcionarios.hasNextLine()) {
			
			try {
			String linha = funcionarios.nextLine();
			String[] valores = linha.split("\t");
			
			Funcionario f = new Funcionario();
			f.setIdFuncionario(Integer.parseInt(valores[0]));
			f.setNome(valores[1]);
			f.setTelefone(valores[2]);
			f.setFuncao(valores[3]);
			f.setPeriodo(valores[4]);
			f.setSalario(Double.parseDouble(valores[5]));
			
			vetorDeFuncionarios[cont] = f;
			cont++;
			}catch(NumberFormatException e) {
				System.out.println("Erro ao ler o produto na linha " + cont + ": " + e.getMessage());
			}
		}
		
		
		System.out.println("Arquivo de Funcionarios: \n\n");
		
		for(int i = 0; i < vetorDeFuncionarios.length; i++) {
			
			Funcionario f = vetorDeFuncionarios[i];
			System.out.println(f.getIdFuncionario() + "\t" + f.getNome() + "\t" + f.getTelefone() + "\t" + f.getFuncao() + "\t" + f.getPeriodo() + "\t" + f.getSalario());
			System.out.println();
			
		}
		
		funcionarios.close();
		
		
	}

}
