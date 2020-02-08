package lms.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import DTO.AdministratorDTO;

import com.fasterxml.jackson.annotation.JsonView;

import lms.domain.Administrator;
import lms.domain.Course;
import lms.domain.Student;
import lms.domain.StudyProgram;
import lms.service.AdministratorService;
import lms.service.CourseService;
import lms.service.StudentService;
import lms.service.StudyProgramService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/admin")
public class AdministratorController {

	@Autowired
	AdministratorService administratorService;
	
	@Autowired
	StudyProgramService studyProgramService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;

	@RequestMapping()
	public ResponseEntity<Iterable<AdministratorDTO>> getAllAdmin() {
		return new ResponseEntity<Iterable<AdministratorDTO>>(administratorService.getAllAdmin(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdministratorDTO> getAdministrator(@PathVariable Long id) {
		Optional<Administrator> faculty = administratorService.getAdminId(id);
		if (faculty.isPresent()) {
			return new ResponseEntity<AdministratorDTO>(faculty.get().toDTO(), HttpStatus.OK);
		}
		return new ResponseEntity<AdministratorDTO>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Administrator> addAdministrator(@RequestBody Administrator faculty) {

		administratorService.addAdministrator(faculty);
		return new ResponseEntity<Administrator>(faculty, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Administrator> updateCountry(@PathVariable Long id, @RequestBody Administrator faculty) {
		administratorService.updateAdministrator(id, faculty);
		return new ResponseEntity<Administrator>(faculty, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Administrator> removeAdministrator(@PathVariable Long id) {
		try {
			administratorService.removeAdministrator(id);
		} catch (Exception e) {
			return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Administrator>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/upis/{studyProgramId}/{yearNumber}")
	public ResponseEntity<Iterable<Student>> getAllStudentsWhoPass(@PathVariable Long studyProgramId, @PathVariable int yearNumber) {
		
		Optional<StudyProgram> studyProgram = studyProgramService.getStudyProgramId(studyProgramId);
	
		if (studyProgram.isPresent()) {
			return new ResponseEntity<Iterable<Student>>(administratorService.getAllStudentsWhoPass(studyProgram.get(), yearNumber), HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<Student>>(HttpStatus.NOT_FOUND);
	}

	
	
	@PostMapping(value = "/upis")
	public ResponseEntity<Boolean>enrollStudentInNextYear(@RequestBody Long studentId, @RequestBody Set<Long> facultativeCourseIds)
	{
		
		Set<Course> facultativeCourses = new HashSet<Course>();
		
		for(Long id: facultativeCourseIds)
			facultativeCourses.add(courseService.getCourseId(id).get());
		
		Optional<Student> student = studentService.getStudentById(studentId);
		
		if(student.isPresent())
		{
			return new ResponseEntity<Boolean>(administratorService.enrollStudentInNextYear(student.get(), facultativeCourses), HttpStatus.OK);
		}
		
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}

}