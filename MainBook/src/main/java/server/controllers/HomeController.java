package Server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Bussines.Services.RoleServices;
import Bussines.Services.UserServices;
import Domain.Models.Role;
import Domain.Models.User;
import Server.ViewModels.LoginView;
import Server.ViewModels.RegisterView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private UserServices userServices;
	@Autowired
	private RoleServices roleServices;
	@GetMapping
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
	@ResponseBody
	public ModelAndView Login(@RequestBody LoginView login ,HttpServletRequest request,
            HttpServletResponse response) throws Exception{
		System.out.println("Passou por aqui!");
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("email");
	    String password = request.getParameter("password");
		User user = this.userServices.BuscarPorEmail(login.getEmail());
		if(user == null) {
			mv.addObject("login", login);
			mv.addObject("msgError", "Dados inválidos, corrija e tente novamente!");
			mv.setViewName("login");
			return mv;
		}
		mv.setViewName("redirect:/signed");
		return mv;
	}
	@GetMapping("/register")
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("register", new RegisterView());
        return mv;
	}
	@PostMapping("/register")
	public ModelAndView Register( RegisterView  register) throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = this.userServices.BuscarPorEmail(register.getEmail());
		if(user != null) {
			mv.addObject("register", register);
			mv.addObject("msgError", "O Email já foi cadastrado, faça login ou insira outro email e tente novamente!");
			mv.setViewName("register");
			return mv;
		}
		Role roleUser = this.roleServices.findByRoleName("USER");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user = new User(0, register.username, register.email,passwordEncoder.encode(register.password), true, roleUser);
		this.userServices.salvar(user);
		mv.setViewName("redirect:/login");
		return mv;
	}
	@GetMapping("/Logout")
	public ModelAndView Logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("usersession");
		mv.setViewName("redirect:/logout");
		return mv;
	}
}
