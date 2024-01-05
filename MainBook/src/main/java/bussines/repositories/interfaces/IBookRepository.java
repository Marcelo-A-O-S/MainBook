package Bussines.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Domain.Models.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>{
	@Query("select b from Book b where b.Isbn = :isbn")
	Book findByISBN(String isbn);
	
	@Query("select b from Book b where b.tituloLivro = :tituloLivro")
	Book findByTituloLivro(String tituloLivro);
	
	@Query("select b from Book b where b.nomeAutor = :nomeAutor")
	Book findByNomeAutor(String nomeAutor);
}
