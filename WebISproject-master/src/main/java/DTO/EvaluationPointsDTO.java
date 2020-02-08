package DTO;

public class EvaluationPointsDTO {
	
	private String evaluationType;
	private int maxPoints;
	private int pointsAchieved;
	
	public EvaluationPointsDTO() {
	}
	
	
	public EvaluationPointsDTO(String evaluationType, int maxPoints, int pointsAchieved) {
		this.evaluationType = evaluationType;
		this.maxPoints = maxPoints;
		this.pointsAchieved = pointsAchieved;
	}

	

	public String getEvaluationType() {
		return evaluationType;
	}


	public void setEvaluationType(String evaluationType) {
		this.evaluationType = evaluationType;
	}


	public int getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
	public int getPointsAchieved() {
		return pointsAchieved;
	}
	public void setPointsAchieved(int pointsAchieved) {
		this.pointsAchieved = pointsAchieved;
	}
	
	

}
