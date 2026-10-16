package controller;


import java.util.function.Predicate;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Compra;
import model.Status;
import repository.ComprasRepository;
import repository.ProdutosRepository;
import utils.Erros;
import view.CancelarCompraView;

public class CancelarCompraController {
	CancelarCompraView view;
	ComprasRepository repository;
	public CancelarCompraController(CancelarCompraView view) {
		this.repository =ComprasRepository.getInstance();
		this.view = view;
		configurarEventos();
		montarTabela();
	}
	
	public void configurarEventos() {
		view.getConsultarButton().addActionListener(e->consultar());
		view.getLimparButton().addActionListener(e->limparCampos());
		view.getCancelarButton().addActionListener(e->cancelar());
	}
	
	public void consultar() {
		String cliente = view.getClienteBox().getSelectedItem().toString();
		Double max;
		Double min;
		Predicate<Compra> filtro; 
		try{
			if(view.getMinField().getText().isBlank()) {
				min = Double.NEGATIVE_INFINITY;
			}else {
				min = Double.valueOf(view.getMinField().getText());				
			}
			if(view.getMaxField().getText().isBlank()){
				max = Double.POSITIVE_INFINITY;
			}else {
				max = Double.valueOf(view.getMaxField().getText());
			}
		}catch(NumberFormatException e) {
			Erros.mostrarErro("Digite um numero válido nos campos", view);
			return;
		}
		Predicate<Compra> maior = c-> min < c.getTotal();
		Predicate<Compra> menor = c-> c.getTotal() < max;
		Predicate<Compra> intervalo = maior.and(menor);
		
		filtro = intervalo;
		
		Predicate<Compra> compra;
		if(cliente.equals("TODOS CLIENTES")) {
			compra = c-> true;
		}else {
			compra = c-> c.getCliente().getNome().equals(cliente);
		}
		filtro = filtro.and(compra);
		
		montarTabela(filtro);
	}
	
	public void montarTabela() {
		view.getCompraTableModel().setRowCount(0);
		for(Compra c : repository.buscarPorFiltro(c -> c.getStatus() == Status.PENDENTE)) {
			view.getCompraTableModel().addRow(new Object[] {
					c.getId(),
					c.getCliente(),
					c.getTotal(),
					c.getStatus()
					});
		}
	}
	public void montarTabela(Predicate<Compra> filtro) {
		view.getCompraTableModel().setRowCount(0);
		for(Compra c :repository.buscarPorFiltro(filtro.and(c -> c.getStatus() == Status.PENDENTE))) {
			view.getCompraTableModel().addRow(new Object[] {
					c.getId(),
					c.getCliente(),
					c.getTotal(),
					c.getStatus()
					});
		}
	}
	
	public void limparCampos() {
		view.getClienteBox().setSelectedIndex(0);
		view.getMinField().setText("");
		view.getMaxField().setText("");
		montarTabela();
	}
	
	public void cancelar() {
		 int linhaSelecionada = view.getCompraTable().getSelectedRow();
			if(linhaSelecionada == -1) {
				return;
			}
			view.getCancelarButton().setEnabled(false);
			int linhaModelo = view.getCompraTable().convertRowIndexToModel(linhaSelecionada);
			Integer id = (Integer) view.getCompraTable().getValueAt(linhaModelo,0);
			this.repository.filtrar(p -> p.getId() == id).ifPresent(c -> {
				c.setStatus(Status.CANCELADO);
				ProdutosRepository.getInstance().devolverProdutos(c.getCompras());
			});
			view.getCancelarButton().setEnabled(false);
			consultar();
	}
}
