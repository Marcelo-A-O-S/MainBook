package Server.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		.requestMatchers(
				"/css/**",
				"/images/**",
				"/Js/**",
				"/",
				"/about",
				"/login",
				"/register"
				).permitAll()
		.requestMatchers("/signed/**").hasRole("USER")
		.anyRequest().authenticated()
		.and().formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/signed"));
		return http.build();
	}
}
