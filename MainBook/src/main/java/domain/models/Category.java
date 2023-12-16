package Domain.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Table(name = "categories")
@Data

public class Category {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer Id;
	public String nameCategory;
	@ManyToMany(mappedBy = "categories")
	public List<Book> books = new ArrayList<Book>();
	public Category() {
		
	}
	public Category(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public Category(Integer id, String nameCategory, List<Book> books) {
		this.Id = id;
		this.nameCategory = nameCategory;
		this.books = books;
	}
	public Category(Integer id, String nameCategory) {
		this.Id = id;
		this.nameCategory = nameCategory;
	}

	public Integer getId() {
		return this.Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
