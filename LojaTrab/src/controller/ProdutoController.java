package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.FaixaEtaria;
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
		this.view.getCadastrarButton().addActionListener(e->cadastrarProduto());
		this.view.getExcluirButton().addActionListener(e->excluirProduto());
		this.view.getAtualizarButton().addActionListener(e->atualizarProduto());
		this.view.getLimparButton().addActionListener(e->limparProdutos());
		
		/*
		this.view.getProdutoTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
				carregarProdutoSelecionado
			}
		});
		*/
	}
	
	public void cadastrarProduto() {
		System.out.println("cadastrado");
		String nome = view.getNomeField().getText();
		Integer qnt = Integer.parseInt(view.getQntDisponivelField().getText());
		FaixaEtaria faixaEtaria = (FaixaEtaria)view.getFaixaEtariaBox().getSelectedItem();
		Double preco = Double.parseDouble(view.getValorField().getText());
		String descricao = view.getDescricaoField().getText();
		
		System.out.println(preco);
		
		
	}
	
	public void excluirProduto() {
		System.out.println("excluido");
	}
	
	public void atualizarProduto() {
		System.out.println("atualizado");
	}
	
	public void limparProdutos() {
		System.out.println("limpo");
		
	}
}
