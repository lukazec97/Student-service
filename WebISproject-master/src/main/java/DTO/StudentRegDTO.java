package DTO;

public class StudentRegDTO
{
	String username;
	String password;
	String firstname;
	String role;
	String lastname;
	String cardnumber;
	UserDTO user;
	
	
	
	public StudentRegDTO() {
	}
	public StudentRegDTO(String username, String password, String firstname, String role, String lastname,
			String cardnumber) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.role = role;
		this.lastname = lastname;
		this.cardnumber = cardnumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	
	
}
