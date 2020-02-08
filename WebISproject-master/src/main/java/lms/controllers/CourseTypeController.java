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

import lms.domain.CourseType;
import lms.service.CourseTypeService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/coursetype")
public class CourseTypeController {

	@Autowired
	CourseTypeService courseTypeService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<CourseType>> getAllCourseType() {
		return new ResponseEntity<Iterable<CourseType>>(courseTypeService.getAllCourseType(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseType> getCourseTypeById(@PathVariable Long id) {
		Optional<CourseType> courseType = courseTypeService.getCourseTypeId(id);
		if (courseType.isPresent()) {
			return new ResponseEntity<CourseType>(courseType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseType>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	//@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseType> addCourseType(@RequestBody CourseType courseType) {

		courseTypeService.addCourseType(courseType);
		return new ResponseEntity<CourseType>(courseType, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseType> updateCourseType(@PathVariable Long id, @RequestBody CourseType courseType) {
		courseTypeService.updateCourseType(id, courseType);
		return new ResponseEntity<CourseType>(courseType, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<CourseType> removeCourseType(@PathVariable Long id) {
		try {
			courseTypeService.removeCourseType(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseType>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseType>(HttpStatus.NO_CONTENT);
	}
}
