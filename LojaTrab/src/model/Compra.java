package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
	private Cliente cliente;
	private LocalDate dataCompra;
	private List<Produto> compras = new ArrayList<>();
	private Double total;
	private FormaPagamento pagamento;
}
