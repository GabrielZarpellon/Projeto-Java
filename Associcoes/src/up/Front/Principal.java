package up.Front;

import java.util.InputMismatchException;

import up.Entidades.Cliente;
import up.Entidades.Produto;
import up.Entidades.Vendedor;
import up.Entidades.Venda;
import up.Entidades.Item;
import up.Persistencia.Persistencia;

public class Principal {
	public static void main(String[] args) {
		int opcao, escolha;
		String decisao;
		Vendedor v1 = null;
		Cliente c1 = null;
		Produto p1 = null;
		Venda venda1 = null;
		Item i1 = null;
		do {
			System.out.println("\n1-Registrar conta");
			System.out.println("2-Realizar compra");
			System.out.println("3-Sair");
			opcao = Console.readInt("Informe a opção: ");
			switch (opcao) {
			case 1:
				System.out.println("\n1-Vendedor");
				System.out.println("2-Cliente");
				System.out.println("3-Produto");
				escolha = Console.readInt("Informe qual cadastro deseja realizar: ");
				switch (escolha) {
				case 1:
					v1 = new Vendedor();
					v1.setNome(Console.readString("Informe o nome do vendedor: "));
					v1.setCpf(Console.readString("Informe o CPF do vendedor: "));
					if (isCPF(v1.getCpf()) == false) {
						do {
							v1.setCpf(Console.readString("Informe um CPF valido: "));
						} while (isCPF(v1.getCpf()) == false);
					}
					if (Persistencia.verificarVCPF(v1) != null) {
						System.out.println("Este vendedor já existe");
					} else {
						v1.setTaxa(Console.readInt("Informe a taxa de comissão do vendedor: "));
						Persistencia.adicionarVlista(v1);
						System.out.println("CONTA VENDEDOR CRIADA!");
					}
					break;
				case 2:
					c1 = new Cliente();
					c1.setNome(Console.readString("Informe o nome do cliente: "));
					c1.setCpf(Console.readString("Informe o CPF do cliente: "));
					if (Persistencia.verificarCCPF(c1) != null) {
						System.out.println("Este cliente já existe");
					} else {
						if (isCPF(c1.getCpf()) == false) {
							do {
								c1.setCpf(Console.readString("Informe um CPF valido: "));
							} while (isCPF(c1.getCpf()) == false);
						}
						Persistencia.adicionarClista(c1);
						System.out.println("CONTA CLIENTE CRIADA!");
					}
					break;
				case 3:
					p1 = new Produto();
					p1.setNome(Console.readString("Informe o nome do produto: "));
					if (Persistencia.verificarP(p1) != null) {
						System.out.println("Este produto já existe");
					} else {
						p1.setPreco(Console.readFloat("Informe o valor do produto: "));
						p1.setMarkup(Console.readFloat("Informe o markup do produto: "));
						Persistencia.adicionarPlista(p1);
						System.out.println("PRODUTO CRIADO!");
					}
					break;
				}
				break;
			case 2:
				venda1 = new Venda();
				i1 = new Item();
				venda1.setCliente(Console.readString("Informe o nome do cliente: "));
				if (Persistencia.verificarCnome(venda1) == null) {
					System.out.println("Esse cliente não esta registrado");
				} else {
					venda1.setVendedor(Console.readString("Informe o nome do vendedor: "));
					if (Persistencia.verificarVnome(venda1) == null) {
						System.out.println("Esse vendedor não esta registrado");
					} else {
						for (Produto item : Persistencia.listaProdutos) {
							System.out.println( "-" + item.getNome());
						}
						i1.setProduto(Console.readString("Informe qual destes itens deseja comprar:"));
						if (Persistencia.verificarIlistaP(i1) == null) {
							System.out.println("Este item não existe");
						} else {
							i1.setQuant(Console.readInt("Informe a quantidade:"));
							Persistencia.adicionarIlista(i1);
							do {
							decisao = Console.readString("Deseja comprar algo mais?");
								if (decisao.equals("Sim") || decisao.equals("sim")) {
									for (Produto item : Persistencia.listaProdutos) {
										System.out.println("-" + item.getNome());
									}
									i1.setProduto(Console.readString("Informe qual destes itens deseja comprar:"));
									if (Persistencia.verificarPlistaI(i1) != null) {
										System.out.println("Este item já esta na compra");
									} else {
										i1.setQuant(Console.readInt("Informe a quantidade:"));
										Persistencia.adicionarIlista(i1);
									}
									decisao = Console.readString("Deseja comprar algo mais?");
								}
							} while (decisao.equals("Sim") || decisao.equals("sim"));
							venda1.setItens(Persistencia.listaItens);
							System.out.println("--- INFORMAÇOES DE VENDA ---");
							System.out.println("Cliente: " + venda1.getCliente());
							System.out.println("Vendedor: " + venda1.getVendedor());
						}
					}
				}
			}
		} while (opcao != 3);
	}


	public static boolean isCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
}