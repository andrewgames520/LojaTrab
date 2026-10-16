package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import model.ItemCompra;
import model.Produto;

public class ProdutosRepository implements Repositorio<Produto>{
	private final List<Produto> produtos = new ArrayList<>();
	private Integer proximoId =1;
	private static final ProdutosRepository INSTANCE = new ProdutosRepository();
	
	private ProdutosRepository() {
	}
	
	public static ProdutosRepository getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void adicionar(Produto produto) {
		produto.setId(proximoId);
		proximoId++;
		produtos.add(produto);
	}
	
	@Override
	public void remover(Integer Id) {
		this.produtos.removeIf(p-> p.getId()==Id);
	}
	
	@Override
	public List<Produto> buscarPorFiltro(Predicate<Produto> regra) {
		return this.produtos.stream().filter(regra).toList();
	}
	
	@Override
	public List<Produto>listarTodos(){
		return this.produtos;
	}
	
	public Optional<Produto> filtrar(Predicate<Produto> regra){
		return this.listarTodos().stream().filter(regra).findFirst();
	}
	public Boolean Buscar(Predicate<Produto> regra){
		
		Optional<Produto> resultado = getInstance().listarTodos().stream().filter(regra).findFirst();
		if (resultado.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public void atualizar(Produto produto) {
		this.listarTodos().replaceAll(p-> p.getId() == produto.getId() ? produto : p);
	}
	
	public void comprarProdutos(List<ItemCompra> comprados) {
		for (ItemCompra itemCompra : comprados) {
			this.buscarPorFiltro(p -> p.getId() == itemCompra.getiD()).forEach(p -> p.setQntDisponivel(p.getQntDisponivel()-itemCompra.getQnt()));
		}
	}
	public void devolverProdutos(List<ItemCompra> comprados) {
		for (ItemCompra itemCompra : comprados) {
			this.buscarPorFiltro(p -> p.getId() == itemCompra.getiD()).forEach(p -> p.setQntDisponivel(p.getQntDisponivel()+itemCompra.getQnt()));
		}
	}
}
