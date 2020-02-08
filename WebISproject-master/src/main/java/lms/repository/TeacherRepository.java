package lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>, TeacherRepositoryCustom {

	public List<Teacher> findTeacherByFirstName(String firstName);
	Optional<Teacher> findByPersonalIdentificationNumber(String personalIdentificationNumber);

}
