package modelo;

public class Cliente {
	
	private int id;
	private String cpf, endereco, telefone;
	
	
	public Cliente() {}


	public Cliente(String cpf, String endereco, String telefone) {
		super();
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
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


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}
	
	
	
	
	
	
	
	
	

}
