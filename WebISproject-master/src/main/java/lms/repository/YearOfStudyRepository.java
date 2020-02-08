package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.YearOfStudy;

@Repository
public interface YearOfStudyRepository extends JpaRepository<YearOfStudy, Long>{

	YearOfStudy findFirstByNumberOfYear(int numberOfYear);
	
}
