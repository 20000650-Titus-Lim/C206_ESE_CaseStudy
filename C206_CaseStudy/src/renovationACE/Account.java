package renovationACE;

public class Account {
	private String name;
	private String role;
	private String email;
	private String password;
	private String status;
	
	
	
	
	public Account(String name, String role, String email, String password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.status = "New";
	}




	public String getName() {
		return name;
	}




	public String getRole() {
		return role;
	}




	public String getEmail() {
		return email;
	}




	public String getPassword() {
		return password;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
