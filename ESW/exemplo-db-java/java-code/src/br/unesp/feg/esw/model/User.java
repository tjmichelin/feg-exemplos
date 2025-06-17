package br.unesp.feg.esw.model;

public class User {
	private int id;
	private String username;
	private String name;
	private String email;
	private String password;
	
	public User() {
		this.id = 0;
		this.username = null;
		this.name = null;
		this.email = null;
		this.password = null;
	}
	
	public User(String userName, String name, String email, String password) {
		this.username = userName;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("ID: ");
		str.append(this.id);
		str.append("\n");
		str.append("Name: ");
		str.append(this.name);
		str.append("\n");
		str.append("Username: ");
		str.append(this.username);
		str.append("\n");
		str.append("E-Mail: ");
		str.append(this.email);
		str.append("\n");
		str.append("Password: ");
		str.append(this.password);
		str.append("\n");
		
		return str.toString();
	}
}
