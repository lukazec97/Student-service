package lms.domain;

import java.time.LocalDate;
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

import DTO.StudentYearDTO;

@Entity
@Where(clause = "deleted = 'false'")
public class StudentYear {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	private LocalDate registrationDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private YearOfStudy yearOfStudy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
	
	@OneToMany(mappedBy = "studentYear", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<EvaluationAttending> evaluationAttendings;
	
	

	public StudentYear() {
	}
	
	
	
	

	public StudentYear(Long id, @NotNull Boolean deleted, int version, LocalDate registrationDate,
			YearOfStudy yearOfStudy, Student student, Set<EvaluationAttending> evaluationAttendings) {
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.registrationDate = registrationDate;
		this.yearOfStudy = yearOfStudy;
		this.student = student;
		this.evaluationAttendings = evaluationAttendings;
	}





	public StudentYear(Long id, @NotNull Boolean deleted, int version, LocalDate registrationDate,
			YearOfStudy yearOfStudy, Student student) {
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.registrationDate = registrationDate;
		this.yearOfStudy = yearOfStudy;
		this.student = student;
	}


	public StudentYear(LocalDate now, YearOfStudy nextYOS, Student student2) {
		this.registrationDate = now;
		this.yearOfStudy = nextYOS;
		this.student = student2;
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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public YearOfStudy getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(YearOfStudy yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	public Set<EvaluationAttending> getEvaluationAttendings() {
		return evaluationAttendings;
	}





	public void setEvaluationAttendings(Set<EvaluationAttending> evaluationAttendings) {
		this.evaluationAttendings = evaluationAttendings;
	}


	public StudentYearDTO toDTO()
	{
		return new StudentYearDTO(this.id, this.registrationDate, this.yearOfStudy.getTitle(), this.student.getId());
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudentYear object = (StudentYear) o;
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
