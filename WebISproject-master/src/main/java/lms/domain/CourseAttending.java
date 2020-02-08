package lms.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import DTO.CourseAttendingDTO;

@Entity
@Where(clause = "deleted = 'false'")
public class CourseAttending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CourseRealization courseRealization;
	
	private int grade;
	
	
	
	public CourseAttending() {
	}

	

	public CourseAttending(Long id, @NotNull Boolean deleted, int version, Student student,
			CourseRealization courseRealization, int grade) {
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.student = student;
		this.courseRealization = courseRealization;
		this.grade = grade;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	public CourseRealization getCourseRealization() {
		return courseRealization;
	}

	public void setCourseRealization(CourseRealization courseRealization) {
		this.courseRealization = courseRealization;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public CourseAttendingDTO toDTO()
	{
		return new CourseAttendingDTO(this.id, this.getStudent().getId(), this.courseRealization.getId());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CourseAttending object = (CourseAttending) o;
		if (object.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, object.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
