package lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByFirstNameOrLastNameLikeIgnoreCase(String name, String name1);
	List<Student> findByLastNameLikeIgnoreCase(String lastName);
	List<Student> findByFirstNameLikeIgnoreCase(String firstName);

	List<Student> findByCourseAttendingsCourseRealizationCourseTitle(String courseTitle);
	Optional<Student> findFirstByCardNumber(String cardNumber);
}
