package principal.modelos;

public class Cliente {
    private Pessoa pessoa;
    private int idCliente;
 
  public Cliente() {
  }

  public Cliente(Pessoa pessoa, int idCliente) {
    this.pessoa = pessoa;
    this.idCliente = idCliente;
  }

  public Pessoa getPessoa() {
    return pessoa;
   }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public int getIdCliente() {
    return idCliente;
  }
 
  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }
}

