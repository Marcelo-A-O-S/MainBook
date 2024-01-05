package Server;

import java.util.ArrayList;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Bussines.Services.BookServices;
import Bussines.Services.CategoryServices;
import Bussines.Services.RoleServices;
import Bussines.Services.UserServices;
import Domain.Models.Category;
import Domain.Models.Role;
import Domain.Models.User;

@EnableJpaRepositories(basePackages = "Bussines.Repositories.Interfaces")
@EntityScan(basePackages = {"Domain.Models", "Bussines.Services", "Bussines.Repositories.Interfaces"})
@ComponentScan(basePackages = {"Bussines.Services", "Bussines.Services.Interfaces", "Server.Controllers", "Bussines.Repositories", "Bussines.Repositories.Interfaces"})
@SpringBootApplication
public class MainBookApplication{

	public static void main(String[] args) {
		SpringApplication.run(MainBookApplication.class, args);
	}

	@Bean
	public CommandLineRunner Initialize(
			CategoryServices cs, RoleServices rs, UserServices us) {
		return args ->{
			List<Category> cat = cs.listar();
			if(cat.size() == 0) {
				List<Category> categories = new ArrayList<Category>();
				categories.add(new Category(0,"Romance"));
				categories.add(new Category(0,"Ficção Cientifica"));
				categories.add(new Category(0,"Mistério"));
				categories.add(new Category(0,"Fantasia"));
				categories.add(new Category(0,"Não Ficção"));
				categories.add(new Category(0,"História"));
				categories.add(new Category(0,"Biografia"));
				categories.add(new Category(0,"Autobiografia"));
				categories.add(new Category(0,"Poesia"));
				categories.add(new Category(0,"Clássicos"));
				categories.add(new Category(0,"Autoajuda"));
				categories.add(new Category(0,"Psicologia"));
				categories.add(new Category(0,"Filosofia"));
				categories.add(new Category(0,"Ciência"));
				categories.add(new Category(0,"Política"));
				categories.add(new Category(0,"Aventura"));
				categories.add(new Category(0,"Suspense"));
				categories.add(new Category(0,"Horror"));
				categories.add(new Category(0,"Humor"));
				categories.add(new Category(0,"Contos de Fadas"));
				for(Category category: categories) {
					cs.salvar(category);
				}
			}
			List<Role> rolelist = rs.listar();
			if(rolelist.size() == 0) {
				List<Role> roles = new ArrayList<Role>();
				roles.add(new Role(0,"USER"));
				roles.add(new Role(0,"ADMIN"));
				for(Role role:roles) {
					rs.salvar(role);
				}
			}
			List<User> userlist = us.listar();
			if(userlist.size() == 0) {
				List<User> users = new ArrayList<User>();
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				Role roleAdmin = rs.findByRoleName("ADMIN");
				Role roleUser = rs.findByRoleName("USER");
				users.add(new User(0,"usuario","usuario@usuario.com",passwordEncoder.encode("123"), true, roleUser));
				users.add(new User(0,"usuarioDesativado","usuarioDesativado@usuario.com",passwordEncoder.encode("123"), false, roleUser));
				users.add(new User(0,"admin", "admin@admin.com",passwordEncoder.encode("123"), true, roleAdmin));
				for(User user:users) {
					us.salvar(user);
				}
			}
					
			
		};
	}


}
