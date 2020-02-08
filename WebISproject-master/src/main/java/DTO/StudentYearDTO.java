package DTO;

import java.time.LocalDate;

public class StudentYearDTO {


	private Long id;

	

	private LocalDate registrationDate;

	private String yearOfStudy;

	private Long studentId;

	

	public StudentYearDTO(java.lang.Long id2, LocalDate registrationDate, String yearOfStudy, Long student) {
		this.id = id2;
		this.registrationDate = registrationDate;
		this.yearOfStudy = yearOfStudy;
		this.studentId = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	

	public String getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(String yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Long getStudent() {
		return studentId;
	}

	public void setStudent(Long student) {
		this.studentId = student;
	}
	
	
	
	

	
}
