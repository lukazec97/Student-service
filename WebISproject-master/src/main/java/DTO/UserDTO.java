package DTO;

import java.util.Set;

public class UserDTO {
	
	private Long id;

	private String username;

	private String password;
	
	private String role;

	private Set<UserPermissionDTO> userPermissions;

	public UserDTO(Long id, String username, String password, String role, Set<UserPermissionDTO> userPermissions) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.userPermissions = userPermissions;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserPermissionDTO> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<UserPermissionDTO> userPermissions) {
		this.userPermissions = userPermissions;
	}
	
	

}
