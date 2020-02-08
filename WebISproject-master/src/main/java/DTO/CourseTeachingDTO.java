package DTO;

public class CourseTeachingDTO {
	
	private Long id;

	
	private int numberOfClasses;
	
	private Long teacherId;
	
	private CourseRealizationDTO courseRealization;

	public CourseTeachingDTO(Long id, int numberOfClasses, Long teacherId, CourseRealizationDTO courseRealization) {
		this.id = id;
		this.numberOfClasses = numberOfClasses;
		this.teacherId = teacherId;
		this.courseRealization = courseRealization;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public CourseRealizationDTO getCourseRealization() {
		return courseRealization;
	}

	public void setCourseRealization(CourseRealizationDTO courseRealization) {
		this.courseRealization = courseRealization;
	}

	
	
	
	

}
