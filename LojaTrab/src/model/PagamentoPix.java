package model;

import java.time.LocalDate;

public class PagamentoPix extends FormaPagamento {
	
	private Status statusPagamento;
	
	public PagamentoPix(Double total) {
		super(total);
		this.setTotal(total * this.CalcularTaxaOuDesconto());
		this.statusPagamento = Status.PENDENTE;
	}

	@Override
	public Double CalcularTaxaOuDesconto() {
		return 0.90;
	}

	@Override
	public void Processar() {
		this.setStatusPagamento(Status.CONCLUIDO);
		
	}
	
}
