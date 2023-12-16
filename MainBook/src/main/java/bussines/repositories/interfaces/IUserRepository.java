package Bussines.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import Domain.Models.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
