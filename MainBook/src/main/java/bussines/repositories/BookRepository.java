package bussines.repositories;

import bussines.repositories.interfaces.IBookRepository;

public class BookRepository {
	public IBookRepository book;
	public BookRepository(IBookRepository _book) {
		this.book = _book;
	}
}
