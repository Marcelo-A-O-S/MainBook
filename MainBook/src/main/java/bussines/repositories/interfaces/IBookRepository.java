package Bussines.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Domain.Models.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>{

}
