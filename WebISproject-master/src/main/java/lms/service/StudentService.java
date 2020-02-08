package lms.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import DTO.CourseDTO;
import DTO.CourseGradeDTO;
import DTO.EvaluationPointsDTO;
import DTO.StudentDTO;
import DTO.StudentXmlPojo;
import lms.domain.Course;
import lms.domain.CourseAttending;
import lms.domain.Evaluation;
import lms.domain.EvaluationAttending;
import lms.domain.Student;
import lms.domain.StudentYear;
import lms.domain.StudyProgram;
import lms.domain.User;
import lms.domain.YearOfStudy;
import lms.repository.CourseAttendingRepository;
import lms.repository.CourseRepository;
import lms.repository.StudentRepository;
import lms.repository.YearOfStudyRepository;
import lms.utils.ConvertToPDF;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	YearOfStudyRepository yearOfStudyRepository;

	@Autowired
	CourseAttendingRepository courseAttendingRepository;

	@Autowired
	CourseAttendingService courseAttendingService;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	UserService userService;

	@Autowired
	StorageService storageService;


	public StudentService() {
	}

	public void enrollInFirstYear(Student student, StudyProgram studyProgram) {
		
		List<YearOfStudy> yearsOfStudy = yearOfStudyRepository.findAll();
		YearOfStudy yearOfStudy = null;
		
		for(YearOfStudy yos: yearsOfStudy)
			if(yos.getStudyProgram() == studyProgram && yos.getNumberOfYear() == 1)
				yearOfStudy = yos;

		StudentYear studentYear = new StudentYear();
		
		studentYear.setStudent(student);
		studentYear.setYearOfStudy(yearOfStudy);
		student.getStudentYears().add(studentYear);
		studentRepository.save(student);
	}

	public Optional<Student> getByCardNumber(String cardNumber) {
		return studentRepository.findFirstByCardNumber(cardNumber);
	}

	public Set<CourseDTO> findAllCurrentCourses(Student student) {
		Set<CourseDTO> ret = new HashSet<>();

		for (StudentYear studentYear : student.getStudentYears())
			for (Course course : studentYear.getYearOfStudy().getCourses())
				ret.add(course.toDTO());

		for (CourseAttending courseAttending : student.getCourseAttendings())
			if (ret.contains(courseAttending.getCourseRealization().getCourse().toDTO()))
				ret.remove(courseAttending.getCourseRealization().getCourse().toDTO());

		return ret;

	}

	public Set<CourseGradeDTO> findAllFinishedCourses(Student student) {
		Set<CourseGradeDTO> ret = new HashSet<>();

		for (CourseAttending courseAttending : student.getCourseAttendings())
			ret.add(new CourseGradeDTO(courseAttending.getCourseRealization().getCourse().getTitle(),
					courseAttending.getGrade()));

		return ret;

	}

	public Set<EvaluationPointsDTO> findAllEvaluations(Course course, Student student) {

		CourseAttending ca = courseAttendingService.getCourseAttendingSubjectStudent(course, student);

		Set<EvaluationPointsDTO> ret = new HashSet<>();

		for (Evaluation e : ca.getCourseRealization().getEvaluations())
			for (EvaluationAttending ea : e.getEvaluationAttendings())
				if (ea.getStudentYear().getStudent() == ca.getStudent())
					ret.add(new EvaluationPointsDTO(e.getEvaluationType().getTitle(), e.getTotalPoints(),
							ea.getAchievedPoints()));

		return ret;
	}

	public Iterable<StudentDTO> getByFirstName(String firstName) {
		List<Student> list =  studentRepository.findByFirstNameLikeIgnoreCase(firstName);
		Set<StudentDTO> ret = new HashSet<>();
		for(Student s: list)
			ret.add(s.toDTO());
		return ret;
	}

	public Iterable<StudentDTO> searchByName(String name) {
		List<Student> list =  studentRepository.findByFirstNameOrLastNameLikeIgnoreCase(name, name);
		Set<StudentDTO> ret = new HashSet<>();
		for(Student s: list)
			ret.add(s.toDTO());
		return ret;
	}

	public Iterable<StudentDTO> getByLastName(String lastName) {
		List<Student> list =  studentRepository.findByLastNameLikeIgnoreCase(lastName);
		Set<StudentDTO> ret = new HashSet<>();
		for(Student s: list)
			ret.add(s.toDTO());
		return ret;
	}

	public Iterable<StudentDTO> getStudents() {
		List<Student> ss = studentRepository.findAll();
		Set<StudentDTO> ret = new HashSet<>();

		for (Student student : ss)
			ret.add(student.toDTO());

		return ret;
	}

	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}

	public void addStudent(Student s) throws NoSuchAlgorithmException {
		studentRepository.save(s);
	}

	public Optional<Student> getStudent(Long id) {
		return studentRepository.findById(id);
	}

	public void removeStudent(Long id) {
		Optional<Student> s = studentRepository.findById(id);
		studentRepository.delete(s.get());
	}

	public void removeStudentSoft(Long id) {
		Optional<Student> s = studentRepository.findById(id);
		if (s.isPresent()) {
			s.get().setDeleted(true);
			studentRepository.save(s.get());
			Optional<User> u = userService.getUser(s.get().getUser().getUsername());
			if (u.isPresent()) {
				userService.removeUserSoft(u.get().getId());
			}
		}
	}

	public void updateStudent(Long id, Student s) {
		Optional<Student> S = studentRepository.findById(id);
		if (S.isPresent()) {
			s.setId(S.get().getId());
			s.setUser(S.get().getUser());
			System.out.println(s.getCardNumber());
			studentRepository.save(s);
		}
	}

	public Path toXMLFile(Student s) {
		File file = new File(s.getFirstName() + " " + s.getLastName() + " " + s.getCardNumber() + ".xml");

		XmlMapper mapper = new XmlMapper();

		try {
			mapper.writeValue(file, s.toDTO());
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file.toPath();
	}

	public Path allToXMLFile()
	{
		File file = new File("students.xml");
		
		XmlMapper mapper = new XmlMapper();
		


		

		

		try {
			mapper.writeValue(file, new StudentXmlPojo(getStudents()));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file.toPath();

	}

	

	public Resource allToPDF() throws FileNotFoundException {

		String filename = "students.pdf";

		return storageService.loadFile(ConvertToPDF.students(getStudents(), filename));



		

	}

	public Resource toPDF(StudentDTO s) {

		String filename = s.getFirstName() + " " + s.getLastName() + " " + s.getCardNumber() + ".pdf";

		return storageService.loadFile(ConvertToPDF.student(s, filename));



		

	}

	

	

}
