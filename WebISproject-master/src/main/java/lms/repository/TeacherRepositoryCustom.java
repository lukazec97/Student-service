package lms.repository;

import java.util.List;

import lms.domain.Teacher;

public interface TeacherRepositoryCustom {
	
	List<Teacher> findByLastName(String lastName);
}
