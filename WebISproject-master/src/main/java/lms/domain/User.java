package lms.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import DTO.UserDTO;
import DTO.UserPermissionDTO;

@Entity
@Where(clause = "deleted = 'false'")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;
	
	private String role;
	
	@NotNull
	private Boolean deleted = false;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserPermission> userPermissions;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
    private Student student;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
    private Teacher teacher;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
    private Administrator administrator;

	public User() {
		
	}
	
	

	public User(Long id, String username, String password, String role, Set<UserPermission> userPermissions,
			Student student, Teacher teacher, Administrator administrator, Boolean deleted) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.userPermissions = userPermissions;
		this.student = student;
		this.teacher = teacher;
		this.administrator = administrator;
		this.deleted = deleted;
	}



	public User(Long id, String username, String password, Set<UserPermission> userPermissions, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userPermissions = userPermissions;
		this.role = role;
	}

	public User(String username2, String password2, String role2, Student student) {
		this.username = username2;
		this.password = password2;
		this.role = role2;
		this.student = student;
	}



	public User(String username2, String password2, String role2) {
		this.username = username2;
		this.password = password2;
		this.role = role2;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}



	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
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

	public Set<UserPermission> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<UserPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public Administrator getAdministrator() {
		return administrator;
	}



	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
	public UserDTO toDTO()
	{
		Set<UserPermissionDTO> sy = new HashSet<>();
		for(UserPermission s:this.userPermissions)
			sy.add(s.toDTO());
		
		return new UserDTO(this.id, this.username, this.password, this.role, sy);
	}
	
	
		
}
