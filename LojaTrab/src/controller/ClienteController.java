package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Cliente;
import repository.ClientesRepository;
import utils.Erros;
import view.ClienteView;

public class ClienteController {
	private ClienteView view;
 private ClientesRepository repository;
 
 public ClienteController(ClienteView view,ClientesRepository repository) {
	 this.repository = repository;
	 this.view = view;
	 configurarEventos();
 }
 
 public void configurarEventos() {
	 view.getSalvarButton().addActionListener(e->salvarCliente());
	 view.getExcluirButton().addActionListener(e->excluirCliente());
	 view.getLimparButton().addActionListener(e->limparCampos());
	 view.getClienteTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			carregarClienteSelecionado();
			
		}
	});
	 montarTabela();
 }
 
 public void carregarClienteSelecionado() {
	 int linhaSelecionada = view.getClienteTable().getSelectedRow();
		if(linhaSelecionada == -1) {
			return;
		}
		view.getExcluirButton().setEnabled(true);
		int linhaModelo = view.getClienteTable().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getClienteTable().getValueAt(linhaModelo,0);
		this.repository.filtrar(p -> p.getId() == id).ifPresent(this::preencherCampos);;
	}
 
 public void preencherCampos(Cliente cliente) {
	 view.getIdField().setText(cliente.getId().toString());
	 view.getNomeField().setText(cliente.getNome());
	 view.getCpfField().setText(cliente.getCpf());
 }
 
 public void salvarCliente() {
	 String id = view.getIdField().getText();
	 String nome = view.getNomeField().getText();
	 String cpf = view.getCpfField().getText();
	 if(nome.isBlank()) {
		 Erros.mostrarErro("Nome vazio", view);
		 return;
	 }
	 Cliente cliente = new Cliente(nome,cpf);
	 if(id.isBlank()) {
		 if(!cliente.verificarCpf()) {
			 Erros.mostrarErro("CPF inválido", view);
			 return;
		 }
		if(repository.Buscar(p-> p.getCpf().equals(cliente.getCpf()))){
			Erros.mostrarErro("CPF já cadastrado", view);
			return;
		}
		repository.adicionar(cliente);
	 }else {
		 cliente.setId(Integer.parseInt(id));
		 repository.atualizar(cliente);
	 }
	 montarTabela();
	 limparCampos();
 }
 
 public void excluirCliente() {
	String id = view.getIdField().getText();
	repository.remover(Integer.parseInt(id));
	limparCampos();
	montarTabela();
 }
 
 public void montarTabela() {
		view.getClienteTableModel().setRowCount(0);
		for(Cliente c : repository.listarTodos()) {
			view.getClienteTableModel().addRow(new Object[] {
					c.getId(),
					c.getNome(),
					c.getCpf()});
		}
	}
 public void limparCampos() {
	 view.getIdField().setText("");
	 view.getNomeField().setText("");
	 view.getCpfField().setText("");
	 view.getExcluirButton().setEnabled(false);
 }
}
