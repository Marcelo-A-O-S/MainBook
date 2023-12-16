package Server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import Bussines.Services.UserServices;
import Server.ViewModels.LoginView;
import Server.ViewModels.RegisterView;

@Controller
public class HomeController {
	@Autowired
	private UserServices userServices;
	@GetMapping("/")
	public String Home() {
		return "index";
	}
	@GetMapping("/about")
	public String About() {
		return "about";
	}
	@GetMapping("/team")
	public String Team() {
		return "team";
	}
	@GetMapping("/login")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("login", new LoginView());
        return mv;
	}
	@PostMapping("/login")
	public String Login( LoginView login) {
		return "login";
	}
	@GetMapping("/register")
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("register", new RegisterView());
        return mv;
	}
	@PostMapping("/register")
	public String Register( RegisterView  register) {
		return "register";
	}
}
