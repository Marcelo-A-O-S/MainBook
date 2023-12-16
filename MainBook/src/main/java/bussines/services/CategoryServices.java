package Bussines.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import Bussines.Repositories.Interfaces.ICategoryRepository;
import Bussines.Services.Interfaces.ICategoryServices;
import Domain.Models.Category;
@Service
public class CategoryServices implements ICategoryServices {
	
	private ICategoryRepository categoryRepository;
	
	public CategoryServices(ICategoryRepository cr) {
		this.categoryRepository = cr;
	}
	@Override
	public void salvar(Category entidade) {
		// TODO Auto-generated method stub
		if(entidade.Id == 0) {
			this.categoryRepository.save(entidade);
		}else {
			this.categoryRepository.save(entidade);
		}
		
	}

	@Override
	public Category buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id).get();
	}

	@Override
	public List<Category> listar() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	@Override
	public void deletar(Category entidade) {
		// TODO Auto-generated method stub
		this.categoryRepository.delete(entidade);
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.categoryRepository.deleteById(id);
	}

	@Override
	public void atualzar(Category entidade) {
		// TODO Auto-generated method stub
		this.categoryRepository.save(entidade);
	}

}
