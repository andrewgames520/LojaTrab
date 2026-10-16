package controller;

import java.util.function.Predicate;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Compra;
import model.ItemCompra;
import model.Status;
import repository.ComprasRepository;
import utils.Erros;
import view.ConsultaCompraView;


public class ConsultaCompraController {
	ConsultaCompraView view;
	ComprasRepository repository = ComprasRepository.getInstance();
	
	public ConsultaCompraController(ConsultaCompraView view) {
		this.view = view;
		configurarEventos();
		montarTabela();
	}
	
	public void configurarEventos() {
		view.getConsultarButton().addActionListener(e->consultar());
		view.getLimparButton().addActionListener(e->limparCampos());
		view.getFinalizarButton().addActionListener(e->finalizar());
		view.getCompraTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					carregarItemSelecionado();
					
				}
			});
	}
	
	public void carregarItemSelecionado() {
		 int linhaSelecionada = view.getCompraTable().getSelectedRow();
			if(linhaSelecionada == -1) {
				return;
			}
			view.getFinalizarButton().setEnabled(false);
			int linhaModelo = view.getCompraTable().convertRowIndexToModel(linhaSelecionada);
			Integer id = (Integer) view.getCompraTable().getValueAt(linhaModelo,0);
			this.repository.filtrar(p -> p.getId() == id).ifPresent(this::preencherCampos);
		}
	
	 public void preencherCampos(Compra compra) {
		 view.getClienteBox().setSelectedItem(compra.getCliente());
		 view.getStatusBox().setSelectedItem(compra.getStatus());
		 if(compra.getStatus().equals(Status.PENDENTE)) {
			 view.getFinalizarButton().setEnabled(true);			 
		 }
	 }
	
	public void consultar() {
		String cliente = view.getClienteBox().getSelectedItem().toString();
		String status = view.getStatusBox().getSelectedItem().toString();
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
		
		Predicate<Compra> terStatus;
		
		if(status.equals("TODOS STATUS")) {
			terStatus = s-> true;
		}else {
			terStatus = s -> s.getStatus().toString().equals(status);
		}
		filtro = filtro.and(terStatus);
		
		montarTabela(filtro);
	}
	
	public void montarTabela() {
		view.getCompraTableModel().setRowCount(0);
		for(Compra c : repository.listarTodos()) {
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
		for(Compra c :repository.buscarPorFiltro(filtro)) {
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
		view.getStatusBox().setSelectedIndex(0);
		view.getMinField().setText("");
		view.getMaxField().setText("");
		montarTabela();
	}
	
	public void finalizar() {
		 int linhaSelecionada = view.getCompraTable().getSelectedRow();
			if(linhaSelecionada == -1) {
				return;
			}
			int linhaModelo = view.getCompraTable().convertRowIndexToModel(linhaSelecionada);
			Integer id = (Integer) view.getCompraTable().getValueAt(linhaModelo,0);
			this.repository.filtrar(p -> p.getId() == id).ifPresent(c-> c.setStatus(Status.CONCLUIDO));
			view.getFinalizarButton().setEnabled(false);
			consultar();
	}
}
