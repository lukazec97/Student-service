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

import DTO.CourseAttendingDTO;
import DTO.StudentDTO;
import DTO.StudentYearDTO;

@Entity
@Where(clause = "deleted = 'false'")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Size(max = 10)
	private String cardNumber;
	
	@NotNull
	private Boolean deleted = false;


	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseAttending> courseAttendings;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<StudentYear> studentYears;
	
	@OneToOne
    private User user;

	public Student() {
	}
	
	

	

	public Student(@Size(max = 50) String firstName, @Size(max = 50) String lastName,
			@Size(max = 10) String cardNumber, String pass) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
	}
	
	

	

	public Student(Long id, @Size(max = 50) String firstName, @Size(max = 50) String lastName,
			@Size(max = 10) String cardNumber,
			Set<CourseAttending> courseAttendings, Set<StudentYear> studentYears, Boolean deleted) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.courseAttendings = courseAttendings;
		this.studentYears = studentYears;
		this.deleted = deleted;
	}




	public Student(String firstname2, String lastname2, String cardnumber2, User user2) {
		this.firstName = firstname2;
		this.lastName = lastname2;
		this.cardNumber = cardnumber2;
		this.user = user2;
	}







	public Set<StudentYear> getStudentYears() {
		return studentYears;
	}

	public void setStudentYears(Set<StudentYear> studentYears) {
		this.studentYears = studentYears;
	}

	public Set<CourseAttending> getCourseAttendings() {
		return courseAttendings;
	}

	public void setCourseAttendings(Set<CourseAttending> courseAttendings) {
		this.courseAttendings = courseAttendings;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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





	public StudentDTO toDTO()
	{
		Set<CourseAttendingDTO> sy = new HashSet<>();
		if(!(this.courseAttendings == null))
			for(CourseAttending s:this.courseAttendings)
				sy.add(s.toDTO());
		
		Set<StudentYearDTO> sy1 = new HashSet<>();
		if(!(this.studentYears == null))
			for(StudentYear s1:this.studentYears)
				sy1.add(s1.toDTO());
		
		return new StudentDTO(this.id, this.firstName, this.lastName, this.user.toDTO(), this.cardNumber, sy, sy1);
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Student object = (Student) o;
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
