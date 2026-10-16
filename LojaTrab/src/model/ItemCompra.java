package model;

import java.util.function.Function;

public class ItemCompra {
	private Integer iD;
	private String nome;
	private Integer qnt;
	private Double valorUnit;
	private Double subTotal;
	
	public Integer getiD() {
		return iD;
	}
	public void setiD(Integer iD) {
		this.iD = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQnt() {
		return qnt;
	}
	public void setQnt(Integer qnt) {
		this.qnt = qnt;
	}
	public Double getValorUnit() {
		return valorUnit;
	}
	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	
	public Double calcularTotal() {
		return this.valorUnit * this.qnt;
	}

	
}
