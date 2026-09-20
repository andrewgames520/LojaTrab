package repository;

import java.util.List;
import java.util.function.Predicate;

public interface Repositorio<T> {
	
	void adicionar(T item);
	void remover(Integer Id);
	List<T> listarTodos();
	List<T> buscarPorFiltro(Predicate<T> filtro);

}
