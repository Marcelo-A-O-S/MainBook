package Bussines.Services.Interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ICustomUserDetailsServices extends UserDetailsService {
	UserDetails LoadByEmail(String email);
}
