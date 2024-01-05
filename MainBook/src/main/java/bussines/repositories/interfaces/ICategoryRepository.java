package Bussines.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Domain.Models.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category , Integer>{
	@Query("select c from Category c where c.nameCategory = :nameCategory")
	Category findByNameCategory(String nameCategory);
}
