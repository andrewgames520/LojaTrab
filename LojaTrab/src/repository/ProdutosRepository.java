package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
	
}
