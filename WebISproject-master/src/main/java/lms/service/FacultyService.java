package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Faculty;
import lms.repository.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	FacultyRepository facultyRepository;

	public FacultyService() {}

	public List<Faculty> getAllFaculty() {
		return facultyRepository.findAll();
	}

	public Optional<Faculty> getFacultyId(Long id) {
		return facultyRepository.findById(id);
	}

	public void addFaculty(Faculty f) {
		facultyRepository.save(f);
	}

	public void removeFaculty(Long id) {
		Optional<Faculty> f = facultyRepository.findById(id);
		facultyRepository.delete(f.get());
	}

	public void updateFaculty(Long id, Faculty f) {
		Optional<Faculty> F = facultyRepository.findById(id);
		if (F.isPresent()) {
			f.setId(F.get().getId());
			facultyRepository.save(f);
		}
	}

	public Optional<Faculty> getFacultyById(Long id) {
		return facultyRepository.findById(id);
	}

}
