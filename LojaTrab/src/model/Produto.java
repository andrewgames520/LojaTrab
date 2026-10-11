package model;

public class Produto {
	private Integer Id;
	private String nome;
	private Integer qntDisponivel;
	private Double valor;
	private String descricao;
	private FaixaEtaria faixaEtaria;
	
	/*public Produto(Integer id,String nome, Integer qnt, String descricao, FaixaEtaria faixaEtaria) {
		this.Id = id;
		this.nome = nome;
		this.qntDisponivel = qnt;
		this.descricao = descricao;
		this.faixaEtaria = faixaEtaria;
	}
	*/

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


	public Integer getQntDisponivel() {
		return qntDisponivel;
	}


	public void setQntDisponivel(Integer qntDisponivel) {
		this.qntDisponivel = qntDisponivel;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	
	
	
}
