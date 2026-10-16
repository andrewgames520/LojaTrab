package model;

import java.time.LocalDate;

public class PagamentoCartao extends FormaPagamento {
	private Status statusPagamento;
	public PagamentoCartao(Double total) {
		super(total);
		this.setTotal(total*this.CalcularTaxaOuDesconto());
		this.statusPagamento = Status.PENDENTE;

	}

	@Override
	public Double CalcularTaxaOuDesconto() {
		
		return 1.15;
	}

	@Override
	public void Processar() {
		this.setStatusPagamento(Status.CONCLUIDO);
	}
	
	
}
