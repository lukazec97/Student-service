package DTO;

import java.util.Set;

public class StudentDTO {

	private Long id;
	
private String firstName;
	
	private String lastName;
	
	private UserDTO user;

	private String cardNumber;

	private Set<CourseAttendingDTO> courseAttendings;

	private Set<StudentYearDTO> studentYears;
	
	

	public StudentDTO(Long id, String firstName, String lastName, UserDTO user, String cardNumber,
			Set<CourseAttendingDTO> courseAttendings, Set<StudentYearDTO> studentYears) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.cardNumber = cardNumber;
		this.courseAttendings = courseAttendings;
		this.studentYears = studentYears;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Set<CourseAttendingDTO> getCourseAttendings() {
		return courseAttendings;
	}

	public void setCourseAttendings(Set<CourseAttendingDTO> courseAttendings) {
		this.courseAttendings = courseAttendings;
	}

	public Set<StudentYearDTO> getStudentYears() {
		return studentYears;
	}

	public void setStudentYears(Set<StudentYearDTO> studentYears) {
		this.studentYears = studentYears;
	}
	
	

}
