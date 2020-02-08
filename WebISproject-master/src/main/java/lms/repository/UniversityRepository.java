package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.University;


@Repository
public interface UniversityRepository extends JpaRepository<University, Long>{

	

}
