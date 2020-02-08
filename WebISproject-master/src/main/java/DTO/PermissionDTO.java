package DTO;

import java.util.Set;

public class PermissionDTO {
	
	
	
	private String title;
	
	private Set<UserPermissionDTO> userPermissions;

	public PermissionDTO(String title, Set<UserPermissionDTO> userPermissions) {
		this.title = title;
		this.userPermissions = userPermissions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<UserPermissionDTO> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<UserPermissionDTO> userPermissions) {
		this.userPermissions = userPermissions;
	}
	
	

}
