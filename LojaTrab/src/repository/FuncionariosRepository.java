package repository;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FuncionariosRepository implements Repositorio<Funcionario> {
	
	private final List<Funcionario> funcionarios = new ArrayList<>();
	private Integer proximoId = 1;
	private static final FuncionariosRepository INSTANCE = new FuncionariosRepository();

	private FuncionariosRepository() {
	}
	
	public static FuncionariosRepository getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void adicionar(Funcionario funcionario) {
		funcionario.setId(proximoId);
		proximoId++;
		funcionarios.add(funcionario);
	}
	
	@Override
	public void remover(Integer Id) {
		this.funcionarios.removeIf(f-> f.getId()==Id);
	}
	
	@Override
	public List<Funcionario> buscarPorFiltro(Predicate<Funcionario> regra) {
		return this.funcionarios.stream().filter(regra).toList();
	}
	
	@Override
	public List<Funcionario>listarTodos(){
		return this.funcionarios;
	}
	
	public Optional<Funcionario> filtrar(Predicate<Funcionario> regra){
		return this.listarTodos().stream().filter(regra).findFirst();
	}
	public Boolean Buscar(Predicate<Funcionario> regra){
		
		Optional<Funcionario> resultado = getInstance().listarTodos().stream().filter(regra).findFirst();
		if (resultado.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public void atualizar(Funcionario funcionario) {
		this.listarTodos().replaceAll(p-> p.getId() == funcionario.getId() ? funcionario : p);
	}
}
