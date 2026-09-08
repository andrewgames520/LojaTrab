package model;

import java.time.LocalDate;

public class PagamentoCartao extends FormaPagamento {

	public PagamentoCartao(String pagante, Double total, LocalDate dataPagamento) {
		super(pagante, total, dataPagamento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double CalcularTaxaOuDesconto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
