package Server.ViewModels;

import java.util.ArrayList;
import java.util.List;

public class BookView {
	
	public Integer Codigo;
	public String tituloLivro;
	public List<String> categorias = new ArrayList<String>();
	public String nomeAutor;
	public String editora;
	public String Isbn;
	
	public Integer getCodigo() {
		return Codigo;
	}
	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	public List<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
}    