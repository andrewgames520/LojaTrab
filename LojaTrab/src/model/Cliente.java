package model;

public class Cliente {
	private String Cpf;
	private Integer Id;
	private String nome;
	
	public Cliente(String cpf, Integer id, String nome) {
		super();
		Cpf = cpf;
		Id = id;
		this.nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
