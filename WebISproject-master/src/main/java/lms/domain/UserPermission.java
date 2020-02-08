package lms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import DTO.UserPermissionDTO;

@Entity
public class UserPermission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Permission permission;

	public UserPermission() {

	}

	public UserPermission(Long id, User user, Permission permission) {
		super();
		this.id = id;
		this.user = user;
		this.permission = permission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	public UserPermissionDTO toDTO()
	{
		return new UserPermissionDTO(this.id, this.getUser().getId(), this.permission.getId());
	}

}