package lms.domain;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;


@Entity
@Where(clause = "deleted = 'false'")
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private String name;

	private Date yearOfEstablishment;
	
	@NotNull
	private Boolean deleted = false;
	
	@Version
	private int version = 0;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Address address;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Teacher rektor;

	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })	
	private Set<Center> centers;
	
	
	
	public University() {}
	
	
	
	
	public University(Long id, @Size(max = 50) String name, Date yearOfEstablishment, @NotNull Boolean deleted,
			int version, Address address, Teacher rektor, Set<Center> centers) {
		this.id = id;
		this.name = name;
		this.yearOfEstablishment = yearOfEstablishment;
		this.deleted = deleted;
		this.version = version;
		this.address = address;
		this.rektor = rektor;
		this.centers = centers;
	}




	public Teacher getRektor() {
		return rektor;
	}


	public void setRektor(Teacher rektor) {
		this.rektor = rektor;
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

	public Date getYearOfEstablishment() {
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(Date yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	public Set<Center> getCenters() {
		return centers;
	}




	public void setCenters(Set<Center> centers) {
		this.centers = centers;
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		University object = (University) o;
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