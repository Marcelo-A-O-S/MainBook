package Server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Bussines.Services.BookServices;
import Bussines.Services.CategoryServices;
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
	public String Books() {
		
		return "Signed/Books/index";
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
		
		return mv;
	}
}
