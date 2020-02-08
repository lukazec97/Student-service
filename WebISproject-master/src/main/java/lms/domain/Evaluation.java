package lms.domain;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import DTO.EvaluationAttendingDTO;
import DTO.EvaluationDTO;

@Entity
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CourseRealization courseRealization;
	
	@OneToMany(mappedBy = "evaluation", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<EvaluationAttending> evaluationAttendings;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EvaluationType evaluationType;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	private int totalPoints;

	public Evaluation() {
	}

	public Evaluation(Long id, CourseRealization courseRealization, Set<EvaluationAttending> evaluationAttendings,
			EvaluationType evaluationType, LocalDate startDate, LocalDate endDate, int totalPoints) {
		this.id = id;
		this.courseRealization = courseRealization;
		this.evaluationAttendings = evaluationAttendings;
		this.evaluationType = evaluationType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPoints = totalPoints;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseRealization getCourseRealization() {
		return courseRealization;
	}

	public void setCourseRealization(CourseRealization courseRealization) {
		this.courseRealization = courseRealization;
	}

	public Set<EvaluationAttending> getEvaluationAttendings() {
		return evaluationAttendings;
	}

	public void setEvaluationAttendings(Set<EvaluationAttending> evaluationAttendings) {
		this.evaluationAttendings = evaluationAttendings;
	}

	public EvaluationType getEvaluationType() {
		return evaluationType;
	}

	public void setEvaluationType(EvaluationType evaluationType) {
		this.evaluationType = evaluationType;
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

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	
	public EvaluationDTO toDTO()
	{
		Set<EvaluationAttendingDTO> sy = new HashSet<>();
		if(!(this.evaluationAttendings == null))
			for(EvaluationAttending s:this.evaluationAttendings)
				sy.add(s.toDTO());
		
		return new EvaluationDTO(this.id, this.courseRealization.getId(), sy, this.evaluationType.getTitle(), this.startDate, this.endDate, this.totalPoints);
	}
	

}
