package Bussines.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import Bussines.Repositories.Interfaces.IRoleRepository;
import Bussines.Services.Interfaces.IRoleServices;
import Domain.Models.Role;
@Service
public class RoleServices implements IRoleServices {
	private IRoleRepository roleRepository;
	public RoleServices(IRoleRepository repository) {
		this.roleRepository = repository;
	}
	@Override
	public void salvar(Role entidade) {
		// TODO Auto-generated method stub
		if(entidade.getId() == 0) {
			this.roleRepository.save(entidade);
		}else {
			this.roleRepository.save(entidade);
		}
	}

	@Override
	public Role buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.roleRepository.findById(id).get();
	}

	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		return this.roleRepository.findAll();
	}

	@Override
	public void deletar(Role entidade) {
		// TODO Auto-generated method stub
		this.roleRepository.delete(entidade);
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.roleRepository.deleteById(id);
	}

	@Override
	public void atualzar(Role entidade) {
		// TODO Auto-generated method stub
		this.roleRepository.save(entidade);
	}
	@Override
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return this.roleRepository.findByRoleName(roleName);
	}

}
