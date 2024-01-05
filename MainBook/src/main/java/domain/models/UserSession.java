package Domain.Models;

import java.util.ArrayList;
import java.util.List;

public class UserSession {
	public Integer Id;
	public String username;
	public String email;
	public List<Role> roles = new ArrayList<Role>();
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
