package Bussines.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import Bussines.Repositories.Interfaces.IUserRepository;
import Bussines.Services.Interfaces.ICustomUserDetailsServices;
import Bussines.Services.Interfaces.IUserServices;
import Domain.Models.User;
import Domain.Models.UserSession;
import jakarta.servlet.http.HttpSession;
@Service
public class UserServices implements IUserServices, ICustomUserDetailsServices{
	private RoleServices rolesServices;
	private IUserRepository userRepository;
	public UserServices(IUserRepository _repository, RoleServices rolesServices) {
		this.userRepository = _repository;
		this.rolesServices = rolesServices;
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
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByEmail(email);
		 if (user == null) {
		        throw new UsernameNotFoundException("User not found with email: " + email);
		    }else if(user != null && user.isEnabled()) {
		    	user = this.userRepository.findUserWithRoles(user.Id);
		    	user.getAuthorities();
	            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	            UserSession userSession = new UserSession();
	            HttpSession session = attributes.getRequest().getSession(true);
	            userSession.setId(user.getId());
	            userSession.setEmail(user.getEmail());
	            userSession.setUsername(user.getUsername());
	            userSession.setRoles(user.getRoles());
	            session.setAttribute("usersession", userSession);
		    }
		return user;
	}
	@Override
	public UserDetails LoadByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}
	@Override
	public User BuscarPorEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}

}
