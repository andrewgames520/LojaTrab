package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
	private Integer id;
	private Cliente cliente;
	private LocalDate dataCompra;
	private List<ItemCompra> compras = new ArrayList<>();
	private Double total;
	private FormaPagamento pagamento;
	private Status status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}
	public List<ItemCompra> getCompras() {
		return compras;
	}
	public void setCompras(List<ItemCompra> compras) {
		this.compras = compras;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public FormaPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(FormaPagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public boolean possuiProduto(Integer id) {
		return this.getCompras().stream().anyMatch(i->i.getiD() == id);
	}
}
