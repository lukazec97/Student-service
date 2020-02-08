package DTO;

import java.util.Set;

public class YearOfStudyDTO {
	
	private Long id;
	
	private String title;
	
	private int numberOfYear;

	private Set<CourseDTO> courses;

	private Set<StudentYearDTO> studentYears;

	private String studyProgram;
	
	
	

	

	
	public YearOfStudyDTO(Long id, String title, int numberOfYear, Set<CourseDTO> courses,
			Set<StudentYearDTO> studentYears, String studyProgram) {
		this.id = id;
		this.title = title;
		this.numberOfYear = numberOfYear;
		this.courses = courses;
		this.studentYears = studentYears;
		this.studyProgram = studyProgram;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfYear() {
		return numberOfYear;
	}

	public void setNumberOfYear(int numberOfYear) {
		this.numberOfYear = numberOfYear;
	}

	public Set<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseDTO> courses) {
		this.courses = courses;
	}

	public Set<StudentYearDTO> getStudentYears() {
		return studentYears;
	}

	public void setStudentYears(Set<StudentYearDTO> studentYears) {
		this.studentYears = studentYears;
	}

	public String getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(String studyProgram) {
		this.studyProgram = studyProgram;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
	

}
