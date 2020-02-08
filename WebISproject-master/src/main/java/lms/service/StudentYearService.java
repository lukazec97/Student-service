package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.StudentYear;
import lms.repository.StudentYearRepository;

@Service
public class StudentYearService {

	@Autowired
	StudentYearRepository studentYearRepository;

	public StudentYearService() {}
	
	public Iterable<StudentYear> getAllStudentYear() {
		return studentYearRepository.findAll();
	}

	public void addStudentYear(StudentYear s) {
		studentYearRepository.save(s);
	}

	public Optional<StudentYear> getStudentYearId(Long id) {
		return studentYearRepository.findById(id);
	}

	public void removeStudentYear(Long id) {
		Optional<StudentYear> s = studentYearRepository.findById(id);
		studentYearRepository.delete(s.get());
	}

	public void updateStudentYear(Long id, StudentYear sy) {
		Optional<StudentYear> SY = studentYearRepository.findById(id);
		if (SY.isPresent()) {
			sy.setId(SY.get().getId());
			studentYearRepository.save(sy);
		}
	}

}
