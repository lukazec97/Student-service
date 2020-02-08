package DTO;

public class AdministratorDTO {
	
	private String firstName;
	
	private String lastName;
	
	private UserDTO user;

	public AdministratorDTO(String firstName, String lastName, UserDTO user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	

}
