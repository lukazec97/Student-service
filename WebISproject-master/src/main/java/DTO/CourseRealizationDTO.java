package DTO;

import java.time.LocalDate;
import java.util.Set;

public class CourseRealizationDTO {
	
	private Long id;

	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Set<CourseTeachingDTO> courseTeachings;

	private Set<CourseAttendingDTO> courseAttendings;

	private Set<EvaluationDTO> evaluations;
	
	private CourseDTO course;

	public CourseRealizationDTO(Long id, LocalDate startDate, LocalDate endDate, Set<CourseTeachingDTO> courseTeachings,
			Set<CourseAttendingDTO> courseAttendings, Set<EvaluationDTO> evaluations, CourseDTO course) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseTeachings = courseTeachings;
		this.courseAttendings = courseAttendings;
		this.evaluations = evaluations;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Set<CourseTeachingDTO> getCourseTeachings() {
		return courseTeachings;
	}

	public void setCourseTeachings(Set<CourseTeachingDTO> courseTeachings) {
		this.courseTeachings = courseTeachings;
	}

	public Set<CourseAttendingDTO> getCourseAttendings() {
		return courseAttendings;
	}

	public void setCourseAttendings(Set<CourseAttendingDTO> courseAttendings) {
		this.courseAttendings = courseAttendings;
	}

	public Set<EvaluationDTO> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<EvaluationDTO> evaluations) {
		this.evaluations = evaluations;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}
	
	

}
