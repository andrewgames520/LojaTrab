package controller;

import utils.Erros;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.FaixaEtaria;
import model.Produto;
import repository.ProdutosRepository;
import view.ProdutoView;

public class ProdutoController {
	private ProdutoView view;
	private ProdutosRepository repository;
	
	public ProdutoController(ProdutoView view, ProdutosRepository repository) {
		super();
		this.view = view;
		this.repository = repository;
		configurarEventos();
	}
	
	public void configurarEventos() {
		this.view.getCadastrarButton().addActionListener(e->salvarProduto());
		this.view.getExcluirButton().addActionListener(e->excluirProduto());
		this.view.getLimparButton().addActionListener(e->limparProdutos());
		this.view.getProdutoTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
					carregarProdutoSelecionado();
			}
		});
		montarTabela();
	}
	
	public void carregarProdutoSelecionado() {
		int linhaSelecionada = view.getProdutoTable().getSelectedRow();
		if(linhaSelecionada == -1) {
			return;
		}
		view.getExcluirButton().setEnabled(true);
		int linhaModelo = view.getProdutoTable().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getProdutoTableModel().getValueAt(linhaModelo,0);
		this.repository.filtrar(p -> p.getId() == id).ifPresent(this::preencherCampos);;
	}
	
	public void preencherCampos(Produto produto) {
		view.getIdField().setText(produto.getId().toString());
		view.getNomeField().setText(produto.getNome());
		view.getFaixaEtariaBox().setSelectedItem(produto.getFaixaEtaria());
		view.getQntSpinner().setValue(produto.getQntDisponivel());
		view.getValorField().setText(Double.toString(produto.getValor()));
		view.getDescricaoField().setText(produto.getDescricao());
	}
	
	public void salvarProduto() {
		
		Double preco;
		String nome = view.getNomeField().getText();
		FaixaEtaria faixaEtaria = (FaixaEtaria) view.getFaixaEtariaBox().getSelectedItem();
		String descricao = view.getDescricaoField().getText();
		Integer qnt = (Integer) view.getQntSpinner().getValue();
		String id = view.getIdField().getText();
		
		if(nome.isBlank()) {
			Erros.mostrarErro("Campo nome esta vazio",view);
			return;
		}
		try {
			preco = Double.parseDouble(view.getValorField().getText());
			if(preco <=0) {
				Erros.mostrarErro("O preço do " + nome +" não pode ser menor que zero", view);
				return;
			}
		}catch(Exception e){
			Erros.mostrarErro("Campo preço inválido", view);
			return;
		}
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setQntDisponivel(qnt);
		produto.setDescricao(descricao);
		produto.setFaixaEtaria(faixaEtaria);
		produto.setValor(preco);
		if(id.isBlank()) {
			if(repository.Buscar( p-> p.getNome().equals(nome))) {
					Erros.mostrarErro("Produto ja existente", view);
					return;
				}
				
			repository.adicionar(produto);			
		}else {
			produto.setId(Integer.parseInt(id));
			repository.atualizar(produto);
		}
		
		montarTabela();
		limparProdutos();
	}
	
	public void excluirProduto() {
		String id = view.getIdField().getText();
		repository.remover(Integer.parseInt(id));
		limparProdutos();
		montarTabela();
	}
	
	public void montarTabela() {
		view.getProdutoTableModel().setRowCount(0);
		for(Produto p : repository.listarTodos()) {
			view.getProdutoTableModel().addRow(new Object[] {
					p.getId(),
					p.getNome(),
					p.getQntDisponivel(),
					p.getFaixaEtaria(),
					p.getValor(),
					p.getDescricao()});
		}
	}
	
	public void limparProdutos() {
		view.getIdField().setText("");
		view.getNomeField().setText("");
		view.getQntSpinner().setValue(1);
		view.getFaixaEtariaBox().setSelectedIndex(0);
		view.getValorField().setText("");
		view.getDescricaoField().setText("");
		
	}
}
