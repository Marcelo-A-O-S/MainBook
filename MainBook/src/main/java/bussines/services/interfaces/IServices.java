package bussines.services.interfaces;

import java.util.List;

public interface IServices<T>{
	void salvar(T entidade);
	T buscarPorId(Long id);
	List<T> listar();
	void deletar(T entidade);
	void deletarPorId(Long id);
	void atualzar(T entidade);
	
}
