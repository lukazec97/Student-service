package lms.domain;

import java.io.IOException;
import java.util.HashSet;
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
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;
import org.springframework.web.multipart.MultipartFile;

import DTO.StudyProgramDTO;
import DTO.YearOfStudyDTO;

@Entity
@Where(clause = "deleted = 'false'")
public class StudyProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private String name;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@OneToOne(fetch = FetchType.LAZY)
	private Teacher rukovodilac;

	@ManyToOne(cascade = CascadeType.ALL)
	private Faculty faculty;

	@ManyToOne(cascade = CascadeType.ALL)
	private Center center;

	@OneToMany(mappedBy = "studyProgram", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<YearOfStudy> yearsOfStudy;

	private String pic_name;

	private String mimetype;

	@Lob
	private byte[] pic;

	public StudyProgram() {}

	public StudyProgram(Long id, @Size(max = 50) String name, @NotNull Boolean deleted, int version,
			Teacher rukovodilac, Faculty faculty, Center center, Set<YearOfStudy> yearsOfStudy, String pic_name,
			String mimetype, byte[] pic) {
		super();
		this.id = id;
		this.name = name;
		this.deleted = deleted;
		this.version = version;
		this.rukovodilac = rukovodilac;
		this.faculty = faculty;
		this.center = center;
		this.yearsOfStudy = yearsOfStudy;
		this.pic_name = pic_name;
		this.mimetype = mimetype;
		this.pic = pic;
	}
	

	public StudyProgram(MultipartFile file, String name2, String center2) {
		this.pic_name = file.getName();
		this.mimetype = file.getContentType();
		try {
		this.pic = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.name = name2;
	}

	public StudyProgram(MultipartFile file, String name2, Center c) {
		this.pic_name = file.getName();
		this.mimetype = file.getContentType();
		try {
		this.pic = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.name = name2;
		this.center = c;
	}


	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
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

	public Teacher getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(Teacher rukovodilac) {
		this.rukovodilac = rukovodilac;
	}

	public Set<YearOfStudy> getYearsOfStudy() {
		return yearsOfStudy;
	}

	public void setYearsOfStudy(Set<YearOfStudy> yearsOfStudy) {
		this.yearsOfStudy = yearsOfStudy;
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public StudyProgramDTO toDTO()
	{
		Set<YearOfStudyDTO> ret = new HashSet<>();
		for(YearOfStudy yos: this.yearsOfStudy)
			ret.add(yos.toDTO());
		
		
		return new StudyProgramDTO(this.id, this.name,  this.center.getName(), ret, this.pic_name, this.mimetype, this.pic);
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudyProgram object = (StudyProgram) o;
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