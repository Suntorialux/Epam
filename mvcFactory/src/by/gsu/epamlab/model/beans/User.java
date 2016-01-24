package by.gsu.epamlab.model.beans;

public class User {
	private String name;
	private Role role;
	public User() {
		super();
	}
	public User(String name, Role role) {
		super();
		this.name = name;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
