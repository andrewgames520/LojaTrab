package controller;

import java.time.LocalDate;
import java.util.function.Function;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Cliente;
import model.Compra;
import model.FormaPagamento;
import model.ItemCompra;
import model.PagamentoCartao;
import model.PagamentoPix;
import model.Produto;
import model.Status;
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
		 view.getDeletarCarrinhoButton().addActionListener(e->deletarCarrinho());
		 view.getSelecionarButton().addActionListener(e -> calcularTotal());
		 view.getFinalizarButton().addActionListener(e -> finalizarCompra());
		// view.getClienteButton().addActionListener(e-> );
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
					i.setQnt(qnt);
					i.setSubTotal(i.calcularTotal());
				});
			}else {
				compraAtual.getCompras().add(itemCompra);				
			}
			view.getSubtotalLabel().setText("SubTotal: R$ " +  compraAtual.calcularTotal());
			view.getDeletarCarrinhoButton().setEnabled(true);
			view.getFinalizarButton().setEnabled(true);
			 montarTabela();
			 limparCampos();
	 }
	 
	 public void excluirItem() {
			Produto produto= (Produto)view.getProdutoBox().getSelectedItem();
			compraAtual.getCompras().removeIf(i-> i.getiD() == produto.getId());
			view.getSubtotalLabel().setText("SubTotal R$: " +  compraAtual.calcularTotal());
			if(compraAtual.getCompras().isEmpty()) {
				view.getDeletarCarrinhoButton().setEnabled(false);
				view.getFinalizarButton().setEnabled(false);
			}
			limparCampos();
			montarTabela();
		 }
		 
		 public void montarTabela() {
				view.getCarrinhoTableModel().setRowCount(0);
				for(ItemCompra i : compraAtual.getCompras().stream().sorted((i1,i2) -> Double.compare(i2.getSubTotal(),i1.getSubTotal())).toList()) {
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
		 
		 public void deletarCarrinho() {
			 compraAtual.getCompras().clear();
			 montarTabela();
			 view.getSubtotalLabel().setText(("SubTotal: R$"));
			 view.getTotalLabel().setText("Total Final: R$");
			 view.getPagamentoBox().setSelectedIndex(-1);
			 view.getClienteBox().setSelectedIndex(0);
			 view.getDeletarCarrinhoButton().setEnabled(false);
		 }
	
		 public void calcularTotal() {
			 FormaPagamento pagamento;
			 if(view.getPagamentoBox().getSelectedItem().equals("Cartão")) {
				 pagamento = new PagamentoCartao(compraAtual.calcularTotal());
			 }else if(view.getPagamentoBox().getSelectedItem().equals("Pix")){
				 pagamento = new PagamentoPix(compraAtual.calcularTotal());
			 }else {
				 Erros.mostrarErro("Selecione uma forma de pagamento", view);
				 return;
			 }
			 view.getTotalLabel().setText("Total Final: R$ " + pagamento.getTotal());
			 compraAtual.setPagamento(pagamento);
		 }
		 
		 public void finalizarCompra() {
			 Cliente cliente = (Cliente) view.getClienteBox().getSelectedItem();
			 compraAtual.getPagamento().Processar();
			 if(cliente == null) {
				 Erros.mostrarErro("Selecione um cliente", view);
				 return;
			 }
			 compraAtual.setCliente(cliente);
			 compraAtual.setTotal(compraAtual.getPagamento().getTotal());
			 compraAtual.setDataCompra(LocalDate.now());
			 ProdutosRepository.getInstance().comprarProdutos(compraAtual.getCompras());
			 
			 repository.adicionar(compraAtual);
			 this.compraAtual = new Compra();
			 montarTabela();
			 view.getSubtotalLabel().setText("SubTotal: R$ 0.0");
			 view.getTotalLabel().setText("Total Final: R$ 0.0");
			 view.getPagamentoBox().setSelectedIndex(-1);
			 view.getClienteBox().setSelectedIndex(0);
			 view.getDeletarCarrinhoButton().setEnabled(false);
			 view.getFinalizarButton().setEnabled(false);
			 
		 }
}
