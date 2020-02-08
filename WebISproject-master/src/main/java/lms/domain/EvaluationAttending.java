package lms.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import DTO.EvaluationAttendingDTO;


@Entity
public class EvaluationAttending {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Evaluation evaluation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private StudentYear studentYear;
	
	private String note;
	
	private int achievedPoints;

	public EvaluationAttending() {
	}

	public EvaluationAttending(Long id, Evaluation evaluation, StudentYear studentYear, String note,
			int achievedPoints) {
		this.id = id;
		this.evaluation = evaluation;
		this.studentYear = studentYear;
		this.note = note;
		this.achievedPoints = achievedPoints;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public StudentYear getStudentYear() {
		return studentYear;
	}

	public void setStudentYear(StudentYear studentYear) {
		this.studentYear = studentYear;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getAchievedPoints() {
		return achievedPoints;
	}

	public void setAchievedPoints(int achievedPoints) {
		this.achievedPoints = achievedPoints;
	}
	
	
	public EvaluationAttendingDTO toDTO()
	{
		return new EvaluationAttendingDTO(this.id, this.evaluation.getId(), this.studentYear.toDTO(), this.note, this.achievedPoints);
	}
	
	

}
