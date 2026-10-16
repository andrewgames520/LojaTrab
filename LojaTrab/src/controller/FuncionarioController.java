package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Funcionario;
import model.Ocupacao;
import repository.FuncionariosRepository;
import utils.Erros;
import view.FuncionarioView;

public class FuncionarioController {

	private FuncionarioView view;
	private FuncionariosRepository repository;
	 
	 public FuncionarioController(FuncionarioView view,FuncionariosRepository repository) {
		 this.repository = repository;
		 this.view = view;
		 configurarEventos();
	 }
	 
	 public void configurarEventos() {
		 view.getSalvarButton().addActionListener(e->salvarFuncionario());
		 view.getExcluirButton().addActionListener(e->excluirFuncionario());
		 view.getLimparButton().addActionListener(e->limparCampos());
		 view.getFuncionariosTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				carregarFuncionarioSelecionado();
				
			}
		});
		 montarTabela();
	 }
	 
	 public void carregarFuncionarioSelecionado() {
		 int linhaSelecionada = view.getFuncionariosTable().getSelectedRow();
			if(linhaSelecionada == -1) {
				return;
			}
			view.getExcluirButton().setEnabled(true);
			int linhaModelo = view.getFuncionariosTable().convertRowIndexToModel(linhaSelecionada);
			Integer id = (Integer) view.getFuncionariosTable().getValueAt(linhaModelo,0);
			this.repository.filtrar(p -> p.getId() == id).ifPresent(this::preencherCampos);
		}
	 
	 public void preencherCampos(Funcionario funcionario) {
		 view.getIdField().setText(funcionario.getId().toString());
		 view.getNomeField().setText(funcionario.getNome());
		 view.getCpfField().setText(funcionario.getCpf());
		 view.getSalarioField().setText(funcionario.getSalario().toString());
		 view.getOcupacaoBox().setSelectedItem(funcionario.getOcupacao());
	 }
	 
	 public void salvarFuncionario() {
		 Double salario;
		 String id = view.getIdField().getText();
		 String nome = view.getNomeField().getText();
		 String cpf = view.getCpfField().getText();
		 Ocupacao ocupacao = (Ocupacao) view.getOcupacaoBox().getSelectedItem();
		 try {
			 salario = Double.parseDouble(view.getSalarioField().getText());
			 if(salario <= 1621) {
				 Erros.mostrarErro("O salário minimo é de R$: 1621", view);
				 return;
			 }
		 }catch(Exception e) {
			 Erros.mostrarErro("Campo salario inválido", view);
			 return;
		 }
		 if(nome.isBlank()) {
			 Erros.mostrarErro("Nome vazio", view);
			 return;
		 }
		 Funcionario funcionario = new Funcionario(nome,salario,cpf,ocupacao);
		 if(id.isBlank()) {
			 if(!funcionario.verificarCpf()) {
				 Erros.mostrarErro("CPF inválido", view);
				 return;
			 }
			if(repository.Buscar(p-> p.getCpf().equals(funcionario.getCpf()))){
				Erros.mostrarErro("CPF já cadastrado", view);
				return;
			}
			repository.adicionar(funcionario);
		 }else {
			 funcionario.setId(Integer.parseInt(id));
			 repository.atualizar(funcionario);
		 }
		 montarTabela();
		 limparCampos();
	 }
	 
	 public void excluirFuncionario() {
		String id = view.getIdField().getText();
		repository.remover(Integer.parseInt(id));
		limparCampos();
		montarTabela();
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
	 public void limparCampos() {
		 view.getIdField().setText("");
		 view.getNomeField().setText("");
		 view.getCpfField().setText("");
		 view.getSalarioField().setText("");
		 view.getOcupacaoBox().setSelectedIndex(0);
		 view.getExcluirButton().setEnabled(false);
	 }
	}

