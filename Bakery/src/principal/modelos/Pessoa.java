package principal.modelos;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String cpf;
	
	public Pessoa(){
	}
	
	public Pessoa(String nome, String telefone) {
		this.nome = nome;
		this.cpf = telefone;
	}
	
	public Pessoa(String nome, String cpf, int id) {
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}

