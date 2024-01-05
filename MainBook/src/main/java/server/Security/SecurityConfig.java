package Server.Security;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import Bussines.Services.UserServices;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserServices userServices;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServices).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
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
				"/register",
				"/registerUser"
				).permitAll()
		.requestMatchers("/signed/**").hasAnyRole("USER", "ADMIN")
		.anyRequest().authenticated()
		.and().formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/signed")
				.failureUrl("/login?erro=true")
				.permitAll()
				)
		.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()).exceptionHandling()
        .accessDeniedPage("/error")
        ; 
				
		return http.build();
	}
}
