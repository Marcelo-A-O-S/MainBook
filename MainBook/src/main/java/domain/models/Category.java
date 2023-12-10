package domain.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class Category {
	public Long Id;
	public String nameCategory;
	@ManyToMany
	public List<Book> books;
}
