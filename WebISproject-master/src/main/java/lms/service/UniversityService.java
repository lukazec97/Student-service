package lms.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lms.domain.University;
import lms.repository.UniversityRepository;

@Service
public class UniversityService {

	@Autowired
	UniversityRepository universityRepository;
	
	public UniversityService() {}
	
	public Iterable<University> getAllUniversity() {
		return universityRepository.findAll();
	}

	public void addUniversity(University u) {
		universityRepository.save(u);
	}

	public Optional<University> getUniversityId(Long id) {
		return universityRepository.findById(id);
	}

	public void removeUniversity(Long id) {
		Optional<University> u = universityRepository.findById(id);
		universityRepository.delete(u.get());
	}

	public void updateUniversity(Long id, University u) {
		Optional<University> U = universityRepository.findById(id);
		if (U.isPresent()) {
			u.setId(U.get().getId());
			universityRepository.save(u);
		}
	}

}
