package DTO;

public class EvaluationAttendingDTO {

	private Long id;
	
	private Long evaluationId;
	
	private StudentYearDTO studentYear;
	
	private String note;
	
	private int achievedPoints;

	public EvaluationAttendingDTO(Long id, Long evaluationId, StudentYearDTO studentYear, String note,
			int achievedPoints) {
		this.id = id;
		this.evaluationId = evaluationId;
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

	public Long getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(Long evaluationId) {
		this.evaluationId = evaluationId;
	}

	public StudentYearDTO getStudentYear() {
		return studentYear;
	}

	public void setStudentYear(StudentYearDTO studentYear) {
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
	
	
}
