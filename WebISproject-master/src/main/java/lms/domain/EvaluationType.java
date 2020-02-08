package lms.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EvaluationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@OneToMany(mappedBy = "evaluationType", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Evaluation> evaluations;

	public EvaluationType() {
	}

	

	public EvaluationType(Long id, String title, Set<Evaluation> evaluations) {
		this.id = id;
		this.title = title;
		this.evaluations = evaluations;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}



	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	
	
	
	

}
