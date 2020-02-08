package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.CourseTeaching;


@Repository
public interface CourseTeachingRepository extends JpaRepository<CourseTeaching, Long>{
	
	

}
