package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Outcome;


@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Long>{

	

}
