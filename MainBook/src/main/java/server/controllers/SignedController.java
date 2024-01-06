package Server.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Bussines.Services.BookServices;
import Bussines.Services.CategoryServices;
import Domain.Models.Book;
import Domain.Models.Category;
import Server.ViewModels.BookView;

@Controller
@RequestMapping("/signed")
public class SignedController {
	@Autowired
	private CategoryServices cs;
	@Autowired
	private BookServices bs;
	
	@GetMapping
	public String index() {
		return "Signed/index";
	}
	@GetMapping("books")
	public ModelAndView Books() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Signed/Books/index");
		return mv;
	}
	@GetMapping("create")
	public ModelAndView Form() {
		ModelAndView mv = new ModelAndView();
		List<Category> categories = cs.listar();
		BookView bv = new BookView();

		mv.addObject("bookModel", bv);
		mv.addObject("categories",categories);
		mv.setViewName("Signed/Books/create");
		return mv;
	}
	@PostMapping("create")
	public ModelAndView CreateBook(BookView bv) {
		ModelAndView mv = new ModelAndView();
		List<Category> categories = new ArrayList<Category>();
		Book book = bs.buscarPorIsbn(bv.getIsbn());
		if(book == null) {
			book = new Book();
			book.setCodigo(0);
			book.setEditora(bv.getEditora());
			book.setIsbn(bv.getIsbn());
			book.setNomeAutor(bv.getNomeAutor());
			book.setTituloLivro(bv.getTituloLivro());
			for(String cat :bv.categorias ) {
				Category category = cs.buscarPorNomeCategoria(cat);
				categories.add(category);
			}
			book.setCategories(categories);
			bs.salvar(book);
			mv.addObject("bookModel", bv);
			categories = cs.listar();
			mv.addObject("categories",categories);
			mv.addObject("sucess", "Salvo com sucesso");
			mv.setViewName("Signed/Books/create");
			return mv;
		}
		mv.addObject("bookModel", bv);
		categories = cs.listar();
		mv.addObject("categories",categories);
		mv.addObject("erro", "Código isbn inválido");
		mv.setViewName("Signed/Books/create");
		return mv;
	}
}
