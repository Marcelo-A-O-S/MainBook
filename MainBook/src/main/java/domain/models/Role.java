package Domain.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String roleName;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	public List<User> users = new ArrayList<User>();
	public Role(Integer id, String _roleName) {
		this.Id = id;
		this.roleName = _roleName;
	}
	public Integer getId() {
		return this.Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
