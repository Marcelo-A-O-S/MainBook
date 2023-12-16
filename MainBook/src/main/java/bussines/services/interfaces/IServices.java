package Bussines.Services.Interfaces;

import java.util.List;

public interface IServices<T>{
	void salvar(T entidade);
	T buscarPorId(Integer id);
	List<T> listar();
	void deletar(T entidade);
	void deletarPorId(Integer id);
	void atualzar(T entidade);
	
}
