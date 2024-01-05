package Bussines.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Domain.Models.Role;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{
	@Query("select r from Role r where r.roleName = :roleName")
	Role findByRoleName(String roleName);
}
