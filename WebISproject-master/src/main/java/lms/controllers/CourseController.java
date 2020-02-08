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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;

import DTO.CourseDTO;
import lms.domain.Course;
import lms.domain.YearOfStudy;
import lms.repository.CourseRepository;
import lms.service.CourseService;
import lms.service.YearOfStudyService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	YearOfStudyService yearOfStudyservice;
	
	@Autowired
	CourseRepository courseRepository;

	@RequestMapping()
	public ResponseEntity<Iterable<CourseDTO>> getAllCourse() {
		return new ResponseEntity<Iterable<CourseDTO>>(courseService.getAllCourse(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
		Optional<Course> course = courseService.getCourseId(id);
		if (course.isPresent()) {
			return new ResponseEntity<CourseDTO>(course.get().toDTO(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseDTO>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {

		courseService.addCourse(course);
		return new ResponseEntity<Course>(course, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
		courseService.updateCourse(id, course);
		return new ResponseEntity<Course>(course, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Course> removeCourse(@PathVariable Long id) {
		try {
			courseService.removeCourse(id);
		} catch (Exception e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/title/{title}")
	public ResponseEntity<Iterable<Course>> getCourseByTitle(@PathVariable String title) {
		return new ResponseEntity<Iterable<Course>>(courseService.getCourseByTitle(title), HttpStatus.OK);
	}
	
	@PostMapping("/file/upload")
	@Secured("ROLE_ADMIN")
	public String uploadMultipartFile(@RequestParam("file") MultipartFile file, @RequestParam("title") String title, @RequestParam("yearOfStudy") String YearOfStudy) {
		try {
			// save file to PostgreSQL
			YearOfStudy yos = yearOfStudyservice.getYearOfStudyId(Long.valueOf(YearOfStudy)).get();
			Course filemode = new Course(file, title, yos);
			courseRepository.save(filemode);
			return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}
	}
}
