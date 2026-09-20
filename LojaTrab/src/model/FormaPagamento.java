package model;

import java.time.LocalDate;

public abstract class FormaPagamento {
	private Double Total;
	private LocalDate dataPagamento;
	private Status statusPagamento;
	
	public FormaPagamento(Double total, LocalDate dataPagamento) {
		super();
		Total = total;
		this.dataPagamento = dataPagamento;
		this.statusPagamento = Status.PENDENTE;
	}
	
	public void cancelarPagamento() {
		this.statusPagamento = Status.CANCELADO;
	}
	
	public abstract Double CalcularTaxaOuDesconto();
	
	public abstract void Processar();
}