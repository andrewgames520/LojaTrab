package controller;

import java.util.function.Predicate;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.FaixaEtaria;
import model.Produto;
import repository.ProdutosRepository;
import utils.Erros;
import view.ConsultaProdutoView;

public class ConsultaProdutoController {
	ConsultaProdutoView view;
	ProdutosRepository repository = ProdutosRepository.getInstance();
	public ConsultaProdutoController(ConsultaProdutoView view) {
		this.view = view;
		configurarEventos();
		montarTabela();
	}
	
	public void configurarEventos() {
		view.getConsultarButton().addActionListener(e->consultar());
		view.getLimparButton().addActionListener(e->limparCampos());
	}
	
	public void consultar() {
		String faixa = view.getfaixaEtariaBox().getSelectedItem().toString();
		Double max;
		Double min;
		Predicate<Produto> filtro; 
		try{
			if(view.getMinimoField().getText().isBlank()) {
				min = Double.NEGATIVE_INFINITY;
			}else {
				min = Double.valueOf(view.getMinimoField().getText());				
			}
			if(view.getMaximoField().getText().isBlank()){
				max = Double.POSITIVE_INFINITY;
			}else {
				max = Double.valueOf(view.getMaximoField().getText());
			}
		}catch(NumberFormatException e) {
			Erros.mostrarErro("Digite um numero válido nos campos", view);
			return;
		}
		Predicate<Produto> maior = p-> min < p.getValor();
		Predicate<Produto> menor = p-> p.getValor() < max;
		Predicate<Produto> intervalo = maior.and(menor);
		
		filtro = intervalo;
		TableRowSorter<DefaultTableModel> ordenar = new TableRowSorter<>(view.getProdutosTableModel());
		view.getProdutosTable().setRowSorter(ordenar);
		
		Predicate<Produto> faixaEtaria;
		if(faixa.equals("Todas as faixas")) {
			faixaEtaria = p-> true;
		}else {
			faixaEtaria = p-> p.getFaixaEtaria().equals(FaixaEtaria.porRotulo(faixa));
		}
		filtro = filtro.and(faixaEtaria);
		
		montarTabela(filtro);
	}
	
	public void montarTabela() {
		view.getProdutosTableModel().setRowCount(0);
		for(Produto p : repository.listarTodos()) {
			view.getProdutosTableModel().addRow(new Object[] {
					p.getId(),
					p.getNome(),
					p.getQntDisponivel(),
					p.getFaixaEtaria(),
					p.getValor(),
					p.getDescricao()
					});
		}
	}
	public void montarTabela(Predicate<Produto> filtro) {
		view.getProdutosTableModel().setRowCount(0);
		for(Produto p :repository.buscarPorFiltro(filtro)) {
			view.getProdutosTableModel().addRow(new Object[] {
					p.getId(),
					p.getNome(),
					p.getQntDisponivel(),
					p.getFaixaEtaria(),
					p.getValor(),
					p.getDescricao()
			});
		}
	}
	
	public void limparCampos() {
		view.getfaixaEtariaBox().setSelectedIndex(0);
		view.getMinimoField().setText("");
		view.getMaximoField().setText("");
		montarTabela();
	}
}
