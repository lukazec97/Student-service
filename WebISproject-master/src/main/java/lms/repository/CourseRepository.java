package lms.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lms.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	
	
	Page<Course> findByEctsGreaterThan(int ects, Pageable pageable);

	@Query(value="SELECT c FROM Course c WHERE c.ects > ?1")
	Page<Course> findCoursesWithEctsGreater(int ects, Pageable pageable);

	@Query(	value="SELECT * FROM Course c WHERE c.ects > ?1",
			countQuery = "SELECT COUNT(*) from Course c where c.ects > ?1",
			nativeQuery = true )
	Page<Course> findCoursesWithEctsGreaterNative(int ects, Pageable pageable);

	List<Course> findByTitle(String title);

}
