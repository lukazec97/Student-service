package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.EvaluationAttending;

@Repository
public interface EvaluationAttendingRepository extends JpaRepository<EvaluationAttending, Long>{

	

	

}
