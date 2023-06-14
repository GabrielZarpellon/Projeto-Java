package principal.modelos;

import jakarta.persistence.Entity;

@Entity


public class Cliente extends Pessoa{
	
	
	public Cliente() {
		
	}
	
	public Cliente(int id) {
		super();
	}
	
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
		
	}

	public Cliente(String nome, String cpf, int id) {
		super(nome, cpf, id);
	}
	
}
