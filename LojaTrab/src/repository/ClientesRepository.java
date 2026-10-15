package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import model.Cliente;

public class ClientesRepository implements Repositorio<Cliente> {
	private final List<Cliente> clientes = new ArrayList<>();
	private Integer proximoId =1;
	private static final ClientesRepository INSTANCE = new ClientesRepository();
	
	private ClientesRepository() {
	}
	
	public static ClientesRepository getInstance() {
		return INSTANCE;
	}
	
	
	@Override
	public void adicionar(Cliente cliente) {
		cliente.setId(proximoId);
		proximoId++;
		clientes.add(cliente);
	}
	
	@Override
	public void remover(Integer Id) {
		this.clientes.removeIf(cliente -> cliente.getId() == Id);
	}
	
	@Override
	public List<Cliente> buscarPorFiltro(Predicate<Cliente> regra) {
		return this.clientes.stream().filter(regra).toList();
	}
	
	@Override
	public List<Cliente>listarTodos(){
		return this.clientes;
	}
	
	public Optional<Cliente> filtrar(Predicate<Cliente> regra){
		return this.listarTodos().stream().filter(regra).findFirst();
	}
	public Boolean Buscar(Predicate<Cliente> regra){
		
		Optional<Cliente> resultado = getInstance().listarTodos().stream().filter(regra).findFirst();
		if (resultado.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public void atualizar(Cliente cliente) {
		this.listarTodos().replaceAll(p-> p.getId() == cliente.getId() ? cliente : p);
	}
}
