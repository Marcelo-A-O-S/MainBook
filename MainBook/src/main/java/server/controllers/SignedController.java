package Server.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

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
	public ModelAndView Books(@ModelAttribute("sucess") String sucess, @ModelAttribute("erro") String erro) {
		ModelAndView mv = new ModelAndView();
		List<Book> books = bs.listar();
		if(sucess != null && !sucess.isEmpty()) {
			mv.addObject("sucess", sucess);
		}else {
			mv.addObject("sucess", null);
		}
		if(erro != null && !erro.isEmpty()) {
			mv.addObject("erro", erro);
		}else {
			mv.addObject("erro", null);
		}
		mv.addObject("books", books);
		mv.setViewName("Signed/Books/index");
		return mv;
	}
	@GetMapping("info")
	public ModelAndView InfoBook(@RequestParam(required = true) Integer param) {
		ModelAndView mv = new ModelAndView();
		Book infoBook = bs.buscarPorId(param);
		if(infoBook != null) {
			mv.addObject("infoBook", infoBook);
			mv.setViewName("Signed/Books/info");
			return mv;
		}
		mv.addObject("erro", "Não existe livro com essa identificação");
		mv.setViewName("Signed/Books/index");
		return mv;
	}
	@GetMapping("delete")
	public ModelAndView DeleteBookParamId(@RequestParam(required = true) Integer param, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView();
		Book book = bs.buscarPorId(param);
		if(book != null) {
			bs.deletar(book);
			mv.setViewName("redirect:/signed/books");
			redirect.addFlashAttribute("sucess", "Livro deletado com sucesso!");
			return mv;

		}
		mv.addObject("erro", "Não existe livro com essa identificação");
		mv.setViewName("Signed/Books/index");
		return mv;
	}

	/*
	 * @DeleteMapping("delete") public ModelAndView
	 * DeleteBookParamId(@RequestParam(required = true) Integer param) {
	 * ModelAndView mv = new ModelAndView(); Book book = bs.buscarPorId(param);
	 * if(book != null) { bs.deletar(book); mv.addObject("sucess",
	 * "Deletado com sucesso!"); mv.setViewName("Signed/Books/index"); return mv; }
	 * mv.addObject("erro", "Não existe livro com essa identificação");
	 * mv.setViewName("Signed/Books/index"); return mv; }
	 */
	@DeleteMapping("delete/{id}")
	public ModelAndView DeleteBookPathId(@PathVariable(required = true) Integer id) {
		ModelAndView mv = new ModelAndView();
		Book book = bs.buscarPorId(id);
		if(book != null) {
			bs.deletar(book);
			mv.addObject("sucess", "Deletado com sucesso!");
			mv.setViewName("Signed/Books/index");
			return mv;
		}
		mv.addObject("erro", "Não existe livro com essa identificação");
		mv.setViewName("Signed/Books/index");
		return mv;
	}
	@GetMapping("create")
	public ModelAndView Form(@ModelAttribute("sucess") String sucess, @ModelAttribute("erro") String erro, @RequestParam(required = false) Integer param) {
		ModelAndView mv = new ModelAndView();
		if(sucess != null && !sucess.isEmpty()) {
			mv.addObject("sucess", sucess);
		}else {
			mv.addObject("sucess", null);
		}
		if(erro != null && !erro.isEmpty()) {
			mv.addObject("erro", erro);
		}else {
			mv.addObject("erro", null);
		}
		BookView bv = new BookView();
		List<Category> categories = cs.listar();
		if(param != null) {
			Book book = bs.buscarPorId(param);
			List<String> categoriesName = new ArrayList<String>();
			for(Category category:book.categories) {
				categoriesName.add(category.nameCategory);
			}
			bv.setCategorias(categoriesName);
			bv.setCodigo(book.getCodigo());
			bv.setEditora(book.getEditora());
			bv.setNomeAutor(book.getNomeAutor());
			bv.setTituloLivro(book.getTituloLivro());
			bv.setIsbn(book.getIsbn());
			mv.addObject("bookModel", bv);
			mv.addObject("categories",categories);
			mv.setViewName("Signed/Books/create");
			return mv;
		}
		
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
			for(String categoryName :bv.categorias ) {
				Category category = cs.buscarPorNomeCategoria(categoryName);
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
	@PostMapping("update")
	public ModelAndView UpdateBook(BookView bv, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView();
		List<Category> categories = new ArrayList<Category>();
		Book book = bs.buscarPorId(bv.getCodigo());
		if(book != null) {
			book.setEditora(bv.getEditora());
			book.setNomeAutor(bv.getNomeAutor());
			book.setIsbn(bv.getIsbn());
			book.setTituloLivro(bv.getTituloLivro());
			book.setCodigo(bv.getCodigo());
			for(String categoryName: bv.getCategorias()) {
				Category category = cs.buscarPorNomeCategoria(categoryName);
				categories.add(category);
			}
			book.setCategories(categories);
			bs.salvar(book);
			mv.setViewName("redirect:/signed/books");
			redirect.addFlashAttribute("sucess", "Livro atualizado com sucesso!");
			return mv;
		}
		mv.addObject("bookModel", bv);
		categories = cs.listar();
		mv.addObject("categories",categories);
		mv.addObject("erro", "Erro ao encontrar o Livro!");
		mv.setViewName("Signed/Books/create");
		return mv;
	}
}
