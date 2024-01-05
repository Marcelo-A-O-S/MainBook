package Bussines.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Domain.Models.Post;
@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {

}
