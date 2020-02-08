package lms.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TitleType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 50)
	private String name;
	
	
	@OneToOne
    @MapsId
    private Title title;
	
	@Version
	private int version;
	
	@NotNull
	private Boolean deleted = false;
	

	public TitleType() {
	}



	


	public TitleType(Long id, @Size(max = 50) String name, Title title) {
		this.id = id;
		this.name = name;
		this.title = title;
	}






	public Long getId() {
		return id;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TitleType object = (TitleType) o;
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