package Bussines.Services.Interfaces;

import Domain.Models.Book;

public interface IBookServices extends IServices<Book>{
	Book buscarPorAutor(String autor);
	Book buscarPorIsbn(String isbn);
	Book buscarPorTitulo(String titulo);
}
