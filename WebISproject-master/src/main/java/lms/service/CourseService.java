package lms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.CourseDTO;
import lms.domain.Course;
import lms.repository.CourseRepository;

@Service
public class CourseService {

	public CourseService() {}
	
	@Autowired
	CourseRepository courseRepository;

	public Iterable<CourseDTO> getAllCourse() {
		Iterable<Course> c = courseRepository.findAll();
		Set<CourseDTO> cd = new HashSet<>();
		for(Course ct: c)
			cd.add(ct.toDTO());
		return cd;
	}

	public void addCourse(Course c) {
		courseRepository.save(c);
	}

	public Optional<Course> getCourseId(Long id) {
		return courseRepository.findById(id);
	}

	public void removeCourse(Long id) {
		Optional<Course> c = courseRepository.findById(id);
		courseRepository.delete(c.get());
	}

	public void updateCourse(Long id, Course c) {
		Optional<Course> C = courseRepository.findById(id);
		if (C.isPresent()) {
			c.setId(C.get().getId());
			courseRepository.save(c);
		}
	}

	public Iterable<Course> getCourseByTitle(String title) {
		return courseRepository.findByTitle(title);
	}

}
