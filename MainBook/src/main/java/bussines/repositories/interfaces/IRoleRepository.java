package Bussines.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Domain.Models.Role;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{

}
