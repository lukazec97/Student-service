package lms.domain;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;
import org.springframework.web.multipart.MultipartFile;

import DTO.CourseDTO;

@Entity
@Where(clause = "deleted = 'false'")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Size(max = 50)
	private String title;

	private int ects;

	private boolean obligatory;

	private int numberOfLectures;

	private int numberOfExcercises;

	@Version
	private int version = 0;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseRealization> courseRealizations;

	@ManyToOne(fetch = FetchType.LAZY)
	private YearOfStudy yearOfStudy;

	private String pic_name;

	private String mimetype;

	@Lob
	private byte[] pic;

	public Course() {
	}

	public Course(Long id, @NotNull Boolean deleted, @Size(max = 50) String title, int ects, boolean obligatory,
			int numberOfLectures, int numberOfExcercises, int version, Set<CourseRealization> courseRealizations,
			YearOfStudy yearOfStudy, String pic_name, String mimetype,
			byte[] pic) {
		super();
		this.id = id;
		this.deleted = deleted;
		this.title = title;
		this.ects = ects;
		this.obligatory = obligatory;
		this.numberOfLectures = numberOfLectures;
		this.numberOfExcercises = numberOfExcercises;
		this.version = version;
		this.courseRealizations = courseRealizations;
		this.yearOfStudy = yearOfStudy;
		this.pic_name = pic_name;
		this.mimetype = mimetype;
		this.pic = pic;
	}

	public Course(MultipartFile file, String title2, YearOfStudy yos) {
		this.pic_name = file.getName();
		this.mimetype = file.getContentType();
		try {
			this.pic = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.title = title2;
		this.yearOfStudy = yos;
	}



	public YearOfStudy getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(YearOfStudy yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Set<CourseRealization> getCourseRealizations() {
		return courseRealizations;
	}

	public void setCourseRealizations(Set<CourseRealization> courseRealizations) {
		this.courseRealizations = courseRealizations;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public boolean isObligatory() {
		return obligatory;
	}

	public void setObligatory(boolean obligatory) {
		this.obligatory = obligatory;
	}

	public int getNumberOfLectures() {
		return numberOfLectures;
	}

	public void setNumberOfLectures(int numberOfLectures) {
		this.numberOfLectures = numberOfLectures;
	}

	public int getNumberOfExcercises() {
		return numberOfExcercises;
	}

	public void setNumberOfExcercises(int numberOfExcercises) {
		this.numberOfExcercises = numberOfExcercises;
	}

	public String getPic_name() {
		return pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	public CourseDTO toDTO()
	{
		return new CourseDTO(this.id, this.title, this.ects, this.obligatory, this.numberOfLectures, this.numberOfExcercises, this.yearOfStudy.getTitle(), this.pic_name, this.mimetype, this.pic);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Course object = (Course) o;
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
