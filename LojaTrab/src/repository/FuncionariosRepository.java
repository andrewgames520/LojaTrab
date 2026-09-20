package repository;
import model.Funcionario;
import java.util.ArrayList;
import java.util.List;
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
}
