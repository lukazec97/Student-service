package lms.controllers;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.CourseDTO;
import DTO.CourseGradeDTO;
import DTO.EvaluationPointsDTO;
import DTO.StudentDTO;
import lms.domain.Course;
import lms.domain.Student;
import lms.domain.StudyProgram;
import lms.service.CourseService;
import lms.service.StorageService;
import lms.service.StudentService;
import lms.service.StudyProgramService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;

	@Autowired
	StorageService storageService;

	@Autowired
	StudyProgramService studyProgramService;
	
	@GetMapping
	public ResponseEntity<Iterable<StudentDTO>> getAllStudent() {
		return new ResponseEntity<Iterable<StudentDTO>>(studentService.getStudents(), HttpStatus.OK);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent()) {
			return new ResponseEntity<StudentDTO>(student.get().toDTO(), HttpStatus.OK);
		}
		return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/{id}/findallcurrentcourses")
	public ResponseEntity<Iterable<CourseDTO>> findAllCurrentCourses(@PathVariable Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent()) {
			return new ResponseEntity<Iterable<CourseDTO>>(studentService.findAllCurrentCourses(student.get()), HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<CourseDTO>>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/{id}/findallfinishedcourses")
	public ResponseEntity<Iterable<CourseGradeDTO>> findAllFinishedCourses(@PathVariable Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent()) {
			return new ResponseEntity<Iterable<CourseGradeDTO>>(studentService.findAllFinishedCourses(student.get()), HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<CourseGradeDTO>>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/{ids}/{idp}/findallevaluations")
	public ResponseEntity<Iterable<EvaluationPointsDTO>> findAllEvaluations(@PathVariable Long ids, @PathVariable Long idp) {
		Optional<Student> student = studentService.getStudentById(ids);
		Optional<Course> course = courseService.getCourseId(idp);
		if(student.isPresent() && course.isPresent() ) {
			return new ResponseEntity<Iterable<EvaluationPointsDTO>>(studentService.findAllEvaluations(course.get(), student.get()), HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<EvaluationPointsDTO>>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) throws NoSuchAlgorithmException{
		studentService.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
		return new ResponseEntity<StudentDTO>(student.toDTO(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
		try {
			studentService.removeStudentSoft(id);
			
		}
		catch(Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping(value = "/lastname/{lastName}")
	public ResponseEntity<Iterable<StudentDTO>> getStudentByLastName(@PathVariable String lastName) {
		return new ResponseEntity<Iterable<StudentDTO>>(studentService.getByLastName(lastName), HttpStatus.OK);
	}
	
	@GetMapping(value = "/firstname/{firstName}")
	public ResponseEntity<Iterable<StudentDTO>> getStudentByFirstName(@PathVariable String firstName) {
		return new ResponseEntity<Iterable<StudentDTO>>(studentService.getByFirstName(firstName), HttpStatus.OK);
	}

	@GetMapping(value = "/search/{name}")
	public ResponseEntity<Iterable<StudentDTO>> searchStudents(@PathVariable String name) {
		return new ResponseEntity<Iterable<StudentDTO>>(studentService.searchByName(name), HttpStatus.OK);
	}
	
	@GetMapping(value = "/cardnumber/{cardNumber}")
	public ResponseEntity<StudentDTO> getStudentByCardNumber(@PathVariable String cardNumber) {
		Optional<Student> student = studentService.getByCardNumber(cardNumber);
		if(student.isPresent()) {
			return new ResponseEntity<StudentDTO>(student.get().toDTO(), HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentDTO>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping(value = "/downloadxml/{id}")
	public ResponseEntity<Resource>downloadStudentXML(@PathVariable Long id)
	{
	
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent())
		{
			Resource file = storageService.loadFile(studentService.toXMLFile(student.get()));
    	return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        .body(file);
  		}
		
		return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		
	}
	@GetMapping(value = "/downloadxml")
	public ResponseEntity<Resource>downloadAllStudentsXML()
	{
	
		
		Resource file = storageService.loadFile(studentService.allToXMLFile());
    	return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        .body(file);
  		
		
	}
	

	@GetMapping(value = "/downloadpdf")
	public ResponseEntity<Resource>downloadStudentsPDF() throws FileNotFoundException
	{
	
		
		Resource file = studentService.allToPDF();
    	return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        .body(file);
  		
		
	}

	@GetMapping(value = "/downloadpdf/{id}")
	public ResponseEntity<Resource>downloadStudentPDF(@PathVariable Long id)
	{
	
		
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent())
		{
			Resource file = studentService.toPDF(student.get().toDTO());
    		return ResponseEntity.ok()
        		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        		.body(file);
  		}
		  
		  return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping(value = "/upisnaprvu/{spId}")
	public ResponseEntity<Void>enrollStudentInFirstYear(@RequestBody String studentId, @PathVariable String spId)
	{
		Optional<Student> student = studentService.getStudentById(Long.parseLong(studentId));
		Optional<StudyProgram> studyProgram = studyProgramService.getStudyProgramId(Long.parseLong(spId));

		if(student.isPresent() && studyProgram.isPresent())
		{
			studentService.enrollInFirstYear(student.get(), studyProgram.get());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
