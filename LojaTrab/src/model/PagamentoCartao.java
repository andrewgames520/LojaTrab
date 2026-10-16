package model;

import java.time.LocalDate;

public class PagamentoCartao extends FormaPagamento {

	public PagamentoCartao(Double total) {
		super(total);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double CalcularTaxaOuDesconto() {

		return null;
	}

	@Override
	public void Processar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
