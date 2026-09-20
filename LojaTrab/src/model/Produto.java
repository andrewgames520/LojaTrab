package model;

public class Produto {
	private Integer Id;
	private Integer qntDisponivel;
	private Double valor;
	private String descricao;
	private FaixaEtaria faixaEtaria;
	
	public Produto(Integer id, Integer qnt, String descricao, FaixaEtaria faixaEtaria) {
		super();
		Id = id;
		qntDisponivel = qnt;
		this.descricao = descricao;
		this.faixaEtaria = faixaEtaria;
	}

	public Produto(Integer id, Integer qnt, FaixaEtaria faixaEtaria) {
		super();
		Id = id;
		qntDisponivel = qnt;
		this.faixaEtaria = faixaEtaria;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getQnt() {
		return qntDisponivel;
	}

	public void setQnt(Integer qnt) {
		qntDisponivel = qnt;
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
