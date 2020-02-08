package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.StudyField;


@Repository
public interface StudyFieldRepository extends JpaRepository<StudyField, Long>{

	

}
