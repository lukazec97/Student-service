package lms.controllers;

import java.util.Optional;

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

import com.fasterxml.jackson.annotation.JsonView;

import lms.domain.StudentYear;
import lms.service.StudentYearService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/studentyear")
public class StudentYearController {

	@Autowired
	StudentYearService studentYearService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<StudentYear>> getAllStudentYear() {
		return new ResponseEntity<Iterable<StudentYear>>(studentYearService.getAllStudentYear(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentYear> getStudentYearById(@PathVariable Long id) {
		Optional<StudentYear> studentYear = studentYearService.getStudentYearId(id);
		if (studentYear.isPresent()) {
			return new ResponseEntity<StudentYear>(studentYear.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudentYear>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	//@Secured("ROLE_ADMIN")
	public ResponseEntity<StudentYear> addStudentYear(@RequestBody StudentYear studentYear) {

		studentYearService.addStudentYear(studentYear);
		return new ResponseEntity<StudentYear>(studentYear, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudentYear> updateStudentYear(@PathVariable Long id, @RequestBody StudentYear studentYear) {
		studentYearService.updateStudentYear(id, studentYear);
		return new ResponseEntity<StudentYear>(studentYear, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudentYear> removeStudentYear(@PathVariable Long id) {
		try {
			studentYearService.removeStudentYear(id);
		} catch (Exception e) {
			return new ResponseEntity<StudentYear>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudentYear>(HttpStatus.NO_CONTENT);
	}
}
