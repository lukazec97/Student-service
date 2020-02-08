package lms.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 50)
	private Date dateChosen;
	
	@Size(max = 50)
	private Date dateStop;
	
	
	@OneToOne(mappedBy = "title", cascade = CascadeType.ALL)
    private TitleType titleType;
	
	
	
	@OneToOne(mappedBy = "title", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })	
	private StudyField studyField;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
	
	
	public Title() {
		
	}
	
	

	public Title(Long id, @Size(max = 50) Date dateChosen, @Size(max = 50) Date dateStop, TitleType titleType,
			StudyField studyField, Teacher teacher, @NotNull Boolean deleted, int version) {
		this.id = id;
		this.dateChosen = dateChosen;
		this.dateStop = dateStop;
		this.titleType = titleType;
		this.studyField = studyField;
		this.teacher = teacher;
		this.deleted = deleted;
		this.version = version;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateChosen() {
		return dateChosen;
	}

	public void setDateChosen(Date dateChosen) {
		this.dateChosen = dateChosen;
	}

	public Date getDateStop() {
		return dateStop;
	}

	public void setDateStop(Date dateStop) {
		this.dateStop = dateStop;
	}

	public StudyField getStudyField() {
		return studyField;
	}

	public void setStudyFields(StudyField studyField) {
		this.studyField = studyField;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



		////
	@NotNull
	private Boolean deleted = false;
		
	@Version
	private int version = 0;
		////
		
	
	//bilo zaboravljeno	
	@Override
	public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Title object = (Title) o;
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