package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.EvaluationType;

@Repository
public interface EvaluationTypeRepository extends JpaRepository<EvaluationType, Long>{

	

}
