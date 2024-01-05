package Domain.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer Id;
	public String userName;
	public String email;
	public String password;
	public boolean enable;
	@ManyToMany
	@JoinTable(
			name = "user_roles",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "Id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "Id")}
			)
	public List<Role> roles = new ArrayList<Role>();
	public User(Integer id, String userName, String email, String password) {
		this.Id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	public User(Integer id, String userName, String email, String password, boolean enable, Role role) {
		this.Id = id;
		this.userName = userName;
		this.email = email;
		this.enable = enable;
		this.password = password;
		this.roles.add(role);
	}
	public User() {
		
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEnable(boolean isEnable) {
		this.enable = isEnable;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enable;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setRole(Role role) {
		this.roles.add(role);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
		List<Role> roles = this.getRoles();
		for(Role role: roles) {
			listAuthorities.add(new SimpleGrantedAuthority("ROLE_"+ role.getRoleName()));
		}
		return listAuthorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

}
