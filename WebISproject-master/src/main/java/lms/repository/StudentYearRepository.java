package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.StudentYear;

@Repository
public interface StudentYearRepository extends JpaRepository<StudentYear, Long> {

}
