package repository;
import model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosRepository {
	
	private static final List<Funcionario> funcionarios = new ArrayList<>();
	private Integer proximoId = 1;
	private static final FuncionariosRepository INSTANCE = new FuncionariosRepository();

	public FuncionariosRepository() {
	}
	
	public static FuncionariosRepository getInstance() {
		return INSTANCE;
	}
}
