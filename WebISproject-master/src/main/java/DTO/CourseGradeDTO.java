package DTO;

public class CourseGradeDTO {
	
	private String course;
	private int grade;
	
	public CourseGradeDTO() {
	}

	

	public CourseGradeDTO(String course, int grade) {
		this.course = course;
		this.grade = grade;
	}

	
	


	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	

}
