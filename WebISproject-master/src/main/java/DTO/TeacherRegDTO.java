package DTO;

public class TeacherRegDTO
{
	String username;
	String password;
	String firstname;
	String role;
	String lastname;
	String personalid;
	
	
	
	public TeacherRegDTO() {
	}
	public TeacherRegDTO(String username, String password, String firstname, String role, String lastname,
			String personalid) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.role = role;
		this.lastname = lastname;
		this.personalid = personalid;
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
	public String getPersonalid() {
		return personalid;
	}
	public void setPersonalid(String personalid) {
		this.personalid = personalid;
	}
	
	
	
}
