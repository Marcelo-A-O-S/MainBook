package Bussines.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Bussines.Repositories.Interfaces.IUserRepository;
import Bussines.Services.Interfaces.IUserServices;
import Domain.Models.User;
@Service
public class UserServices implements IUserServices {
	
	private IUserRepository userRepository;
	public UserServices(IUserRepository _repository) {
		this.userRepository = _repository;
	}
	@Override
	public void salvar(User entidade) {
		// TODO Auto-generated method stub
		if(entidade.Id.equals(0)) {
			this.userRepository.save(entidade);
		}else {
			this.userRepository.save(entidade);
		}
	}

	@Override
	public User buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepository.findById(id);
		return user.get();
	}

	@Override
	public List<User> listar() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public void deletar(User entidade) {
		// TODO Auto-generated method stub
		this.userRepository.delete(entidade);
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}

	@Override
	public void atualzar(User entidade) {
		// TODO Auto-generated method stub
		this.userRepository.save(entidade);
	}

}
