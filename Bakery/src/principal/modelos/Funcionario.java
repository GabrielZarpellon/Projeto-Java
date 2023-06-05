package principal.modelos;

import jakarta.persistence.Entity;

@Entity

public class Funcionario extends Pessoa{

	private String funcao;
	private String periodo;
	private double salario;


public Funcionario() {
}

public Funcionario(String nome, String cpf) {
	super(nome, cpf);
}
public Funcionario(String nome, String cpf, int id) {
	super(nome, cpf, id);
}

public Funcionario( String funcao, String periodo, double salario) {

	this.funcao = funcao;
	this.periodo = periodo;
	this.salario = salario;
}

public Funcionario(String nome, String cpf, String funcao, String periodo, double salario) {
	super(nome, cpf);
	this.funcao = funcao;
	this.periodo = periodo;
	this.salario = salario;
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
