package DTO;

public class CourseAttendingDTO {
	
	private Long id;

	private Long studentId;
	
	private Long courseRealizationId;

	public CourseAttendingDTO(Long id, Long studentId, Long courseRealizationId) {
		this.id = id;
		this.studentId = studentId;
		this.courseRealizationId = courseRealizationId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseRealizationId() {
		return courseRealizationId;
	}

	public void setCourseRealizationId(Long courseRealizationId) {
		this.courseRealizationId = courseRealizationId;
	}
	
	
	
	

}
