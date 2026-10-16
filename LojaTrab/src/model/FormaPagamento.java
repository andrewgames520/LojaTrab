package model;

import java.time.LocalDate;

public abstract class FormaPagamento {
	private Double Total;
	private Status statusPagamento;
	
	public FormaPagamento(Double total) {
		super();
		Total = total;
		this.statusPagamento = Status.PENDENTE;
	}
	
	public void cancelarPagamento() {
		this.statusPagamento = Status.CANCELADO;
	}
	
	public abstract Double CalcularTaxaOuDesconto();
	
	public abstract void Processar();
}