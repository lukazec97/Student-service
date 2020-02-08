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
import lms.domain.CourseAttending;
import lms.service.CourseAttendingService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courseattending")
public class CourseAttendingController {

	@Autowired
	CourseAttendingService courseAttendingService;
	
	@RequestMapping()
	public ResponseEntity<Iterable<CourseAttending>> getAllCourseAttending() {
		return new ResponseEntity<Iterable<CourseAttending>>(courseAttendingService.getAllCourseAttending(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseAttending> getCourseAttendingId(@PathVariable Long id) {
		Optional<CourseAttending> courseAttending = courseAttendingService.getCourseAttendingId(id);
		if (courseAttending.isPresent()) {
			return new ResponseEntity<CourseAttending>(courseAttending.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	//@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseAttending> addCourseAttending(@RequestBody CourseAttending courseAttending) {

		courseAttendingService.addCourseAttending(courseAttending);
		return new ResponseEntity<CourseAttending>(courseAttending, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseAttending> updateCourseAttending(@PathVariable Long id, @RequestBody CourseAttending courseAttending) {
		courseAttendingService.updateCourseAttending(id, courseAttending);
		return new ResponseEntity<CourseAttending>(courseAttending, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseAttending> removeCourseAttending(@PathVariable Long id) {
		try {
			courseAttendingService.removeCourseAttending(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseAttending>(HttpStatus.NO_CONTENT);
	}
}
