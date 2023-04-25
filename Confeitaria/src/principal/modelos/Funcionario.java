package principal.modelos;

	public class Funcionario extends Pessoa{

		private int idFuncionario;
		private String funcao;
		private String periodo;
		private double salario;

	
	public Funcionario() {
	}
	
	public Funcionario(String nome, String telefone) {
		super(nome, telefone);
	}
	
	public Funcionario(String nome, String telefone, int idFuncionario, String funcao, String periodo, double salario) {
		super(nome, telefone);
		this.idFuncionario = idFuncionario;
		this.funcao = funcao;
		this.periodo = periodo;
		this.salario = salario;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}

