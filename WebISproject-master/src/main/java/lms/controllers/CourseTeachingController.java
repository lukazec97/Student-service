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

import lms.domain.CourseTeaching;
import lms.service.CourseTeachingService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courseteaching")
public class CourseTeachingController {

	@Autowired
	CourseTeachingService courseTeachingService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<CourseTeaching>> getAllCourseTeaching() {
		return new ResponseEntity<Iterable<CourseTeaching>>(courseTeachingService.getAllCourseTeaching(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseTeaching> getCourseTeachingById(@PathVariable Long id) {
		Optional<CourseTeaching> courseTeaching = courseTeachingService.getCourseTeachingId(id);
		if (courseTeaching.isPresent()) {
			return new ResponseEntity<CourseTeaching>(courseTeaching.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseTeaching>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	//@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseTeaching> addCourseTeaching(@RequestBody CourseTeaching courseTeaching) {

		courseTeachingService.addCourseTeaching(courseTeaching);
		return new ResponseEntity<CourseTeaching>(courseTeaching, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseTeaching> updateCourseTeaching(@PathVariable Long id, @RequestBody CourseTeaching courseTeaching) {
		courseTeachingService.updateCourseTeaching(id, courseTeaching);
		return new ResponseEntity<CourseTeaching>(courseTeaching, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseTeaching> removeCourseTeaching(@PathVariable Long id) {
		try {
			courseTeachingService.removeCourseTeaching(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseTeaching>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseTeaching>(HttpStatus.NO_CONTENT);
	}
}
