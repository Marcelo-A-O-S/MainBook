package Bussines.Services.Interfaces;

import Domain.Models.User;

public interface IUserServices extends IServices<User> {
	User BuscarPorEmail(String email) throws Exception;
	
}
