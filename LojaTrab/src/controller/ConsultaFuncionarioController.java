package controller;

import java.util.function.Predicate;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.FaixaEtaria;
import model.Funcionario;
import model.Produto;
import repository.FuncionariosRepository;
import utils.Erros;
import view.ConsultaFuncionarioView;


public class ConsultaFuncionarioController {
	private ConsultaFuncionarioView view;
	private FuncionariosRepository repository = FuncionariosRepository.getInstance();
	
	public ConsultaFuncionarioController(ConsultaFuncionarioView view) {
		this.view = view;
		configurarEventos();
		montarTabela();
	}
	
	public void configurarEventos() {
		view.getConsultarButton().addActionListener(e->consultar());
		view.getLimparButton().addActionListener(e->limparCampos());
	}
	
	public void consultar() {
		String ocupacao = view.getOcupacaoBox().getSelectedItem().toString();
		Double max;
		Double min;
		Predicate<Funcionario> filtro; 
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
		Predicate<Funcionario> maior = f-> min < f.getSalario();
		Predicate<Funcionario> menor = f-> f.getSalario() < max;
		Predicate<Funcionario> intervalo = maior.and(menor);
		
		filtro = intervalo;
		
		Predicate<Funcionario> ocupa;
		if(ocupacao.equals("Todas as ocupações")) {
			ocupa = f-> true;
		}else {
			ocupa = f-> f.getOcupacao().toString().equals(ocupacao);
		}
		filtro = filtro.and(ocupa);
		
		montarTabela(filtro);
	}
	
	public void montarTabela() {
		view.getFuncionariosTableModel().setRowCount(0);
		for(Funcionario f : repository.listarTodos()) {
			view.getFuncionariosTableModel().addRow(new Object[] {
					f.getId(),
					f.getNome(),
					f.getSalario(),
					f.getOcupacao(),
					f.getCpf()
					});
		}
	}
		
		public void montarTabela(Predicate<Funcionario> filtro) {
			view.getFuncionariosTableModel().setRowCount(0);
			for(Funcionario f : repository.buscarPorFiltro(filtro)) {
				view.getFuncionariosTableModel().addRow(new Object[] {
						f.getId(),
						f.getNome(),
						f.getSalario(),
						f.getOcupacao(),
						f.getCpf()
				});
			}
	}
		public void limparCampos() {
			view.getMinimoField().setText("");
			view.getMaximoField().setText("");
			view.getOcupacaoBox().setSelectedItem(0);
			montarTabela();
		}
}
