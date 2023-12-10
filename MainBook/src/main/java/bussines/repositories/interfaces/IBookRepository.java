package bussines.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.models.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

}
