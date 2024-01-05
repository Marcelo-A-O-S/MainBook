package Bussines.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Bussines.Repositories.Interfaces.IPostRepository;
import Bussines.Services.Interfaces.IPostServices;
import Domain.Models.Post;
@Service
public class PostServices implements IPostServices{
	private IPostRepository postRepository;
	public PostServices(IPostRepository _postRepository) {
		this.postRepository = _postRepository;
	}
	@Override
	public void salvar(Post entidade) {
		// TODO Auto-generated method stub
		if(entidade.getId() == 0) {
			this.postRepository.save(entidade);
		}else {
			this.postRepository.save(entidade);
		}
	}

	@Override
	public Post buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Post> post =  this.postRepository.findById(id);
		return post.get();
	}

	@Override
	public List<Post> listar() {
		// TODO Auto-generated method stub
		return this.postRepository.findAll();
	}

	@Override
	public void deletar(Post entidade) {
		// TODO Auto-generated method stub
		this.postRepository.delete(entidade);
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.postRepository.deleteById(id);
	}

	@Override
	public void atualzar(Post entidade) {
		// TODO Auto-generated method stub
		this.postRepository.save(entidade);
	}

}
