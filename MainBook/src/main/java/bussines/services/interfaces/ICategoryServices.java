package Bussines.Services.Interfaces;

import Domain.Models.Category;

public interface ICategoryServices extends IServices<Category>{
	Category buscarPorNomeCategoria(String nomeCategoria);
}
