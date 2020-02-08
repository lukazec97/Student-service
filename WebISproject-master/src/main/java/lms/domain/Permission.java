package lms.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import DTO.PermissionDTO;
import DTO.UserPermissionDTO;

@Entity
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String title;
	
	@OneToMany(mappedBy = "permission")
	private Set<UserPermission> userPermissions;

	public Permission() {

	}

	public Permission(Long id, String title, Set<UserPermission> userPermissions) {
		super();
		this.id = id;
		this.title = title;
		this.userPermissions = userPermissions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<UserPermission> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<UserPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}

	public PermissionDTO toDTO()
	{
		Set<UserPermissionDTO> sy = new HashSet<>();
		for(UserPermission s:this.userPermissions)
			sy.add(s.toDTO());
		
		return new PermissionDTO(this.title, sy);
	}


}