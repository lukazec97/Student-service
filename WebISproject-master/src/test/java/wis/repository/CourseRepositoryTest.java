package wis.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import lms.domain.Course;
import lms.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CourseRepositoryTest {
	
	@Autowired 
	CourseRepository courseRepository;
		
	@Test
	@Transactional
	@Rollback(true)
	public void testPagination() {
		Pageable pageable = PageRequest.of(2, 4);
		Page<Course> courses = courseRepository.findAll(pageable);
		assertEquals(4, courses.getContent().size());
		
		courses = courseRepository.findByEctsGreaterThan(4, pageable);
		assertEquals(16, courses.getTotalElements());
		assertEquals(4, courses.getTotalPages());
		
		courses = courseRepository.findCoursesWithEctsGreater(5, pageable);
		assertEquals(11, courses.getTotalElements());
		assertEquals(3, courses.getTotalPages());

		courses = courseRepository.findCoursesWithEctsGreaterNative(4, pageable);
		assertEquals(16, courses.getTotalElements());
		assertEquals(4, courses.getTotalPages());
		
		pageable = PageRequest.of(0, 5, Sort.by("ects").descending().and(Sort.by("title")));
		courses = courseRepository.findAll(pageable);
	}
}
