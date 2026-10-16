package controller;

import java.util.function.Function;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Compra;
import model.ItemCompra;
import model.Produto;
import repository.ComprasRepository;
import repository.ProdutosRepository;
import utils.Erros;
import view.CompraView;

public class CompraController {
	private CompraView view;
	private ComprasRepository repository;
	private Compra compraAtual;
	
	public CompraController(CompraView view, ComprasRepository repository) {
		this.view = view;
		this.repository = repository;
		this.compraAtual = new Compra();
		configurarEventos();
	}
	
	 public void configurarEventos() {
		 view.getSalvarButton().addActionListener(e->salvarItem());
		 view.getExcluirCarrinhoButton().addActionListener(e->excluirItem());
		 view.getLimparButton().addActionListener(e->limparCampos());
		 view.getCarrinhoTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				carregarItemSelecionado();
				
			}
		});
	 }
	
	 public void carregarItemSelecionado() {
		 int linhaSelecionada = view.getCarrinhoTable().getSelectedRow();
			if(linhaSelecionada == -1) {
				return;
			}
			view.getExcluirCarrinhoButton().setEnabled(true);
			int linhaModelo = view.getCarrinhoTable().convertRowIndexToModel(linhaSelecionada);
			Integer id = (Integer) view.getCarrinhoTable().getValueAt(linhaModelo,0);
			compraAtual.getCompras().stream().filter(i->i.getiD() == id).findFirst().ifPresent(this::preencherCampos);;
		}
	 
	 public void preencherCampos(ItemCompra item) {
		 view.getProdutoBox().setSelectedItem(ProdutosRepository.getInstance().buscarPorFiltro(p -> p.getId() == item.getiD()).getFirst());
		 view.getQntSpinner().setValue(item.getQnt());
	 }
	 public void salvarItem() {
		 Produto produtoSelecionado = (Produto) view.getProdutoBox().getSelectedItem();
		 Integer qnt = (Integer) view.getQntSpinner().getValue();		 
			 
			 ItemCompra itemCompra = new ItemCompra();
			 if(produtoSelecionado == null) {
				 Erros.mostrarErro("Selecione um produto", view);
				 return;
			 }
			 itemCompra.setiD(produtoSelecionado.getId());
			 itemCompra.setNome(produtoSelecionado.getNome());
			 if(produtoSelecionado.getQntDisponivel()<qnt) {
				 Erros.mostrarErro("Não ha " + produtoSelecionado + " suficientes no estoque para realizar a compra", view);
				 return;
			 }
			 itemCompra.setQnt(qnt);
			 itemCompra.setValorUnit(produtoSelecionado.getValor());
			 itemCompra.setSubTotal(itemCompra.calcularTotal());
			if(compraAtual.possuiProduto(itemCompra.getiD())) {
				compraAtual.getCompras().stream().filter(i -> i.getiD() == itemCompra.getiD()).forEach(i ->{
					i.setQnt(qnt + i.getQnt());
					i.setSubTotal(i.calcularTotal());
				});
			}else {
				compraAtual.getCompras().add(itemCompra);				
			}
			Double total =0.;
			compraAtual.getCompras().forEach(i -> total += i.getSubTotal());
			 montarTabela();
			 limparCampos();
	 }
	 
	 public void excluirItem() {
			Produto produto= (Produto)view.getProdutoBox().getSelectedItem();
			compraAtual.getCompras().removeIf(i-> i.getiD() == produto.getId());
			limparCampos();
			montarTabela();
		 }
		 
		 public void montarTabela() {
				view.getCarrinhoTableModel().setRowCount(0);
				for(ItemCompra i : compraAtual.getCompras()) {
					view.getCarrinhoTableModel().addRow(new Object[] {
							i.getiD(),
							i.getNome(),
							i.getQnt(),
							i.getValorUnit(),
							i.getSubTotal()
							});
				}
			}
		 public void limparCampos() {
			 view.getProdutoBox().setSelectedIndex(-1);
			 view.getQntSpinner().setValue(1);
			 view.getExcluirCarrinhoButton().setEnabled(false);
		 }
	
}
