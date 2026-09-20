package model;

public class Funcionario {
	private	String nome;
	private Double salario;
	private String Cpf;
	private Ocupacao ocupacao;
	private Integer Id;
	
	public Funcionario(String nome,Integer Id, Double salario, String cpf, Ocupacao ocupacao) {
		super();
		this.nome = nome;
		this.Id = Id;
		this.salario = salario;
		Cpf = cpf;
		this.ocupacao = ocupacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCpf() {
		return Cpf;
	}

	public Ocupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}
	
	
}
