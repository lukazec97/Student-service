package DTO;

import java.util.Set;

public class TeacherDTO {
	
	private Long id;
	
private String firstName;
	
	private String lastName;
	
	private String personalIdentificationNumber;


	private Set<CourseTeachingDTO> courseTeachings;
	
	private UserDTO user;

	

	public TeacherDTO(Long id,String firstName, String lastName, String personalIdentificationNumber,
			Set<CourseTeachingDTO> courseTeachings, UserDTO user) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalIdentificationNumber = personalIdentificationNumber;
		this.courseTeachings = courseTeachings;
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

	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	public Set<CourseTeachingDTO> getCourseTeachings() {
		return courseTeachings;
	}

	public void setCourseTeachings(Set<CourseTeachingDTO> courseTeachings) {
		this.courseTeachings = courseTeachings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

	
}
