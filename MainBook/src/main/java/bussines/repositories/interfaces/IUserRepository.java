package Bussines.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Domain.Models.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.email = :email")
	User findByEmail(String email);
	@Query("select u from User u where u.userName = :username")
	User findByUsername(String username);
    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.id = :userId")
    User findUserWithRoles(Integer userId);
}
