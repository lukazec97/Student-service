package lms.domain;

import java.util.HashSet;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.Version;

import DTO.CourseTeachingDTO;
import DTO.TeacherDTO;

@Entity
@Where(clause = "deleted = 'false'")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Size(max = 20)
	private String personalIdentificationNumber;

	@NotNull
	private Boolean deleted = false;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseTeaching> courseTeachings;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Title> title;

	@OneToOne(fetch = FetchType.LAZY)
	private Address address;

	@OneToOne(fetch = FetchType.LAZY)
	private Faculty facultyDean;

	@OneToOne(fetch = FetchType.LAZY)
	private University universityRector;

	@OneToOne(fetch = FetchType.LAZY)
	private StudyProgram StudyProgramHandler;

	@Version
	private int version = 0;
	
	@OneToOne
    private User user;
	
	public Teacher() {
	}

	public Teacher(Long id, @Size(max = 50) String firstName, @Size(max = 50) String lastName,
			@Size(max = 20) String personalIdentificationNumber,  Set<CourseTeaching> courseTeachings, Set<Title> title, Address address,
			Faculty facultyDean, University universityRector, StudyProgram studyProgramHandler, int version,
			User user, Boolean deleted) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalIdentificationNumber = personalIdentificationNumber;
		this.courseTeachings = courseTeachings;
		this.title = title;
		this.address = address;
		this.facultyDean = facultyDean;
		this.universityRector = universityRector;
		StudyProgramHandler = studyProgramHandler;
		this.version = version;
		this.user = user;
		this.deleted = deleted;
	}

	public Teacher(@Size(max = 50) String firstName, @Size(max = 50) String lastName,
			@Size(max = 20) String personalIdentificationNumber, 
			Set<CourseTeaching> courseTeachings, Set<Title> title, Address address, Faculty facultyDean,
			University universityRector, StudyProgram studyProgramHandler, int version) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalIdentificationNumber = personalIdentificationNumber;
		this.courseTeachings = courseTeachings;
		this.title = title;
		this.address = address;
		this.facultyDean = facultyDean;
		this.universityRector = universityRector;
		StudyProgramHandler = studyProgramHandler;
		this.version = version;
	}

	public Teacher(String firstname2, String lastname2, String personalid, User user2) {
		this.firstName = firstname2;
		this.lastName = lastname2;
		this.personalIdentificationNumber = personalid;
		this.user = user2;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	

	public Set<CourseTeaching> getCourseTeachings() {
		return courseTeachings;
	}

	public void setCourseTeachings(Set<CourseTeaching> courseTeachings) {
		this.courseTeachings = courseTeachings;
	}

	public Set<Title> getTitle() {
		return title;
	}

	public void setTitle(Set<Title> title) {
		this.title = title;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Faculty getFacultyDean() {
		return facultyDean;
	}

	public void setFacultyDean(Faculty facultyDean) {
		this.facultyDean = facultyDean;
	}

	public University getUniversityRector() {
		return universityRector;
	}

	public void setUniversityRector(University universityRector) {
		this.universityRector = universityRector;
	}

	public StudyProgram getStudyProgramHandler() {
		return StudyProgramHandler;
	}

	public void setStudyProgramHandler(StudyProgram studyProgramHandler) {
		StudyProgramHandler = studyProgramHandler;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public Boolean getDeleted() {
		return deleted;
	}



	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public TeacherDTO toDTO()
	{
		Set<CourseTeachingDTO> sy = new HashSet<>();
		if(!(this.courseTeachings == null))
			for(CourseTeaching s:this.courseTeachings)
				sy.add(s.toDTO());
		
		return new TeacherDTO(this.id,this.firstName, this.lastName, this.personalIdentificationNumber, sy, this.user.toDTO());
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Teacher object = (Teacher) o;
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
