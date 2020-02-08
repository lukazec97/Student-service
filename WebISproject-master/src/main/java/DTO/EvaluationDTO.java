package DTO;

import java.time.LocalDate;
import java.util.Set;

public class EvaluationDTO {
	
	private Long id;
	
	private Long courseRealizationId;
	
	private Set<EvaluationAttendingDTO> evaluationAttendings;
	
	private String evaluationType;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	private int totalPoints;

	

	

	public EvaluationDTO(Long id, Long courseRealizationId, Set<EvaluationAttendingDTO> evaluationAttendings,
			String evaluationType, LocalDate startDate, LocalDate endDate, int totalPoints) {
		this.id = id;
		this.courseRealizationId = courseRealizationId;
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

	

	public Long getCourseRealizationId() {
		return courseRealizationId;
	}

	public void setCourseRealizationId(Long courseRealizationId) {
		this.courseRealizationId = courseRealizationId;
	}

	public Set<EvaluationAttendingDTO> getEvaluationAttendings() {
		return evaluationAttendings;
	}

	public void setEvaluationAttendings(Set<EvaluationAttendingDTO> evaluationAttendings) {
		this.evaluationAttendings = evaluationAttendings;
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

	public String getEvaluationType() {
		return evaluationType;
	}

	public void setEvaluationType(String evaluationType) {
		this.evaluationType = evaluationType;
	}
	
	

}
