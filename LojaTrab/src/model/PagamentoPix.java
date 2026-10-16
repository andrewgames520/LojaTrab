package model;

import java.time.LocalDate;

public class PagamentoPix extends FormaPagamento {

	public PagamentoPix(Double total) {
		super(total);
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
