package Bussines.Services;

import java.util.List;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Bussines.Repositories.Interfaces.IBookRepository;
import Bussines.Services.Interfaces.IBookServices;
import Domain.Models.Book;
@Service
public class BookServices implements IBookServices{
	private  IBookRepository bookRepository;
	public BookServices(IBookRepository _bookRepository) {
		this.bookRepository = _bookRepository;
	}
	@Override
	public void salvar(Book entidade) {
		// TODO Auto-generated method stub
		if(entidade.codigo == 0) {
			this.bookRepository.save(entidade);
		}else {
			this.bookRepository.save(entidade);
		}
		
	}
	@Override
	public Book buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Book> book = this.bookRepository.findById(id);
		return book.get();
	}
	@Override
	public List<Book> listar() {
		// TODO Auto-generated method stub
		List<Book> books = this.bookRepository.findAll();
		return books;
	}
	@Override
	public void deletar(Book entidade) {
		// TODO Auto-generated method stub
		this.bookRepository.delete(entidade);
		
	}
	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.bookRepository.deleteById(id);
	}
	@Override
	public void atualzar(Book entidade) {
		// TODO Auto-generated method stub
		this.bookRepository.save(entidade);
	}
}
