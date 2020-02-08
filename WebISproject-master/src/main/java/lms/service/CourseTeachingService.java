package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lms.domain.CourseTeaching;
import lms.repository.CourseTeachingRepository;

@Service
public class CourseTeachingService {

	public CourseTeachingService() {}
	
	@Autowired
	CourseTeachingRepository courseTeachingRepository;

	public Iterable<CourseTeaching> getAllCourseTeaching() {
		return courseTeachingRepository.findAll();
	}

	public void addCourseTeaching(CourseTeaching c) {
		courseTeachingRepository.save(c);
	}

	public Optional<CourseTeaching> getCourseTeachingId(Long id) {
		return courseTeachingRepository.findById(id);
	}

	public void removeCourseTeaching(Long id) {
		Optional<CourseTeaching> c = courseTeachingRepository.findById(id);
		courseTeachingRepository.delete(c.get());
	}

	public void updateCourseTeaching(Long id, CourseTeaching ct) {
		Optional<CourseTeaching> CT = courseTeachingRepository.findById(id);
		if (CT.isPresent()) {
			ct.setId(CT.get().getId());
			courseTeachingRepository.save(ct);
		}
	}

}
