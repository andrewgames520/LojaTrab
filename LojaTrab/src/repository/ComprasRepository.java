package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import model.Compra;


public class ComprasRepository implements Repositorio<Compra> {
	private final List<Compra> compras = new ArrayList<>();
	private Integer proximoId = 1;
	private static final ComprasRepository INSTANCE = new ComprasRepository();

	private ComprasRepository() {
		
	}
	
	public static ComprasRepository getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void adicionar(Compra compra) {
		compra.setId(proximoId);
		proximoId++;
		compras.add(compra);
	}
	
	@Override
	public void remover(Integer Id) {
		this.compras.removeIf(f-> f.getId()==Id);
	}
	
	@Override
	public List<Compra> buscarPorFiltro(Predicate<Compra> regra) {
		return this.compras.stream().filter(regra).toList();
	}
	
	@Override
	public List<Compra>listarTodos(){
		return this.compras;
	}
	
	public Optional<Compra> filtrar(Predicate<Compra> regra){
		return this.listarTodos().stream().filter(regra).findFirst();
	}
	public Boolean Buscar(Predicate<Compra> regra){
		
		Optional<Compra> resultado = getInstance().listarTodos().stream().filter(regra).findFirst();
		if (resultado.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public void atualizar(Compra compra) {
		this.listarTodos().replaceAll(p-> p.getId() == compra.getId() ? compra : p);
	}
}
