package model;

import java.time.LocalDate;

public abstract class FormaPagamento {
	private String pagante;
	private Double Total;
	private LocalDate dataPagamento;
	private StatusPagamento statusPagamento;
	
	public FormaPagamento(String pagante, Double total, LocalDate dataPagamento) {
		super();
		this.pagante = pagante;
		Total = total;
		this.dataPagamento = dataPagamento;
		this.statusPagamento = StatusPagamento.PENDENTE;
	}
	
	public void cancelarPagamento() {
		this.statusPagamento = StatusPagamento.CANCELADO;
	}
	
	public abstract Double CalcularTaxaOuDesconto();
}