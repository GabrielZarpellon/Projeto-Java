package principal;
import principal.modelos.Pessoa;
import java.util.Scanner;

import Funcao.FuncaoProd;

import java.io.File;
import java.io.FileNotFoundException;
import principal.modelos.Funcionario;
import principal.modelos.Cliente;
import principal.modelos.Produto;
import principal.modelos.Item_Pedido;
import principal.modelos.Estoque;
import principal.modelos.Pedido;
import Funcao.FuncaoCliente;
import Funcao.FuncaoFuncionario;

public class Programa {
	public static void main(String[] args) throws FileNotFoundException {
		
		FuncaoProd Cardapio = new FuncaoProd();
		
		FuncaoCliente HistoricoClientes = new FuncaoCliente();
		
		FuncaoFuncionario ArquivoFuncionarios = new FuncaoFuncionario();
		
		//Mostrar o cardapio
		//Cardapio.LerProdutos();
		
		//Mostrar Historico de Clientes
		//HistoricoClientes.LerClientes();
		
		//Mostrar Arquivo de Funcionarios
		ArquivoFuncionarios.LerFuncionario();
		
		
	}

}

