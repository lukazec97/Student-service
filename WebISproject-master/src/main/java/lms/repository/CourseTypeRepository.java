package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.CourseType;


@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, Long>{

	

}
