package lms.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import DTO.CourseAttendingDTO;
import DTO.CourseRealizationDTO;
import DTO.CourseTeachingDTO;
import DTO.EvaluationDTO;

@Entity
@Where(clause = "deleted = 'false'")
public class CourseRealization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	private LocalDate startDate;
	
	private LocalDate endDate;
	
	@OneToMany(mappedBy = "courseRealization", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseTeaching> courseTeachings;

	@OneToMany(mappedBy = "courseRealization", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseAttending> courseAttendings;

	@OneToMany(mappedBy = "courseRealization", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Evaluation> evaluations;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	
	
	
	public CourseRealization() {
	}
	
	

	public CourseRealization(Long id, @NotNull Boolean deleted, int version, LocalDate startDate, LocalDate endDate,
			Set<CourseTeaching> courseTeachings, Set<CourseAttending> courseAttendings, Set<Evaluation> evaluations,
			Course course) {
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseTeachings = courseTeachings;
		this.courseAttendings = courseAttendings;
		this.evaluations = evaluations;
		this.course = course;
	}



	public CourseRealization(Long id, @NotNull Boolean deleted, int version, LocalDate startDate, LocalDate endDate,
			Set<CourseTeaching> courseTeachings, Set<CourseAttending> courseAttendings, Course course) {
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseTeachings = courseTeachings;
		this.courseAttendings = courseAttendings;
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}
	
	

	public Set<CourseAttending> getCourseAttendings() {
		return courseAttendings;
	}

	public void setCourseAttendings(Set<CourseAttending> courseAttendings) {
		this.courseAttendings = courseAttendings;
	}

	public Set<CourseTeaching> getCourseTeachings() {
		return courseTeachings;
	}

	public void setCourseTeachings(Set<CourseTeaching> courseTeachings) {
		this.courseTeachings = courseTeachings;
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
	
	
	
	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}



	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public CourseRealizationDTO toDTO()
	{
		Set<CourseTeachingDTO> sy = new HashSet<>();
		if(!(this.courseTeachings == null))
			for(CourseTeaching s:this.courseTeachings)
				sy.add(s.toDTO());
		
		Set<CourseAttendingDTO> sy1 = new HashSet<>();
		if(!(this.courseAttendings == null))
			for(CourseAttending s1:this.courseAttendings)
				sy1.add(s1.toDTO());
		
		Set<EvaluationDTO> sy2 = new HashSet<>();
		if(!(this.evaluations == null))
			for(Evaluation s2:this.evaluations)
				sy2.add(s2.toDTO());
		
		return new CourseRealizationDTO(this.id, this.startDate, this.endDate, sy, sy1, sy2, this.course.toDTO());
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CourseRealization object = (CourseRealization) o;
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
